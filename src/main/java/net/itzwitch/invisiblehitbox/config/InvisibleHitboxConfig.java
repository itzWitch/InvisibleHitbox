package net.itzwitch.invisiblehitbox.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InvisibleHitboxConfig {
    public static final int[] COLORS = {
        0xFFFF1744, // Red
        0xFF00E5FF, // Cyan
        0xFFD500F9, // Purple
        0xFF00E676, // Green
        0xFFFFEA00, // Yellow
        0xFF2979FF, // Blue
        0xFFFF6D00, // Orange
        0xFFFFFFFF  // White
    };

    public static final float[] LINE_WIDTHS = {
        1.0f, 1.5f, 2.0f, 2.5f, 3.0f, 4.0f, 5.0f
    };

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("invisiblehitbox.json").toFile();
    public static final InvisibleHitboxConfig INSTANCE = new InvisibleHitboxConfig();

    public int language = 0; // 0 = TR, 1 = EN, 2 = ES, 3 = DE
    public boolean enabled = true;
    public int colorIndex = 0;
    public int hitboxColor = 0xFFFF1744;
    public int lineWidthIndex = 3;
    public float lineWidth = 2.5f;
    public boolean fillEnabled = false;
    public int fillColorIndex = 1;
    public int fillColor = 0xFF00E5FF;
    public boolean renderLookVector = true;
    public boolean onlyPlayers = true; // Sadece oyuncular (duvarlardaki armor stand/mobları gizler)

    public static InvisibleHitboxConfig getInstance() {
        return INSTANCE;
    }

    public void load() {
        if (CONFIG_FILE.exists()) {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                InvisibleHitboxConfig loaded = GSON.fromJson(reader, InvisibleHitboxConfig.class);
                if (loaded != null) {
                    this.language = loaded.language;
                    this.enabled = loaded.enabled;
                    this.colorIndex = loaded.colorIndex;
                    this.hitboxColor = loaded.hitboxColor;
                    this.lineWidthIndex = loaded.lineWidthIndex;
                    this.lineWidth = loaded.lineWidth;
                    this.fillEnabled = loaded.fillEnabled;
                    this.fillColorIndex = loaded.fillColorIndex;
                    this.fillColor = loaded.fillColor;
                    this.renderLookVector = loaded.renderLookVector;
                    this.onlyPlayers = loaded.onlyPlayers;
                }
            } catch (Exception e) {
                System.err.println("[InvisibleHitbox] Failed to read config, resetting: " + e.getMessage());
                save();
            }
        } else {
            save();
        }
    }

    public void save() {
        try {
            File parent = CONFIG_FILE.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
                GSON.toJson(this, writer);
            }
        } catch (IOException e) {
            System.err.println("[InvisibleHitbox] Failed to save config: " + e.getMessage());
        }
    }

    public void reset() {
        this.language = 0;
        this.enabled = true;
        this.colorIndex = 0;
        this.hitboxColor = COLORS[0];
        this.lineWidthIndex = 3;
        this.lineWidth = LINE_WIDTHS[3];
        this.fillEnabled = false;
        this.fillColorIndex = 1;
        this.fillColor = COLORS[1];
        this.renderLookVector = true;
        this.onlyPlayers = true;
        save();
    }
}
