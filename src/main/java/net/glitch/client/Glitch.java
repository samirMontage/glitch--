package net.glitch.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.glitch.client.module.ModuleManager;
import net.glitch.client.ui.ClickGuiScreen;
import org.lwjgl.glfw.GLFW;

public class Glitch implements ModInitializer, ClientModInitializer {
    public static Glitch INSTANCE;
    private ModuleManager moduleManager;
    public static KeyBinding clickGuiKey;

    @Override
    public void onInitialize() {
        // Оставляем пустым для main эндпоинта
    }

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        moduleManager = new ModuleManager();

        // 1. Создаем бинд
        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.glitch.clickgui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.glitch"
        ));

        // 2. Проверяем нажатие каждый тик клиента
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.currentScreen == null) {
                if (clickGuiKey.wasPressed()) {
                    client.openScreen(new ClickGuiScreen());
                }
            }
        });
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
