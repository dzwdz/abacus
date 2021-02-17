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

            // i'm not using PlayerInventory.count because it's ignoring nbt
            int count = 0;
            for (ItemStack inventoryStack : mc.player.inventory.main)
                if (inventoryStack.isItemEqualIgnoreDamage(item))
                    count += inventoryStack.getCount();

            for (ItemStack inventoryStack : mc.player.inventory.offHand)
                if (inventoryStack.isItemEqualIgnoreDamage(item))
                    count += inventoryStack.getCount();

            String display;
            if (count < 1000) {
                display = Integer.toString(count);
            } else {
                display = Integer.toString(count/1000) + "k";
            }
            mc.getItemRenderer().renderGuiItemOverlay(mc.textRenderer, item, x, y, display);
            x += 20;

            if (x + 20 > scaledWidth) {
                x = scaledWidth / 2 + 94;
                y -= 20;
            }
        }
        mc.getTextureManager().bindTexture(GUI_ICONS_TEXTURE);
    }
}
