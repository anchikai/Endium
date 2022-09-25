package net.anchikai.endium.mixin;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow @Final private final BuiltinModelItemRenderer builtinModelItemRenderer;

    protected ItemRendererMixin(BuiltinModelItemRenderer builtinModelItemRenderer) {
        this.builtinModelItemRenderer = builtinModelItemRenderer;
    }

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
                if (!model.isBuiltin() && bl) {
                    boolean direct = true;
                    RenderLayer renderLayer = RenderLayers.getItemLayer(stack, direct);
                    VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers, renderLayer, true, stack.hasGlint());

                    ((ItemRendererAccessor) this).endium_mod$renderBakedItemModel(model, stack, light, overlay, matrices, vertexConsumer);
                } else {
                    this.builtinModelItemRenderer.render(stack, renderMode, matrices, vertexConsumers, light, overlay);
                }

                matrices.pop();
            }
            info.cancel();
        }
    }
}