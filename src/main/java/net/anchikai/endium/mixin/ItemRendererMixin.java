package net.anchikai.endium.mixin;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.item.ModItems;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow @Final private BuiltinModelItemRenderer builtinModelItemRenderer;

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformation$Mode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/model/BakedModelManager;getModel(Lnet/minecraft/client/util/ModelIdentifier;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2, ordinal = 0),
            index = 8)
    public BakedModel useEndiumTridentModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(ModItems.ENDIUM_TRIDENT)) {
            return ((ItemRendererAccessor) this).endium_mod$getModels().getModelManager().getModel(new ModelIdentifier(EndiumMod.MOD_ID + ":endium_trident#inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "getHeldItemModel", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/item/ItemModels;getModel(Lnet/minecraft/item/ItemStack;)Lnet/minecraft/client/render/model/BakedModel;", shift = At.Shift.BY, by = 2), index = 5)
    public BakedModel getHeldEndiumTridentModel(BakedModel value, ItemStack stack) {
        if (stack.isOf(ModItems.ENDIUM_TRIDENT)) {
            return ((ItemRendererAccessor) this).endium_mod$getModels().getModelManager().getModel(new ModelIdentifier(EndiumMod.MOD_ID + ":endium_trident_in_hand#inventory"));
        }
        return value;
    }
}