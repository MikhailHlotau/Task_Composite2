package com.glotov.composite.component;


public interface TextComponent {

    void add(TextComponent component);

    void remove(TextComponent component);

    String getText();
}
