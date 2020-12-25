package dzwdz.abacus.mixin;

import dzwdz.abacus.Abacus;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @Inject(
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderMountHealth(Lnet/minecraft/client/util/math/MatrixStack;)V"
            ),
            method = "render"
    )
    public void renderMicroDurability(MatrixStack matrices, float delta, CallbackInfo callbackInfo) {
        Abacus.renderer.onHudRender(matrices, delta);
    }
}
