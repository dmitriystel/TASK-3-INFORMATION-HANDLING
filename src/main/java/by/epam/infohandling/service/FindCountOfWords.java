package by.epam.infohandling.service;

import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;

import java.util.Map;
import java.util.stream.Collectors;

public class FindCountOfWords {
    public Map<String, Integer> findCountOfWords(TextComponent text) {
        Map<String, Integer> words;
        words = text.getComponents().stream()
                .flatMap(paragraph -> paragraph.getComponents().stream())
                .flatMap(sentence -> sentence.getComponents().stream())
                .filter(word -> word.getType().equals(TextComponentType.WORD))
                .map(word -> word.toString().toLowerCase())
                .collect(Collectors.toMap(str -> str, i -> 1, (i1, i2) -> i1 + i2));
        return words;
    }
}
