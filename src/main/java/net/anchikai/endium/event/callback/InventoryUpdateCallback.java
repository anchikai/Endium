package net.anchikai.endium.event.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

public interface InventoryUpdateCallback {
    ActionResult interact(PlayerInventory inventory);

    Event<InventoryUpdateCallback> EVENT = EventFactory.createArrayBacked(
        InventoryUpdateCallback.class, listeners -> (inventory) -> {
            inventory.player.sendMessage(Text.of("Inventory update"), true);
            for (InventoryUpdateCallback event : listeners) {
                ActionResult result = event.interact(inventory);
                if(result != ActionResult.PASS) {
                    return result;
                }
            }
            return ActionResult.PASS;
        }
    );
}