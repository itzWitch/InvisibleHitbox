package net.itzwitch.invisiblehitbox.mixin;

import com.terraformersmc.modmenu.util.mod.fabric.FabricMod;
import net.itzwitch.invisiblehitbox.config.I18n;
import net.itzwitch.invisiblehitbox.config.InvisibleHitboxConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = FabricMod.class, remap = false)
public abstract class FabricModMixin {

    @Shadow
    public abstract String getId();

    @Inject(method = "getName", at = @At("HEAD"), cancellable = true)
    private void onGetName(CallbackInfoReturnable<String> cir) {
        if ("invisiblehitbox".equals(this.getId())) {
            cir.setReturnValue(I18n.getModMenuName(InvisibleHitboxConfig.INSTANCE.language));
        }
    }

    @Inject(method = "getDescription", at = @At("HEAD"), cancellable = true)
    private void onGetDescription(CallbackInfoReturnable<String> cir) {
        if ("invisiblehitbox".equals(this.getId())) {
            cir.setReturnValue(I18n.getModMenuDescription(InvisibleHitboxConfig.INSTANCE.language));
        }
    }

    @Inject(method = "getTranslatedDescription", at = @At("HEAD"), cancellable = true)
    private void onGetTranslatedDescription(CallbackInfoReturnable<String> cir) {
        if ("invisiblehitbox".equals(this.getId())) {
            cir.setReturnValue(I18n.getModMenuDescription(InvisibleHitboxConfig.INSTANCE.language));
        }
    }
}
