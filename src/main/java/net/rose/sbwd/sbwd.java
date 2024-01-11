package net.rose.sbwd;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.rose.sbwd.block.ModBlocks;
import net.rose.sbwd.entity.ModEntities;
import net.rose.sbwd.entity.custom.ThermobaricEntity;
import net.rose.sbwd.item.ModItems;
import net.rose.sbwd.item.ModToolMaterial;
import net.rose.sbwd.world.feature.ModConfiguredFeatures;
import net.rose.sbwd.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class sbwd implements ModInitializer {
	public static final String MOD_ID = "sbwd";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModOreGeneration.generateOres();


		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
