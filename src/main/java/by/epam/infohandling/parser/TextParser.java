package by.epam.infohandling.parser;

import by.epam.infohandling.entity.TextComposite;

// 7 OK
// интерфейс парсера
public interface TextParser {
    TextComposite parseText(String text);
}
