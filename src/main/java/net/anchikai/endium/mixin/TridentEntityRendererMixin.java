package net.anchikai.endium.mixin;

import net.anchikai.endium.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.util.Identifier;

import static net.anchikai.endium.EndiumMod.id;

@Mixin(TridentEntityRenderer.class)
public class TridentEntityRendererMixin {
    @Inject(method = "getTexture(Lnet/minecraft/entity/projectile/TridentEntity;)Lnet/minecraft/util/Identifier;", at = @At(value = "HEAD"), cancellable = true)
    public void getTextureMixin(TridentEntity entity, CallbackInfoReturnable<Identifier> cir) {
//        if(entity.tridentStack.isOf(ModItems.ENDIUM_TRIDENT)) {
            cir.setReturnValue(id("textures/entity/endium_trident.png"));
//        }
    }
}