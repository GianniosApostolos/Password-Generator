package org.domain;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {


    int passwordLength;

    String potentialPasswordCharacters;
    List<String> excludedCharacters = new ArrayList<>();

    SecureRandom secureRandom = new SecureRandom();
    StringBuilder myPassword;


    public PasswordGenerator(int passwordLength,List<String> excludedCharacters,PasswordTypes passwordType)
    {
        this.passwordLength=passwordLength;
        this.excludedCharacters =excludedCharacters;
        CreatePasswordCharacters(passwordType);
    }

    private void CreatePasswordCharacters(PasswordTypes passwordType)
    {

        switch (passwordType)
        {
            case DIGITS:
                this.potentialPasswordCharacters = "1234567890";
                break;

            case CHARACTERS:
                this.potentialPasswordCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;

            case CHARACTERS_SMALL:
                this.potentialPasswordCharacters = "abcdefghijklmnopqrstuvwxyz";
                break;

                case CHARACTERS_CAPITAL:
                this.potentialPasswordCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;

            case SYMBOLS:
                this.potentialPasswordCharacters = "!@#$%^&*-+(){}/|<>?";
                break;

                case ALL:
                default:
                    this.potentialPasswordCharacters = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*-+(){}/|<>?";
                    break;

        }
    }

    public String GeneratePassword()
    {
        myPassword= new StringBuilder(passwordLength);
        int index;
        char chosenChar;
        for(int i=0;i<passwordLength;i++)
        {
            index=secureRandom.nextInt(0,potentialPasswordCharacters.length());
            chosenChar = potentialPasswordCharacters.charAt(index);
            if(excludedCharacters.contains(Character.toString(chosenChar)))
                i--;
            else
                myPassword.append(chosenChar);
        }

        return myPassword.toString();
    }


}
