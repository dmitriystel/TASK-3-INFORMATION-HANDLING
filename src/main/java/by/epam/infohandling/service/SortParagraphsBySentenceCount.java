package by.epam.infohandling.service;

import by.epam.infohandling.entity.TextComponent;

import java.util.List;

public class SortParagraphsBySentenceCount {

    public List<TextComponent> sort(TextComponent text) {
        List<TextComponent> paragraphs = text.getComponents();
        paragraphs.sort((o1, o2) -> {
            Integer sizeO1 = o1.getComponents().size();
            Integer sizeO2 = o2.getComponents().size();
            return sizeO1.compareTo(sizeO2);
        });
        return paragraphs;
    }
}
