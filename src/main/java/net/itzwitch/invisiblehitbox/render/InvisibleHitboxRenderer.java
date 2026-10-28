package net.itzwitch.invisiblehitbox.render;

import net.itzwitch.invisiblehitbox.config.InvisibleHitboxConfig;
import net.minecraft.class_12179;
import net.minecraft.class_12180;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;

public class InvisibleHitboxRenderer {

    /**
     * Ultra-fast hitbox rendering with separate outline and interior fill colors.
     * Uses strict vanilla player bounding box dimensions (no expansion/cheating).
     */
    public static void renderHitbox(class_1297 entity, float tickDelta, InvisibleHitboxConfig config) {
        class_243 pos = entity.method_73189();
        class_243 lerpedPos = entity.method_30950(tickDelta);
        class_243 offset = lerpedPos.method_1020(pos);

        // Strict vanilla bounding box
        class_238 box = entity.method_5829().method_997(offset);

        int outlineColor = config.hitboxColor;
        float lineWidth = config.lineWidth;

        // Separate fill color with translucent alpha
        class_12179 style = config.fillEnabled
                ? class_12179.method_75537(outlineColor, lineWidth, (config.fillColor & 0x00FFFFFF) | 0x35000000)
                : class_12179.method_75536(outlineColor, lineWidth);

        class_12180.method_75541(box, style);

        // Look direction ray
        if (config.renderLookVector) {
            class_243 eyePos = lerpedPos.method_1031(0.0, (double) entity.method_5751(), 0.0);
            class_243 lookDir = entity.method_5828(tickDelta);
            class_243 lookEnd = eyePos.method_1019(lookDir.method_1021(2.0D));
            class_12180.method_75546(eyePos, lookEnd, outlineColor, lineWidth);
        }
    }
}
