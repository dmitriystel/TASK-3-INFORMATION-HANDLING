package by.epam.infohandling.entity;
/*
2 ok
список составляющих
 */

public enum TextComponentType {

    TEXT,
    PARAGRAPH("\n"),
    SENTENCE,
    LEXEME(" "),
    WORD,
    LETTER,
    PUNCTUATION,
    NUMBER;

    private final String delimiter;

    TextComponentType() {
        delimiter = "";
    }

    TextComponentType(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
