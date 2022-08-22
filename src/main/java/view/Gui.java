package view;

import controller.SemesterController;
import model.Grade;
import model.Semester;
import model.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gui extends JFrame {

    // Main Gui Panel
    private JPanel gui;

    // Panel for Comboboxes
    JPanel semesterComboboxPanel;
    JPanel subjectComboboxPanel;
    JPanel gradeComboboxPanel;

    // Comboboxes
    JComboBox<String> semesters;
    JComboBox<String> subjects;
    JComboBox<String> grades;

    // Panel and Buttons for Semester
    JPanel createSemesterButtonPanel;
    JButton createSemester;
    JButton updateSemester;
    JButton deleteSemester;

    // Panel and Buttons for Subject
    JPanel createSubjectButtonPanel;
    JButton createSubject;
    JButton updateSubject;
    JButton deleteSubject;

    // Panel and Buttons for Grade
    JPanel createGradeButtonPanel;
    JButton createGrade;
    JButton updateGrade;
    JButton deleteGrade;

    // Textareas
    //JTextArea semesterInfo;
    //JTextArea subjectInfo;
    //JTextArea gradeInfo;

    //Semester Info
    JPanel semesterInfo;
    JLabel semesterInfo1;
    JLabel semesterInfo2;
    JLabel semesterInfo3;
    JLabel semesterInfo4;
    JLabel semesterInfo5;

    //Subject Info
    JPanel subjectInfo;
    JLabel subjectInfo1;
    JLabel subjectInfo2;
    JLabel subjectInfo3;
    JLabel subjectInfo4;
    JLabel subjectInfo5;

    //grade Info
    JPanel gradeInfo;
    JLabel gradeInfo1;
    JLabel gradeInfo2;
    JLabel gradeInfo3;
    JLabel gradeInfo4;
    JLabel gradeInfo5;


    // Sort Semesters
    JPanel sortSemester;
    ButtonGroup sortSemesterButtonGroup;
    JRadioButton serb1;
    JRadioButton serb2;

    // Sort Subjects
    JPanel sortSubject;
    ButtonGroup sortSubjectButtonGroup;
    JRadioButton surb1;
    JRadioButton surb2;

    // Sort Subjects
    JPanel sortGrade;
    ButtonGroup sortGradeButtonGroup;
    JRadioButton grb1;
    JRadioButton grb2;
    JRadioButton grb3;
    JRadioButton grb4;


    checkboxListener ck = new checkboxListener();



    public Gui(){
        createComponents();
        setVisible(true);
        setResizable(true);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(gui);

        addComponents();

        gui.setLayout(new GridLayout(4,3));
        createSemesterButtonPanel.setLayout(new GridLayout(3,3));
        createSubjectButtonPanel.setLayout(new GridLayout(3,3));
        createGradeButtonPanel.setLayout(new GridLayout(3,3));

        createSemester.addActionListener(new buttonlistener());
        deleteSemester.addActionListener(new buttonlistener());
        createSubject.addActionListener(new buttonlistener());
        deleteSubject.addActionListener(new buttonlistener());
        createGrade.addActionListener(new buttonlistener());
        deleteGrade.addActionListener(new buttonlistener());




        refreshSemester();
        refreshSubject();
        refreshGrade();



    }

    public void createComponents() {
        gui = new JPanel();
        semesterComboboxPanel = new JPanel();
        subjectComboboxPanel = new JPanel();
        gradeComboboxPanel = new JPanel();
        semesters = new JComboBox<>();
        subjects = new JComboBox<>();
        grades = new JComboBox<>();
        createSemester = new JButton("create Semester");
        deleteSemester = new JButton("delete Semester");
        createSubject = new JButton("create Subject");
        deleteSubject = new JButton("delete Subject");
        createGrade = new JButton("create Grade");
        deleteGrade = new JButton("delete Grade");
        createSemesterButtonPanel = new JPanel();
        createSubjectButtonPanel = new JPanel();
        createGradeButtonPanel = new JPanel();
        updateSemester = new JButton("update Semester");
        updateSubject = new JButton("update Subject");
        updateGrade = new JButton("update Grade");
        semesterInfo = new JPanel();
        subjectInfo = new JPanel();
        gradeInfo = new JPanel();
        sortSemester = new JPanel();
        sortSemesterButtonGroup = new ButtonGroup();
        serb1 = new JRadioButton();
        serb2 = new JRadioButton();
        sortSubject = new JPanel();
        sortSubjectButtonGroup = new ButtonGroup();
        surb1 = new JRadioButton();
        surb2 = new JRadioButton();
        sortGrade = new JPanel();
        sortGradeButtonGroup = new ButtonGroup();
        grb1 = new JRadioButton();
        grb2 = new JRadioButton();
        grb3 = new JRadioButton();
        grb4 = new JRadioButton();
    }

    public void addComponents() {
        semesterComboboxPanel.setLayout(new GridLayout(3,1));
        subjectComboboxPanel.setLayout(new GridLayout(3,1));
        gradeComboboxPanel.setLayout(new GridLayout(3,1));

        semesterComboboxPanel.add(new JPanel());
        semesterComboboxPanel.add(semesters);
        semesterComboboxPanel.add(new JPanel());

        subjectComboboxPanel.add(new JPanel());
        subjectComboboxPanel.add(subjects);
        subjectComboboxPanel.add(new JPanel());

        gradeComboboxPanel.add(new JPanel());
        gradeComboboxPanel.add(grades);
        gradeComboboxPanel.add(new JPanel());


        gui.add(semesterComboboxPanel);
        gui.add(subjectComboboxPanel);
        gui.add(gradeComboboxPanel);


        createSemesterButtonPanel.add(new JPanel());
        createSemesterButtonPanel.add(new JPanel());
        createSemesterButtonPanel.add(new JPanel());
        updateSemester.addActionListener(new buttonlistener());
        updateSubject.addActionListener(new buttonlistener());
        updateGrade.addActionListener(new buttonlistener());
        createSemesterButtonPanel.add(createSemester);
        createSemesterButtonPanel.add(updateSemester);
        createSemesterButtonPanel.add(deleteSemester);
        createSemesterButtonPanel.add(new JPanel());
        createSemesterButtonPanel.add(new JPanel());
        createSemesterButtonPanel.add(new JPanel());
        gui.add(createSemesterButtonPanel);
        createSubjectButtonPanel.add(new JPanel());
        createSubjectButtonPanel.add(new JPanel());
        createSubjectButtonPanel.add(new JPanel());
        createSubjectButtonPanel.add(createSubject);
        createSubjectButtonPanel.add(updateSubject);
        createSubjectButtonPanel.add(deleteSubject);
        createSubjectButtonPanel.add(new JPanel());
        createSubjectButtonPanel.add(new JPanel());
        createSubjectButtonPanel.add(new JPanel());
        gui.add(createSubjectButtonPanel);

        createGradeButtonPanel.add(new JPanel());
        createGradeButtonPanel.add(new JPanel());
        createGradeButtonPanel.add(new JPanel());
        createGradeButtonPanel.add(createGrade);
        createGradeButtonPanel.add(updateGrade);
        createGradeButtonPanel.add(deleteGrade);
        createGradeButtonPanel.add(new JPanel());
        createGradeButtonPanel.add(new JPanel());
        createGradeButtonPanel.add(new JPanel());
        gui.add(createGradeButtonPanel);

        semesterInfo.setLayout(new GridLayout(5,1));
        semesterInfo1 = new JLabel();
        semesterInfo2 = new JLabel();
        semesterInfo3 = new JLabel();
        semesterInfo4 = new JLabel();
        semesterInfo5 = new JLabel();
        semesterInfo.add(semesterInfo1);
        semesterInfo.add(semesterInfo2);
        semesterInfo.add(semesterInfo3);
        semesterInfo.add(semesterInfo4);
        semesterInfo.add(semesterInfo5);

        subjectInfo.setLayout(new GridLayout(5,1));
        subjectInfo1 = new JLabel();
        subjectInfo2 = new JLabel();
        subjectInfo3 = new JLabel();
        subjectInfo4 = new JLabel();
        subjectInfo5 = new JLabel();
        subjectInfo.add(subjectInfo1);
        subjectInfo.add(subjectInfo2);
        subjectInfo.add(subjectInfo3);
        subjectInfo.add(subjectInfo4);
        subjectInfo.add(subjectInfo5);

        gradeInfo.setLayout(new GridLayout(5,1));
        gradeInfo1 = new JLabel();
        gradeInfo2 = new JLabel();
        gradeInfo3 = new JLabel();
        gradeInfo4 = new JLabel();
        gradeInfo5 = new JLabel();
        gradeInfo.add(gradeInfo1);
        gradeInfo.add(gradeInfo2);
        gradeInfo.add(gradeInfo3);
        gradeInfo.add(gradeInfo4);
        gradeInfo.add(gradeInfo5);

        gui.add(semesterInfo);
        gui.add(subjectInfo);
        gui.add(gradeInfo);


        sortSemester.setLayout(new GridLayout(4,3));

        sortSemesterButtonGroup.add(serb1);
        sortSemesterButtonGroup.add(serb2);
        serb1.setSelected(true);
        serb1.setActionCommand("0");
        serb2.setActionCommand("1");
        serb1.addActionListener(new buttonlistener());
        serb2.addActionListener(new buttonlistener());

        sortSemester.add(new JLabel("A-Z"));
        sortSemester.add(serb1);
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel("Z-A"));
        sortSemester.add(serb2);
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        sortSemester.add(new JLabel());
        surb1.addActionListener(new buttonlistener());
        surb2.addActionListener(new buttonlistener());


        sortSubject.setLayout(new GridLayout(4,3));

        sortSubjectButtonGroup.add(surb1);
        sortSubjectButtonGroup.add(surb2);
        surb1.setSelected(true);
        surb1.setActionCommand("0");
        surb2.setActionCommand("1");

        sortSubject.add(new JLabel("A-Z"));
        sortSubject.add(surb1);
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel("Z-A"));
        sortSubject.add(surb2);
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());
        sortSubject.add(new JLabel());


        sortGrade.setLayout(new GridLayout(4,3));

        sortGradeButtonGroup.add(grb1);
        sortGradeButtonGroup.add(grb2);
        sortGradeButtonGroup.add(grb3);
        sortGradeButtonGroup.add(grb4);
        grb1.addActionListener(new buttonlistener());
        grb2.addActionListener(new buttonlistener());
        grb3.addActionListener(new buttonlistener());
        grb4.addActionListener(new buttonlistener());
        grb1.setSelected(true);
        grb1.setActionCommand("0");
        grb2.setActionCommand("1");
        grb3.setActionCommand("2");
        grb4.setActionCommand("3");

        sortGrade.add(new JLabel("Value 6-1"));
        sortGrade.add(grb1);
        sortGrade.add(new JLabel());
        sortGrade.add(new JLabel("Value: 1-6"));
        sortGrade.add(grb2);
        sortGrade.add(new JLabel());
        sortGrade.add(new JLabel("Weighting: 2-0"));
        sortGrade.add(grb3);
        sortGrade.add(new JLabel());
        sortGrade.add(new JLabel("Weighting: 0-2"));
        sortGrade.add(grb4);
        sortGrade.add(new JLabel());



        gui.add(sortSemester);
        gui.add(sortSubject);
        gui.add(sortGrade);


        semesters.addItemListener(ck);
        subjects.addItemListener(ck);
        grades.addItemListener(ck);

        //gui.add(refresh);
    }

    public void refreshSemester() {

        semesters.removeItemListener(ck);

        int index = semesters.getSelectedIndex();
        semesters.removeAllItems();
        SemesterController.setSemesterList();
        if(sortSemesterButtonGroup.getSelection().getActionCommand().equals("0")) {
            SemesterController.sortSemesterList(0);
        } else if (sortSemesterButtonGroup.getSelection().getActionCommand().equals("1")) {
            SemesterController.sortSemesterList(1);
        }


        for (Semester sem:
                SemesterController.getSemesterList()) {
            semesters.addItem(sem.getName());
        }
        if (index >= 0) {
            semesters.setSelectedIndex(index);
        }
        if (semesters.getItemCount() > 0) {
            LocalDate start = SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getStart();
            LocalDate end = SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getEnd();

            semesterInfo1.setText("Name: " + SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getName());
            semesterInfo2.setText("Start: " + SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getStart());
            semesterInfo3.setText("End: " + SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getEnd());
            semesterInfo4.setText("Average of all Semesters: " + SemesterController.getAverageOfAllSemesters());

        } else {
        }

        semesters.addItemListener(ck);

    }

    public void refreshSubject() {

        subjects.removeItemListener(ck);

        int index = subjects.getSelectedIndex();
        subjects.removeAllItems();
        SemesterController.setSubjectList(semesters.getSelectedIndex());
        if (SemesterController.getSubjectList() != null) {

            //Sorts Subjects
            if(sortSubjectButtonGroup.getSelection().getActionCommand().equals("0")) {
                SemesterController.sortSubjectList(0);
            } else if (sortSubjectButtonGroup.getSelection().getActionCommand().equals("1")) {
                SemesterController.sortSubjectList(1);
            }

            for (Subject sub :
                    SemesterController.getSubjectList()) {
                subjects.addItem(sub.getName());
            }
        }
        if (index >= 0) {
            if (subjects.getItemCount() > index) {
                subjects.setSelectedIndex(index);
            }
        }
        if (subjects.getItemCount() > 0) {
            subjectInfo1.setText("Name: " + SemesterController.getSubjectList().get(subjects.getSelectedIndex()).getName());
            subjectInfo2.setText("Weighting: " + SemesterController.getSubjectList().get(subjects.getSelectedIndex()).getWeighting());
            subjectInfo3.setText("Average of all Subjects: " + SemesterController.getAverageOfAllSubjects
                    (SemesterController.getSemesterList().get(semesters.getSelectedIndex())));
        } else {
            subjectInfo1.setText("Name: ");
        }

        subjects.addItemListener(ck);
    }

    public void refreshGrade() {

        grades.removeItemListener(ck);

        int index = grades.getSelectedIndex();
        grades.removeAllItems();
        if (subjects.getSelectedIndex() >= 0) {
            SemesterController.setGradeList(subjects.getSelectedIndex());
            if (SemesterController.getGradeList() != null) {

                //Sorts
                if(sortGradeButtonGroup.getSelection().getActionCommand().equals("0")) {
                    SemesterController.sortGradeList(0);
                } else if (sortGradeButtonGroup.getSelection().getActionCommand().equals("1")) {
                    SemesterController.sortGradeList(1);
                } else if (sortGradeButtonGroup.getSelection().getActionCommand().equals("2")) {
                    SemesterController.sortGradeList(2);
                } else if (sortGradeButtonGroup.getSelection().getActionCommand().equals("3")) {
                    SemesterController.sortGradeList(3);
                }

                for (Grade gra :
                        SemesterController.getGradeList()) {
                    grades.addItem(gra.getName());
                }
            }
            if (index >= 0) {
                if (grades.getItemCount() > index)
                    grades.setSelectedIndex(index);
            }
        }
        if (grades.getItemCount() > 0) {
            LocalDate date = SemesterController.getGradeList().get(grades.getSelectedIndex()).getDate();
            gradeInfo5.setFont(new TextArea().getFont());
            gradeInfo1.setText("Name: " + SemesterController.getGradeList().get(grades.getSelectedIndex()).getName());
            gradeInfo2.setText("Value: " + SemesterController.getGradeList().get(grades.getSelectedIndex()).getValue());
            gradeInfo3.setText("Weighting: " + SemesterController.getGradeList().get(grades.getSelectedIndex()).getWeighting());
            gradeInfo4.setText("Date: " + date.getDayOfMonth() + ". " + date.getMonth().name().charAt(0) +
                    date.getMonth().name().substring(1).toLowerCase() + " " + date.getYear());
            gradeInfo5.setText("Average of all Grades: " + SemesterController.getAverageOfAllGrades
                    (SemesterController.getSubjectList().get(subjects.getSelectedIndex())));
        } else {
            gradeInfo1.setText("Name: ");
            gradeInfo2.setText("Value: ");
            gradeInfo3.setText("Weighting: ");
            gradeInfo4.setText("Date: ");
            gradeInfo5.setText("Average of all Grades: ");

        }

        grades.addItemListener(ck);
    }


    private class buttonlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "create Semester") {
                ArrayList<Semester> old = new ArrayList<>(SemesterController.getSemesterList());

                Dialog dialog = new Dialog(1);
                dialog.setVisible(true);

                refreshSemester();
                refreshSubject();
                refreshGrade();

                ArrayList<Semester> newlist = new ArrayList<>(SemesterController.getSemesterList());

                for (int i = 0; i < newlist.size()-1; i++) {
                    if(old.get(i).getUuid().equals(newlist.get(i).getUuid())) {

                    } else {
                        semesters.setSelectedIndex(i);
                        break;
                    }
                }
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "update Semester") {
                System.out.println("sel ind" + semesters.getSelectedIndex());
                Dialog dialog = new Dialog(4, semesters.getSelectedIndex());
                dialog.setVisible(true);
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "delete Semester") {
                SemesterController.deleteSemester(semesters.getSelectedIndex());
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "create Subject") {
                ArrayList<Subject> old = new ArrayList<>(SemesterController.getSubjectList());

                Dialog dialog = new Dialog(2, semesters.getSelectedIndex());
                dialog.setVisible(true);

                refreshSubject();
                refreshGrade();

                ArrayList<Subject> newlist = new ArrayList<>(SemesterController.getSubjectList());


                for (int i = 0; i < newlist.size()-1; i++) {
                    if(old.get(i).getUuid().equals(newlist.get(i).getUuid())) {

                    } else {
                        subjects.setSelectedIndex(i);
                        break;
                    }
                }
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "update Subject") {
                Dialog dialog = new Dialog(5, subjects.getSelectedIndex());
                dialog.setVisible(true);
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "delete Subject") {
                SemesterController.deleteSubject(subjects.getSelectedIndex(), semesters.getSelectedIndex());
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "create Grade") {
                ArrayList<Grade> old = new ArrayList<>(SemesterController.getGradeList());

                Dialog dialog = new Dialog(3, subjects.getSelectedIndex());
                dialog.setVisible(true);

                refreshGrade();

                ArrayList<Grade> newlist = new ArrayList<>(SemesterController.getGradeList());

                for (int i = 0; i < newlist.size()-1; i++) {
                    if(old.get(i).getUuid().equals(newlist.get(i).getUuid())) {

                    } else {
                        grades.setSelectedIndex(i);
                        break;
                    }
                }
                refreshSemester();
                refreshSubject();
                refreshGrade();
            }

            else if (e.getActionCommand() == "update Grade") {
                Dialog dialog = new Dialog(6, grades.getSelectedIndex());
                dialog.setVisible(true);
                refreshSemester();
                refreshSubject();
                refreshGrade();;
            }

            else if (e.getActionCommand() == "delete Grade") {
                SemesterController.deleteGrade(grades.getSelectedIndex(), subjects.getSelectedIndex());
                refreshSemester();
                refreshSubject();
                refreshGrade();;
            }

            else if (e.getSource() == serb1 || e.getSource() == serb2) {
                String selection = SemesterController.getSemesterList().get(semesters.getSelectedIndex()).getUuid();
                refreshSemester();
                semesters.removeItemListener(ck);
                for (Semester sems:
                     SemesterController.getSemesterList()) {
                    if (selection.equals(sems.getUuid())) {
                        semesters.setSelectedIndex(SemesterController.getSemesterList().indexOf(sems));
                    }
                }
                semesters.addItemListener(ck);
                refreshSemester();
            }

            else if (e.getSource() == surb1 || e.getSource() == surb2) {
                String selection = SemesterController.getSubjectList().get(subjects.getSelectedIndex()).getUuid();
                refreshSubject();
                subjects.removeItemListener(ck);
                for (Subject subs:
                        SemesterController.getSubjectList()) {
                    if (selection.equals(subs.getUuid())) {
                        subjects.setSelectedIndex(SemesterController.getSubjectList().indexOf(subs));
                    }
                }
                subjects.addItemListener(ck);
                refreshSubject();
            }

            else if (e.getSource() == grb1 || e.getSource() == grb2
                    || e.getSource() == grb3 || e.getSource() == grb4) {

                String selection = SemesterController.getGradeList().get(grades.getSelectedIndex()).getUuid();
                refreshGrade();
                grades.removeItemListener(ck);
                for (Grade gra:
                        SemesterController.getGradeList()) {
                    if (selection.equals(gra.getUuid())) {
                        grades.setSelectedIndex(SemesterController.getGradeList().indexOf(gra));
                    }
                }
                grades.addItemListener(ck);
                refreshGrade();
            }

        }
    }








    private class checkboxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == semesters) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    refreshSemester();
                    refreshSubject();
                    refreshGrade();
                }
            }

            else if (e.getSource() == subjects) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    refreshSemester();
                    refreshSubject();
                    refreshGrade();
                }
            }

            else if (e.getSource() == grades) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    refreshSemester();
                    refreshSubject();
                    refreshGrade();
                }
            }
        }
    }


}
