package net.glitch.client.module.combat;

import net.glitch.client.module.Category;
import net.glitch.client.module.Module;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;

public class AutoTotem extends Module {

    public AutoTotem() {
        super("AutoTotem", Category.COMBAT);
    }

    public void onTick(net.minecraft.client.MinecraftClient client) {
        if (!isEnabled()) return;
        if (client.player == null || client.interactionManager == null) return;

        // Проверяем, есть ли уже тотем в левой руке
        if (client.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING) {
            return;
        }

        // Ищем тотем в инвентаре
        for (int i = 0; i < 36; i++) {
            var stack = client.player.getInventory().getStack(i);
            if (stack.getItem() == Items.TOTEM_OF_UNDYING) {
                int slot = i < 9 ? i + 36 : i;
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    slot,
                    0,
                    SlotActionType.PICKUP,
                    client.player
                );
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    45, // Слот офхенда (левой руки)
                    0,
                    SlotActionType.PICKUP,
                    client.player
                );
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    slot,
                    0,
                    SlotActionType.PICKUP,
                    client.player
                );
                break;
            }
        }
    }
}
