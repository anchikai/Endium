package net.anchikai.endium.screen;

import net.anchikai.endium.client.gui.screen.ChromiumAnvilScreen;

import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.anchikai.endium.EndiumMod.id;

public class EndiumModScreenHandlers {

    public static ScreenHandlerType<ChromiumAnvilScreenHandler> CHROMIUM_ANVIL;

    static {
        CHROMIUM_ANVIL = register(id("chromium_anvil"), ChromiumAnvilScreenHandler::new);
    }

    public static <T extends ScreenHandler> ScreenHandlerType<T> register(Identifier id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registry.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory));
    }

    public static void init() {
    }

    public static void initializeClient() {
        HandledScreens.register(EndiumModScreenHandlers.CHROMIUM_ANVIL, ChromiumAnvilScreen::new);
    }
}