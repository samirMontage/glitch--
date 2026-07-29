package net.glitch.client;

public class Glitch {
    public static final Glitch INSTANCE = new Glitch();
    public static final String NAME = "Glitch Client";
    public static final String VERSION = "1.0.0";

    public void init() {
        System.out.println("[" + NAME + "] Loading client version " + VERSION);
    }
}
