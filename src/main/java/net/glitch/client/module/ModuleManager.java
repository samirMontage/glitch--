package net.glitch.client.module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Добавляем тестовые модули
        modules.add(new Module("Fullbright", Category.RENDER));
        modules.add(new Module("AutoSprint", Category.MOVEMENT));
        modules.add(new Module("ESP", Category.RENDER));
    }

    public List<Module> getModules() {
        return modules;
    }
}
