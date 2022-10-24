package net.anchikai.endium.init;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.event.callback.InventoryUpdateCallback;
import net.anchikai.endium.event.handler.InventoryUpdateHandler;

public class ModEvents {
    public static void init() {
        InventoryUpdateCallback.EVENT.register(new InventoryUpdateHandler());
        EndiumMod.LOGGER.info("Registering ModEvents for " + EndiumMod.MOD_ID);
    }
}