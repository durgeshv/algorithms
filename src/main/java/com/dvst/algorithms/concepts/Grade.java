package main.java.com.dvst.algorithms.concepts;

/**
 * Created by durgesh on 5/9/17.
 */
public class Grade {

    private double percentage;
    private double weightage;

    public Grade(){

    }

    public Grade(double percentage, double weightage){
        this.percentage = percentage;
        this.weightage = weightage;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getWeightage() {
        return weightage;
    }

    public void setWeightage(double weightage) {
        this.weightage = weightage;
    }
}
