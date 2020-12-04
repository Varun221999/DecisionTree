package com.jetbrains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner obj = new Scanner(System.in);
        ArrayList<String> Alt = new ArrayList<>(10);
        ArrayList<String> Bar = new ArrayList<>(10);
        ArrayList<String> Fri = new ArrayList<>(10);
        ArrayList<String> Hun = new ArrayList<>(10);
        ArrayList<String> Pat = new ArrayList<>(10);
        ArrayList<String> Price = new ArrayList<>(10);
        ArrayList<String> Rain = new ArrayList<>(10);
        ArrayList<String> Res = new ArrayList<>(10);
        ArrayList<String> Type = new ArrayList<>(10);
        ArrayList<String> Est = new ArrayList<>(10);
        ArrayList<String> WillWait = new ArrayList<>(10);

        /*File Parsing Try-Catch*/
        try {
            String fileName = "Resources/restaurant.csv";
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
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

    }
}
