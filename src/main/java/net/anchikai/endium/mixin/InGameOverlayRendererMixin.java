package net.anchikai.endium.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.block.ModDustBlock;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameOverlayRenderer.class)
@Environment(EnvType.CLIENT)
public class InGameOverlayRendererMixin {
    private static final Identifier IN_DUST_TEXTURE = EndiumMod.id("textures/misc/in_dust.png");

    @Inject(method = "renderOverlays", at = @At("TAIL"))
    private static void renderOverlays(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        PlayerEntity player = client.player;
        if (!player.isSpectator()) {
            BlockState blockState = client.world.getBlockState(BlockPos.ofFloored(player.getEyePos()));
            if (blockState.getBlock() instanceof ModDustBlock) {
                renderDustOverlay(client, matrices);
            }
        }
    }

    private static void renderDustOverlay(MinecraftClient client, MatrixStack matrices) {
        PlayerEntity player = client.player;
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderTexture(0, IN_DUST_TEXTURE);
        BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
        float f = LightmapTextureManager.getBrightness(player.world.getDimension(), 15);
        RenderSystem.enableBlend();
        RenderSystem.setShaderColor(f, f, f, 1.0f);
        float g = 4.0F;
        float h = -1.0F;
        float i = 1.0F;
        float j = -1.0F;
        float k = 1.0F;
        float l = -0.5F;
        float m = -player.getYaw() / 64.0F;
        float n = player.getPitch() / 64.0F;
        Matrix4f matrix4f = matrices.peek().getPositionMatrix();
        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix4f, -1.0F, -1.0F, -0.5F).texture(4.0F + m, 4.0F + n).next();
        bufferBuilder.vertex(matrix4f, 1.0F, -1.0F, -0.5F).texture(0.0F + m, 4.0F + n).next();
        bufferBuilder.vertex(matrix4f, 1.0F, 1.0F, -0.5F).texture(0.0F + m, 0.0F + n).next();
        bufferBuilder.vertex(matrix4f, -1.0F, 1.0F, -0.5F).texture(4.0F + m, 0.0F + n).next();
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.disableBlend();
    }
}
