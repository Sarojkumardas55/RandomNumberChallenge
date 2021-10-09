package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.io.FileReader;

public interface RandomNumber {

    int showNumber();

}
 class RandomNumberFinder implements RandomNumber{
    @Override
    public int showNumber() {
        // creating an object of Random class
        Random random = new Random();

        return random.nextInt(10);
        //System.out.println("Randomly Generated Integers Values = "+x);


    }
}
 class InputInteger implements RandomNumber{
    @Override
    public int showNumber() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter input number");
        int num= scanner.nextInt();
        System.out.println("Input number is= "+num);
        return num;

    }
}
 class FactoryCheakNumber {

     RandomNumberFinder randomNumberFinder = new RandomNumberFinder();
     InputInteger inputInteger = new InputInteger();
     FileHandle fileHandle=new FileHandle();

     public int showNumber() {

         int inputNumber = inputInteger.showNumber();


         int number = randomNumberFinder.showNumber();
         while (number != inputNumber) {


             if (number < inputNumber) {
                 System.out.println(" Too High , try again");
             } else {
                 System.out.println(" Too Low , try again");
             }
             inputNumber = inputInteger.showNumber();
         }

             System.out.println("Random number is equql to input number");


         fileHandle.createNewFile();
         fileHandle.writeFile(number);
         fileHandle.readFile();
         return 0;
     }
 }
 class FileHandle {

     public void createNewFile() {

         try {
             File file = new File("filename.txt");
             if (file.createNewFile()) {
                 System.out.println("File created: " + file.getName());
             } else {
                 System.out.println("File already exists.");
             }
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }

     }
     public void writeFile(int num){
         //int number=factoryCheakNumber.showNumber();

         try {
             FileWriter myWriter = new FileWriter("filename.txt");
             myWriter.write("Guessed random number = "+ num);
             myWriter.close();
             System.out.println("Successfully wrote to the file.");
         } catch (IOException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
     }
     public void readFile() {
         try {
             FileReader fileReader = new FileReader("filename.txt");
             Scanner scanner=new Scanner(fileReader);
             while (scanner.hasNextLine()){
                 String data=scanner.nextLine();
                 System.out.println(data);

             }

         }
         catch (IOException e){
             System.out.println("An error occoured");
             e.printStackTrace();
         }

     }
 }