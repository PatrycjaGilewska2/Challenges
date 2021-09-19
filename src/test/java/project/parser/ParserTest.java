package project.parser;


import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import project.domain.Share;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static project.common.StringConstants.*;

class ParserTest {

    @Test
    void shouldParseJsonToList_whenJsonExists() throws IOException {
        //given
        Parser parser = new Parser(FULL_JSON_PATH);
        //when
        List<Share> jsonFromFile = parser.sharesFromJson();
        //then
        assertThat(jsonFromFile).isNotEmpty().hasSize(100);
    }

    @Test
    void shouldThrowMismatchedInputException_whenJsonIsEmpty() {
        //given
        Parser parser = new Parser(EMPTY_JSON_PATH);
        //then
        AssertionsForClassTypes.assertThatThrownBy(parser::sharesFromJson).isInstanceOf(MismatchedInputException.class);

    }

    @Test
    void shouldThrowNoSuchFileException_whenPathToJsonIsIncorrect() {
        //given
        Parser parser = new Parser(WRONG_JSON_PATH);
        //then
        AssertionsForClassTypes.assertThatThrownBy(parser::sharesFromJson).isInstanceOf(NoSuchFileException.class);

    }

}