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
        this.renderBackground(matrices);

        drawCenteredText(matrices, this.textRenderer, "Glitch Client — ClickGUI", this.width / 2, 20, 0xFFFFFFFF);

        if (Glitch.INSTANCE != null && Glitch.INSTANCE.getModuleManager() != null) {
            List<Module> modules = Glitch.INSTANCE.getModuleManager().getModules();

            int x = 50;
            int y = 50;

            if (modules != null) {
                for (Module module : modules) {
                    // Если модуль включен — подсвечиваем плашку зеленым акцентом, иначе темно-серым
                    int bgColor = module.isEnabled() ? 0xDD228B22 : 0xAA111111;
                    fill(matrices, x, y, x + 130, y + 20, bgColor);

                    // Цвет текста
                    int textColor = module.isEnabled() ? 0xFF55FF55 : 0xCCCCCCCC;
                    drawStringWithShadow(matrices, this.textRenderer, module.getName(), x + 8, y + 6, textColor);

                    y += 25;
                }
            }
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Проверяем клик ЛКМ (button == 0)
        if (button == 0 && Glitch.INSTANCE != null && Glitch.INSTANCE.getModuleManager() != null) {
            List<Module> modules = Glitch.INSTANCE.getModuleManager().getModules();

            int x = 50;
            int y = 50;

            if (modules != null) {
                for (Module module : modules) {
                    // Проверяем, попал ли курсор в границы плашки модуля
                    if (mouseX >= x && mouseX <= x + 130 && mouseY >= y && mouseY <= y + 20) {
                        module.toggle(); // Переключаем модуль!
                        return true;
                    }
                    y += 25;
                }
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
