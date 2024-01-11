package net.rose.sbwd.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GiftSword extends SwordItem {



    public GiftSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("This katana can be swung extremely fast but will cause struck targets to become unstable").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        explode(target, attacker);
        return super.postHit(stack, target, attacker);
    }

    private void explode(LivingEntity target, LivingEntity attacker) {
        attacker.world.createExplosion(attacker, target.getX(), target.getEyeY(), target.getZ(),1.25f,false, Explosion.DestructionType.BREAK);

    }

}




