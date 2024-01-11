package net.rose.sbwd.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.TntEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.rose.sbwd.entity.custom.ThermobaricEntity;
import net.rose.sbwd.sbwd;

public class ModEntities {
    public static final EntityType<TntEntity> THERMOBARIC_ENTITY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(sbwd.MOD_ID, "thermobaricEntity"),
            EntityType.TNT);
    public static final EntityType<TntEntity> NUKE_ENTITY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(sbwd.MOD_ID, "nukeEntity"),
            EntityType.TNT);
}
