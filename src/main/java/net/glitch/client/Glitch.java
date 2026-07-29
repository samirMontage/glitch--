package net.glitch.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.glitch.client.module.ModuleManager;
import net.glitch.client.ui.ClickGuiScreen;
import org.lwjgl.glfw.GLFW;

public class Glitch implements ClientModInitializer {
    public static Glitch INSTANCE;
    private ModuleManager moduleManager;
    private static KeyBinding clickGuiKey;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        moduleManager = new ModuleManager();

        // Регистрируем клавишу RSHIFT для открытия ClickGUI
        clickGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.glitch.clickgui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.glitch"
        ));

        // Отслеживаем нажатие каждый тик
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (clickGuiKey.wasPressed()) {
                if (client.currentScreen == null) {
                    client.openScreen(new ClickGuiScreen());
                }
            }
        });
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
