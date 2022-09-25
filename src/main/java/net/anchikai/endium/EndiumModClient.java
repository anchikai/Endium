package net.anchikai.endium;

import net.anchikai.endium.block.ModBlocks;
import net.anchikai.endium.client.EndiumTridentItemRenderer;
import net.anchikai.endium.client.render.entity.EndiumTridentEntityRenderer;
import net.anchikai.endium.client.render.entity.model.EndiumTridentEntityModel;
import net.anchikai.endium.common.init.TridentEntityTypes;
import net.anchikai.endium.item.ModItems;
import net.anchikai.endium.item.custom.ModElytraItem;
import net.anchikai.endium.client.render.entity.feature.ModElytraFeatureRenderer;
import net.anchikai.endium.misc.EndiumTag;
import net.anchikai.endium.screen.EndiumModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.*;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EndiumModClient implements ClientModInitializer {
    public static final EntityModelLayer CHROMIUM_SHIELD_MODEL_LAYER = new EntityModelLayer(new Identifier("endium", "chromium_shield"),"main");
    public static final Identifier ENDIUM_RIPTIDE_TEXTURE = new Identifier(EndiumMod.MOD_ID, "textures/entity/endium_trident_riptide.png");
    public static final EntityModelLayer ENDIUM_TRIDENT = new EntityModelLayer(new Identifier(EndiumMod.MOD_ID, "endium_trident"), "main");
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

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> registrationHelper.register(new ModElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(EndiumModClient::allowCapeRender);

        EntityModelLayerRegistry.registerModelLayer(CHROMIUM_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);

        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(new Identifier("endium", "entity/chromium_shield_base"));
            registry.register(new Identifier("endium", "entity/chromium_shield_base_nopattern"));
        });

        var item = ModItems.ENDIUM_TRIDENT;
        Identifier tridentId = Registry.ITEM.getId(item);
        Identifier texture = new Identifier(tridentId.getNamespace(), "textures/entity/endium_trident.png");

        EntityModelLayer modelLayer = EntityModelLayers.TRIDENT;
        EndiumTridentItemRenderer tridentItemRenderer = new EndiumTridentItemRenderer(tridentId, texture, modelLayer);
        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(tridentItemRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(item, tridentItemRenderer);
        EntityRendererRegistry.register(TridentEntityTypes.ENDIUM_TRIDENT, ctx -> new EndiumTridentEntityRenderer(ctx, texture, modelLayer));

        FabricModelPredicateProviderRegistry.register(item, new Identifier("throwing"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F);
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(new ModelIdentifier(tridentId + "_in_inventory", "inventory")));

        EndiumModScreenHandlers.initializeClient();
    }

    @Environment(EnvType.CLIENT)
    private static boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isIn(EndiumTag.ENDIUM_ELYTRA));
    }

}