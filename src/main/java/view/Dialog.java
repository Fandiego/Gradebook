package view;

import controller.SemesterController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Dialog extends JDialog{
    JPanel dialog;
    JPanel dialog1;
    JPanel dialog2;
    JPanel dialog3;
    JPanel dialog4;
    JPanel dialog5;

    //Semester
    JTextField semesterName;
    SpinnerDateModel semesterStartSpinnerDateModel;
    JSpinner semesterStartSpinner;
    JSpinner.DateEditor semesterStartSpinnerEditor;
    SpinnerDateModel semesterEndeSpinnerDateModel;
    JSpinner semesterEndeSpinner;
    JSpinner.DateEditor semesterEndeEditor;

    //Subject
    JTextField subjectName;
    JSpinner subjectSpinner;
    SpinnerNumberModel subjectModel;
    JSpinner.NumberEditor subjectEditor;

    //Grade
    JTextField gradeName;
    JSpinner gradeValueSpinner;
    SpinnerNumberModel gradeValueModel;
    JSpinner.NumberEditor gradeValueEditor;
    JSpinner gradeWeightingSpinner;
    SpinnerNumberModel gradeWeightingModel;
    JSpinner.NumberEditor gradeWeightingEditor;
    JSpinner gradeDateSpinner;
    SpinnerDateModel gradeDateModel;
    JSpinner.DateEditor gradeDateEditor;


    // Enter Button
    JButton enter;
    int status;
    int semesterIndex;

    public Dialog(int status) {
        dialog = new JPanel();
        enter = new JButton("enter");
        this.status = status;


        if(status == 1 || status == 4) {
            semesterName = new JTextField();
            dialog.add(semesterName);
            dialog.setLayout(new GridLayout(5,1));
            dialog1 = new JPanel();
            dialog2 = new JPanel();
            dialog3 = new JPanel();
            dialog4 = new JPanel();
            dialog1.setLayout(new GridLayout(2,4));
            dialog2.setLayout(new GridLayout(2,4));
            dialog3.setLayout(new GridLayout(2,4));
            dialog4.setLayout(new GridLayout(2,5));
            dialog.add(dialog1);
            dialog.add(dialog2);
            dialog.add(dialog3);
            dialog.add(dialog4);
            dialog.add(new JPanel());
            dialog1.add(new JPanel());
            dialog1.add(new JPanel());
            dialog1.add(new JPanel());
            dialog1.add(new JPanel());
            dialog1.add(new JPanel());
            dialog1.add(new JLabel("Name: "));
            dialog1.add(semesterName);
            dialog2.add(new JPanel());
            dialog2.add(new JPanel());
            dialog2.add(new JPanel());
            dialog2.add(new JPanel());
            dialog2.add(new JPanel());
            dialog2.add(new JLabel("Beginn: "));
            semesterStartSpinnerDateModel = new SpinnerDateModel(new Date(),null,null, Calendar.MONTH);
            semesterStartSpinner = new JSpinner(semesterStartSpinnerDateModel);
            semesterStartSpinnerEditor = new JSpinner.DateEditor(semesterStartSpinner, "dd/MM/yyyy");
            semesterStartSpinner.setEditor(semesterStartSpinnerEditor);
            semesterStartSpinnerEditor.getTextField().setEditable(false);
            dialog2.add(semesterStartSpinner);
            dialog2.add(new JPanel());
            dialog3.add(new JPanel());
            dialog3.add(new JPanel());
            dialog3.add(new JPanel());
            dialog3.add(new JPanel());
            dialog3.add(new JPanel());
            dialog3.add(new JLabel("Ende: "));

            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate localDate = LocalDate.now().plusMonths(6);
            Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

            semesterEndeSpinnerDateModel = new SpinnerDateModel(date, null,null, Calendar.MONTH);
            semesterEndeSpinner = new JSpinner(semesterEndeSpinnerDateModel);
            semesterEndeEditor = new JSpinner.DateEditor(semesterEndeSpinner, "dd/MM/yyyy");
            semesterEndeSpinner.setEditor(semesterEndeEditor);
            semesterEndeEditor.getTextField().setEditable(false);
            dialog3.add(semesterEndeSpinner);
            dialog3.add(new JPanel());

            for (int i = 0; i < 7; i++) {
                dialog4.add(new JPanel());
            }
            dialog4.add(enter);
            dialog4.add(new JPanel());

            semesterName.setText("Semestername");

        }

        else if(status == 2 ||status == 5) {
            subjectName = new JTextField();
            dialog.add(subjectName);

            dialog.setLayout(new GridLayout(4,1));
            JPanel dialog1 = new JPanel();
            dialog1.setLayout(new GridLayout(2,4));
            JPanel dialog2 = new JPanel();
            dialog2.setLayout(new GridLayout(2,4));
            JPanel dialog3 = new JPanel();
            dialog3.setLayout(new GridLayout(2,5));
            dialog.add(dialog1);
            dialog.add(dialog2);
            dialog.add(dialog3);
            dialog.add(new JPanel());
            for (int i = 0; i < 4; i++) {
                dialog1.add(new JPanel());
            }
            dialog1.add(new JPanel());
            dialog1.add(new JLabel("Name: "));
            dialog1.add(subjectName);
            dialog1.add(new JPanel());
            subjectName.setText("Subject: " + (SemesterController.getSubjectList().size() + 1));

            for (int i = 0; i < 5; i++) {
                dialog2.add(new JPanel());
            }
            dialog2.add(new JLabel("Gewichtung: "));
            subjectModel = new SpinnerNumberModel(0.0,0.0,2.0,0.01);
            //sp.setMaximum(200);
            //sp.setMinimum(0);
            //sp.setStepSize(1);
            //sp.setValue(100);
            subjectSpinner = new JSpinner(subjectModel);
            subjectEditor = new JSpinner.NumberEditor(subjectSpinner, "0.00");
            subjectSpinner.setEditor(subjectEditor);
            subjectEditor.getTextField().setEditable(false);
            subjectSpinner.setValue(1);
            dialog2.add(subjectSpinner);
            dialog2.add(new JPanel());

            for (int i = 0; i < 7; i++) {
                dialog3.add(new JPanel());
            }
            dialog3.add(enter);
            dialog3.add(new JPanel());
            dialog3.add(new JPanel());

        }

        else if(status == 3 || status == 6) {

            if (status == 3) {
                setTitle("create Grade");
            } else if (status == 6) {
                setTitle("edit Grade");
            }


            dialog.setLayout(new GridLayout(6,1));
            dialog1 = new JPanel();
            dialog1.setLayout(new GridLayout(2,4));
            dialog2 = new JPanel();
            dialog2.setLayout(new GridLayout(2,4));
            dialog3 = new JPanel();
            dialog3.setLayout(new GridLayout(2,4));
            dialog4 = new JPanel();
            dialog4.setLayout(new GridLayout(2,4));
            dialog5 = new JPanel();
            dialog5.setLayout(new GridLayout(2,5));
            dialog.add(dialog1);
            dialog.add(dialog2);
            dialog.add(dialog3);
            dialog.add(dialog4);
            dialog.add(dialog5);
            dialog.add(new JPanel());

            for (int i = 0; i < 5; i++) {
                dialog1.add(new JPanel());
            }
            gradeName = new JTextField();
            gradeName.setText("Prüfung " + (SemesterController.getGradeList().size() + 1));
            dialog1.add(new JLabel("Name: "));
            dialog1.add(gradeName);
            dialog1.add(new JPanel());

            for (int i = 0; i < 5; i++) {
                dialog2.add(new JPanel());
            }
            dialog2.add(new JLabel("Note: "));
            gradeValueModel = new SpinnerNumberModel(4,1.0,6.0,0.1);
            gradeValueSpinner = new JSpinner(gradeValueModel);
            gradeValueEditor = new JSpinner.NumberEditor(gradeValueSpinner, "0.00");
            gradeValueSpinner.setEditor(gradeValueEditor);
            gradeValueEditor.getTextField().setEditable(false);
            dialog2.add(gradeValueSpinner);
            dialog2.add(new JPanel());



            for (int i = 0; i < 5; i++) {
                dialog3.add(new JPanel());
            }

            dialog3.add(new JLabel("Gewichtung: "));
            gradeWeightingModel = new SpinnerNumberModel(0.0,0.0,2.0,0.01);
            gradeWeightingSpinner = new JSpinner(gradeWeightingModel);
            gradeWeightingEditor = new JSpinner.NumberEditor(gradeWeightingSpinner, "0.00");
            gradeWeightingSpinner.setEditor(gradeWeightingEditor);
            gradeWeightingEditor.getTextField().setEditable(false);
            gradeWeightingSpinner.setValue(1);
            dialog3.add(gradeWeightingSpinner);
            dialog3.add(new JPanel());


            for (int i = 0; i < 5; i++) {
                dialog4.add(new JPanel());
            }
            dialog4.add(new JLabel("Date: "));
            gradeDateModel = new SpinnerDateModel(new Date(),null,null, Calendar.MONTH);
            gradeDateSpinner = new JSpinner(gradeDateModel);
            gradeDateEditor = new JSpinner.DateEditor(gradeDateSpinner, "dd/MM/yyyy");
            gradeDateSpinner.setEditor(gradeDateEditor);
            gradeDateEditor.getTextField().setEditable(false);
            dialog4.add(gradeDateSpinner);
            dialog4.add(new JPanel());



            for (int i = 0; i < 7; i++) {
                dialog5.add(new JPanel());
            }

            dialog5.add(enter);
            dialog5.add(new JPanel());
            dialog5.add(new JPanel());
        }
        enter.addActionListener(new buttonlistener());
        setSize(600,300);
        getContentPane().add(dialog);
        setModal(true);
    }


    public Dialog(int status, int semesterIndex) {
        this(status);

        if (status == 3) {
        }

        this.semesterIndex = semesterIndex;
        if (status == 4) {
            subjectName.setText(SemesterController.getSemesterList().get(semesterIndex).getName());
        } else if (status == 5) {
            subjectName.setText(SemesterController.getSubjectList().get(semesterIndex).getName());
            subjectModel.setValue(SemesterController.getSubjectList().get(semesterIndex).getWeighting());
        } else if(status == 6) {
            gradeName.setText(SemesterController.getGradeList().get(semesterIndex).getName());
            gradeValueSpinner.setValue(SemesterController.getGradeList().get(semesterIndex).getValue());
            gradeWeightingSpinner.setValue(SemesterController.getGradeList().get(semesterIndex).getWeighting());
            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate localDate = SemesterController.getGradeList().get(semesterIndex).getDate();
            Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

            gradeDateSpinner.setValue(date);
        }
    }





    private class buttonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand() == "enter" && status == 1) {
                LocalDate start = LocalDate.parse(semesterStartSpinnerEditor.getTextField().getText().substring(6,10) + "-" +
                        semesterStartSpinnerEditor.getTextField().getText().substring(3,5) + "-" +
                        semesterStartSpinnerEditor.getTextField().getText().substring(0,2));

                LocalDate end = LocalDate.parse(semesterEndeEditor.getTextField().getText().substring(6,10) + "-" +
                        semesterEndeEditor.getTextField().getText().substring(3,5) + "-" +
                        semesterEndeEditor.getTextField().getText().substring(0,2));


                SemesterController.addSemester(semesterName.getText(), start, end);
                dispose();
            } else if (e.getActionCommand() == "enter" && status == 2) {
                SemesterController.addSubject(subjectName.getText(), subjectModel.getNumber().doubleValue(),semesterIndex);
                dispose();
            } else if (e.getActionCommand() == "enter" && status == 3) {
                Double val = new Double(gradeValueModel.getNumber().doubleValue());
                val = (Math.ceil(val*10)/10);
                Double wei = new Double(gradeWeightingModel.getNumber().doubleValue());
                wei = Math.ceil(wei*100)/100;

                System.out.println(gradeDateEditor.getTextField().getText());

                LocalDate date = LocalDate.parse(gradeDateEditor.getTextField().getText().substring(6,10) + "-" +
                        gradeDateEditor.getTextField().getText().substring(3,5) + "-" +
                        gradeDateEditor.getTextField().getText().substring(0,2));

                SemesterController.addGrade(gradeName.getText(), val,wei,date,semesterIndex);
                dispose();
            } else if (e.getActionCommand() == "enter" && status == 4) {
                SemesterController.updateSemester(semesterIndex, semesterName.getText(), LocalDate.of(2004,10,21), LocalDate.of(2004,10,21));
                dispose();
            } else if (e.getActionCommand() == "enter" && status == 5) {
                SemesterController.updateSubject(semesterIndex, subjectModel.getNumber().doubleValue(),subjectName.getText());
                dispose();
            } else if (e.getActionCommand() == "enter" && status == 6) {
                Double val = new Double(gradeValueModel.getNumber().doubleValue());
                val = (Math.ceil(val*10)/10);
                Double wei = new Double(gradeWeightingModel.getNumber().doubleValue());
                wei = Math.ceil(wei*100)/100;


                LocalDate date = LocalDate.parse(gradeDateEditor.getTextField().getText().substring(6,10) + "-" +
                        gradeDateEditor.getTextField().getText().substring(3,5) + "-" +
                        gradeDateEditor.getTextField().getText().substring(0,2));


                SemesterController.updateGrade(semesterIndex, gradeName.getText(), val, wei, date);
                dispose();
            }
        }
    }

}
