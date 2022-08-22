package controller;

import data.DataHandler;
import model.Grade;
import model.Semester;
import model.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class SemesterController {
/*
    static ArrayList<Semester> semesterList;
    static ArrayList<Subject> subjectList;

    public SemesterController() {
        semesterList = new ArrayList<>();
        subjectList = new ArrayList<>();
    }

    public static void addSemester(String name) {
        DataHandler.insertSemester(new Semester(name));
    }

    public static void addSubject(String name, int semesterIndex) {
        DataHandler.insertSubject(new Subject(name, getSemesterList().get(semesterIndex).getUuid()));
    }

    public static void deleteSemester(int index) {
        DataHandler.deleteSemester(DataHandler.getSemesterlist().get(index));
    }


    public static ArrayList<Semester> getSemesterList() {
        return semesterList;
    }

    public static void setSemesterList() {
        DataHandler.readSemesterJSON();
        semesterList = DataHandler.getSemesterlist();
    }

    public static void deleteSubject(int index) {
        DataHandler.deleteSubject(getSubjectList().get(index));
    }



    public static ArrayList<Subject> getSubjects(int indexOfSelSemester) {
        ArrayList<Subject> selection = new ArrayList<>();
        DataHandler.readSubjectJSON();
        System.out.println(getSemesterList().get(indexOfSelSemester).getName());
        for (Subject sub : DataHandler.getSubjectlist()
             ) {
            if(sub.getSemesterUuid().equals(getSemesterList().get(indexOfSelSemester).getUuid())) {
                selection.add(sub);
            }
        }

        setSubjectList(selection);

        return selection;
    }


    public static ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public static void setSubjectList(ArrayList<Subject> subjectsList) {
        subjectList = subjectsList;
    }
 */
    private static ArrayList<Semester> semesterList = new ArrayList<>();
    private static ArrayList<Subject> subjectList = new ArrayList<>();
    private static ArrayList<Grade> gradeList = new ArrayList<>();
    private static SemesterController instance;

    private SemesterController() {
    }

    public static SemesterController getInstance() {
        if (instance == null) {
            instance = new SemesterController();
        }
        return instance;
    }

    public static void addSemester(String name, LocalDate start, LocalDate end) {
        System.out.println(name + " / " + start + " / " + end + " / ");
        DataHandler.insertSemester(new Semester(name, start, end));
        setSemesterList();
    }

    public static void addSubject(String name,double weighting,int semesterIndex) {
        DataHandler.insertSubject(new Subject(name,weighting,getSemesterList().get(semesterIndex).getUuid()));
        setSubjectList(semesterIndex);
    }

    public static void addGrade(String name, double value, double weighting,LocalDate date, int semesterIndex) {
        DataHandler.insertGrade(new Grade(name, value,weighting,getSubjectList().get(semesterIndex).getUuid(), date));
        setGradeList(semesterIndex);
    }

    public static void updateSemester(int index, String name, LocalDate start, LocalDate end) {
        //DataHandler.updateSemester(getSemesterList().get(index));
        Semester semester = new Semester(name, start, end,getSemesterList().get(index).getUuid());
        //System.out.println("SemesterUUID: " + getSemesterList().get(index).getUuid());
        DataHandler.deleteSemester(getSemesterList().get(index));
        DataHandler.insertSemester(semester);
        setSemesterList();
    }

    public static void updateSubject(int index, double weighting,String name) {
        Subject subject = new Subject(name, weighting,getSubjectList().get(index).getSemesterUuid(),
                getSubjectList().get(index).getUuid());
        //System.out.println("SemesterUUID: " + getSemesterList().get(index).getUuid());
        DataHandler.deleteSubject(getSubjectList().get(index));
        DataHandler.insertSubject(subject);
        int SemesterIndex = 0;
        for (Semester semesters:
             getSemesterList()) {
            if (semesters.getUuid().equals(subject.getSemesterUuid())) {
                break;
            } else {
                SemesterIndex = SemesterIndex + 1;
            }
        }
        setSubjectList(SemesterIndex);
    }

    public static void updateGrade(int index, String name, double value, double weighting, LocalDate date) {
        Grade grade = new Grade(name, value, weighting,getGradeList().get(index).getSubjectUuid(),
                getGradeList().get(index).getUuid(), date);
        DataHandler.deleteGrade(getGradeList().get(index));
        DataHandler.insertGrade(grade);
        int subjectIndex = 0;
        for (Subject subjects:
                getSubjectList()) {
            if (subjects.getUuid().equals(grade.getSubjectUuid())) {
                break;
            } else {
                subjectIndex = subjectIndex + 1;
            }
        }
        setGradeList(subjectIndex);
    }

    public static void deleteSemester(int index) {
        DataHandler.deleteSemester(getSemesterList().get(index));
        setSemesterList();
    }

    public static void deleteSubject(int index, int semesterIndex) {
        DataHandler.deleteSubject(getSubjectList().get(index));
        setSubjectList(semesterIndex);
    }

    public static void deleteGrade(int index, int subjectIndex) {
        DataHandler.deleteGrade(getGradeList().get(index));
        setGradeList(subjectIndex);
    }

    public static ArrayList<Semester> getSemesterList() {
        return semesterList;
    }

    public static ArrayList<Subject> getSubjectList() {
        return subjectList;
    }

    public static ArrayList<Grade> getGradeList() {
        return gradeList;
    }

    public static void setSemesterList() {
        if(SemesterController.getSemesterList() != null) {
            SemesterController.semesterList.clear();
        }
        DataHandler.readSemesterJSON();
        if (DataHandler.getSemesterlist() != null) {
            SemesterController.semesterList = DataHandler.getSemesterlist();
        } else {
        }
    }

    public static void setSubjectList(int semesterIndex) {
        if (SemesterController.subjectList != null) {
            SemesterController.subjectList.clear();
        }
        DataHandler.readSubjectJSON();
        for (Subject sub:
             DataHandler.getSubjectlist()) {
            if (sub.getSemesterUuid().equals(getSemesterList().get(semesterIndex).getUuid())) {
                subjectList.add(sub);
            } else {}
        }
    }

    public static void setGradeList(int subjectIndex) {
        if (SemesterController.gradeList != null) {
            SemesterController.gradeList.clear();
        }
        DataHandler.readGradeJSON();
        for (Grade gra:
                DataHandler.getGradelist()) {
            if (DataHandler.getGradelist() != null) {
                if (gra.getSubjectUuid().equals(getSubjectList().get(subjectIndex).getUuid())) {
                    gradeList.add(gra);
                } else {
                }
            }
        }
    }

    public static void sortSemesterList(int status) {
        if (status == 0) {
            getSemesterList().sort(Comparator.comparing(Semester::getName));
        } else if (status == 1) {
            getSemesterList().sort(Comparator.comparing(Semester::getName).reversed());
        }
    }

    public static void sortSubjectList(int status) {
        if (status == 0) {
            getSubjectList().sort(Comparator.comparing(Subject::getName));
        } else if (status == 1) {
            getSubjectList().sort(Comparator.comparing(Subject::getName).reversed());
        }
    }

    public static void sortGradeList(int status) {
        if (status == 0) {
            getGradeList().sort(Comparator.comparing(Grade::getValue).reversed());
        } else if (status == 1) {
            getGradeList().sort(Comparator.comparing(Grade::getValue));
        } else if (status == 2) {
            getGradeList().sort(Comparator.comparing(Grade::getWeighting).reversed());
        } else if (status == 3) {
            getGradeList().sort(Comparator.comparing(Grade::getWeighting));
        }
    }

    public static double getAverageSemester() {
        ArrayList<Semester> semesterList = getSemesterList();

        DataHandler.readSubjectJSON();
        ArrayList<Subject> subjectList = DataHandler.getSubjectlist();

        DataHandler.readGradeJSON();
        ArrayList<Grade> gradeList = DataHandler.getGradelist();

        ArrayList<Double> semesterTotal = new ArrayList<>();
        ArrayList<Double> semesterWeighting = new ArrayList<>();
        ArrayList<Double> semesterAverage = new ArrayList<>();

        ArrayList<Double> subjectTotal = new ArrayList<>();
        ArrayList<Double> subjectWeighting = new ArrayList<>();
        ArrayList<Double> subjectAverage = new ArrayList<>();



        for (int i = 0; i < semesterList.size(); i++) {
            System.out.println("Subi");
            for (int j = 0; j < subjectList.size(); j++) {
                if(semesterList.get(i).getUuid().equals(subjectList.get(j).getSemesterUuid())) {
                    for (int k = 0; k < gradeList.size(); k++) {
                        if (subjectList.get(j).getUuid().equals(gradeList.get(k).getSubjectUuid())) {
                            subjectTotal.add(gradeList.get(k).getValue() / gradeList.get(k).getWeighting());
                            subjectWeighting.add(gradeList.get(k).getWeighting());
                        }
                    }
                    double total = 0;
                    double totalw = 0;

                    for (Double value:
                         subjectTotal) {
                        total = total + value;
                        totalw = totalw + subjectWeighting.get(subjectTotal.indexOf(value));
                        System.out.println(total + " " + totalw);
                    }
                    semesterTotal.add(total / totalw);
                    semesterWeighting.add(subjectList.get(j).getWeighting());
                    subjectTotal.clear();
                    subjectWeighting.clear();
                }
            }
            double x = 0;
            double y = 0;
            for (Double value:
                    semesterTotal) {
                x = x + value * semesterWeighting.get(semesterTotal.indexOf(value));
                y = y + semesterWeighting.get(semesterTotal.indexOf(value));
            }
            semesterAverage.add(Math.floor((x / y) * 100) /100);
            System.out.println("Jetzt");
            for (Double val:
                 semesterAverage) {
                System.out.println("va       " + val);
            }

            semesterTotal.clear();
            semesterWeighting.clear();
        }

        double x = 0;
        double y = 0;
        for (Double value:
             semesterTotal) {
            System.out.println("Semester: " + value + "  " + semesterWeighting.get(semesterTotal.indexOf(value)));
            x = x + value * semesterWeighting.get(semesterTotal.indexOf(value));
            y = y + semesterWeighting.get(semesterTotal.indexOf(value));
        }

        System.out.println("x: " + x + " y: " + y);
        System.out.println("result: " + x / y);

        double result = x / y;

        return Math.floor(result * 100) /100;
    }


    public static double getAverageSubject() {
        ArrayList<Subject> subjectList = getSubjectList();
        DataHandler.readGradeJSON();
        ArrayList<Grade> gradeList = DataHandler.getGradelist();
        ArrayList<Double> subjectTotal = new ArrayList<>();
        ArrayList<Double> subjectWeighting = new ArrayList<>();
        ArrayList<Double> subjectAverage = new ArrayList<>();
        for (int i = 0; i < subjectList.size(); i++) {
            double x = 0;
            double y = 0;
            for (int j = 0; j < gradeList.size(); j++) {
                if(gradeList.get(j).getSubjectUuid().equals(subjectList.get(i).getUuid())) {
                    x = x + gradeList.get(j).getValue()*gradeList.get(j).getWeighting();
                    y = y + gradeList.get(j).getWeighting();
                }
            }
            subjectTotal.add(i, x);
            subjectWeighting.add(i,y);
        }
        double total = 0;
        double size = 0;
        for (Double value:
             subjectTotal) {
            subjectAverage.add(value / subjectWeighting.get(subjectTotal.indexOf(value)));
            if (subjectAverage.get(subjectTotal.indexOf(value)).isNaN() == false) {
                total = total + subjectAverage.get(subjectTotal.indexOf(value));
                size = size + 1;
            }
        }
        double result = total / size;
        return Math.floor(result * 100) /100;
    }




    public static double getAverageGrade() {

        double total = 0;
        double weighting = 0;

        for (Grade grade:
             getGradeList()) {
            total = total + grade.getValue() * grade.getWeighting();
            weighting = weighting + grade.getWeighting();
        }

        return Math.floor(total / weighting * 100) / 100;
    }

    public static double getAverageOfAllSemesters() {

        double total = 0;
        double weighting = 0;

        for (Semester semester:
                DataHandler.getSemesterlist()) {
            total = total + getAverageOfAllSubjects(semester);
            weighting = weighting + 1;
        }

        return Math.floor(total / weighting * 100) / 100;
    }

    public static double getAverageOfAllSubjects(Semester semester) {

        //Provisorisch
        DataHandler.readSubjectJSON();

        double total = 0;
        double weighting = 0;

        for (Subject subject:
                DataHandler.getSubjectlist()) {
            if(subject.getSemesterUuid().equals(semester.getUuid())) {
                total = total + getAverageOfAllGrades(subject) * subject.getWeighting();
                weighting = weighting + subject.getWeighting();
            }
        }

        return Math.floor(total / weighting * 100) / 100;
    }

    public static double getAverageOfAllGrades(Subject subject) {

        //Provisorisch
        DataHandler.readGradeJSON();

        double total = 0;
        double weighting = 0;

        for (Grade grade:
                DataHandler.getGradelist()) {
            if(grade.getSubjectUuid().equals(subject.getUuid())) {
                total = total + grade.getValue() * grade.getWeighting();
                weighting = weighting + grade.getWeighting();
            }
        }

        return Math.floor(total / weighting * 100) / 100;
    }
}
