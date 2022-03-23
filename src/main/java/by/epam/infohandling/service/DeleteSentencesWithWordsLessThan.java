package by.epam.infohandling.service;

import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;

import java.util.List;

public class DeleteSentencesWithWordsLessThan {
    public void delete(TextComponent text, int countWord) {
        List<TextComponent> sentenceList;

        for (TextComponent paragraph : text.getComponents()) {
            sentenceList = paragraph.getComponents();
            for (TextComponent sentence : sentenceList) {
                int countOfWords = 0;
                for (TextComponent word : sentence.getComponents()) {
                    if (word.getType().equals(TextComponentType.WORD)) {
                        countOfWords++;
                    }
                }
                if (countOfWords < countWord) {
                    paragraph.remove(sentence);
                }
            }
        }
    }
}
