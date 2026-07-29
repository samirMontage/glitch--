package net.glitch.client.module;

import net.glitch.client.Category;
import net.glitch.client.Module;
import net.glitch.client.ui.ClickGuiScreen;

public class ClickGuiModule extends Module {

    public ClickGuiModule() {
        // Имя, Описание, Категория, Стандартная клавиша (344 = Right Shift)
        super("ClickGUI", "Открывает меню управления модулями", Category.RENDER, 344);
    }

    @Override
    public void onEnable() {
        System.out.println("Opening Glitch ClickGUI...");
        // В реальном клиенте здесь открывается Screen в Майнкрафте:
        // mc.openScreen(new ClickGuiScreen());
    }

    @Override
    public void onDisable() {
        System.out.println("Closing Glitch ClickGUI...");
    }
}
