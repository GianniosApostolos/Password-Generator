# Password-Generator
Java console application designed as a proof of concept for another project. **(Created and tested on windows 10. Needs java-19 installed)**

Users can generate passwords from a list of available options.

It is possible to create a list of excluded characters which will not be selected when the password is created. For example, the user might exclude the characters " ilL1| " or "0Oo" because they look similar to each other. Only 1 group of characters can be excluded up to as many as you want. If you don't want to exclude any character then siply, press "enter" when the program asks you to

<details>
  <summary>Available options</summary>
  
  #### Options
  * Digits
  * All characters
  * Small characters
  * Capital characters
  * Symbols
  * All of the above
  
</details>

Updates will be done in the near future. The program does not support two or more options at this time

### How to use

#### Option 1:
There is a **_.bat_** file called "start_application.bat" at **_out/artifacts/Password_Generator_jar_**.  
It launches the .jar file containing the program. You may rename it however you want. In case you delete the file you can easily recreate it

<details>
  <summary> How to recreate the file </summary>
  
  ##### Steps
  1. Find the directory of "Password_Generator.jar"  
  2. Create a new document with the extension of **_.bat_**. You may name it however you want  
  3. Edit the **_.bat_** file and type -> java -jar Password_Generator.jar  
  4. Click on the **_.bat_** file and launch the application  
</details>

#### Option 2:
You may also launch the application through windows cmd.

1. Find the directory of "Password_Generator.jar"
2. Open cmd at the same directory
3. Type java -jar Password_Generator.jar and it will launch the application

I recommend following option 1 for easier access.




