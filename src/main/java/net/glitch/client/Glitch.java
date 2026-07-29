package net.glitch.client;

import net.fabricmc.api.ModInitializer;
import net.glitch.client.ModuleManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Glitch implements ModInitializer {
    public static final String MOD_ID = "glitch";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    private static Glitch INSTANCE;
    private ModuleManager moduleManager;

    @Override
    public void onInitialize() {
        INSTANCE = this;
        LOGGER.info("Initializing Glitch Client...");
        
        moduleManager = new ModuleManager();
    }

    public static Glitch getInstance() {
        return INSTANCE;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
