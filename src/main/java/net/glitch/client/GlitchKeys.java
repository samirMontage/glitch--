package net.glitch.client;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding; // Если ругается на options, замени на option в зависимости от маппингов, но лучше так:
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class GlitchKeys {
    public static net.minecraft.client.options.KeyBinding openGuiKey;

    public static void register() {
        openGuiKey = KeyBindingHelper.registerKeyBinding(new net.minecraft.client.options.KeyBinding(
            "key.glitch.open_gui",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_SHIFT,
            "category.glitch.main"
        ));
    }
}
