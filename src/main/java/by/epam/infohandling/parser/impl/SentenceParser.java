package by.epam.infohandling.parser.impl;

import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;
import by.epam.infohandling.entity.TextComposite;
import by.epam.infohandling.parser.TextParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser implements TextParser {
    private static final String SENTENCE_PATTERN =
            "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";
    private final LexemeParser lexemeParser = new LexemeParser();

    @Override
    public TextComposite parseText(String text) {

        TextComposite sentenceComposite = new TextComposite(TextComponentType.SENTENCE);
        Pattern pattern = Pattern.compile(SENTENCE_PATTERN);
        Matcher matcher = pattern.matcher(text);

        List<String> sentences = new ArrayList<>();
        while (matcher.find()) {
            sentences.add(matcher.group());
        }

        for (String sentence : sentences) {
            TextComponent sentenceComponents = lexemeParser.parseText(sentence);
            sentenceComposite.add(sentenceComponents);
        }

        return sentenceComposite;
    }
}
