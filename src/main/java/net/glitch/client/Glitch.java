package net.glitch.client;

import net.fabricmc.api.ModInitializer;
import net.glitch.client.module.ModuleManager;

public class Glitch implements ModInitializer {
    public static Glitch INSTANCE;
    private ModuleManager moduleManager;

    @Override
    public onInitialize() {
        INSTANCE = this;
        moduleManager = new ModuleManager();
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
