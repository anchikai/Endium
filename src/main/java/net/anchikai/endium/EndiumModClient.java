package net.anchikai.endium;

import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.item.custom.ModElytraItem;
import net.anchikai.endium.client.render.entity.feature.ModElytraFeatureRenderer;
import net.anchikai.endium.misc.EndiumTag;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EndiumModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_TRAPDOOR, RenderLayer.getCutout());

        FabricModelPredicateProviderRegistry.register(ModItems.ENDIUM_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> ModElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new ModElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EndiumModClient::allowCapeRender);


    }

    @Environment(EnvType.CLIENT)
    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isIn(EndiumTag.ENDIUM_ELYTRA));
    }

}