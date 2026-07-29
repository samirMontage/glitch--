package net.glitch.client.ui;

import net.glitch.client.Glitch;
import net.glitch.client.module.Module;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import java.util.List;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(Text.of("Glitch Client - ClickGUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        
        // Безопасное получение списка модулей через публичный метод getInstance()
        if (Glitch.getInstance() != null && Glitch.getInstance().getModuleManager() != null) {
            List<Module> modules = Glitch.getInstance().getModuleManager().getModules();
            
            int y = 20;
            for (Module module : modules) {
                String status = module.isEnabled() ? " [§aON§r]" : " [§cOFF§r]";
                drawStringWithShadow(matrices, this.textRenderer, module.getName() + status, 20, y, 0xFFFFFF);
                y += 15;
            }
        }

        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        // Обработка кликов мыши по модулям
        if (button == 0 && Glitch.getInstance() != null && Glitch.getInstance().getModuleManager() != null) {
            List<Module> modules = Glitch.getInstance().getModuleManager().getModules();
            int y = 20;
            for (Module module : modules) {
                if (mouseX >= 20 && mouseX <= 120 && mouseY >= y && mouseY <= y + 12) {
                    module.toggle();
                    break;
                }
                y += 15;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
