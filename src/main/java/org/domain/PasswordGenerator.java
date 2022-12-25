package org.domain;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class PasswordGenerator {


    int passwordLength;

    String potentialPasswordCharacters;
    Set<String> excludedCharacters = new HashSet<>();

    SecureRandom secureRandom = new SecureRandom();
    StringBuilder myPassword;


    public PasswordGenerator(int passwordLength, Set<String> excludedCharacters, PasswordTypes passwordType) {
        this.passwordLength = passwordLength;
        this.excludedCharacters = excludedCharacters;
        CreatePasswordCharacters(passwordType);
    }

    private void CreatePasswordCharacters(PasswordTypes passwordType) {

        switch (passwordType) {
            case DIGITS:
                this.potentialPasswordCharacters = "1234567890";
                break;

            case CHARACTERS:
                this.potentialPasswordCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;

            case CHARACTERS_LOWERCASE:
                this.potentialPasswordCharacters = "abcdefghijklmnopqrstuvwxyz";
                break;

            case CHARACTERS_UPPERCASE:
                this.potentialPasswordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;

            case SYMBOLS:
                this.potentialPasswordCharacters = "!@#$%^&*-+(){}/|<>?,.";
                break;

            case ALL:
            default:
                this.potentialPasswordCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*-+(){}/|<>?,.";
                break;

        }
    }

    public String GeneratePassword() {

        if (IsPasswordGeneratable(excludedCharacters, potentialPasswordCharacters)) {


            myPassword = new StringBuilder(passwordLength);
            int index;
            char chosenChar;
            for (int i = 0; i < passwordLength; i++) {
                index = secureRandom.nextInt(0, potentialPasswordCharacters.length());
                chosenChar = potentialPasswordCharacters.charAt(index);
                if (excludedCharacters.contains(Character.toString(chosenChar)))
                    i--;
                else
                    myPassword.append(chosenChar);
            }

            return myPassword.toString();
        } else
            return "Cannot generate a password where all available characters are excluded.\nConsider modifying the excluded characters list and try again.\n";
    }


    // Check if the password can be created based on the given Excluded characters Set and the total available characters that the password can have
    // For example. A password with the excluded characters {1,2,3,4,5,6,7,8,9,0} and DIGITS type can't be generated because there are no available characters
    public boolean IsPasswordGeneratable(Set<String> excludedCharacters, String potentialPasswordCharacters) {
        boolean canBeGenerated = true;

        if (potentialPasswordCharacters.length() > excludedCharacters.size())
            return true;

        for (int i = 0; i < potentialPasswordCharacters.length(); i++) {
            if (!excludedCharacters.contains(Character.toString(potentialPasswordCharacters.charAt(i))))
                return true;
        }

        return false;
    }


}
