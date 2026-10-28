package net.itzwitch.invisiblehitbox.mixin;

import net.itzwitch.invisiblehitbox.config.InvisibleHitboxConfig;
import net.itzwitch.invisiblehitbox.render.InvisibleHitboxRenderer;
import net.minecraft.class_12155;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = class_12155.class, priority = 500)
public abstract class EntityHitboxDebugRendererMixin {

    /**
     * Prevents invisible players from being skipped during hitbox iteration.
     */
    @Redirect(
        method = "method_23109",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/class_1297;method_5767()Z"
        )
    )
    private boolean redirectIsInvisible(class_1297 entity) {
        InvisibleHitboxConfig config = InvisibleHitboxConfig.INSTANCE;
        if (config.enabled) {
            if (entity instanceof class_1657) {
                return false;
            }
        }
        return entity.method_5767();
    }

    /**
     * Renders custom hitboxes for players and cancels non-player hitboxes
     * (armor stands, wall mobs, items) when onlyPlayers is enabled.
     */
    @Inject(
        method = "method_75432",
        at = @At("HEAD"),
        cancellable = true
    )
    private void onDrawHitbox(class_1297 entity, float tickDelta, boolean inLocalServer, CallbackInfo ci) {
        if (inLocalServer) {
            return;
        }

        InvisibleHitboxConfig config = InvisibleHitboxConfig.INSTANCE;
        if (!config.enabled) {
            return;
        }

        // Hide all non-player entities (armor stands, display entities, mobs in walls)
        if (config.onlyPlayers && !(entity instanceof class_1657)) {
            ci.cancel();
            return;
        }

        // Player hitbox rendering (both invisible and visible)
        if (entity instanceof class_1657) {
            ci.cancel();
            InvisibleHitboxRenderer.renderHitbox(entity, tickDelta, config);
        }
    }
}
