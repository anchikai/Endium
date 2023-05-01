package net.anchikai.endium.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.anchikai.endium.screen.ChromiumAnvilScreenHandler;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.RenameItemC2SPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ChromiumAnvilScreen extends ForgingScreen<ChromiumAnvilScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/anvil.png");
    private static final Text TOO_EXPENSIVE_TEXT = Text.translatable("container.repair.expensive");
    private TextFieldWidget nameField;
    private final PlayerEntity player;

    public ChromiumAnvilScreen(ChromiumAnvilScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title, TEXTURE);
        this.player = inventory.player;
        this.titleX = 60;
    }

    public void handledScreenTick() {
        super.handledScreenTick();
        this.nameField.tick();
    }

    protected void setup() {
        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.nameField = new TextFieldWidget(this.textRenderer, i + 62, j + 24, 103, 12, Text.translatable("container.repair"));
        this.nameField.setFocusUnlocked(false);
        this.nameField.setEditableColor(-1);
        this.nameField.setUneditableColor(-1);
        this.nameField.setDrawsBackground(false);
        this.nameField.setMaxLength(50);
        this.nameField.setChangedListener(this::onRenamed);
        this.nameField.setText("");
        this.addSelectableChild(this.nameField);
        this.setInitialFocus(this.nameField);
        this.nameField.setEditable(false);
    }

    public void resize(MinecraftClient client, int width, int height) {
        String string = this.nameField.getText();
        this.init(client, width, height);
        this.nameField.setText(string);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256) {
            this.client.player.closeHandledScreen();
        }

        return this.nameField.keyPressed(keyCode, scanCode, modifiers) || this.nameField.isActive() || super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void onRenamed(String name) {
        if (!name.isEmpty()) {
            String string = name;
            Slot slot = this.handler.getSlot(0);
            if (slot != null && slot.hasStack() && !slot.getStack().hasCustomName() && name.equals(slot.getStack().getName().getString())) {
                string = "";
            }

            this.handler.setNewItemName(string);
            this.client.player.networkHandler.sendPacket(new RenameItemC2SPacket(string));
        }
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        RenderSystem.disableBlend();
        super.drawForeground(matrices, mouseX, mouseY);
        int level = handler.getLevelCost();
        if (level > 0) {
            int color = 8453920;
            boolean bl = true;
            String string = I18n.translate("container.repair.cost", level);
            if (level >= 40 && !player.getAbilities().creativeMode) {
                string = I18n.translate("container.repair.expensive");
                color = 16736352;
            } else if (!handler.getSlot(2).hasStack()) {
                bl = false;
            } else if (!handler.getSlot(2).canTakeItems(player)) {
                color = 16736352;
            }

            if (bl) {
                int k = backgroundWidth - 8 - textRenderer.getWidth(string) - 2;
                fill(matrices, k - 2, 67, backgroundWidth - 8, 79, 1325400064);
                textRenderer.drawWithShadow(matrices, string, k, 69.0F, color);
            }
        }

    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        super.drawBackground(matrices, delta, mouseX, mouseY);
        drawTexture(matrices, this.x + 59, this.y + 20, 0, this.backgroundHeight + (this.handler.getSlot(0).hasStack() ? 0 : 16), 110, 16);
    }

    public void renderForeground(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.nameField.render(matrices, mouseX, mouseY, delta);
    }

    protected void drawInvalidRecipeArrow(MatrixStack matrices, int x, int y) {
        if ((this.handler.getSlot(0).hasStack() || this.handler.getSlot(1).hasStack()) && !this.handler.getSlot(this.handler.getResultSlotIndex()).hasStack()) {
            drawTexture(matrices, x + 99, y + 45, this.backgroundWidth, 0, 28, 21);
        }

    }

    public void onSlotUpdate(ScreenHandler handler, int slotId, ItemStack stack) {
        if (slotId == 0) {
            this.nameField.setText(stack.isEmpty() ? "" : stack.getName().getString());
            this.nameField.setEditable(!stack.isEmpty());
            this.setFocused(this.nameField);
        }

    }
}