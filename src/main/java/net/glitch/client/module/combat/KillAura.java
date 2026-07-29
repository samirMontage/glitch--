package net.glitch.client.module.combat;

import net.glitch.client.module.Category;
import net.glitch.client.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class KillAura extends Module {
    private int ticks = 0;

    public KillAura() {
        super("KillAura", Category.COMBAT);
    }

    public void onTick(net.minecraft.client.MinecraftClient client) {
        if (!isEnabled()) return;
        if (client.player == null || client.world == null) return;

        Entity target = null;
        double minDistance = 4.2; // Радиус атаки

        for (Entity entity : client.world.getEntities()) {
            if (entity == client.player) continue;
            if (!(entity instanceof LivingEntity)) continue;
            if (entity.isDead()) continue;
            
            // На Рилик полезно бить и игроков, и мобов (в зависимости от режима)
            if (entity instanceof PlayerEntity || entity instanceof LivingEntity) {
                double dist = client.player.distanceTo(entity);
                if (dist < minDistance) {
                    minDistance = dist;
                    target = entity;
                }
            }
        }

        if (target != null) {
            ticks++;
            // Бьем по кд кулдауна атаки (примерно каждые 10-12 тиков для меча)
            if (ticks >= 10) {
                client.interactionManager.attackEntity(client.player, target);
                client.player.swingHand(net.minecraft.util.Hand.MAIN_HAND);
                ticks = 0;
            }
        }
    }

    @Override
    public void onDisable() {
        ticks = 0;
    }
}
