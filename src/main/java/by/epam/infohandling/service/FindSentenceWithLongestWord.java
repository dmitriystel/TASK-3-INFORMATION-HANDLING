package by.epam.infohandling.service;

import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;

import java.util.ArrayList;
import java.util.List;

public class FindSentenceWithLongestWord {
    public List<TextComponent> find(TextComponent text) {
        int sizeOfLongestWord = 0;
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent word : sentence.getComponents()) {
                    if (word.getType().equals(TextComponentType.WORD)) {
                        List<TextComponent> letters = word.getComponents();
                        if (letters.size() > sizeOfLongestWord) {
                            sizeOfLongestWord = letters.size();
                        }
                    }
                }
            }
        }
        List<TextComponent> result = new ArrayList<>();
        for (TextComponent paragraph : text.getComponents()) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent word : sentence.getComponents()) {
                    if (word.getType().equals(TextComponentType.WORD)) {
                        List<TextComponent> letters = word.getComponents();
                        if (letters.size() == sizeOfLongestWord) {
                            result.add(word);
                        }
                    }
                }
            }
        }
        return result;
    }
}
