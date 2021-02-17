package dzwdz.abacus;

import de.siphalor.amecs.api.AmecsKeyBinding;
import de.siphalor.amecs.api.KeyModifiers;
import de.siphalor.amecs.api.PriorityKeyBinding;
import dzwdz.abacus.mixin.HandledScreenInvoker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class WatchKeybinding extends AmecsKeyBinding implements PriorityKeyBinding {
    public WatchKeybinding(Identifier id, InputUtil.Type type, int code, String category, KeyModifiers defaultModifiers) {
        super(id, type, code, category, defaultModifiers);
    }

    @Override
    public boolean onPressedPriority() {
        MinecraftClient mc = MinecraftClient.getInstance();

        Screen screen = mc.currentScreen;
        if (!(screen instanceof HandledScreen)) return false;

        Mouse mouse = mc.mouse;
        double scale = mc.getWindow().getScaleFactor();
        Slot slot = ((HandledScreenInvoker) screen).invokeGetSlotAt(mouse.getX() / scale, mouse.getY() / scale);
        if (slot == null) return false;

        ItemStack item = slot.getStack().copy();
        if (item.isEmpty()) return false;

        item.setDamage(0);

        boolean wasPresent = Abacus.selectedItems.removeIf(item::isItemEqualIgnoreDamage);
        if (!wasPresent)
            Abacus.selectedItems.add(item);
        return true;
    }
}
