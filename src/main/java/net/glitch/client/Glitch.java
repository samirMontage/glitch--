package net.glitch.client;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Glitch implements ClientModInitializer {
    public static final String MOD_ID = "glitch";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    private static Glitch INSTANCE;
    private ModuleManager moduleManager;

    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        LOGGER.info("Initializing Glitch Client...");
        
        GlitchKeys.register(); // Регистрируем правый Shift
        ClientTickHandler.init(); // Подключаем отслеживание нажатия
        
        moduleManager = new ModuleManager();
    }

    public static Glitch getInstance() {
        return INSTANCE;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
