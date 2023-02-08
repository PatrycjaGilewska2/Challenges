package task.model;

import java.time.ZonedDateTime;

import lombok.Builder;

@Builder
public class DatabaseDto {

    private final String id;
    private final String name;
    private final String description;
    private final ZonedDateTime dateTime;

}
