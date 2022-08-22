package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import util.LocalDateDeserializer;
import util.LocalDateSerializer;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author Diego Fantino
 * @since 2021.07.27
 * @version 2.0
 *
 */

public class Semester {
    private String uuid;
    private String name;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate start;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate end;

    public Semester(String name, LocalDate start, LocalDate end) {
        uuid = UUID.randomUUID().toString();
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Semester(@JsonProperty("name") String name, @JsonProperty("start") LocalDate start,
            @JsonProperty("end") LocalDate end, @JsonProperty("uuid") String uuid) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}

