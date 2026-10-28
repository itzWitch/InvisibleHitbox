package net.itzwitch.invisiblehitbox.mixin;

import net.itzwitch.invisiblehitbox.config.I18n;
import net.itzwitch.invisiblehitbox.config.InvisibleHitboxConfig;
import net.minecraft.class_1074;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_1074.class)
public abstract class MinecraftI18nMixin {

    @Inject(method = "method_4663", at = @At("HEAD"), cancellable = true)
    private static void onHasTranslation(String key, CallbackInfoReturnable<Boolean> cir) {
        if ("modmenu.nameTranslation.invisiblehitbox".equals(key) ||
            "modmenu.descriptionTranslation.invisiblehitbox".equals(key) ||
            "modmenu.summaryTranslation.invisiblehitbox".equals(key)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "method_4662", at = @At("HEAD"), cancellable = true)
    private static void onTranslate(String key, Object[] args, CallbackInfoReturnable<String> cir) {
        if ("modmenu.nameTranslation.invisiblehitbox".equals(key)) {
            cir.setReturnValue(I18n.getModMenuName(InvisibleHitboxConfig.INSTANCE.language));
        } else if ("modmenu.descriptionTranslation.invisiblehitbox".equals(key) ||
                   "modmenu.summaryTranslation.invisiblehitbox".equals(key)) {
            cir.setReturnValue(I18n.getModMenuDescription(InvisibleHitboxConfig.INSTANCE.language));
        }
    }
}
