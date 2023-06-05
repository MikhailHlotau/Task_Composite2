package com.glotov.composite.component.impl;

import com.glotov.composite.component.TextComponent;
import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {
    private List<TextComponent> components = new ArrayList<>();

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        for (TextComponent component : components) {
            sb.append(component.getText());
        }
        return sb.toString();
    }
}

