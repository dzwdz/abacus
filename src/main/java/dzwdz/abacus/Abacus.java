package dzwdz.abacus;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.LinkedList;
import java.util.List;

public class Abacus implements ModInitializer {
    public static Renderer renderer;
    public static List<ItemStack> selectedItems = new LinkedList<>();

    @Override
    public void onInitialize() {
        renderer = new Renderer();
        selectedItems.add(new ItemStack(Items.BLAZE_ROD));
        selectedItems.add(new ItemStack(Items.GOLD_NUGGET));
    }
}
