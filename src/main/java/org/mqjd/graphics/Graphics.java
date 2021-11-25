package org.mqjd.graphics;

import java.util.ArrayList;
import java.util.List;

import org.mqjd.component.Component;

public class Graphics {

    private final Console meta = new Console();
    private final List<Component> components = new ArrayList<>();

    public Graphics add(Component component) {
        components.add(component);
        return this;
    }

    public void draw() {
        components.forEach(Component::draw);
        meta.draw();
    }

    public void draw(Text text) {
        meta.add(text);
    }
}
