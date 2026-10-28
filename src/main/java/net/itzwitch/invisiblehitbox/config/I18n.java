package net.itzwitch.invisiblehitbox.config;

public class I18n {
    public static final int LANG_TR = 0;
    public static final int LANG_EN = 1;
    public static final int LANG_ES = 2;
    public static final int LANG_DE = 3;

    public static String getTitle(int lang) {
        return switch (lang) {
            case LANG_TR -> "G\u00f6r\u00fcnmezlik Hitbox Ayarlar\u0131";
            case LANG_EN -> "Invisible Hitbox Settings";
            case LANG_ES -> "Ajustes de Hitbox Invisible";
            case LANG_DE -> "Unsichtbare Hitbox Einstellungen";
            default -> "Invisible Hitbox Settings";
        };
    }

    public static String getMod(int lang, boolean enabled) {
        String state = enabled ? "\u00a7a[ A\u00c7IK ]" : "\u00a7c[ KAPALI ]";
        if (lang == LANG_EN) state = enabled ? "\u00a7a[ ON ]" : "\u00a7c[ OFF ]";
        else if (lang == LANG_ES) state = enabled ? "\u00a7a[ ACTIVADO ]" : "\u00a7c[ DESACTIVADO ]";
        else if (lang == LANG_DE) state = enabled ? "\u00a7a[ AN ]" : "\u00a7c[ AUS ]";
        return "Mod: " + state;
    }

    public static String getColorName(int lang, int colorIndex) {
        String[][] colors = {
            {"\u00a7cK\u0131rm\u0131z\u0131", "\u00a7cRed", "\u00a7cRojo", "\u00a7cRot"},
            {"\u00a7bCamg\u00f6be\u011fi", "\u00a7bCyan", "\u00a7bCian", "\u00a7bT\u00fcrkis"},
            {"\u00a7dMor", "\u00a7dPurple", "\u00a7dMorado", "\u00a7dLila"},
            {"\u00a7aYe\u015fil", "\u00a7aGreen", "\u00a7aVerde", "\u00a7aGr\u00fcn"},
            {"\u00a7eSar\u0131", "\u00a7eYellow", "\u00a7eAmarillo", "\u00a7eGelb"},
            {"\u00a79Mavi", "\u00a79Blue", "\u00a79Azul", "\u00a79Blau"},
            {"\u00a76Turuncu", "\u00a76Orange", "\u00a76Naranja", "\u00a76Orange"},
            {"\u00a7fBeyaz", "\u00a7fWhite", "\u00a7fBlanco", "\u00a7fWei\u00df"}
        };
        int idx = Math.floorMod(colorIndex, colors.length);
        int l = Math.floorMod(lang, 4);
        return colors[idx][l];
    }

    public static String getColorBtn(int lang, int colorIndex) {
        String label = switch (lang) {
            case LANG_TR -> "Hitbox Rengi: ";
            case LANG_EN -> "Hitbox Color: ";
            case LANG_ES -> "Color Hitbox: ";
            case LANG_DE -> "Hitbox-Farbe: ";
            default -> "Hitbox Color: ";
        };
        return label + getColorName(lang, colorIndex);
    }

    public static String getFillColorBtn(int lang, int colorIndex) {
        String label = switch (lang) {
            case LANG_TR -> "Dolgu Rengi: ";
            case LANG_EN -> "Fill Color: ";
            case LANG_ES -> "Color Relleno: ";
            case LANG_DE -> "F\u00fcllfarbe: ";
            default -> "Fill Color: ";
        };
        return label + getColorName(lang, colorIndex);
    }

    public static String getLineWidth(int lang, float width) {
        String label = switch (lang) {
            case LANG_TR -> "\u00c7izgi Kal\u0131nl\u0131\u011f\u0131: ";
            case LANG_EN -> "Line Width: ";
            case LANG_ES -> "Grosor L\u00ednea: ";
            case LANG_DE -> "Linienst\u00e4rke: ";
            default -> "Line Width: ";
        };
        return label + "\u00a7e" + String.format(java.util.Locale.US, "%.1fpx", width);
    }

    public static String getFill(int lang, boolean fill) {
        String label = switch (lang) {
            case LANG_TR -> "\u0130\u00e7 Dolgu: ";
            case LANG_EN -> "Interior Fill: ";
            case LANG_ES -> "Relleno: ";
            case LANG_DE -> "Innenf\u00fcllung: ";
            default -> "Interior Fill: ";
        };
        String state = fill ? "\u00a7a[ A\u00c7IK ]" : "\u00a7c[ KAPALI ]";
        if (lang == LANG_EN) state = fill ? "\u00a7a[ ON ]" : "\u00a7c[ OFF ]";
        else if (lang == LANG_ES) state = fill ? "\u00a7a[ ACTIVADO ]" : "\u00a7c[ DESACTIVADO ]";
        else if (lang == LANG_DE) state = fill ? "\u00a7a[ AN ]" : "\u00a7c[ AUS ]";
        return label + state;
    }

    public static String getLookRay(int lang, boolean lookRay) {
        String label = switch (lang) {
            case LANG_TR -> "Bakt\u0131\u011f\u0131 Y\u00f6n: ";
            case LANG_EN -> "Look Ray: ";
            case LANG_ES -> "Direcci\u00f3n Vista: ";
            case LANG_DE -> "Blickrichtung: ";
            default -> "Look Ray: ";
        };
        String state = lookRay ? "\u00a7a[ A\u00c7IK ]" : "\u00a7c[ KAPALI ]";
        if (lang == LANG_EN) state = lookRay ? "\u00a7a[ ON ]" : "\u00a7c[ OFF ]";
        else if (lang == LANG_ES) state = lookRay ? "\u00a7a[ ACTIVADO ]" : "\u00a7c[ DESACTIVADO ]";
        else if (lang == LANG_DE) state = lookRay ? "\u00a7a[ AN ]" : "\u00a7c[ AUS ]";
        return label + state;
    }

    public static String getOnlyPlayers(int lang, boolean onlyPlayers) {
        String label = switch (lang) {
            case LANG_TR -> "Sadece Oyuncular: ";
            case LANG_EN -> "Players Only: ";
            case LANG_ES -> "Solo Jugadores: ";
            case LANG_DE -> "Nur Spieler: ";
            default -> "Players Only: ";
        };
        String state = onlyPlayers ? "\u00a7a[ A\u00c7IK ]" : "\u00a7c[ KAPALI ]";
        if (lang == LANG_EN) state = onlyPlayers ? "\u00a7a[ ON ]" : "\u00a7c[ OFF ]";
        else if (lang == LANG_ES) state = onlyPlayers ? "\u00a7a[ ACTIVADO ]" : "\u00a7c[ DESACTIVADO ]";
        else if (lang == LANG_DE) state = onlyPlayers ? "\u00a7a[ AN ]" : "\u00a7c[ AUS ]";
        return label + state;
    }

    public static String getLanguageName(int lang) {
        return switch (lang) {
            case LANG_TR -> "Dil: \u00a76T\u00fcrk\u00e7e (tr)";
            case LANG_EN -> "Language: \u00a76English (en)";
            case LANG_ES -> "Idioma: \u00a76Espa\u00f1ol (es)";
            case LANG_DE -> "Sprache: \u00a76Deutsch (de)";
            default -> "Language: \u00a76English (en)";
        };
    }

    public static String getReset(int lang) {
        return switch (lang) {
            case LANG_TR -> "\u00a7c\u27f3 Ayarlar\u0131 S\u0131f\u0131rla";
            case LANG_EN -> "\u00a7c\u27f3 Reset Settings";
            case LANG_ES -> "\u00a7c\u27f3 Restablecer Ajustes";
            case LANG_DE -> "\u00a7c\u27f3 Einstellungen Zur\u00fccksetzen";
            default -> "\u00a7c\u27f3 Reset Settings";
        };
    }

    public static String getSaveAndClose(int lang) {
        return switch (lang) {
            case LANG_TR -> "\u00a7a\u2713 Kaydet ve Kapat";
            case LANG_EN -> "\u00a7a\u2713 Save & Close";
            case LANG_ES -> "\u00a7a\u2713 Guardar y Salir";
            case LANG_DE -> "\u00a7a\u2713 Speichern & Schlie\u00dfen";
            default -> "\u00a7a\u2713 Save & Close";
        };
    }

    public static String getModMenuName(int lang) {
        return switch (lang) {
            case LANG_TR -> "G\u00f6r\u00fcnmezlik Hitbox";
            case LANG_EN -> "Invisible Hitbox";
            case LANG_ES -> "Hitbox Invisible";
            case LANG_DE -> "Unsichtbare Hitbox";
            default -> "Invisible Hitbox";
        };
    }

    public static String getModMenuDescription(int lang) {
        return switch (lang) {
            case LANG_TR -> "G\u00f6r\u00fcnmez oyuncular\u0131n F3+B ile hitboxlar\u0131n\u0131 g\u00f6sterir. Geli\u015fmi\u015f oyun i\u00e7i ayar men\u00fcs\u00fc i\u00e7erir. Mod Menu gerektirir.";
            case LANG_EN -> "Renders hitboxes for invisible players with a custom, high-performance in-game config menu. Requires Mod Menu.";
            case LANG_ES -> "Muestra los hitboxes de jugadores invisibles con F3+B y men\u00fa de configuraci\u00f3n en el juego. Requiere Mod Menu.";
            case LANG_DE -> "Zeigt Hitboxen f\u00fcr unsichtbare Spieler mit F3+B und integriertem Einstellungsmen\u00fc. Erfordert Mod Menu.";
            default -> "Renders hitboxes for invisible players with a custom, high-performance in-game config menu. Requires Mod Menu.";
        };
    }
}
