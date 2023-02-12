package task.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.mock.web.MockMultipartFile;

import task.model.Client;

public class TestUtil {

    private static final String CSV_PATH = "src/test/resources/example.csv";

    public static Client getClient1() { return new Client(1L, "Mufasa Adams", "Sneezy", "2023-02-12T10:29:07+00:00"); }

    public static Client getClient2() { return new Client(2L, "Sarabi Baker", "Sleepy", "2011-10-05T14:48:00.000Z"); }

    public static Client getClient3() { return new Client(3L, "Simba Clark", "Dopey", "2023-02-12"); }

    public static MockMultipartFile getMockMultipartFile() throws IOException {
        byte[] csv_bytes = Files.readAllBytes(Paths.get(CSV_PATH));
        return new MockMultipartFile("example.csv", csv_bytes);

    }

}
