package net.rose.sbwd.block.custom;
/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;


public class BedTNT
        extends Block {

    public BedTNT(Settings settings) {
        super(settings);


    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.CONSUME;
        }
        world.removeBlock(pos, false);

        world.createExplosion(null, DamageSource.badRespawnPoint(), null, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, 5.0f, true, Explosion.DestructionType.DESTROY);
        return ActionResult.SUCCESS;
    }

}
