package com.glotov.composite.parser;

import com.glotov.composite.component.TextComponent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextParser {
    private Parser parserChain;

    public TextParser() {
        buildParserChain();
    }

    private void buildParserChain() {
        Parser symbolParser = new SymbolParser();
        Parser sentenceParser = new SentenceParser();
        Parser paragraphParser = new ParagraphParser();

        symbolParser.setNextParser(sentenceParser);
        sentenceParser.setNextParser(paragraphParser);
        paragraphParser.setNextParser(null);

        parserChain = symbolParser;
    }

    public TextComponent parseText(String filePath) throws IOException {
        String text = readTextFromFile(filePath);
        return parserChain.parseComponent(text);
    }

    private String readTextFromFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String getTextFromComponent(TextComponent component) {
        return component.getText();
    }
}
