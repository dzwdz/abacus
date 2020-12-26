package dzwdz.abacus.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HandledScreen.class)
public interface HandledScreenInvoker {
    @Invoker("getSlotAt")
    Slot invokeGetSlotAt(double xPosition, double yPosition);
}
