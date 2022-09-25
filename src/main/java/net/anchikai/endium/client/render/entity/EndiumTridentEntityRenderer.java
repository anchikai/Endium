package net.anchikai.endium.client.render.entity;

import net.anchikai.endium.client.render.entity.model.EndiumTridentEntityModel;
import net.anchikai.endium.common.EndiumTridentEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public class EndiumTridentEntityRenderer extends EntityRenderer<EndiumTridentEntity> {
    private final EndiumTridentEntityModel model;
    private final Identifier texture;

    public EndiumTridentEntityRenderer(EntityRendererFactory.Context context, Identifier texture, EntityModelLayer modelLayer) {
        super(context);
        this.model = new EndiumTridentEntityModel(context.getPart(modelLayer));
        this.texture = texture;
    }

    public void render(EndiumTridentEntity endiumTridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(MathHelper.lerp(g, endiumTridentEntity.prevYaw, endiumTridentEntity.getYaw()) - 90.0F));
        matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(MathHelper.lerp(g, endiumTridentEntity.prevPitch, endiumTridentEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(endiumTridentEntity)), false, endiumTridentEntity.isEnchanted());
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.pop();
        super.render(endiumTridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(EndiumTridentEntity impaledTridentEntity) {
        return this.texture;
    }
}