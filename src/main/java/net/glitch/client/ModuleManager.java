package net.glitch.client;

import net.glitch.client.module.Module;
import net.glitch.client.module.Category;
import net.glitch.client.module.combat.AutoTotem;
import net.glitch.client.module.combat.KillAura;
import net.glitch.client.module.ClickGuiModule;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        modules.add(new AutoTotem());
        modules.add(new KillAura());
        modules.add(new ClickGuiModule());
    }

    public List<Module> getModules() {
        return modules;
    }

    public List<Module> getModulesByCategory(Category category) {
        List<Module> matched = new ArrayList<>();
        for (Module module : modules) {
            if (module.getCategory() == category) {
                matched.add(module);
            }
        }
        return matched;
    }
}
