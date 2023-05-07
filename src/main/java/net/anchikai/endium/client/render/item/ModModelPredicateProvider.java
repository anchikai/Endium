package net.anchikai.endium.client.render.item;

import net.anchikai.endium.item.ChromiumItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;


@Environment(value=EnvType.CLIENT)
public class ModModelPredicateProvider {
    public static void registerModItemModelPredicates() {
         // Shields
        ModModelPredicateProvider.registerShield(ChromiumItems.CHROMIUM_SHIELD);
    }

    private static void registerShield(Item shield) {
        ModelPredicateProviderRegistry.register(shield, new Identifier("blocking"), 
            (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0f : 0.0f);
    }
}