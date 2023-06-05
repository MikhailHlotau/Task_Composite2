package com.glotov.composite.component.impl;

import com.glotov.composite.component.TextComponent;

public class Symbol implements TextComponent {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }


    @Override
    public void add(TextComponent component) {

    }

    @Override
    public void remove(TextComponent component) {

    }

    @Override
    public String getText() {
        return String.valueOf(symbol);
    }
}
