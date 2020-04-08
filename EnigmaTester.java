///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Arrays;

/**
 * Tester file to test the functionality of the various methods
 * in the class Enigma
 *
 * <p>Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class EnigmaTester {

    /**
     * Main method containing the test cases for the Enigma class
     * @param String[] args - takes in 1 command line argument that represents
     * the method to test
     * @return void
     */
    public static void main(String[] args) {
        // print usage message if there isn't exactly 1 command line arg
        if (args.length != 1) {
            System.out.println("USAGE: java EnigmaTester <MethodToTest>");
            return;
        }

        // determine which test to run based on command line arg
        String testName = args[0];
        switch (testName) {
            case "createRotor2dArray":
                testCreateRotor2dArray();
                break;
            case "selectRotors":
                testSelectRotors();
                break;
            case "rotateRotors":
                testRotateRotors();
                break;
            case "encryptMessage":
                testEncryptMessage();
                break;
            case "decryptMessage":
                testDecryptMessage();
                break;
            default:
                System.out.println("Invalid <MethodToTest>.");
                break;
        }
    }

    /**
     * Method that tests createRotor2dArray
     *
     * @ return void
     */
    public static void testCreateRotor2dArray() {
        System.out.println("Testing createRotor2dArray...");

        // param to pass in
        String[] rotors = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
        };

        // The expected return
        char[][] expectedRotor2dArray = {{'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                          'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                          'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                                          'V', 'W', 'X', 'Y', 'Z'},
                                         {'E', 'K', 'M', 'F', 'L', 'G', 'D',
                                          'Q', 'V', 'Z', 'N', 'T', 'O', 'W',
                                          'Y', 'H', 'X', 'U', 'S', 'P', 'A',
                                          'I', 'B', 'R', 'C', 'J'}};
        // call createRotor2dArray and save the returning 2d array
        char[][] actualRotor2dArray = Enigma.createRotor2dArray(rotors);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedRotor2dArray));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualRotor2dArray));

        // test fails if method returns null
        if (actualRotor2dArray == null) {
            System.out.println("Test Failed: actualRotor2dArray is null.");
            return;
        }

        // compare number of rows
        if (expectedRotor2dArray.length != actualRotor2dArray.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }

        // compare number of columns
        for (int i = 0; i < expectedRotor2dArray.length; i++) {
            if (expectedRotor2dArray[i].length
            != actualRotor2dArray[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }

        // compare array elements
        for (int i = 0; i < expectedRotor2dArray.length; i++) {
            for (int j = 0; j < expectedRotor2dArray[i].length; j++) {
                if (expectedRotor2dArray[i][j] != actualRotor2dArray[i][j]) {
                    System.out.println(
                            "Test Failed: array elements don't match");
                    return;
                }
            }
        }
        // otherwise, test passes
        System.out.println("Test Passed!");
    }

    /**
     * Method that tests selectRotors
     *
     * @ return void
     */
    public static void testSelectRotors() {

        System.out.println("Testing selectRotors...");
        //parameters to test with
        char[][] rotor2dArray = {{'A', 'B', 'C', 'D', 'E', 'F',
                                  'G', 'H', 'I', 'J', 'K', 'L',
                                  'M', 'N', 'O', 'P', 'Q', 'R',
                                  'S', 'T', 'U', 'V', 'W', 'X',
                                  'Y', 'Z'},
                                 {'E', 'K', 'M', 'F', 'L', 'G',
                                  'D', 'Q', 'V', 'Z', 'N', 'T',
                                  'O', 'W', 'Y', 'H', 'X', 'U',
                                  'S', 'P', 'A', 'I', 'B', 'R',
                                  'C', 'J'},
                                 {'A', 'J', 'D', 'K', 'S', 'I',
                                  'R', 'U', 'X', 'B', 'L', 'H',
                                  'W', 'T', 'M', 'C', 'Q', 'G',
                                  'Z', 'N', 'P', 'Y', 'F', 'V',
                                  'O', 'E'},
                                 {'B', 'D', 'F', 'H', 'J', 'L',
                                  'C', 'P', 'R', 'T', 'X', 'V',
                                  'Z', 'N', 'Y', 'E', 'I', 'W',
                                  'G', 'A', 'K', 'M', 'U', 'S',
                                  'Q', 'O'}};

        String rotorsToUse = "2 1";
        // expected return
        char[][] expectedSelectedRotors = {{'A', 'J', 'D', 'K', 'S', 'I',
                                            'R', 'U', 'X', 'B', 'L', 'H',
                                            'W', 'T', 'M', 'C', 'Q', 'G',
                                            'Z', 'N', 'P', 'Y', 'F', 'V',
                                            'O', 'E'},
                                           {'E', 'K', 'M', 'F', 'L', 'G',
                                            'D', 'Q', 'V', 'Z', 'N', 'T',
                                            'O', 'W', 'Y', 'H', 'X', 'U',
                                            'S', 'P', 'A', 'I', 'B', 'R',
                                            'C', 'J'}};
        // call selectRotors with parameters and save return array
        char[][] actualSelectedRotors =
                Enigma.selectRotors(rotor2dArray, rotorsToUse);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedSelectedRotors));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualSelectedRotors));

        // test fails if returns null
        if (actualSelectedRotors == null) {
            System.out.println("Test Failed: actualSelectedRotors is null.");
            return;
        }
        // compare number of rows
        if (expectedSelectedRotors.length != actualSelectedRotors.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }
        // compare number of cols
        for (int i = 0; i < expectedSelectedRotors.length; i++) {
            if (expectedSelectedRotors[i].length
                    != actualSelectedRotors[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }
        // compare array elements
        for (int i = 0; i < expectedSelectedRotors.length; i++) {
            for (int j = 0; j < expectedSelectedRotors[i].length; j++) {
                if (expectedSelectedRotors[i][j]
                        != actualSelectedRotors[i][j]) {
                    System.out.println(
                            "Test Failed: array elements don't match");
                    return;
                }
            }
        }
        //otherwise test passes
        System.out.println("Test Passed!");
    }

    /**
     * Method that tests rotateRotors
     *
     * @ return void
     */
    public static void testRotateRotors() {

        System.out.println("Testing rotateRotors...");
        //parameters to pass into method
        char[][] rotorsSelected = {{'A', 'J', 'D', 'K', 'S', 'I',
                                    'R', 'U', 'X', 'B', 'L', 'H',
                                    'W', 'T', 'M', 'C', 'Q', 'G',
                                    'Z', 'N', 'P', 'Y', 'F', 'V',
                                    'O', 'E'},
                                   {'E', 'K', 'M', 'F', 'L', 'G',
                                    'D', 'Q', 'V', 'Z', 'N', 'T',
                                    'O', 'W', 'Y', 'H', 'X', 'U',
                                    'S', 'P', 'A', 'I', 'B', 'R',
                                    'C', 'J'}};
        String numRotations = "3";
        // expected return
        char[][] expectedRotatedRotors = {{'V', 'O', 'E', 'A', 'J',
                                           'D', 'K', 'S', 'I', 'R',
                                           'U', 'X', 'B', 'L', 'H',
                                           'W', 'T', 'M', 'C', 'Q',
                                           'G', 'Z', 'N', 'P', 'Y',
                                           'F'},
                                          {'R', 'C', 'J', 'E', 'K',
                                           'M', 'F', 'L', 'G', 'D',
                                           'Q', 'V', 'Z', 'N', 'T',
                                           'O', 'W', 'Y', 'H', 'X',
                                           'U', 'S', 'P', 'A', 'I',
                                           'B'}};
        // call rotateRotors with defined parameters and save return array
        char[][] actualRotatedRotors =
                Enigma.rotateRotors(rotorsSelected, numRotations);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedRotatedRotors));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualRotatedRotors));

        // test fails if method returns null
        if (actualRotatedRotors == null) {
            System.out.println("Test Failed: actualRotatedRotors is null.");
            return;
        }
        // compare number of rows
        if (expectedRotatedRotors.length != actualRotatedRotors.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }
        // compare number of columns
        for (int i = 0; i < expectedRotatedRotors.length; i++) {
            if (expectedRotatedRotors[i].length
                    != actualRotatedRotors[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }
        // compare array elements
        for (int i = 0; i < expectedRotatedRotors.length; i++) {
            for (int j = 0; j < expectedRotatedRotors[i].length; j++) {
                if (expectedRotatedRotors[i][j] != actualRotatedRotors[i][j]) {
                    System.out.println(
                            "Test Failed: array elements don't match");
                    return;
                }
            }
        }
        // otherwise, test passes
        System.out.println("Test Passed!");
    }

    /**
     * Method that tests encryptMessage
     *
     * @ return void
     */
    public static void testEncryptMessage() {
        System.out.println("Testing encryptMessage...");

        // parameters
        char[][] rotorsRotated = {{'V', 'O', 'E', 'A', 'J',
                                   'D', 'K', 'S', 'I', 'R',
                                   'U', 'X', 'B', 'L', 'H',
                                   'W', 'T', 'M', 'C', 'Q',
                                   'G', 'Z', 'N', 'P', 'Y',
                                   'F'},
                                  {'R', 'C', 'J', 'E', 'K',
                                   'M', 'F', 'L', 'G', 'D',
                                   'Q', 'V', 'Z', 'N', 'T',
                                   'O', 'W', 'Y', 'H', 'X',
                                   'U', 'S', 'P', 'A', 'I',
                                   'B'}};
        String inputText = "Annie is my TA!";
        // expected return
        String expectedOutput = "SVVGD GJ CI WS!";

        // call encryptMessage with defined parameters
        // and save encrypted message
        String actualOutput = Enigma.encryptMessage(rotorsRotated, inputText);
        System.out.println("Expected: " + expectedOutput);
        System.out.println("Actual: " + actualOutput);

        // test fails if message is null
        if (actualOutput == null) {
            System.out.println("Test Failed: actualOutput is null.");
            return;
        }
        // compare length of strings
        if (expectedOutput.length() != actualOutput.length()) {
            System.out.println(
                    "Test Failed: The length of the strings do not match.");
            return;
        }

        // compare String characters
        if(!expectedOutput.equals(actualOutput)) {
            System.out.println("Test Failed: The strings don't match.");
            return;
        }
        // otherwise, test passes
        System.out.println("Test Passed!");
    }

    public static void testDecryptMessage() {
        //TODO: Define the test cases for the decryptMessage method
    }
}
