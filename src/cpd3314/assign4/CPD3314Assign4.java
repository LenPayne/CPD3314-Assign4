/*
 * Copyright 2014 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* The following exercises are adapted from:
 * Gaddis, T. (2013). Starting Out with Java: From Control Structures through 
 * Objects. (5th ed.). Upper Saddle River, NJ: Pearson Education.
 * ISBN: 978-0-13-285583-9
 */
package cpd3314.assign4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Len Payne <len.payne@lambtoncollege.ca>
 */
public class CPD3314Assign4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] questions = {
            "1. Sum of Numbers",
            "2. Distance Traveled File",
            "3. Largest and Smallest",
            "4. Celsius and Fahrenheit Table",
            "5. Line Numbers"
        };
        int choice = 0;
        do {
            for (String q : questions) {
                System.out.println(q);
            }
            System.out.print("Which Exercise Do You Want to View? (0 to quit): ");
            try {
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        doExercise1();
                        break;
                    case 2:
                        doExercise2();
                        break;
                    case 3:
                        doExercise3();
                        break;
                    case 4:
                        doExercise4();
                        break;
                    case 5:
                        doExercise5();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Not a valid choice.");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("That is not a valid choice.");
            }
        } while (choice != 0);
    }

    /*
     * Exercise #1 - Sum of Even Numbers
     *
     * Write a program that asks the user for a positive nonzero integer 
     * value. The program should use a loop to get the sum of all the even
     * integers from 0 up to the number entered. For example, if the user 
     * enters 30, the loop will find the sum of 2, 4, 6, ... 30.
     *
     * Sample Output:
     * ==============
     * 
     *   Enter a positive, nonzero integer value:
     *   30
     *   The sum of all even integers up to 30 is 240.
     */
    public static void doExercise1() {
        // TODO: Complete Exercise 1 Below

    }

    /*
     * Exercise #2 - Distance Traveled File
     * 
     * The distance a vehicle travels can be calculated as follows:
     *     Distance = Speed * Time
     * For example, if a train travels 40 miles-per-hour for three hours, the 
     * distance traveled is 120 miles. Write a program that asks for the speed 
     * of a vehicle (in miles-per-hour) and the number of hours it has traveled. 
     * It should use a loop to display the distance a vehicle has traveled for 
     * each hour of a time period specified by the user. For example, if a 
     * vehicle is traveling at 40mph for a three-hour time period, it should 
     * output a report similar to the one that follows to a file named 
     * "ex3output.txt":
     * 
     * ex3output.txt:
     * ==============
     *   Hour    Distance Traveled
     *   -------------------------
     *   1               40
     *   2               80
     *   3              120
     * 
     * Input Validation: Do not accept a negative number for speed and do not 
     * accept any value less than 1 for time traveled.
     */
    public static void doExercise2() {
        // TODO: Complete Exercise 2 Below

    }

    /*
     * Exercise 3 - Largest and Smallest
     * 
     * Write a program with a loop that lets the user enter a series of 
     * integers. The user should enter -99 to signal the end of the series. 
     * After all the numbers have been entered, the program should display the 
     * largest and smallest numbers entered.
     * 
     * To pass the unit tests, your final two lines of output must match the pattern:
     * Smallest number is x.
     * Largest number is y.
     *
     * Sample Output:
     * ==============
     *   Enter an integer (-99 to quit):
     *   4
     *   Enter an integer (-99 to quit):
     *   5
     *   Enter an integer (-99 to quit):
     *   7
     *   Enter an integer (-99 to quit):
     *   3
     *   Enter an integer (-99 to quit):
     *   -99
     *   Smallest number is 3.
     *   Largest number is 7.
     */
    public static void doExercise3() {
        // TODO: Complete Exercise 3 Below

    }

    /*
     * Exercise 4 - Temperature Table
     * 
     * Write a program that displays a table of the Celsius temperatures 0 
     * through 100 and their Fahrenheit and Kelvin equivalents. The formula for 
     * converting a temperature from Celsius to Fahrenheit is:
     *     F = (9.0/5.0) * C + 32
     * To convert from Celsius to Kelvin us:
     *     K = C + 273.15
     * Your program must use a loop to display the table.
     * Round your answers to one decimal place.
     * 
     * Sample Output:
     * ==============
     *   C        F         K
     *   --------------------------
     *   0.0      32.0      273.2
     *   .        .         .
     *   .        .         .
     *   .        .         .
     *   20.0     68.0      293.2
     *   .        .         .
     *   .        .         .
     *   .        .         .
     *   100.0    212.0     373.2
     */
    public static void doExercise4() {
        // TODO: Complete Exercise 4 Below

    }

    /*
     * Exercise 5 - Line Numbers
     * 
     * Write a program that asks the user for the name of a file. The program 
     * should display the contents of the file with each line preceded with a 
     * line number followed by a colon. The line numbering should start at 1.
     * 
     * Sample Output:
     * ==============
     *   What file do you want to read?
     *   shakespeare.txt
     * 
     *   1: Not marble, nor the gilded monuments
     *   2: Of princes shall outlive this powerful rhyme,
     *   3: But you shall shine more bright in these contents
     *   ...
     */
    public static void doExercise5() {
        // TODO: Complete Exercise 5 Below

    }
}
