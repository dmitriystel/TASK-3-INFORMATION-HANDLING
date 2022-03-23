package by.epam.infohandling.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/*
4 ok
составной объект
Тип Composite хранит составные и неделимые компоненты и определяет их поведение.
Это конкретно наш текст
 */

public class TextComposite implements TextComponent {

    private TextComponentType type; // было private final TextComponentType elementType;
    private final List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public TextComponentType getType() {// было public TextComponentType getElementType
        return type;
    }

    @Override
    public List<TextComponent> getComponents() {
        return new ArrayList<TextComponent>(components);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextComposite)) return false;
        TextComposite composite = (TextComposite) o;
        return getType() == composite.getType() && Objects.equals(getComponents(), composite.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getComponents());
    }

    @Override
    public String toString() {
        String delimiter = type.getDelimiter();
        return this.getComponents().stream()
                .map(textComponent -> textComponent.toString() + delimiter)
                .collect(Collectors.joining());
    }
}

