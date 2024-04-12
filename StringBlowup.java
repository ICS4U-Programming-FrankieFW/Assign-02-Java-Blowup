import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StringBlowup {
    public static void main(String[] args) {
        //This checks if it is not the length of 2
        if (args.length != 2) {
            //This prints to the terminal letting you know it printed to the file
            System.out.println("Usage: java StringBlowup input_file output_file");
            //This returns the input
            return;
        }
        //This is where I initialize my inputfile
        String inputFile = args[0];
        //This is where I initialize my outputfile
        String outputFile = args[1];

        try {
            //This makes a buffered reader to read the input file
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            //This is the buffered writer which writes into the output file 
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            //This is the string line used for a string in a line 
            String line;
            //The while loop that checks if the line reader doesn't equal null
            while ((line = reader.readLine()) != null) {
                //String result shows the the line will be blown up
                String result = BlowUp(line);
                //The writer writes the result 
                writer.write(result);
                //This writer creates a new line
                writer.newLine();
            }
            //This closes the reader 
            reader.close();
            //This close the writer
            writer.close();
            //This let's the user know that the output has been written to an outputfile
            System.out.println("Output has been written to " + outputFile);
        } //This is the catch that catches any errors  
        catch (IOException e) {
            //This prints if there was an error reading or writing to the file
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
    //This is the function for String blowup
    public static String BlowUp(String str) {
        StringBuilder result = new StringBuilder();
        //This is the for loop that checks the String length
        for (int i = 0; i < str.length(); i++) {
            //This checks and returns the character  
            char currentChar = str.charAt(i);
            //This is the if statement for the if the character is digit
            if (Character.isDigit(currentChar)) {
                //This if statement checks the length and the letter
                if (i + 1 < str.length() && Character.isLetter(str.charAt(i + 1))) {
                   //This checks for the value and repeating it if there is a character
                   int repeatCount = Character.getNumericValue(currentChar);
                    //Thi starts the next character 
                    char nextChar = str.charAt(i + 1);
                    //The for loop which is used to repeat the count if there is a number next to it 
                    for (int j = 0; j < repeatCount; j++) {
                        result.append(nextChar);
                    }
                    i++; 
                }
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
