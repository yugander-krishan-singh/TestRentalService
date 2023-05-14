package org.com;

import java.util.Scanner;

import org.com.inputManager.InputManager;

public class mainApp {
    private static String getOptions() {
        StringBuilder build = new StringBuilder();
        String input = "Choose you options \n";
        build.append(input);

        input = "1. add branch \n";
        build.append(input);

        input = "2. allocate price \n";
        build.append(input);

        input = "3. add vehicle \n";
        build.append(input);

        input = "4. book vehicle \n";
        build.append(input);

        input = "5. Exit";
        build.append(input);

        return build.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to rental service. Please choose your options below. U only need to enter a number");
        while(true) {
            try {
                System.out.println(getOptions());

                int userInput = input.nextInt();
                if (userInput == 5) {
                    break;
                } else if (userInput == 1) {
                    InputManager.handleAddBranch();
                } else if (userInput == 2) {
                    InputManager.handleAllocatePrice();
                } else if (userInput == 3) {
                    InputManager.handleAddVehicle();
                } else if (userInput == 4) {
                    InputManager.handleBookVehicle();
                } else {
                    System.out.println("Please choose among the give options by entering number between 1 to 5 \n");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
