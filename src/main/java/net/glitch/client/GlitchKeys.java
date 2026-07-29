package net.glitch.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class GlitchKeys {
    public static KeyBinding openGuiKey;

    public static void register() {
        openGuiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.glitch.open_gui", // Название для перевода
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT, // Кнопка: Правый Shift
            "category.glitch.main" // Категория в настройках управления
        ));
    }
}
