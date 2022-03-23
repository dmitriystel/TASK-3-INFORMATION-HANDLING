package by.epam.infohandling.reader;

import by.epam.infohandling.exception.TextException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;
// 6 ok
public class TextReader {
    private static final Logger logger = LogManager.getLogger();

    public String readText(String filepath) throws TextException {
        String text;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            text = reader.lines().collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            logger.error("file " + filepath + "not found");
            throw new TextException("file " + filepath + "not found");
        } catch (IOException e) {
            logger.error("reading error");
            throw new TextException("reading error");
        }
        return text;
    }
}
