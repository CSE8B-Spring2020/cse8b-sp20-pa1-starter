///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              (program's title)
// Files:              (list of source files)
// Quarter:            (course) Spring 2020
//
// Author:             (your name)
// Email:              (your email address)
// Instructor's Name:  (name of your instructor)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in CSE 8B syllabus)
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER
//                   4. complete this section for each program file.
//
// Pair Partner:        (name of your pair programming partner)
// Email:               (email address of your programming partner)
// Instructors's Name:  (name of your partner's instructor)
// Lab Section:         (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;

/**
 * An application that implements a simplified version of an encrypting and
 * decrypting machine called Enigma.
 *
 * <p>
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class Enigma {

    /** The number of letters printed on each rotor. */
    public static final int ROTOR_LENGTH = 26;

    /**
     * Main method contains the console output and reads the user input for
     * this program.
     * 
     * @param String[] args - command line arguments that are unused
     * @return void
     */
    public static void main(String[] args) {
        /**
         * The cipher strings for each rotor. They store the letter-order for
         * each rotor. The rotor at index 0 is the identity rotor. The identity
         * rotor will be useful for debugging.
         *
         * The remaining cipher strings correspond to: Rotor 1, Rotor 2, etc.
         */
        String[] rotors = {
                // Identity Rotor (index 0 - and useful for testing):
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                // Standard Rotors 1 through 8:
                "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
                "AJDKSIRUXBLHWTMCQGZNPYFVOE",
                "BDFHJLCPRTXVZNYEIWGAKMUSQO",
                "ESOVPZJAYQUIRHXLNFTGKDCMWB",
                "VZBRGITYUPSDNHLXAWMJQOFECK",
                "JPGVOUMFYQBENHZRDKASXLICTW",
                "NZJHGRCXMYSWBOUFAIVLPEKQDT",
                "FKQHTLXOCBJSPDZRAMEWNIUYGV"};

        // creates 2D char array representation of rotors
        char[][] rotor2dArray = createRotor2dArray(rotors);

        Scanner in = new Scanner(System.in);

        // parses user input of encryption or decryption
        System.out.print("Enter (1) for encryption; (2) for decryption: ");
        String optionStr = in.nextLine();
        int option = Integer.parseInt(optionStr);

        // parses user input of rotors to be used
        System.out.print("Enter the rotors to be used: ");
        String rotorsToUse = in.nextLine();
        char[][] rotorsSelected = selectRotors(rotor2dArray, rotorsToUse);

        // parses user input of number of rotations
        System.out.print("Enter the number of rotations: ");
        String numRotations = in.nextLine();
        char[][] rotorsRotated = rotateRotors(rotorsSelected, numRotations);

        // parses the message to be encrypted/decrypted and prints out the
        // encrypted/decrypted message
        String inputText = null;
        String outputText = null;
        if (option == 1) {
            System.out.print("Enter the text to be encrypted: ");
            inputText = in.nextLine();
            outputText = encryptMessage(rotorsRotated, inputText);
            System.out.print("Encrpyted text: " + outputText);
        } else if (option == 2) {
            System.out.print("Enter the text to be decrypted: ");
            inputText = in.nextLine();
            outputText = decryptMessage(rotorsRotated, inputText);
            System.out.print("Decrpyted text: " + outputText);
        } else {
            System.out.println("Invalid option!");
            return;
        }
    }

    /**
     * This method takes as a parameter a 1D array of Strings where each String
     * represents a rotor. This method builds a 2D array of characters from the
     * Strings.
     *
     * For now it returns null.
     *
     * @param rotors (1D array of String rotors)
     * @return 2D char array representation of rotors
     */
    public static char[][] createRotor2dArray(String[] rotors) {
        return null;
    }

    /**
     * This method selects the rotors that the user wants to use and returns
     * them in a 2D array in order of the selection.
     *
     * For now it returns null.
     *
     * @param rotor2dArray 2D char array representation of rotors
     * @param rotorsToUse  indices of rotors the user wants to use
     * @return 2D char array representation of rotors that the user
     *  wants to use
     */
    public static char[][] selectRotors(char[][] rotor2dArray,
                                        String rotorsToUse) {
        return null;
    }

    /**
     * This method accepts as parameters the number of rotations to be done on
     * the 2D array of chars that represents the rotor configurations.
     * It should perform those many rotations on the 2D array of rotors.
     *
     * For now it returns the original 2D array passed to it.
     *
     * @param numRotations   (number of rotations to be done)
     * @param rotorsSelected (selected rotor configurations to use)
     * @return rotated 2D array of rotor configurations
     */
    public static char[][] rotateRotors(char[][] rotorsSelected,
                                        String numRotations) {
        return rotorsSelected;
    }

    /**
     * This method takes as parameters a String inputText to be encrypted and a
     * 2D array of rotated rotors. It encrypts the inputText using the rotated
     * rotors and should return the encrypted message.
     *
     * For now it returns the original message.
     *
     * @param inputText     (message to be encrypted)
     * @param rotorsRotated (2D array of rotated rotors)
     * @return encrypted message
     */
    public static String encryptMessage(char[][] rotorsRotated,
                                        String inputText) {
        return inputText;
    }

    /**
     * This method takes as parameters a String inputText to be decrypted and a
     * 2D array of rotated rotors. It decrypts the inputText using the rotated
     * rotors and should return the decrypted message.
     *
     * For now it returns the original message.
     *
     * @param inputText     (message to be decrypted)
     * @param rotorsRotated (2D array of rotated rotors)
     * @return decrypted message
     */
    public static String decryptMessage(char[][] rotorsRotated,
                                        String inputText) {
        return inputText;
    }
}
