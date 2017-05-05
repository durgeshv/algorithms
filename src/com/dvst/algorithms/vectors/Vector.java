package com.dvst.algorithms.vectors;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by durgesh on 5/2/17.
 */
public class Vector {

    private List<Double> coordinates;

    public static void main(String[] args){
        System.out.println("Initializing Vectors !!");
        Vector v1 = new Vector(Arrays.asList(1.0,2.0,3.0));
        System.out.println(v1.toString());
        Vector v2 = new Vector(Arrays.asList(-1.0,2.0,3.0));
        System.out.println(v2.toString());
        System.out.println(v1.equals(v2));

        System.out.println("Addition : " + new Vector().add(new Vector(Arrays.asList(8.218, -9.341)), new Vector(Arrays.asList(-1.129, 2.111))));
        System.out.println("Subtraction : " + new Vector().subtract(new Vector(Arrays.asList(7.119, 8.215)), new Vector(Arrays.asList(-8.223, 0.878))));
        System.out.println("Scalar Product : " + new Vector().getScalarProduct(new Vector(Arrays.asList(1.671, -1.012, -0.318)), 7.41));
        System.out.println("Magnitude : " + new Vector().getMagnitude(new Vector(Arrays.asList(-0.221, 7.437))));
        System.out.println("Magnitude : " + new Vector().getMagnitude(new Vector(Arrays.asList(8.813, -1.331, -6.247))));
        System.out.println("Normalize : " + new Vector().normalize(new Vector(Arrays.asList(5.581, -2.136))));
        System.out.println("Normalize : " + new Vector().normalize(new Vector(Arrays.asList(1.996, 3.108, -4.554))));
        System.out.println("Dot Product : " + new Vector().getDotProduct(new Vector(Arrays.asList(7.887, 4.138)), new Vector(Arrays.asList(-8.802, 6.776))));
        System.out.println("Dot Product : " + new Vector().getDotProduct(new Vector(Arrays.asList(-5.955, -4.904, -1.874)), new Vector(Arrays.asList(-4.496, -8.755, 7.103))));
        System.out.println("Angle in Radians : " + new Vector().getAngle(new Vector(Arrays.asList(3.183, -7.627)), new Vector(Arrays.asList(-2.668, 5.319))));
        System.out.println("Angle in Degrees : " + new Vector().toDegrees(new Vector().getAngle(new Vector(Arrays.asList(3.183, -7.627)), new Vector(Arrays.asList(-2.668, 5.319)))));
        System.out.println("Angle in Radians : " + new Vector().getAngle(new Vector(Arrays.asList(7.35, 0.221, 5.188)), new Vector(Arrays.asList(2.751, 8.259, 3.985))));
        System.out.println("Angle in Degrees : " + new Vector().toDegrees(new Vector().getAngle(new Vector(Arrays.asList(7.35, 0.221, 5.188)), new Vector(Arrays.asList(2.751, 8.259, 3.985)))));

    }

    public Vector(){
        this.coordinates = new ArrayList<>();
    }

    public Vector(List<Double> coordinates){
        this.coordinates = coordinates;
    }

    public String toString(){
        if(this.coordinates != null){
            return "Vector : " + coordinates.toString();
        }
        return "Vector : ()";
    }

    public boolean equals(Vector vector){
        if(coordinates.size() == vector.getCoordinates().size()){
            for (int i=0;i<coordinates.size();i++){
                if(Math.abs(coordinates.get(i)) != Math.abs(vector.getCoordinates().get(i))){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    public Vector add(Vector v1, Vector v2){
        Vector result = new Vector();
        int size = getSize(v1, v2);
        try{
            for(int i=0; i<size; i++){
                double x = v1.getCoordinates().size() >= i ? v1.getCoordinates().get(i) : 0;
                double y = v2.getCoordinates().size() >= i ? v2.getCoordinates().get(i) : 0;
                result.getCoordinates().add(round(x + y));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public Vector subtract(Vector v1, Vector v2){
        Vector result = new Vector();
        int size = getSize(v1, v2);
        try{
            for(int i=0; i<size; i++){
                double x = v1.getCoordinates().size() >= i ? v1.getCoordinates().get(i) : 0;
                double y = v2.getCoordinates().size() >= i ? v2.getCoordinates().get(i) : 0;
                result.getCoordinates().add(round(x - y));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public Vector getScalarProduct(Vector v, double scalar){
        Vector result = new Vector();
        int size = v.getCoordinates().size();
        try{
            for(int i=0; i<size; i++){
                double x = v.getCoordinates().size() >= i ? v.getCoordinates().get(i) : 0;
                result.getCoordinates().add(round(x * scalar));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public double getMagnitude(Vector v){
        double result = 0.0;
        int size = v.getCoordinates().size();
        try{
            for (int i=0; i<size; i++){
                result += v.getCoordinates().get(i) * v.getCoordinates().get(i);
            }
            result = round(Math.sqrt(result));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public Vector normalize(Vector v){
        Vector result = new Vector();
        int size = v.getCoordinates().size();
        try{
            double magnitude = getMagnitude(v);
            result = getScalarProduct(v, (1 / magnitude));
        }
        catch(Exception ex){

        }
        return result;
    }

    public double getDotProduct(Vector v, Vector w){
        double result = 0.0;
        int size = getSize(v, w);
        try{
            for (int i=0; i<size; i++){
                result += v.getCoordinates().get(i) * w.getCoordinates().get(i);
            }
            result = round(result);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public double getAngle(Vector v, Vector w){
        double result = 0.0;
        int size = getSize(v, w);
        try{
            double dotProduct = getDotProduct(v, w);
            double magnitudeProduct = getMagnitude(v) * getMagnitude(w);

            if(dotProduct == 0){
                result = 90.0;
            }
            else if(dotProduct == magnitudeProduct){
                result = 0.0;
            }
            else if(dotProduct == -magnitudeProduct){
                result = 180.0;
            }
            else{
                result = round(Math.acos(dotProduct / magnitudeProduct));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    private double round(double value){
        //return Math.round(value * 1000.0) / 1000.0;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return Double.parseDouble(df.format(value));
    }

    private int getSize(Vector v1, Vector v2){
        if(v1.getCoordinates().size() > v2.getCoordinates().size()){
            return v1.getCoordinates().size();
        }
        return v2.getCoordinates().size();
    }

    private double toDegrees(double radians){
        return round(Math.toDegrees(radians));
    }

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}
