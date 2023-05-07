package net.anchikai.endium.mixin;

import net.anchikai.endium.block.ChromiumBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.state.property.DirectionProperty;

@Mixin(AnvilBlock.class)
public class AnvilBlockMixin {
    @Shadow
    public static final DirectionProperty FACING;

    @Inject(method = "getLandingState", at = @At("HEAD"), cancellable = true)
    private static void getLandingStateMixin(BlockState fallingState, CallbackInfoReturnable<BlockState> info) {
        if (fallingState.isOf(ChromiumBlocks.CHROMIUM_ANVIL)) {
            info.setReturnValue(ChromiumBlocks.CHROMIUM_ANVIL.getDefaultState().with(FACING, fallingState.get(FACING)));
        }
    }

    static {
        FACING = HorizontalFacingBlock.FACING;
    }
}