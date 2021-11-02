import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Collections;

public class numberMachine {
    static Scanner strScan = new Scanner(System.in);
    static Scanner intScan = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int magicBall = 0;
        boolean contP = true;
        boolean skipQB = true;
        int qbJNum = 0;
        char petThree = 'c';
        char actOne = 'c';
        int petAgeAns = 0;
        int luckyAns = 0;
        int carModelAns = 0;
        int randAns = 0;
        boolean contI = true;
        boolean contU = true;
        boolean randomI = false;
        // prompt name
        System.out.println("Please enter your name: ");
        String uName = strScan.nextLine();
        System.out.println("");
        System.out.println("Hello " + uName + "!");
        // prompt user to skip interactive portion, 
        // skipping will generate random lottery number
        while (contI) {
            System.out.println("");
            System.out.println("Do you want to continue with the interactive portion?: ");
            System.out.println("Type yes or y to continue, no or n to skip,");
            String contAns = strScan.nextLine();
            char contYN = contAns.charAt(0);
            if (contYN == 'n') {
                contP = true;
                contI = false;
                contU = false;
                randomI = true;
            } else if (contYN == 'y') {
                contP = true;
                contI = true;
                contU = true;
                randomI = false;
            }
            // interactive portion loop
            while (contU) {
                System.out.println("");
                System.out.println("What is the name of your favorite pet (type no if none)?: ");
                String petAns = strScan.nextLine();
                if (petAns.equals("no") || petAns.length() < 4) {
                    petAns = "Garfield";
                    petThree = petAns.charAt(2);
                    petAgeAns = (int) (Math.random() * (65 - 1)) + 1;
                } else {
                    petThree = petAns.charAt(2);
                    System.out.println("");
                    System.out.println("What is the age of your favorite pet?: ");
                    System.out.println("(0 for less than 1 year, only input number!) ");
                    while (!intScan.hasNextInt()) {
                        System.out.println("That's not a number! Try again!");
                        intScan.nextLine();
                    }
                    petAgeAns = intScan.nextInt();
                }

                System.out.println("");
                System.out.println("What is your lucky number?: ");
                while (!intScan.hasNextInt()) {
                    System.out.println("That's not a number! Try again!");
                    intScan.next();
                }
                luckyAns = intScan.nextInt();

                System.out.println("");
                System.out.println("Enter the name of your favorite quarterback (type no if none): ");
                String qbAns = strScan.nextLine();
                if (qbAns.equals("no")) {
                    qbJNum = (int) (Math.random() * (65 - 1)) + 1;
                    skipQB = true;
                } else {
                    System.out.println("");
                    System.out.println("What is his/her jersey number?: ");
                    while (!intScan.hasNextInt()) {
                        System.out.println("That's not a number! Try again!");
                        intScan.next();
                    }
                    qbJNum = intScan.nextInt();
                }

                System.out.println("");
                System.out.println("Did you ever own a car? (type yes or no): ");
                String carValidate = strScan.nextLine();
                if (carValidate.equals("yes")) {
                    System.out.println("");
                    System.out.println("What is the two-digit model year of your first car?: ");
                    System.out.println("(type the last two digits of your car model year)");
                    while (!intScan.hasNextInt()) {
                        System.out.println("That's not a number! Try again!");
                        intScan.next();
                    }
                    carModelAns = intScan.nextInt();
                } else{
                    carModelAns = (int) (Math.random() * (65 - 1)) + 1;
                }

                System.out.println("");
                System.out.println("What is the first name of your favorite actor or actress? (type no if none): ");
                String actorAns = strScan.nextLine();
                actOne = actorAns.charAt(0);

                System.out.println("");
                System.out.println("Enter a random number between 1 and 50: ");
                while (!intScan.hasNextInt()) {
                    System.out.println("That's not a number! Try again!");
                    intScan.next();
                }
                randAns = intScan.nextInt();

                contP = true;
                contU = false;
            }
            // lottery number generator loop
            while (contP) {
                // Magic Ball Generator
                if (skipQB == true) {
                    magicBall = luckyAns;
                    if (magicBall > 75) {
                        magicBall -= 75;
                    }
                } else {
                    magicBall = qbJNum;
                    if (magicBall > 75) {
                        magicBall -= 75;
                    }
                }
                // Lottery Numbers
                int petNameC = petThree;
                num1 = petNameC;
                while (num1 > 65) {
                    num1 -= 65;
                }
                num2 = carModelAns + luckyAns;
                while (num2 > 65) {
                    num2 -= 65;
                }

                num3 = randAns - num1;
                while (num3 < 1) {
                    num3 += 42;
                }
                int actorC = actOne;
                num4 = actorC;
                while (num4 > 65) {
                    num4 -= 65;
                }

                num5 = qbJNum + petAgeAns + luckyAns;
                while (num5 > 65) {
                    num5 -= 65;
                }
                // random lottery generator for when user skips interactive portion
                if (randomI) {
                    num1 = (int) (Math.random() * (65 - 1)) + 1;
                    num2 = (int) (Math.random() * (65 - 1)) + 1;
                    num3 = (int) (Math.random() * (65 - 1)) + 1;
                    num4 = (int) (Math.random() * (65 - 1)) + 1;
                    num5 = (int) (Math.random() * (65 - 1)) + 1;
                    magicBall = (int) (Math.random() * (75 - 1)) + 1;
                }
                // create arraylists to easily sort and remove duplicates
                ArrayList<Integer> lotArray = new ArrayList<Integer>();
                ArrayList<Integer> lotArrayND = new ArrayList<Integer>();

                lotArray.add(num1);
                lotArray.add(num2);
                lotArray.add(num3);
                lotArray.add(num4);
                lotArray.add(num5);                
                ArrayList<Integer> lotArraySort = lotArray;
                // linkedhashsets removes duplicates while keeping order
                LinkedHashSet<Integer> removed = new LinkedHashSet<>(lotArray);
                for (Integer i : removed) {
                    lotArrayND.add(i);
                }
                //sorts the array using collections utility
                Collections.sort(lotArraySort);
                System.out.println("");
                System.out.println("Currently generating Lottery numbers for " + uName + "...");
                System.out.println("");
                //added pause to make it seem like computer is doing serious work (when it really isn't)
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                System.out.println("Lottery numbers: " + num1 + ", " + num2 + ", " + num3 + ", " + num4 + ", " + num5
                        + " Magic ball: " + magicBall);
                System.out.println("");   
                System.out.println("Lottery numbers without duplicates: " + lotArrayND);   
                System.out.println("");   
                System.out.println("Lottery numbers sorted: " + lotArraySort); 
                System.out.println("");  
                System.out.println("Do you want to generate again? (enter yes or no): ");
                String continueAns = strScan.nextLine();
                //responding yes will run the program all the way back to the first while loop
                if (continueAns.equals("yes")) {
                    contP = false;
                    contI = true;
                } else {
                    contP = false;
                    contI = false;
                }
            }
        }
        System.out.println("");
        System.out.println("Thank you for using the lottery game " + uName + "!");
        System.out.println("Hope you get lucky!");

        strScan.close();
        intScan.close();
    }
}
