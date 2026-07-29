package net.glitch.client;

import net.glitch.client.setting.Setting;
import java.util.ArrayList;
import java.util.List;

public abstract class Module {
    private final String name;
    private final String description;
    private final Category category;
    private int key;
    private boolean toggled;
    private final List<Setting<?>> settings = new ArrayList<>();

    public Module(String name, String description, Category category, int key) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
        this.toggled = false;
    }

    public void addSetting(Setting<?> setting) {
        this.settings.add(setting);
    }

    public List<Setting<?>> getSettings() {
        return settings;
    }

    public void toggle() {
        setToggled(!toggled);
    }

    public void setToggled(boolean toggled) {
        if (this.toggled == toggled) return;
        this.toggled = toggled;

        if (toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void onEnable() {}
    public void onDisable() {}
    public void onUpdate() {}

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }
    public boolean isToggled() { return toggled; }
}
