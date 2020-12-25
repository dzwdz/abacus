package dzwdz.abacus;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

import static net.minecraft.client.gui.DrawableHelper.GUI_ICONS_TEXTURE;

public class Renderer implements HudRenderCallback {
    private MinecraftClient mc;

    public Renderer() {
        mc = MinecraftClient.getInstance();
    }

    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        int scaledWidth = mc.getWindow().getScaledWidth();
        int scaledHeight = mc.getWindow().getScaledHeight();
        int x = scaledWidth / 2 + 94;
        int y = scaledHeight - 19;
        for (ItemStack item : Abacus.selectedItems) {
            mc.getItemRenderer().renderInGui(item, x, y);
            int count = 0;
            for (ItemStack inventoryStack : mc.player.inventory.main) { // todo don't do this on each frame
                if (inventoryStack.isItemEqualIgnoreDamage(item)) {
                    count += inventoryStack.getCount();
                }
            }
            mc.getItemRenderer().renderGuiItemOverlay(mc.textRenderer, item, x, y, Integer.toString(count));
            x += 20;
        }
        mc.getTextureManager().bindTexture(GUI_ICONS_TEXTURE);
    }
}
