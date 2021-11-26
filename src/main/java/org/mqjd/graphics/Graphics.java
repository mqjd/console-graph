package org.mqjd.graphics;

import java.util.ArrayList;
import java.util.List;

import org.mqjd.element.Element;
import org.mqjd.element.Text;

public class Graphics {

    private final ConsolePrinter meta = new ConsolePrinter();
    private final List<Element> components = new ArrayList<>();

    public Graphics add(Element component) {
        components.add(component);
        return this;
    }

    public void draw() {
        components.forEach(Element::draw);
        meta.draw();
    }

    public void draw(Text text) {
        meta.add(text);
    }
}
