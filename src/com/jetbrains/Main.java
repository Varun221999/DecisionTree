package com.jetbrains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        //TODO: add return statements in cases itself.
        for(int i = 0; i <10; i++ ){
            switch (i) {
                case 0:
                     attribute_entropy(Alt); break;
                case 1:
                    attribute_entropy(Bar); break;
                case 2:
                    attribute_entropy(Fri); break;
                case 3:
                    attribute_entropy(Hun); break;
                case 4:
                    attribute_entropy(Pat); break;
                case 5:
                    attribute_entropy(Price); break;
                case 6:
                    attribute_entropy(Rain); break;
                case 7:
                    attribute_entropy(Res); break;
                case 8:
                    attribute_entropy(Type); break;
                case 9:
                    attribute_entropy(Est); break;
                default:
                    break;
            }
        }
        return 0.0;
    }
    static double attribute_entropy(ArrayList<String> att){
        Map<String,Integer> goalAchievedCount = new HashMap<String,Integer>();
        Map<String,Integer> subAttributeCount = new HashMap<String,Integer>();
        for(int i = 1; i < att.size(); i++){
          if(subAttributeCount.containsKey(att.get(i))){
              subAttributeCount.put(att.get(i),subAttributeCount.get(att.get(i)) + 1);
          }
          else {
              subAttributeCount.put(att.get(i), 1);
              goalAchievedCount.put(att.get(i), 0);
          }

          if(WillWait.get(i).equals("Yes")){
              goalAchievedCount.put(att.get(i),goalAchievedCount.get(att.get(i)) + 1);
          }
        }
        return 0.0;
    }
}
