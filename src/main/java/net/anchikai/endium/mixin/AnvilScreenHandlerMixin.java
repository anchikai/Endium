package net.anchikai.endium.mixin;

import net.anchikai.endium.access.ChromiumAnvilInterface;
import net.anchikai.endium.block.ChromiumBlocks;
import net.anchikai.endium.network.SyncPacket;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import org.apache.commons.lang3.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import io.netty.buffer.Unpooled;

import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Iterator;
import java.util.Map;

import static net.minecraft.screen.AnvilScreenHandler.getNextCost;

@Mixin(AnvilScreenHandler.class)
public abstract class AnvilScreenHandlerMixin extends ForgingScreenHandler implements ChromiumAnvilInterface {
    @Shadow
    private final Property levelCost;
    public boolean isChromiumAnvil = false;

    public AnvilScreenHandlerMixin(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, context);
        this.levelCost = Property.create();
    }

    @Inject(method = "canUse", at = @At(value = "HEAD"))
    private void canUse(BlockState state, CallbackInfoReturnable<Boolean> info) {
        if (state.isOf(ChromiumBlocks.CHROMIUM_ANVIL)) {
            isChromiumAnvil = true;
            PacketByteBuf data = new PacketByteBuf(Unpooled.buffer());
            data.writeInt(player.getId());
            data.writeString(state.getBlock().toString());
            ServerPlayNetworking.send((ServerPlayerEntity) player, SyncPacket.ANVIL_SYNC_PACKET, data);
        }
    }

    @Inject(method = "onTakeOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;set(I)V"), cancellable = true)
    private void onTakeOutput(PlayerEntity player, ItemStack stack, CallbackInfo info) {
        if (isChromiumAnvil) {
            this.context.run((world, blockPos) -> {
                this.levelCost.set(0);
                world.syncWorldEvent(1030, blockPos, 0);
                info.cancel();
            });
        }
    }

    @ModifyArg(
            slice = @Slice(
                from = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;setCustomName(Lnet/minecraft/text/Text;)Lnet/minecraft/item/ItemStack;")
            ),
            at = @At(value = "INVOKE", target = "Lnet/minecraft/screen/Property;set(I)V", ordinal = 0),
            method = "updateResult"
    )
    private int endium$halveCostOfRepair(int cost) {
        if (isChromiumAnvil) {
            return (int) (cost * 0.5);
        }
        return cost;
    }

    @Override
    public void setChromiumAnvil(String string) {
        if (string.equals(ChromiumBlocks.CHROMIUM_ANVIL.toString())) {
            isChromiumAnvil = true;
        }
    }
}