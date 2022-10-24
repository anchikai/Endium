package net.anchikai.endium;

import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.client.render.entity.feature.CulminiteElytraFeatureRenderer;
import net.anchikai.endium.client.render.entity.feature.EndiumElytraFeatureRenderer;
import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.item.custom.ModElytraItem;
import net.anchikai.endium.misc.EndiumTag;
import net.anchikai.endium.screen.EndiumModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EndiumModClient implements ClientModInitializer {
    public static final EntityModelLayer CHROMIUM_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("endium", "chromium_shield"),"main");
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AMARANTH_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHROMIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHROMIUM_TRAPDOOR, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LUNGWORT_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LUNGWORT_FLOWER, RenderLayer.getCutout());

        FabricModelPredicateProviderRegistry.register(ModItems.ENDIUM_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> ModElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);
        FabricModelPredicateProviderRegistry.register(ModItems.CULMINITE_ELYTRA.asItem(),
                new Identifier("broken"), (itemStack, clientWorld, livingEntity, seed) -> ModElytraItem.isUsable(itemStack) ? 0.0F : 1.0F);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new EndiumElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new CulminiteElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EndiumModClient::allowCapeRender);

        EntityModelLayerRegistry.registerModelLayer(CHROMIUM_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("endium", "entity/chromium_shield_base"));
            registry.register(new Identifier("endium", "entity/chromium_shield_base_nopattern"));
        });

        EndiumModScreenHandlers.initializeClient();
    }

    @Environment(EnvType.CLIENT)
    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isIn(EndiumTag.ENDIUM_ELYTRA) || player.getEquippedStack(EquipmentSlot.CHEST).isIn(EndiumTag.CULMINITE_ELYTRA));
    }
}