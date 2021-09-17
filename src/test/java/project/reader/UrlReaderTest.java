package project.reader;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static project.common.StringConstants.PATH;
import static project.common.StringConstants.WRONG_PATH;

class UrlReaderTest {

    @Test
    void shouldReadStringFromUrl() throws IOException {
        String data = UrlReader.readFromUrl(PATH);
        assertThat(data).isNotEmpty();
    }

    @Test
    void shouldThrowException_whenUrlIsNotCorrect() {
        assertThatThrownBy(() -> UrlReader.readFromUrl(WRONG_PATH)).isInstanceOf(MalformedURLException.class);
    }
}