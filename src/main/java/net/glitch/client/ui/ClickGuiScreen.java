package net.glitch.client.ui;

import net.glitch.client.Category;
import net.glitch.client.Glitch;
import net.glitch.client.Module;

import java.util.ArrayList;
import java.util.List;

public class ClickGuiScreen {

    // Размеры и координаты окон категорий
    private final int width = 100;
    private final int height = 200;

    public void drawScreen(int mouseX, int mouseY) {
        int xOffset = 20;

        // Рисуем рамку для каждой категории (COMBAT, MOVEMENT, RENDER...)
        for (Category category : Category.values()) {
            drawCategoryPanel(category, xOffset, 20, mouseX, mouseY);
            xOffset += 110; // Сдвиг следующей панели вправо
        }
    }

    private void drawCategoryPanel(Category category, int x, int y, int mouseX, int mouseY) {
        // Шапка панели (Название категории)
        System.out.println("Rendering Category: " + category.getName() + " at X:" + x + " Y:" + y);

        // Список модулей, принадлежащих этой категории
        int moduleY = y + 25;
        for (Module module : Glitch.INSTANCE.getModuleManager().getModulesByCategory(category)) {
            boolean isHovered = mouseX >= x && mouseX <= x + width && mouseY >= moduleY && mouseY <= moduleY + 18;
            
            // Цвет кнопки зависит от того, включен модуль или нет
            String status = module.isToggled() ? "[ON]" : "[OFF]";
            System.out.println("  -> Module Button: " + module.getName() + " " + status + (isHovered ? " (Hovered)" : ""));

            moduleY += 20;
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (button != 0) return; // Регистрируем только ЛКМ

        int xOffset = 20;
        for (Category category : Category.values()) {
            int moduleY = 20 + 25;
            for (Module module : Glitch.INSTANCE.getModuleManager().getModulesByCategory(category)) {
                
                // Проверка клика по кнопке модуля
                if (mouseX >= xOffset && mouseX <= xOffset + width && mouseY >= moduleY && mouseY <= moduleY + 18) {
                    module.toggle(); // Включаем/выключаем модуль по клику!
                    System.out.println("Toggled module: " + module.getName() + " -> " + module.isToggled());
                }
                moduleY += 20;
            }
            xOffset += 110;
        }
    }
}
