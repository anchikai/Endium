package net.anchikai.endium;

import net.anchikai.endium.block.AmaranthBlocks;
import net.anchikai.endium.block.PlantBlocks;
import net.anchikai.endium.client.render.entity.feature.CulminiteElytraFeatureRenderer;
import net.anchikai.endium.client.render.entity.feature.EndiumElytraFeatureRenderer;
import net.anchikai.endium.client.render.item.ModModelPredicateProvider;
import net.anchikai.endium.item.CulminiteItems;
import net.anchikai.endium.item.EndiumElytraItem;
import net.anchikai.endium.item.EndiumItems;
import net.anchikai.endium.network.SyncPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EndiumModClient implements ClientModInitializer {
    public static final EntityModelLayer CHROMIUM_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("endium", "chromium_shield"),"main");

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(AmaranthBlocks.AMARANTH_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AmaranthBlocks.AMARANTH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AmaranthBlocks.AMARANTH_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(AmaranthBlocks.AMARANTH_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(PlantBlocks.LUNGWORT_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(PlantBlocks.POTTED_LUNGWORT_FLOWER, RenderLayer.getCutout());

        ModelPredicateProviderRegistry.register(EndiumItems.ENDIUM_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> EndiumElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);
        ModelPredicateProviderRegistry.register(CulminiteItems.CULMINITE_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> EndiumElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new EndiumElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new CulminiteElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EndiumModClient::allowCapeRender);

        EntityModelLayerRegistry.registerModelLayer(CHROMIUM_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);

        SyncPacket.init();
        ModModelPredicateProvider.registerModItemModelPredicates();
    }

    @Environment(EnvType.CLIENT)
    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isOf(EndiumItems.ENDIUM_ELYTRA) || player.getEquippedStack(EquipmentSlot.CHEST).isOf(CulminiteItems.CULMINITE_ELYTRA));
    }
}