package net.glitch.client.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.glitch.client.Glitch;
import net.glitch.client.module.Module;

import java.util.List;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(new LiteralText("ClickGUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        // 1. Отрисовываем затемнение фона
        this.renderBackground(matrices);

        // 2. Рисуем заголовок меню в центре сверху
        drawCenteredText(matrices, this.textRenderer, "Glitch Client — ClickGUI", this.width / 2, 20, 0xFFFFFFFF);

        // 3. Выводим список модулей плашками
        if (Glitch.INSTANCE != null && Glitch.INSTANCE.getModuleManager() != null) {
            List<Module> modules = Glitch.INSTANCE.getModuleManager().getModules();
            
            int x = 50;
            int y = 50;

            if (modules.isEmpty()) {
                drawStringWithShadow(matrices, this.textRenderer, "Нет загруженных модулей...", x, y, 0xAAAAAA);
            } else {
                for (Module module : modules) {
                    // Рисуем задний фон для модуля (плашка)
                    fill(matrices, x, y, x + 120, y + 20, 0x88000000);
                    
                    // Зеленый цвет если включен, белый если выключен
                    int color = module.isEnabled() ? 0xFF00FF00 : 0xFFFFFFFF;
                    drawStringWithShadow(matrices, this.textRenderer, module.getName(), x + 5, y + 6, color);
                    
                    y += 25; // Смещение вниз для следующего модуля
                }
            }
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false; // Чтобы игра не вставала на паузу в одиночке при открытии GUI
    }
}
