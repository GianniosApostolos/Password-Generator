package org.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> excludedCharacters = new ArrayList<>();
        PasswordTypes passwordType = PasswordTypes.ALL;
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int passwordLength = 0;

        System.out.print("\n\n");
        System.out.println("Hello! Thanks for downloading my password generator program. Let's start!\n\n ");

        excludedCharacters = EditExcludedCharacters(); //populate the list by calling a function


        boolean invalidValue;
        do {
            System.out.println("Password length?");
            do {
                try {
                    userInput = scanner.nextLine();
                    passwordLength = Integer.parseInt(userInput);
                    if (passwordLength <= 0) {
                        System.out.println("Unsupported value. Enter a positive number value");
                        invalidValue = true;
                    } else
                        invalidValue = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("Unsupported value. Enter a positive number value");
                    invalidValue = true;
                }
            } while (invalidValue);


            PrintMenu();

            userInput = scanner.nextLine().toUpperCase();

            switch (userInput) {
                case "1":
                case "DIGITS":
                    passwordType = PasswordTypes.DIGITS;
                    break;
                case "2":
                case "CHARACTERS_ALL":
                    passwordType = PasswordTypes.CHARACTERS;
                    break;
                case "3":
                case "CHARACTERS_SMALL":
                    passwordType = PasswordTypes.CHARACTERS_SMALL;
                    break;
                case "4":
                case "CHARACTERS_CAPITAL":
                    passwordType = PasswordTypes.CHARACTERS_CAPITAL;
                    break;
                case "5":
                case "SYMBOLS":
                    passwordType = PasswordTypes.SYMBOLS;
                    break;
                case "6":
                case "ALL":
                    passwordType = PasswordTypes.ALL;
                    break;

                case "7":
                case "EDIT EXCLUDED CHARACTERS":
                    excludedCharacters = EditExcludedCharacters();
                    break;
                default:
                    passwordType = PasswordTypes.ALL;
                    break;
            }

            // Only print the password if the user hasn't terminated the application
            if (!userInput.equals("0") && !userInput.equals("EXIT") && !userInput.equals("EXIT APPLICATION")) {
                PasswordGenerator passwordGenerator = new PasswordGenerator(passwordLength, excludedCharacters, passwordType);
                System.out.println("Password -> " + passwordGenerator.GeneratePassword());

                System.out.println("Generate new password with the same parameters? Press 0 to cancel");
                String repeatPassword = scanner.nextLine();
                while (!repeatPassword.equals("0")) {
                    System.out.println("Password -> " + passwordGenerator.GeneratePassword());
                    repeatPassword = scanner.nextLine();
                }
            }

        } while (!userInput.equals("0") && !userInput.equals("EXIT") && !userInput.equals("EXIT APPLICATION"));

        System.out.print("Application terminated... ");


    }

    private static void PrintMenu() {
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("Password type:" + "                      |");
        System.out.println("1. DIGITS" + "                           |");
        System.out.println("2. CHARACTERS_ALL" + "                   |");
        System.out.println("3. CHARACTERS_SMALL" + "                 |");
        System.out.println("4. CHARACTERS_CAPITAL" + "               |");
        System.out.println("5. SYMBOLS" + "                          |");
        System.out.println("6. ALL" + "                              |");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("7. EDIT EXCLUDED CHARACTERS" + "         |");
        System.out.println("0. EXIT APPLICATION" + "                 |");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
    }

    private static List<String> EditExcludedCharacters() {
        List<String> excludedCharacters = new ArrayList<>();
        String userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter excluded characters. Separate by comma or spaces for clarity");
        userInput = scanner.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            char characterRead = userInput.charAt(i);
            if (characterRead != ',' && characterRead != ' ') {
                excludedCharacters.add(Character.toString(characterRead));
            }
        }

        return excludedCharacters;
    }

}