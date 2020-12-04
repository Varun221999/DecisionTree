package com.jetbrains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.math.*;

public class Main {

    static ArrayList<String> Alt = new ArrayList<>(10);
    static ArrayList<String> Bar = new ArrayList<>(10);
    static ArrayList<String> Fri = new ArrayList<>(10);
    static ArrayList<String> Hun = new ArrayList<>(10);
    static ArrayList<String> Pat = new ArrayList<>(10);
    static ArrayList<String> Price = new ArrayList<>(10);
    static ArrayList<String> Rain = new ArrayList<>(10);
    static ArrayList<String> Res = new ArrayList<>(10);
    static ArrayList<String> Type = new ArrayList<>(10);
    static ArrayList<String> Est = new ArrayList<>(10);
    static ArrayList<String> WillWait = new ArrayList<>(10);
    static double dataSetEntropy = 0.0;
    public static void main(String[] args) {
        // write your code here
        /*File Parsing Try-Catch*/
        try {
            String fileName = "Resources/restaurant.csv";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String header[] = br.readLine().split(",");
                Alt.add(header[0]);
                Bar.add(header[1]);
                Fri.add(header[2]);
                Hun.add(header[3]);
                Pat.add(header[4]);
                Price.add(header[5]);
                Rain.add(header[6]);
                Res.add(header[7]);
                Type.add(header[8]);
                Est.add(header[9]);
                WillWait.add(header[10]);
            while ((line = br.readLine()) != null) {
                //process the line
                String[] arr = line.split(",");
                Alt.add(arr[0]);
                Bar.add(arr[1]);
                Fri.add(arr[2]);
                Hun.add(arr[3]);
                Pat.add(arr[4]);
                Price.add(arr[5]);
                Rain.add(arr[6]);
                Res.add(arr[7]);
                Type.add(arr[8]);
                Est.add(arr[9]);
                WillWait.add(arr[10]);
            }
        } catch (Exception e) {
            //System.out.println("Wrong Input. Please Enter 1 or 2");
            e.printStackTrace();
            System.exit(0);
        }
        entropy();
    }

    /*TODO: Entropy Calculation*/
    static double entropy(){
        dataSetEntropy = attribute_gain(WillWait);
        for(int i = 0; i <10; i++ ){
            switch (i) {
                case 0:
                     attribute_gain(Alt); break;
                case 1:
                    attribute_gain(Bar); break;
                case 2:
                    attribute_gain(Fri); break;
                case 3:
                    attribute_gain(Hun); break;
                case 4:
                    attribute_gain(Pat); break;
                case 5:
                    attribute_gain(Price); break;
                case 6:
                    attribute_gain(Rain); break;
                case 7:
                    attribute_gain(Res); break;
                case 8:
                    attribute_gain(Type); break;
                case 9:
                    attribute_gain(Est); break;
                default:
                    break;
            }
        }
        return 0.0;
    }
    static double attribute_gain(ArrayList<String> att) {
        Map<String, Integer> goalAchievedCount = new HashMap<>(); //Map to keep track of what sub Attribute has Yes as goal.
        Map<String, Integer> subAttributeCount = new HashMap<>(); //Map to keep track of different types of sub Attributes & their repetition count
        for (int i = 1; i < att.size(); i++) {
            if (subAttributeCount.containsKey(att.get(i))) {
                subAttributeCount.put(att.get(i), subAttributeCount.get(att.get(i)) + 1);
            }
            else {
                subAttributeCount.put(att.get(i), 1);
                goalAchievedCount.put(att.get(i), 0);
            }

            if (WillWait.get(i).equals("Yes")) {
                goalAchievedCount.put(att.get(i), goalAchievedCount.get(att.get(i)) + 1);
            }
        } //for-loop end

        ArrayList<Double> subAttEntropy = new ArrayList<>();
        ArrayList<Integer> subAttCountList = new ArrayList<>();
        double value = 0.0;
        int totalRep = 0;
        int success = 0;
        int failure = 0;

        /*TODO: Calculate Sub Attribute Entropy's*/
        for (Map.Entry<String, Integer> map : subAttributeCount.entrySet()){
            totalRep = map.getValue();
            success = goalAchievedCount.get(map.getKey());
            failure = totalRep - success;

            subAttEntropy.add(calculation(totalRep, success, failure));
            subAttCountList.add(map.getValue());
        }

        /*TODO: Calculate Attribute Gain*/
        int exampleCounts = att.size() - 1; // -1 becuase the 1st element of every attribute list is the title itself.
        double gain = 0.0;

        //        if(Objects.equals(att.get(0), "WillWait")){
        //
        //        }
        for(int i = 0; i < subAttEntropy.size(); i++) {

            gain += ( (double) subAttCountList.get(i) / (double) exampleCounts ) * (subAttEntropy.get(i)) ;
        }
            System.out.println(  att.get(0)+"  Gain: " + (1- gain));
            return 1 - gain;
    }

    private static Double calculation(int totalRep, int success, int failure) {
        double logYes, logNo, total;
        double yes =  ( (double) success/ (double) totalRep);
        logYes = Math.log(yes) == Double.NEGATIVE_INFINITY ? 0.0 : ((yes) * (Math.log(yes) / Math.log(2)));

        double no =  ( (double) failure/ (double) totalRep);
        logNo = Math.log(no) == Double.NEGATIVE_INFINITY ? 0.0 : ((no) * (Math.log(no) / Math.log(2)));

        total = 0 - logYes - logNo;
       return total;
    }
}
