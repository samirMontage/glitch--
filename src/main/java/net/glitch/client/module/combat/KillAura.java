package net.glitch.client.module.combat;

import net.glitch.client.module.Category;
import net.glitch.client.module.Module;

public class KillAura extends Module {

    public KillAura() {
        super("KillAura", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        if (!isEnabled()) return;
    }

    @Override
    public void onDisable() {
    }
}
