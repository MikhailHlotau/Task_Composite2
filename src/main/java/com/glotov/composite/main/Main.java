package com.glotov.composite.main;

import com.glotov.composite.component.TextComponent;
import com.glotov.composite.parser.TextParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        TextParser textParser = new TextParser();
        TextComponent parsedText = textParser.parseText("src/main/resources/text.txt");
        String restoredText = textParser.getTextFromComponent(parsedText);
        System.out.println(restoredText);
        System.out.println("//////");

        try {
            Path filePath = Path.of("src/main/resources/text.txt");
            String text = Files.readString(filePath);
            System.out.println(text);
            System.out.println("////////");


            String filePath2 = "src/main/resources/text.txt";
            List<String> sentences = readSentencesFromFile(filePath2);
            for (String sentence : sentences) {
                System.out.println(sentence);
                System.out.println("//////");;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readSentencesFromFile(String filePath) throws IOException {
        List<String> sentences = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String text = sb.toString();
            Pattern sentencePattern = Pattern.compile("([^.!?]+[.!?])");
            Matcher matcher = sentencePattern.matcher(text);
            while (matcher.find()) {
                String sentence = matcher.group();
                sentences.add(sentence);
            }
        }
        return sentences;
    }
}
