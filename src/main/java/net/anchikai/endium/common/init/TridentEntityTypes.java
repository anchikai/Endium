package net.anchikai.endium.common.init;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.common.EndiumTridentEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.registry.Registry;

public class TridentEntityTypes {
    public static EntityType<EndiumTridentEntity> ENDIUM_TRIDENT;

    public static void init() {
        ENDIUM_TRIDENT = register("endium_trident", createEntityType(EndiumTridentEntity::new));
    }

    private static <T extends Entity> EntityType<T> register(String s, EntityType<T> bombEntityType) {
        return Registry.register(Registry.ENTITY_TYPE, EndiumMod.MOD_ID + ":" + s, bombEntityType);
    }

    private static <T extends Entity> EntityType<T> createEntityType(EntityType.EntityFactory<T> factory) {
        return FabricEntityTypeBuilder.create(SpawnGroup.MISC, factory).dimensions(EntityDimensions.changing(0.5f, 0.5f)).trackRangeBlocks(4).trackedUpdateRate(20).build();
    }
}