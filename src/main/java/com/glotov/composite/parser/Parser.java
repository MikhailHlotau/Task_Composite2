package com.glotov.composite.parser;

import com.glotov.composite.component.TextComponent;

abstract class Parser {
    protected Parser nextParser;

    public void setNextParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public TextComponent parseComponent(String text) {
        TextComponent component = parse(text);
        if (nextParser != null) {
            component.add(nextParser.parseComponent(text));
        }
        return component;
    }

    protected abstract com.glotov.composite.component.TextComponent parse(String text);
}
