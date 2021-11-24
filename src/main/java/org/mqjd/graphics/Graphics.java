package org.mqjd.graphics;

import org.fusesource.jansi.Ansi;
import org.mqjd.component.Component;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

public class Graphics {

    private final List<Component> components = new ArrayList<>();

    public Graphics add(Component component){
        components.add(component);
        return this;
    }

    public void draw() {
        components.forEach(Component::draw);
    }

    public void draw(String text, Ansi.Color color) {
        System.out.println(ansi().eraseScreen().fg(color).a(text));
    }
}
