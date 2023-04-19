package net.anchikai.endium.entity;

import net.anchikai.endium.EndiumMod;
import net.minecraft.entity.vehicle.BoatEntity;

public class ModEntities {
    public static BoatEntity.Type AMARANTH_BOAT;

    public static void registerModEntities() { EndiumMod.LOGGER.info("Registering ModEntities for " + EndiumMod.MOD_ID); }
}
