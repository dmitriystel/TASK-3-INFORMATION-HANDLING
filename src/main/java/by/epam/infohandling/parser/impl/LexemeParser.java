package by.epam.infohandling.parser.impl;

import by.epam.infohandling.entity.Symbol;
import by.epam.infohandling.entity.TextComponent;
import by.epam.infohandling.entity.TextComponentType;
import by.epam.infohandling.entity.TextComposite;
import by.epam.infohandling.interpreter.Context;
import by.epam.infohandling.interpreter.MathExpression;
import by.epam.infohandling.interpreter.MathExpressionCreator;
import by.epam.infohandling.parser.TextParser;
import by.epam.infohandling.polishnotation.ReversePolishNotationParser;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextParser {

    private static final String LEXEME_SEPARATOR = "\\s+";
    private static final String PUNCTUATION_PATTERN = "[,\\.\\u2026]";
    private static final String CALCULATION_PATTERN = "([0-9]+[\\+\\-\\*\\/]{1}[0-9]+)+([\\+\\-\\*\\/]{1}[0-9]+)*";

    private final WordParser wordParser = new WordParser();

    @Override
    public TextComposite parseText(String text) {
        TextComposite lexemeComposite = new TextComposite(TextComponentType.LEXEME);
        String[] lexemes = text.strip().split(LEXEME_SEPARATOR);
        Pattern calculationPattern = Pattern.compile(CALCULATION_PATTERN);
        for (String lexeme : lexemes) {
            if (calculationPattern.matcher(lexeme).find()) {
                lexeme = calculate(lexeme).orElse(lexeme);
                TextComposite numberComposite = new TextComposite(TextComponentType.NUMBER);
                char[] letters = lexeme.toCharArray();
                for (char letter : letters) {
                    numberComposite.add(new Symbol(letter, TextComponentType.LETTER));
                }
                lexemeComposite.add(numberComposite);
            } else {
                TextComponent lexemeComponent = wordParser.parseText(lexeme);
                lexemeComposite.add(lexemeComponent);
                Pattern punctuationPattern = Pattern.compile(PUNCTUATION_PATTERN);
                Matcher punctuationMatcher = punctuationPattern.matcher(lexeme);
                if (punctuationMatcher.find()) {
                    String group = punctuationMatcher.group();
                    TextComponent punctuationComponent = new Symbol(group.charAt(0), TextComponentType.PUNCTUATION);
                    lexemeComposite.add(punctuationComponent);
                }
            }
        }
        return lexemeComposite;
    }

    private Optional<String> calculate(String input) {
        ReversePolishNotationParser reversePolishNotation = new ReversePolishNotationParser(input);
        String polishNotationExpression = reversePolishNotation.parse();
        if (reversePolishNotation.isParsingOK()) {
            MathExpressionCreator interpreter = new MathExpressionCreator();
            List<MathExpression> list = interpreter.parse(polishNotationExpression);
            Context context = new Context();
            for (MathExpression terminal : list) {
                terminal.interprete(context);
            }
            String result = String.valueOf(context.pop());
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }
}
