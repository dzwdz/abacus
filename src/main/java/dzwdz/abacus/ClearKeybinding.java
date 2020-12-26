package dzwdz.abacus;

import de.siphalor.amecs.api.AmecsKeyBinding;
import de.siphalor.amecs.api.KeyModifiers;
import de.siphalor.amecs.api.PriorityKeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;

public class ClearKeybinding extends AmecsKeyBinding implements PriorityKeyBinding {
    public ClearKeybinding(Identifier id, InputUtil.Type type, int code, String category, KeyModifiers defaultModifiers) {
        super(id, type, code, category, defaultModifiers);
    }

    @Override
    public boolean onPressedPriority() {
        Screen screen = MinecraftClient.getInstance().currentScreen;
        if (!(screen instanceof HandledScreen || screen == null)) return false;

        Abacus.selectedItems.clear();
        return true;
    }
}
