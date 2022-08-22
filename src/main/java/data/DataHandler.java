package data;


import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Grade;
import model.Semester;
import model.Subject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public final class DataHandler {

    private static ArrayList<Semester> semesterlist = new ArrayList<>();
    private static ArrayList<Subject> subjectlist = new ArrayList<>();
    private static ArrayList<Grade> gradelist = new ArrayList<>();

    private DataHandler() {

    }

    public static void insertSemester(Semester book) {
        getSemesterlist().add(book);
        writeSemesterJSON();
    }

    public static void deleteSemester(Semester book) {
        getSemesterlist().remove(book);
        writeSemesterJSON();
    }

    public static void insertSubject(Subject book) {
        getSubjectlist().add(book);
        writeSubjectJSON();
    }

    public static void deleteSubject(Subject book) {
        getSubjectlist().remove(book);
        writeSubjectJSON();
    }

    public static void insertGrade(Grade book) {
        getGradelist().add(book);
        writeGradeJSON();
    }

    public static void deleteGrade(Grade book) {
        getGradelist().remove(book);
        writeGradeJSON();
    }

    public static void readSemesterJSON() {
        try {
            String path = "data/semester.json";
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Semester[] semesters = objectMapper.readValue(jsonData, Semester[].class);

            getSemesterlist().clear();

            for (Semester semester : semesters) {
                getSemesterlist().add(semester);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void writeSemesterJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = "data/semester.json";
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getSemesterlist());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readSubjectJSON() {
        try {
            String path = "data/subject.json";
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Subject[] subjects = objectMapper.readValue(jsonData, Subject[].class);

            getSubjectlist().clear();

            for (Subject semester : subjects) {
                getSubjectlist().add(semester);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void writeSubjectJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = "data/subject.json";
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getSubjectlist());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void readGradeJSON() {
        try {
            String path = "data/grade.json";
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Grade[] grades = objectMapper.readValue(jsonData, Grade[].class);

            getGradelist().clear();

            for (Grade semester : grades) {
                getGradelist().add(semester);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void writeGradeJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = "data/grade.json";
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getGradelist());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static ArrayList<Semester> getSemesterlist() {
        return semesterlist;
    }

    public void setSemesterlist(ArrayList<Semester> semesterlist) {
        this.semesterlist = semesterlist;
    }

    public static ArrayList<Subject> getSubjectlist() {
        return subjectlist;
    }

    public void setSubjectlist(ArrayList<Subject> subjectlist) {
        this.subjectlist = subjectlist;
    }

    public static ArrayList<Grade> getGradelist() {
        return gradelist;
    }

    public void setGradelist(ArrayList<Grade> gradelist) {
        this.gradelist = gradelist;
    }
}
