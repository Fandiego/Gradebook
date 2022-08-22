package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 *
 * @author Diego Fantino
 * @since 2021.07.27
 * @version 2.0
 *
 */
public class Subject {

    private String uuid;
    private String name;
    private double weighting;
    private String semesterUuid;

    public Subject(String name, double weighting, String semesterUuid) {
        uuid = UUID.randomUUID().toString();
        this.name = name;
        this.weighting = weighting;
        this.semesterUuid = semesterUuid;
    }

    public Subject(@JsonProperty("name") String name, @JsonProperty("weighting") double weighting,
                   @JsonProperty("semesterUuid") String semesterUuid, @JsonProperty("uuid") String uuid) {
        this.uuid = uuid;
        this.name = name;
        this.weighting = weighting;
        this.semesterUuid = semesterUuid;
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

    public double getWeighting() {
        return weighting;
    }

    public void setWeighting(double weighting) {
        this.weighting = weighting;
    }

    public String getSemesterUuid() {
        return semesterUuid;
    }

    public void setSemesterUuid(String semesterUuid) {
        this.semesterUuid = semesterUuid;
    }

}

