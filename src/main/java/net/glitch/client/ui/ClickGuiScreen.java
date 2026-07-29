package net.glitch.client.ui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

import net.glitch.client.Glitch;
import net.glitch.client.module.Category;
import net.glitch.client.module.Module;

public class ClickGuiScreen extends Screen {

    public ClickGuiScreen() {
        super(new LiteralText("ClickGUI"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);

        int x = 20;
        for (Category category : Category.values()) {
            int y = 20;
            // Рендер категории
            
            for (Module module : Glitch.INSTANCE.getModuleManager().getModulesByCategory(category)) {
                // Рендер модулей категории
                y += 15;
            }
            
            x += 100;
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
