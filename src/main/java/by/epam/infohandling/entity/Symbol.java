package by.epam.infohandling.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

/*
3 ок
неделимый элемент древовидной структуры
начинают с этого класса, это самое простое
 */
public class Symbol implements TextComponent {
    static Logger logger = LogManager.getLogger();
    private TextComponentType type;
    private char symbol;

    public Symbol(char symbol, TextComponentType type) {
        this.symbol = symbol;
        this.type = type;
    }
    public char getSymbol() {
        return symbol;
    }

    public void setType(TextComponentType type) {
        this.type = type;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    @Override
    public boolean add(TextComponent component) {
        logger.error("Can't add anything for the symbol");
        return false;
    }

    @Override
    public boolean remove(TextComponent component) {
        logger.error("Can't remove anything for the symbol");
        return false;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public List<TextComponent> getComponents() {
        logger.error("Can't get components for the symbol");
        throw new UnsupportedOperationException("Can't get components for the symbol");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Symbol)) return false;
        Symbol symbol1 = (Symbol) o;
        return getSymbol() == symbol1.getSymbol() && getType() == symbol1.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getSymbol());
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}



