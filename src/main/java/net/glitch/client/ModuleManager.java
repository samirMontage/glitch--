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
        // Боевые модули
        modules.add(new AutoTotem());
        modules.add(new KillAura());
        
        // Рендер и утилиты
        modules.add(new ClickGuiModule());
        modules.add(new Module("Fullbright", Category.RENDER));
        modules.add(new Module("AutoSprint", Category.MOVEMENT));
        modules.add(new Module("ESP", Category.RENDER));
    }

    public List<Module> getModules() {
        return modules;
    }
}
