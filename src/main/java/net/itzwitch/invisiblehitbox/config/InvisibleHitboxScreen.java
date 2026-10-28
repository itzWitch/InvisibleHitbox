package net.itzwitch.invisiblehitbox.config;

import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_4185;
import net.minecraft.class_437;

public class InvisibleHitboxScreen extends class_437 {
    private final class_437 parent;
    private final InvisibleHitboxConfig config = InvisibleHitboxConfig.INSTANCE;

    private class_4185 btnMod;
    private class_4185 btnColor;
    private class_4185 btnLineWidth;
    private class_4185 btnLookRay;
    private class_4185 btnFill;
    private class_4185 btnFillColor;
    private class_4185 btnOnlyPlayers;
    private class_4185 btnLang;
    private class_4185 btnReset;
    private class_4185 btnSave;

    public InvisibleHitboxScreen(class_437 parent) {
        super(class_2561.method_43470(I18n.getTitle(InvisibleHitboxConfig.INSTANCE.language)));
        this.parent = parent;
    }

    @Override
    protected void method_25426() { // init
        int btnWidth = 160;
        int btnHeight = 20;
        int centerX = this.field_22789 / 2;
        int startY = this.field_22790 / 2 - 58;

        int leftX = centerX - 165;
        int rightX = centerX + 5;

        // Row 0
        btnMod = class_4185.method_46430(
            class_2561.method_43470(I18n.getMod(config.language, config.enabled)),
            b -> {
                config.enabled = !config.enabled;
                config.save();
                updateLabels();
            }
        ).method_46434(leftX, startY, btnWidth, btnHeight).method_46431();
        this.method_37063(btnMod);

        btnColor = class_4185.method_46430(
            class_2561.method_43470(I18n.getColorBtn(config.language, config.colorIndex)),
            b -> {
                config.colorIndex = (config.colorIndex + 1) % InvisibleHitboxConfig.COLORS.length;
                config.hitboxColor = InvisibleHitboxConfig.COLORS[config.colorIndex];
                config.save();
                updateLabels();
            }
        ).method_46434(rightX, startY, btnWidth, btnHeight).method_46431();
        this.method_37063(btnColor);

        // Row 1
        btnLineWidth = class_4185.method_46430(
            class_2561.method_43470(I18n.getLineWidth(config.language, config.lineWidth)),
            b -> {
                config.lineWidthIndex = (config.lineWidthIndex + 1) % InvisibleHitboxConfig.LINE_WIDTHS.length;
                config.lineWidth = InvisibleHitboxConfig.LINE_WIDTHS[config.lineWidthIndex];
                config.save();
                updateLabels();
            }
        ).method_46434(leftX, startY + 24, btnWidth, btnHeight).method_46431();
        this.method_37063(btnLineWidth);

        btnLookRay = class_4185.method_46430(
            class_2561.method_43470(I18n.getLookRay(config.language, config.renderLookVector)),
            b -> {
                config.renderLookVector = !config.renderLookVector;
                config.save();
                updateLabels();
            }
        ).method_46434(rightX, startY + 24, btnWidth, btnHeight).method_46431();
        this.method_37063(btnLookRay);

        // Row 2
        btnFill = class_4185.method_46430(
            class_2561.method_43470(I18n.getFill(config.language, config.fillEnabled)),
            b -> {
                config.fillEnabled = !config.fillEnabled;
                config.save();
                updateLabels();
            }
        ).method_46434(leftX, startY + 48, btnWidth, btnHeight).method_46431();
        this.method_37063(btnFill);

        btnFillColor = class_4185.method_46430(
            class_2561.method_43470(I18n.getFillColorBtn(config.language, config.fillColorIndex)),
            b -> {
                config.fillColorIndex = (config.fillColorIndex + 1) % InvisibleHitboxConfig.COLORS.length;
                config.fillColor = InvisibleHitboxConfig.COLORS[config.fillColorIndex];
                config.save();
                updateLabels();
            }
        ).method_46434(rightX, startY + 48, btnWidth, btnHeight).method_46431();
        this.method_37063(btnFillColor);

        // Row 3
        btnOnlyPlayers = class_4185.method_46430(
            class_2561.method_43470(I18n.getOnlyPlayers(config.language, config.onlyPlayers)),
            b -> {
                config.onlyPlayers = !config.onlyPlayers;
                config.save();
                updateLabels();
            }
        ).method_46434(leftX, startY + 72, btnWidth, btnHeight).method_46431();
        this.method_37063(btnOnlyPlayers);

        btnLang = class_4185.method_46430(
            class_2561.method_43470(I18n.getLanguageName(config.language)),
            b -> {
                config.language = (config.language + 1) % 4;
                config.save();
                updateLabels();
            }
        ).method_46434(rightX, startY + 72, btnWidth, btnHeight).method_46431();
        this.method_37063(btnLang);

        // Row 4: Actions
        btnReset = class_4185.method_46430(
            class_2561.method_43470(I18n.getReset(config.language)),
            b -> {
                config.reset();
                updateLabels();
            }
        ).method_46434(leftX, startY + 104, btnWidth, btnHeight).method_46431();
        this.method_37063(btnReset);

        btnSave = class_4185.method_46430(
            class_2561.method_43470(I18n.getSaveAndClose(config.language)),
            b -> {
                config.save();
                if (this.field_22787 != null) {
                    this.field_22787.method_1507(this.parent);
                }
            }
        ).method_46434(rightX, startY + 104, btnWidth, btnHeight).method_46431();
        this.method_37063(btnSave);
    }

    private void updateLabels() {
        int lang = config.language;
        if (btnMod != null) btnMod.method_25355(class_2561.method_43470(I18n.getMod(lang, config.enabled)));
        if (btnColor != null) btnColor.method_25355(class_2561.method_43470(I18n.getColorBtn(lang, config.colorIndex)));
        if (btnLineWidth != null) btnLineWidth.method_25355(class_2561.method_43470(I18n.getLineWidth(lang, config.lineWidth)));
        if (btnLookRay != null) btnLookRay.method_25355(class_2561.method_43470(I18n.getLookRay(lang, config.renderLookVector)));
        if (btnFill != null) btnFill.method_25355(class_2561.method_43470(I18n.getFill(lang, config.fillEnabled)));
        if (btnFillColor != null) btnFillColor.method_25355(class_2561.method_43470(I18n.getFillColorBtn(lang, config.fillColorIndex)));
        if (btnOnlyPlayers != null) btnOnlyPlayers.method_25355(class_2561.method_43470(I18n.getOnlyPlayers(lang, config.onlyPlayers)));
        if (btnLang != null) btnLang.method_25355(class_2561.method_43470(I18n.getLanguageName(lang)));
        if (btnReset != null) btnReset.method_25355(class_2561.method_43470(I18n.getReset(lang)));
        if (btnSave != null) btnSave.method_25355(class_2561.method_43470(I18n.getSaveAndClose(lang)));
    }

    @Override
    public void method_25419() { // close
        config.save();
        super.method_25419();
    }

    @Override
    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        this.method_57734(context);
        super.method_25394(context, mouseX, mouseY, delta);
        int centerX = this.field_22789 / 2;
        int titleY = this.field_22790 / 2 - 80;
        context.method_27535(this.field_22793, class_2561.method_43470(I18n.getTitle(config.language)), centerX, titleY, 0xFFFFFF);
    }
}
