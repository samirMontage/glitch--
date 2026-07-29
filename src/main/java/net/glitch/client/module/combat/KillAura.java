package net.glitch.client.module.combat;

import net.glitch.client.Category;
import net.glitch.client.Module;
import net.glitch.client.setting.Setting;

public class KillAura extends Module {

    // Настройки Ауры под PvP 1.16+ и RW
    public Setting<Double> range = new Setting<>("Attack Range", 3.2, 2.0, 6.0);
    public Setting<Boolean> attackCooldown = new Setting<>("1.16 Cooldown", true); // Авто-урон по задержке оружия
    public Setting<Boolean> gcdFix = new Setting<>("GCD Mouse Fix", true); // Сглаживание ротации под легитную мышь
    public Setting<Boolean> playersOnly = new Setting<>("Players Only", true);
    public Setting<Boolean> shieldBreaker = new Setting<>("Auto Axe Shield", true); // Ломать щиты топором

    public KillAura() {
        super("KillAura", "Автоматическая атака врагов с бесфлажными ротациями для RW", Category.COMBAT, 82); // 82 = Клавиша R
        addSetting(range);
        addSetting(attackCooldown);
        addSetting(gcdFix);
        addSetting(playersOnly);
        addSetting(shieldBreaker);
    }

    @Override
    public void onUpdate() {
        if (!isToggled()) return;

        // Логика под RW:
        // 1. Поиск ближайшей цели в радиусе (range.getValue())
        // 2. Расчет легитной ротации взгляда (Yaw/Pitch) с учетом GCD
        // 3. Если у цели поднят щит и включен shieldBreaker -> быстрый свап на топор
        // 4. Удар при готовности Cooldown оружия
    }
}
