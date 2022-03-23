package by.epam.infohandling.entity;

import java.util.List;
/*
1 ok
общий интерфейс древовидной структуры # Component, определяет структуру данных
Интерфейс Component задает интерфейс для всех составных объектов.
 */
public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    List<TextComponent> getComponents();
    TextComponentType getType();
}
