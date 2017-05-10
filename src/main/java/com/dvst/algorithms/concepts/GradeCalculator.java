package main.java.com.dvst.algorithms.concepts;


import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by durgesh on 5/9/17.
 */
public class GradeCalculator {

    private List<Grade> grades = new ArrayList<>();
    private double percentage;

    public static void main(String[] args){
        System.out.println("Software Development Process");
        GradeCalculator sdpGradeCalculator = new GradeCalculator();
        sdpGradeCalculator.getGrades().add(new Grade(100.00, 2.00));
        sdpGradeCalculator.getGrades().add(new Grade(70.5, 6.00));
        sdpGradeCalculator.getGrades().add(new Grade(87.5, 6.00));
        sdpGradeCalculator.getGrades().add(new Grade(95.00, 8.00));
        sdpGradeCalculator.getGrades().add(new Grade(83.00, 10.00));
        sdpGradeCalculator.getGrades().add(new Grade(71.00, 10.00));
        sdpGradeCalculator.getGrades().add(new Grade(87.00, 10.00));
        sdpGradeCalculator.getGrades().add(new Grade(100.00, 10.00));
        sdpGradeCalculator.getGrades().add(new Grade(97.00, 15.00));
        sdpGradeCalculator.getGrades().add(new Grade(103.6, 20.00));
        sdpGradeCalculator.getGrades().add(new Grade(100.00, 3.00));

        sdpGradeCalculator.calculateGrade();

        System.out.println("Software Architecture and Design");
        GradeCalculator sadGradeCalculator = new GradeCalculator();
        sadGradeCalculator.getGrades().add(new Grade(100.00, 2.00));
        sadGradeCalculator.getGrades().add(new Grade(70.5, 6.00));
        sadGradeCalculator.getGrades().add(new Grade(87.5, 6.00));
        sadGradeCalculator.getGrades().add(new Grade(95.00, 8.00));
        sadGradeCalculator.getGrades().add(new Grade(83.00, 10.00));
        sadGradeCalculator.getGrades().add(new Grade(71.00, 10.00));
        sadGradeCalculator.getGrades().add(new Grade(87.00, 10.00));
        sadGradeCalculator.getGrades().add(new Grade(100.00, 10.00));
        sadGradeCalculator.getGrades().add(new Grade(97.00, 15.00));
        sadGradeCalculator.getGrades().add(new Grade(103.6, 20.00));
        sadGradeCalculator.getGrades().add(new Grade(100.00, 3.00));

        sadGradeCalculator.calculateGrade();

    }

    public void calculateGrade(){
        double totalEffectivePercentage = 0.0;
        double totalWeightage = 0.0;
        if(grades != null){
            for (Grade g : grades){
                double effectivePercentage = round((g.getWeightage() * g.getPercentage()) / 100);
                System.out.println("Percentage : " + g.getPercentage() + "  |   Weightage : " + g.getWeightage() + "  | Effective Percentage : " + effectivePercentage);
                totalWeightage += g.getWeightage();
                totalEffectivePercentage += effectivePercentage;
            }
        }
        System.out.println("Total Weightage : " + round(totalWeightage) + "  |  Final Percentage : " + round(totalEffectivePercentage));
    }

    private double round(double value){
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(value));
    }


    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
