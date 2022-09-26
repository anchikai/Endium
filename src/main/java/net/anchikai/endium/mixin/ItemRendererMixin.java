package net.anchikai.endium.mixin;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {

    @Inject(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At(value = "HEAD"), cancellable = true)
    public void renderItem(ItemStack stack, ModelTransformation.Mode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, BakedModel model, CallbackInfo info) {
        if (stack.isOf(ModItems.ENDIUM_TRIDENT)) {
            if (!stack.isEmpty()) {
                matrices.push();
                boolean bl = renderMode == ModelTransformation.Mode.GUI || renderMode == ModelTransformation.Mode.GROUND || renderMode == ModelTransformation.Mode.FIXED;
                if (bl) {
                    model = ((ItemRendererAccessor) this).endium_mod$getModels().getModelManager().getModel(new ModelIdentifier(EndiumMod.MOD_ID + ":endium_trident#inventory"));
                }

                model.getTransformation().getTransformation(renderMode).apply(leftHanded, matrices);
                matrices.translate(-0.5, -0.5, -0.5);
                RenderLayer renderLayer = RenderLayers.getItemLayer(stack, true);
                VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, renderLayer, true, stack.hasGlint());

                ((ItemRendererAccessor) this).endium_mod$renderBakedItemModel(model, stack, light, overlay, matrices, vertexConsumer);

                matrices.pop();
            }
            info.cancel();
        }
    }

// @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
//         at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/BakedModelManager;getModel(Lnet/minecraft/client/util/ModelIdentifier;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2, ordinal = 0),
//         index = 8)
// public BakedModel useEndiumTridentModel(BakedModel value, ItemStack stack) {
//     if (stack.isOf(ModItems.ENDIUM_TRIDENT)) {
//         return ((ItemRendererAccessor) this).endium_mod$getModels().getModelManager().getModel(new ModelIdentifier(EndiumMod.MOD_ID + ":endium_trident#inventory"));
//     }
//     return value;
// }
//
// @ModifyVariable(method = "getHeldItemModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
// public BakedModel getHeldEndiumTridentModel(BakedModel value, ItemStack stack) {
//     if (stack.isOf(ModItems.ENDIUM_TRIDENT)) {
//         return ((ItemRendererAccessor) this).endium_mod$getModels().getModelManager().getModel(new ModelIdentifier(EndiumMod.MOD_ID + ":endium_trident_in_hand#inventory"));
//     }
//     return value;
// }
}