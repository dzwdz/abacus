package dzwdz.abacus;

import de.siphalor.amecs.api.KeyModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class Abacus implements ModInitializer {
    public static Renderer renderer;
    public static List<ItemStack> selectedItems = new LinkedList<>();

    public static KeyBinding watchKeybinding = new WatchKeybinding(id("watch"), InputUtil.Type.KEYSYM, -1, "key.categories.abacus", new KeyModifiers());
    public static KeyBinding clearKeybinding = new ClearKeybinding(id("clear"), InputUtil.Type.KEYSYM, -1, "key.categories.abacus", new KeyModifiers());

    private static Identifier id(String s) {
        return new Identifier("abacus", s);
    }

    @Override
    public void onInitialize() {
        renderer = new Renderer();
        KeyBindingHelper.registerKeyBinding(watchKeybinding);
        KeyBindingHelper.registerKeyBinding(clearKeybinding);
    }
}
