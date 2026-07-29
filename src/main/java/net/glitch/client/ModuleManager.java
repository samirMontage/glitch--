package net.glitch.client;

import net.glitch.client.module.ClickGuiModule;
import net.glitch.client.module.combat.AutoTotem;
import net.glitch.client.module.combat.KillAura;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        // Регистрируем все наши модули
        register(new ClickGuiModule());
        register(new AutoTotem());
        register(new KillAura());
    }

    private void register(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Category category) {
        return modules.stream()
                .filter(m -> m.getCategory() == category)
                .collect(Collectors.toList());
    }
}
