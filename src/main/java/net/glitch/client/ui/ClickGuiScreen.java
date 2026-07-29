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
        // 1. Рисуем затемнение фона
        this.renderBackground(matrices);

        // 2. Рисуем заголовок
        drawCenteredText(matrices, this.textRenderer, "Glitch Client — ClickGUI", this.width / 2, 20, 0xFFFFFFFF);

        // 3. Рисуем список модулей
        if (Glitch.INSTANCE != null && Glitch.INSTANCE.getModuleManager() != null) {
            List<Module> modules = Glitch.INSTANCE.getModuleManager().getModules();

            int x = 50;
            int y = 50;

            if (modules == null || modules.isEmpty()) {
                drawStringWithShadow(matrices, this.textRenderer, "Нет загруженных модулей...", x, y, 0xAAAAAA);
            } else {
                for (Module module : modules) {
                    // Рисуем рамку плашки
                    fill(matrices, x, y, x + 130, y + 20, 0xAA000000);

                    // Отрисовываем название модуля
                    drawStringWithShadow(matrices, this.textRenderer, module.getName(), x + 8, y + 6, 0xFFFFFFFF);

                    y += 25;
                }
            }
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
