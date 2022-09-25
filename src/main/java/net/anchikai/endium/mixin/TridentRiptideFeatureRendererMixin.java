package net.anchikai.endium.mixin;

import net.anchikai.endium.item.ModItems;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.TridentRiptideFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static net.anchikai.endium.EndiumModClient.ENDIUM_RIPTIDE_TEXTURE;

@Mixin(TridentRiptideFeatureRenderer.class)
public abstract class TridentRiptideFeatureRendererMixin {
    @ModifyVariable(method = "render", at = @At("STORE"))
    private VertexConsumer swapHotRiptide(VertexConsumer orig, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity livingEntity) {
        if (livingEntity instanceof PlayerEntity && livingEntity.isUsingRiptide() && (livingEntity.getMainHandStack().getItem() == ModItems.ENDIUM_TRIDENT || (livingEntity.getOffHandStack().getItem() == ModItems.ENDIUM_TRIDENT))) {
            return vertexConsumerProvider.getBuffer(RenderLayer.getEntityCutoutNoCull(ENDIUM_RIPTIDE_TEXTURE));
        }
        return orig;
    }
}