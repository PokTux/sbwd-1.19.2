package net.rose.sbwd.entity.custom;


import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.EntityDamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.rose.sbwd.misc.Warhead;
import org.apache.commons.lang3.ObjectUtils;
import org.jetbrains.annotations.Nullable;

public class NukeEntity
        extends Entity {
    private static final TrackedData<Integer> FUSE = DataTracker.registerData(NukeEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final int DEFAULT_FUSE = 600;
    @Nullable
    private LivingEntity causingEntity;

    public NukeEntity(EntityType<? extends net.minecraft.entity.TntEntity> entityType, World world) {
        super(entityType, world);
        this.intersectionChecked = true;
    }

    public NukeEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        this((EntityType<? extends net.minecraft.entity.TntEntity>)EntityType.TNT, world);
        this.setPosition(x, y, z);
        double d = world.random.nextDouble() * 6.2831854820251465;
        this.setVelocity(-Math.sin(d) * 0.02, 0.2f, -Math.cos(d) * 0.02);
        this.setFuse(600);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.causingEntity = igniter;
    }

    int yield = 64;
    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(FUSE, 300);
    }

    @Override
    protected MoveEffect getMoveEffect() {
        return MoveEffect.NONE;
    }

    @Override
    public boolean canHit() {
        return !this.isRemoved();
    }

    @Override
    public void tick() {
        if (!this.hasNoGravity()) {
            this.setVelocity(this.getVelocity().add(0.0, -0.04, 0.0));
        }
        this.move(MovementType.SELF, this.getVelocity());
        this.setVelocity(this.getVelocity().multiply(0.98));
        if (this.onGround) {
            this.setVelocity(this.getVelocity().multiply(0.7, -0.5, 0.7));
        }
        int i = this.getFuse() - 1;
        this.setFuse(i);
        if (i <= 0) {
            this.discard();
            if (!this.world.isClient) {
                this.explode();
            }
        } else {
            this.updateWaterState();
            if (this.world.isClient) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5, this.getZ(), 0.0, 0.0, 0.0);
            }
        }
    }

    private void explode() {
        float f = 4.0f;
        Warhead.explode((ServerWorld) world, this.getX(), this.getBodyY(0.0625), this.getZ(), yield, ignored -> true);












        for (PlayerEntity player : world.getPlayers()) {
            if (player.squaredDistanceTo(this) > (yield*2) * (yield*2)) continue;

            player.playSound(SoundEvents.ENTITY_DRAGON_FIREBALL_EXPLODE, SoundCategory.BLOCKS, 1800.0F, 0.85F);







        }
        for (var entity : world.getOtherEntities(this, Box.of(getPos(), (yield*2), (yield*2), (yield*2)))) {
            if (entity.isImmuneToExplosion()) continue;

            double distanceModifier = 1 - entity.distanceTo(this) / (double) yield;
            if (distanceModifier >= 0) {
                double x = entity.getX() - this.getX();
                double y = (entity instanceof TntEntity ? entity.getY() : entity.getEyeY()) - this.getY();
                double z = entity.getZ() - this.getZ();
                double dist = Math.sqrt(x * x + y * y + z * z);
                if (dist != 0.0) {
                    x /= dist;
                    y /= dist;
                    z /= dist;
                    entity.damage(DamageSource.GENERIC, MathHelper.floor((distanceModifier * distanceModifier + distanceModifier) * 7.0 * yield + 1.0));
                    double knockback = distanceModifier * 5;
                    if (entity instanceof LivingEntity living) {
                        knockback = ProtectionEnchantment.transformExplosionKnockback(living, knockback);
                    }

                    entity.addVelocity(x * knockback, y * knockback, z * knockback);
                }


            }
        }
    }








    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {
        nbt.putShort("Fuse", (short)this.getFuse());
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {
        this.setFuse(nbt.getShort("Fuse"));
    }

    @Nullable
    public LivingEntity getCausingEntity() {
        return this.causingEntity;
    }

    @Override
    protected float getEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.15f;
    }

    public void setFuse(int fuse) {
        this.dataTracker.set(FUSE, fuse);
    }

    public int getFuse() {
        return this.dataTracker.get(FUSE);
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}

