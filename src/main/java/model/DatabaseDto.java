package model;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Builder
public class DatabaseDto {
    private final String key;
    private final String name;
    private final String description;
    private final ZonedDateTime timestamp;
}
