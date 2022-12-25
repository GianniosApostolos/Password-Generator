package org.domain;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<String> excludedCharacters = new HashSet<>();
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
                case "CHARACTERS_LOWERCASE":
                    passwordType = PasswordTypes.CHARACTERS_LOWERCASE;
                    break;
                case "4":
                case "CHARACTERS_UPPERCASE":
                    passwordType = PasswordTypes.CHARACTERS_UPPERCASE;
                    break;
                case "5":
                case "SYMBOLS":
                    passwordType = PasswordTypes.SYMBOLS;
                    break;
                case "6":
                case "ALL":
                default:
                    passwordType = PasswordTypes.ALL;
                    break;

                case "7":
                case "EDIT EXCLUDED CHARACTERS":
                    excludedCharacters = EditExcludedCharacters();
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
        System.out.println("3. CHARACTERS_LOWERCASE" + "             |");
        System.out.println("4. CHARACTERS_UPPERCASE" + "             |");
        System.out.println("5. SYMBOLS" + "                          |");
        System.out.println("6. ALL" + "                              |");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
        System.out.println("7. EDIT EXCLUDED CHARACTERS" + "         |");
        System.out.println("0. EXIT APPLICATION" + "                 |");
        System.out.println("- - - - - - - - - - - - - - - - - - -");
    }

    private static Set<String> EditExcludedCharacters() {
        Set<String> excludedCharacters = new HashSet<>();
        String userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter excluded characters. Separate by spaces for clarity");
        userInput = scanner.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            char characterRead = userInput.charAt(i);
            if (characterRead != ' ') {
                excludedCharacters.add(Character.toString(characterRead));
            }
        }

        return excludedCharacters;
    }

}