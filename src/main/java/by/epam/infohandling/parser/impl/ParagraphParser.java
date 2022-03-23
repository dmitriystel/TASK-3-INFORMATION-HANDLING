package by.epam.infohandling.parser.impl;

import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;
import by.epam.infohandling.entity.TextComposite;
import by.epam.infohandling.parser.TextParser;
// ?
public class ParagraphParser implements TextParser {
    private static final String PARAGRAPH_PATTERN = "[\\n\\t]+";
    private final SentenceParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parseText(String text) {
        TextComposite paragraphComposite = new TextComposite(TextComponentType.PARAGRAPH);
        String[] paragraphs = text.strip().split(PARAGRAPH_PATTERN);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = sentenceParser.parseText(paragraph);
            paragraphComposite.add(paragraphComponent);
        }
        return paragraphComposite;
    }
}




