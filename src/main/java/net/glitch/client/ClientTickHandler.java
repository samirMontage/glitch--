package net.glitch.client;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class ClientTickHandler {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (GlitchKeys.openGuiKey.wasPressed()) {
                if (client.player != null) {
                    Glitch.LOGGER.info("Правый Shift нажат!");
                }
            }
        });
    }
}
