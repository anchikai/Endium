package net.anchikai.endium.screen;

import net.anchikai.endium.EndiumMod;
import net.anchikai.endium.client.gui.screen.ChromiumAnvilScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class EndiumModScreenHandlers {
    public static ScreenHandlerType<ChromiumAnvilScreenHandler> CHROMIUM_ANVIL = register(EndiumMod.id("chromium_anvil"), ChromiumAnvilScreenHandler::new);

    public static <T extends ScreenHandler> ScreenHandlerType<T> register(Identifier id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, id, new ScreenHandlerType<>(factory, FeatureSet.empty()));
    }

    public static void init() {
    }

    public static void initializeClient() {
        HandledScreens.register(EndiumModScreenHandlers.CHROMIUM_ANVIL, ChromiumAnvilScreen::new);
    }
}