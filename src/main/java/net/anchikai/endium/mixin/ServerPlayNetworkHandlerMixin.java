package net.anchikai.endium.mixin;

import net.anchikai.endium.screen.ChromiumAnvilScreenHandler;
import net.minecraft.SharedConstants;
import net.minecraft.network.packet.c2s.play.RenameItemC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {
    @Shadow
    public ServerPlayerEntity player;

    @Inject(method = "onRenameItem", at = @At("RETURN"))
    public void onRenameItem(RenameItemC2SPacket packet, CallbackInfo info) {
        if (((ServerPlayNetworkHandler) (Object) this).player.currentScreenHandler instanceof ChromiumAnvilScreenHandler anvilScreenHandler) {
            String string = SharedConstants.stripInvalidChars(packet.getName());
            if (string.length() <= 35) {
                anvilScreenHandler.setNewItemName(string);
            }
        }
    }
}