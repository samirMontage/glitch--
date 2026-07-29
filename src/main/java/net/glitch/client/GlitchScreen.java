package net.glitch.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class GlitchScreen extends Screen {
    public GlitchScreen() {
        super(new LiteralText("Glitch Client Menu"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.textRenderer.drawWithShadow(matrices, "Glitch Client v1.0.0", (float)(this.width / 2 - 50), (float)(this.height / 2 - 10), 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
