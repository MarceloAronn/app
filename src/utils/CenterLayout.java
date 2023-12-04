package utils;

import java.awt.Component;

public class CenterLayout {
    public static Integer getCenter(Component parent, Component element) {
        Integer center = (parent.getWidth() - element.getWidth()) / 2;
        return center;
    }
}
