package net.anchikai.endium.mixin;

import net.anchikai.endium.entity.ModEntities;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.vehicle.BoatEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@SuppressWarnings("unused")
@Mixin(BoatEntity.Type.class)
public class BoatEntityTypeMixin {

    @Invoker("<init>")
    public static BoatEntity.Type endium$invokeNew(String internalName, int ordinal, Block baseBlock, String name) {
        throw new IllegalStateException("HOW");
    }

    @Final
    @Shadow
    @Mutable
    private static BoatEntity.Type[] field_7724;

    @Inject(method = "<clinit>", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/vehicle/BoatEntity$Type;field_7724:[Lnet/minecraft/entity/vehicle/BoatEntity$Type;", shift = At.Shift.AFTER, opcode = Opcodes.PUTSTATIC))
    private static void addAmaranthBoat(CallbackInfo ci) {
        var boatTypes = new BoatEntity.Type[field_7724.length + 1];
        System.arraycopy(field_7724, 0, boatTypes, 0, field_7724.length);

        boatTypes[boatTypes.length - 1] = BoatEntityTypeMixin.endium$invokeNew("AMARANTH", BoatEntity.Type.values().length, Blocks.OAK_PLANKS, "amaranth");
        ModEntities.AMARANTH_BOAT = boatTypes[boatTypes.length - 1];

        field_7724 = boatTypes;
    }

    @Inject(method = "getType(I)Lnet/minecraft/entity/vehicle/BoatEntity$Type;", at = @At("HEAD"), cancellable = true)
    private static void returnCorrectType(int type, CallbackInfoReturnable<BoatEntity.Type> cir) {
        if (type != ModEntities.AMARANTH_BOAT.ordinal()) return;
        cir.setReturnValue(ModEntities.AMARANTH_BOAT);
    }

    @Inject(method = "getType(Ljava/lang/String;)Lnet/minecraft/entity/vehicle/BoatEntity$Type;", at = @At("HEAD"), cancellable = true)
    private static void returnCorrectType(String name, CallbackInfoReturnable<BoatEntity.Type> cir) {
        if (!Objects.equals(name, "amaranth")) return;
        cir.setReturnValue(ModEntities.AMARANTH_BOAT);
    }
}