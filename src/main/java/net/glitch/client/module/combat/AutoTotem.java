package net.glitch.client.module.combat;

import net.glitch.client.module.Category;
import net.glitch.client.module.Module;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.SlotActionType;

public class AutoTotem extends Module {
    private int delay = 0;

    public AutoTotem() {
        super("AutoTotem", Category.COMBAT);
    }

    public void onTick(net.minecraft.client.MinecraftClient client) {
        if (!isEnabled()) return;
        if (client.player == null || client.interactionManager == null) return;

        if (client.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING) {
            delay = 0;
            return;
        }

        if (delay > 0) {
            delay--;
            return;
        }

        for (int i = 0; i < 36; i++) {
            // Обрати внимание: здесь теперь поле inventory без круглых скобок
            ItemStack stack = client.player.inventory.getStack(i);
            if (stack.getItem() == Items.TOTEM_OF_UNDYING) {
                int slot = i < 9 ? i + 36 : i;
                
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    slot, 0, SlotActionType.PICKUP, client.player
                );
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    45, 0, SlotActionType.PICKUP, client.player
                );
                client.interactionManager.clickSlot(
                    client.player.currentScreenHandler.syncId,
                    slot, 0, SlotActionType.PICKUP, client.player
                );
                
                delay = 5;
                break;
            }
        }
    }
}
