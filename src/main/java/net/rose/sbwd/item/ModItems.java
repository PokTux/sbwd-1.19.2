package net.rose.sbwd.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rose.sbwd.item.custom.FloatSword;
import net.rose.sbwd.item.custom.GiftSword;
import net.rose.sbwd.item.custom.VoidAxe;
import net.rose.sbwd.item.custom.WhyAreHoesAProtectedJavaClass;
import net.rose.sbwd.sbwd;

public class ModItems {

    public static final Item RAW_LEAD = registerItem("raw_lead",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));
    public static final Item LEAD_INGOT = registerItem("lead_ingot",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));

    public static final Item LEAD_CANISTER = registerItem("lead_canister",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));

    public static final Item SULFUR = registerItem("sulfur",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));
    public static final Item HEC = registerItem("he_compound",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));


    public static final Item URANIUM = registerItem("uranium",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));
    public static final Item PLUTONIUM = registerItem("plutonium",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));

    public static final Item ARTIST_BILLET = registerItem("artist_billet",
            new Item(new FabricItemSettings().group(ModItemGroup.SBWD)));





    //tools

    public static final Item LEAD_PIPE = registerItem("lead_pipe",
            new SwordItem(ModToolMaterial.LEAD, 4,-2.9f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));

    public static final Item LEAD_SWORD = registerItem("lead_sword",
            new SwordItem(ModToolMaterial.LEAD, 3,-2.4f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));

    public static final Item ARTIST_SWORD = registerItem("artist_sword",
            new GiftSword(ModToolMaterialTwo.PLUTONIUM, 4,1.2f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));

    public static final Item PROGRAMMER_AXE = registerItem("programmer_axe",
            new VoidAxe(ModToolMaterialTwo.PLUTONIUM, 7f,-0.5f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));


    public static final Item LEAD_PICKAXE = registerItem("lead_pickaxe",
            new PickaxeItem(ModToolMaterial.LEAD, 1,-2.8f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));

    public static final Item LEAD_AXE = registerItem("lead_axe",
            new AxeItem(ModToolMaterial.LEAD, 6,-3.1f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));
    public static final Item LEAD_SHOVEL = registerItem("lead_shovel",
            new ShovelItem(ModToolMaterial.LEAD, 1.5f,-3f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));

    public static final Item LEAD_HOE = registerItem("lead_hoe",
            new WhyAreHoesAProtectedJavaClass(ModToolMaterial.LEAD, -2,-1f,
                    new FabricItemSettings().group(ModItemGroup.SBWD).maxCount(1)));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(sbwd.MOD_ID, name), item);
    }



    public static void registerModItems(){
        sbwd.LOGGER.debug("Registering Mod Items for " + sbwd.MOD_ID);
    }
}
