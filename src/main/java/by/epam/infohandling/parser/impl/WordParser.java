package by.epam.infohandling.parser.impl;

import by.epam.infohandling.entity.TextComponentType;
import by.epam.infohandling.entity.TextComposite;
import by.epam.infohandling.entity.Symbol;
import by.epam.infohandling.parser.TextParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements TextParser {
    private static final String WORD_PATTERN = "[0-9a-zA-Zа-яА-ЯёЁ'\\(\\)-]+";

    @Override
    public TextComposite parseText(String text) {
        TextComposite wordComposite = new TextComposite(TextComponentType.WORD);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String group = matcher.group();
            char[] letters = group.toCharArray();
            for (char letter : letters) {
                wordComposite.add(new Symbol(letter, TextComponentType.LETTER));
            }
        }
        return wordComposite;
    }
}
