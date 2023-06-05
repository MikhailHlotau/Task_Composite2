package com.glotov.composite.parser;

import com.glotov.composite.component.TextComponent;
import com.glotov.composite.component.impl.Sentence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SentenceParser extends Parser {
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("([^.!?]+[.!?])");

    @Override
    protected TextComponent parse(String text) {
        Sentence sentence = new Sentence();
        Matcher matcher = SENTENCE_PATTERN.matcher(text);
        while (matcher.find()) {
            String sentenceText = matcher.group();
            if (nextParser != null) {
                TextComponent component = nextParser.parseComponent(sentenceText);
                sentence.add(component);
            } else {
                Matcher symbolMatcher = SymbolParser.SYMBOL_PATTERN.matcher(sentenceText);
                while (symbolMatcher.find()) {
                    String symbolText = symbolMatcher.group();
                    TextComponent symbolComponent = SymbolParser.parseSymbol(symbolText);
                    sentence.add(symbolComponent);
                }
            }
        }
        return sentence;
    }
}




