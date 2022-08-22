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
public class Grade {
    private String uuid;
    private String name;
    private double value;
    private double weighting;
    private String subjectUuid;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate date;

    public Grade(String name, double value, double weighting, String subjectUuid, LocalDate date) {
        uuid = UUID.randomUUID().toString();
        this.name = name;
        this.value = value;
        this.weighting = weighting;
        this.date = date;
        this.subjectUuid = subjectUuid;
    }

    public Grade(@JsonProperty("name") String name, @JsonProperty("value") double value,
                 @JsonProperty("weighting") double weighting, @JsonProperty("subjectUuid") String subjectUuid,
                 @JsonProperty("uuid") String uuid, @JsonProperty("date") LocalDate date) {
        this.uuid = uuid;
        this.name = name;
        this.value = value;
        this.weighting = weighting;
        this.date = date;
        this.subjectUuid = subjectUuid;
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

    public double getValue() {
        return value;
    }

    public double getWeighting() {
        return weighting;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    public String getSubjectUuid() {
        return subjectUuid;
    }

    public void setSubjectUuid(String subjectUuid) {
        this.subjectUuid = subjectUuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}


