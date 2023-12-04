package utils;

import java.awt.Color;

public class ColorUtils {
    public static Color hexToRgb(String hex) {
        return new Color(
            Integer.valueOf(hex.substring(1, 3), 16),
            Integer.valueOf(hex.substring(3, 5), 16),
            Integer.valueOf(hex.substring(5, 7), 16)
        );
    }    
}
