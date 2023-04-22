package net.anchikai.endium.init;

import net.anchikai.endium.event.handler.InventoryUpdateHandler;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModEvents {
    public static void register() {
        InventoryUpdateHandler handler = new InventoryUpdateHandler();

        ServerTickEvents.START_WORLD_TICK.register(world -> {
            for (ServerPlayerEntity player : world.getPlayers()) {
                PlayerInventory inventory = player.getInventory();
                handler.interact(inventory);
            }
        });
    }
}