package net.rose.sbwd.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.rose.sbwd.sbwd;

public class ModItemGroup {
    public static final ItemGroup SBWD = FabricItemGroupBuilder.build(
            new Identifier(sbwd.MOD_ID, "sbwd"), () -> new ItemStack(ModItems.SULFUR));

}
