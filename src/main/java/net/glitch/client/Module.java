package net.glitch.client;

public abstract class Module {
    private final String name;
    private final String description;
    private final Category category;
    private int key;
    private boolean toggled;

    public Module(String name, String description, Category category, int key) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.key = key;
        this.toggled = false;
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
