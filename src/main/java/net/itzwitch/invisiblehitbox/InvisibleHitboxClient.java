package net.itzwitch.invisiblehitbox;

import net.fabricmc.api.ClientModInitializer;
import net.itzwitch.invisiblehitbox.config.InvisibleHitboxConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvisibleHitboxClient implements ClientModInitializer {
    public static final String MOD_ID = "invisiblehitbox";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        InvisibleHitboxConfig.getInstance().load();
        LOGGER.info("[InvisibleHitbox] Loaded Invisible Hitbox v4.0.0 by itzWitch");
    }
}
