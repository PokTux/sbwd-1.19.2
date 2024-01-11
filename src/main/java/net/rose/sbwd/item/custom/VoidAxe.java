package net.rose.sbwd.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class VoidAxe extends AxeItem {
    public VoidAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.literal("This hatchet seems to be able to strike targets even without making contact with them").formatted(Formatting.AQUA));
        } else {
            tooltip.add(Text.literal("Press Shift for more info!").formatted(Formatting.YELLOW));
        }
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        particlespawn(world, entity, selected);
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void particlespawn(World world, Entity entity, boolean selected) {
        int p = new Random().nextInt(10);
        if (p < 3) {
            float a = (float) ((Math.random()) * 2 - 1);
            float b = (float) ((Math.random()) * 2 - 1);
            float c = (float) ((Math.random()) * 2 - 1);
            if (selected)
                entity.world.addParticle(ParticleTypes.SCULK_SOUL, entity.getX() + a, entity.getEyeY() + b, entity.getZ() + c, 0, 0, 0);
        }
    }
}
