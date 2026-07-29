package net.glitch.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.glitch.client.module.ModuleManager;
import net.glitch.client.ui.ClickGuiScreen;
import org.lwjgl.glfw.GLFW;

public class Glitch implements ModInitializer, ClientModInitializer {
    public static Glitch INSTANCE;
    private ModuleManager moduleManager;
    private boolean isKeyPressed = false;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        moduleManager = new ModuleManager();
    }

    @Override
    public void onInitializeClient() {
        // Отслеживаем прямое физическое нажатие Правого Shift (GLFW_KEY_RIGHT_SHIFT = 301)
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.getWindow() != null) {
                long windowHandle = client.getWindow().getHandle();
                boolean down = GLFW.glfwGetKey(windowHandle, GLFW.GLFW_KEY_RIGHT_SHIFT) == GLFW.GLFW_PRESS;

                if (down && !isKeyPressed) {
                    isKeyPressed = true;
                    if (client.currentScreen == null) {
                        client.execute(() -> client.openScreen(new ClickGuiScreen()));
                    }
                } else if (!down) {
                    isKeyPressed = false;
                }
            }
        });
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
