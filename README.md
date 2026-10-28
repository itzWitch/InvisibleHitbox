# Invisible Hitbox (Fabric 1.21.11)

A lightweight, zero-lag client-side Minecraft Fabric mod that renders hitboxes for invisible players when `F3+B` is pressed, featuring a custom classic Minecraft-style configuration screen.

Normally in vanilla Minecraft, invisible players and mobs with the Invisibility effect do not show hitboxes when `F3+B` is active. This mod fixes that behavior seamlessly while maintaining full vanilla FPS.

---

## Features

- **Lag-Free Invisible Hitbox Rendering:** Shows bounding boxes for invisible players when `F3+B` is active with zero FPS loss.
- **Custom Native In-Game Menu:** Built as a native Minecraft 2-column button screen (accessed via Mod Menu -> Invisible Hitbox -> Configure).
- **Multi-Language Support (4 Languages):**
  - Türkçe (tr)
  - English (en)
  - Español (es)
  - Deutsch (de)
- **Customizable In-Game Settings:**
  - **Mod Toggle:** Enable or disable mod functionality
  - **Hitbox Outline Color:** 8 vibrant color choices (Red, Cyan, Purple, Green, Yellow, Blue, Orange, White)
  - **Line Width:** 1.0px to 5.0px thickness
  - **Interior Fill & Separate Fill Color:** Optional translucent box fill with independently selectable color
  - **Players Only:** Completely eliminates wall entities, armor stands, and background arena mobs in PvP
  - **Look Direction Ray:** Direction ray showing where the invisible player is looking
  - **One-Click Reset & Save:** Immediate reset to defaults or save & close
- **Directly Open Source:** Source code (.java files) is packaged directly inside the JAR for full transparency on CurseForge / Modrinth.

---

## Dependencies

- **Minecraft:** 1.21.11
- **Fabric Loader:** 0.15.0 or newer
- **Mod Menu** *(Required)*

---

## Configuration Menu Layout

| Button (Left) | Button (Right) |
|---|---|
| Mod: [ AÇIK / KAPALI ] | Hitbox Rengi: [ Kırmızı / ... ] |
| Çizgi Kalınlığı: [ 2.5px ] | Baktığı Yön: [ AÇIK / KAPALI ] |
| İç Dolgu: [ AÇIK / KAPALI ] | Dolgu Rengi: [ Camgöbeği / ... ] |
| Sadece Oyuncular: [ AÇIK / KAPALI ] | Dil: [ Türkçe / English / Español / Deutsch ] |
| ⟲ Ayarları Sıfırla | ✓ Kaydet ve Kapat |

---

## Author & License

- **Author:** itzWitch
- **License:** MIT License
