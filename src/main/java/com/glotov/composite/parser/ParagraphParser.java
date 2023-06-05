package com.glotov.composite.parser;

import com.glotov.composite.component.TextComponent;
import com.glotov.composite.component.impl.Paragraph;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends Parser {
    private static final Pattern PARAGRAPH_PATTERN = Pattern.compile("([^\n]+)");

    @Override
    protected TextComponent parse(String text) {
        Paragraph paragraph = new Paragraph();
        Matcher matcher = PARAGRAPH_PATTERN.matcher(text);
        while (matcher.find()) {
            String paragraphText = matcher.group();
            if (nextParser != null) {
                TextComponent component = nextParser.parseComponent(paragraphText);
                paragraph.add(component);
            } else {
                SentenceParser sentenceParser = new SentenceParser();
                TextComponent sentenceComponent = sentenceParser.parseComponent(paragraphText);
                paragraph.add(sentenceComponent);
            }
        }
        return paragraph;
    }
}
