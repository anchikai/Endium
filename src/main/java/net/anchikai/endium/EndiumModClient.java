package net.anchikai.endium;

import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.item.custom.ModElytraItem;
import net.anchikai.endium.misc.EndiumElytraFeatureRender;
import net.anchikai.endium.misc.EndiumTag;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EndiumModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FabricModelPredicateProviderRegistry.register(ModItems.ENDIUM_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> ModElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new EndiumElytraFeatureRender<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EndiumModClient::allowCapeRender);


    }

    @Environment(EnvType.CLIENT)
    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isIn(EndiumTag.ENDIUM_ELYTRA));
    }

}