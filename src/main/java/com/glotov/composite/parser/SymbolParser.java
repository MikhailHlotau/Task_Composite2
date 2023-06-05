package com.glotov.composite.parser;

import com.glotov.composite.component.TextComponent;
import com.glotov.composite.component.impl.Symbol;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolParser extends Parser {
    protected static final Pattern SYMBOL_PATTERN = Pattern.compile("\\S");

    @Override
    protected TextComponent parse(String text) {
        Matcher matcher = SYMBOL_PATTERN.matcher(text);
        if (matcher.find()) {
            char symbol = matcher.group().charAt(0);
            return new Symbol(symbol);
        }
        return null;
    }

    public static Symbol parseSymbol(String text) {
        SymbolParser symbolParser = new SymbolParser();
        return (Symbol) symbolParser.parseComponent(text);
    }
}

