package net.glitch.client.module;

import java.util.ArrayList;
import java.util.List;

public class Module {
    private final String name;
    private String description;
    private Category category;
    private int key;
    private boolean enabled;
    private final List<Object> settings = new ArrayList<>();

    // Конструктор на 4 аргумента (имя, описание, категория, клавиша)
    public Module(String name, String description, Category category, int key) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
        this.enabled = false;
    }

    // Конструктор на 3 аргумента (имя, описание, категория)
    public Module(String name, String description, Category category) {
        this(name, description, category, 0);
    }

    // Конструктор на 2 аргумента (имя, категория)
    public Module(String name, Category category) {
        this(name, "", category, 0);
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Category getCategory() { return category; }
    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    public boolean isEnabled() { return enabled; }
    public boolean isToggled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) { onEnable(); } else { onDisable(); }
    }

    public void addSetting(Object setting) {
        this.settings.add(setting);
    }

    public void onEnable() {}
    public void onDisable() {}
}
