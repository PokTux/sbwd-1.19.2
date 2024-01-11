package net.rose.sbwd.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.particle.Particle;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.rose.sbwd.block.custom.*;
import net.rose.sbwd.item.ModItemGroup;
import net.rose.sbwd.item.ModItems;
import net.rose.sbwd.sbwd;

public class ModBlocks {



//ores
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.SBWD);

    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool(),
                    UniformIntProvider.create(1,2)), ModItemGroup.SBWD);
    public static final Block DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(1,2)), ModItemGroup.SBWD);
    public static final Block NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool().sounds(BlockSoundGroup.NETHER_ORE),
                    UniformIntProvider.create(1,2)), ModItemGroup.SBWD);

    public static final Block URANIUM_ORE = registerBlock("uranium_ore",
            new DeadlyOreBlock(FabricBlockSettings.of(Material.STONE).strength(9f).resistance(1800f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
                    UniformIntProvider.create(2,4)), ModItemGroup.SBWD);




//blocks of mats
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(3f).requiresTool()), ModItemGroup.SBWD);
    public static final Block SULFUR_BLOCK = registerBlock("sulfur_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(3f).requiresTool()), ModItemGroup.SBWD);
    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new DeadlyBlock(FabricBlockSettings.of(Material.METAL).strength(9f).resistance(1800f).requiresTool()), ModItemGroup.SBWD);

    public static final Block PLUTONIUM_BLOCK = registerBlock("plutonium_block",
            new SuperDeadlyBlock(FabricBlockSettings.of(Material.METAL).strength(9f).resistance(1800f).requiresTool()), ModItemGroup.SBWD);



//rtg
    public static final Block RTG = registerBlock("rtg",
        new RTG(FabricBlockSettings.of(Material.METAL).strength(4.5f).requiresTool().luminance(8).nonOpaque()), ModItemGroup.SBWD);

//bombs
    public static final Block THERMOBARIC_TNT = registerBlock("thermobaric_tnt",
        new ThermobaricTNT(FabricBlockSettings.of(Material.METAL).strength(1f)), ModItemGroup.SBWD);

    public static final Block BED_TNT = registerBlock("bed_tnt",
        new BedTNT(FabricBlockSettings.of(Material.METAL).strength(1f)), ModItemGroup.SBWD);

    public static final Block NUKE_TNT = registerBlock("nuke_tnt",
        new NukeTNT(FabricBlockSettings.of(Material.METAL).strength(1f)), ModItemGroup.SBWD);


//sulfur deco
    public static final Block SULFUR_LANTERN = registerBlock("sulfur_lantern",
        new LanternBlock(AbstractBlock.Settings.of(Material.METAL).requiresTool().strength(3.5f).sounds(BlockSoundGroup.LANTERN).luminance(state -> 15).nonOpaque()),
        ModItemGroup.SBWD);

    public static final Block ROSEPLUSH = registerBlock("roseplush",
        new Plush(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.WOOL).strength(0.5f).luminance(1).nonOpaque()),
        ModItemGroup.SBWD);

    public static final Block PRISMICPLUSH = registerBlock("prismicplush",
        new Plush(FabricBlockSettings.of(Material.WOOL).sounds(BlockSoundGroup.WOOL).strength(0.5f).nonOpaque()),
        ModItemGroup.SBWD);













    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(sbwd.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(sbwd.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    public static void registerModBlocks() {
        sbwd.LOGGER.debug("Registering Mod Blocks for " + sbwd.MOD_ID);
    }
}
