///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
//
/////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
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
     * @param String[] args - command line arguments that are unused
     * @return void
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java EnigmaTester <MethodToTest>");
            return;
        }
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

    public static void testCreateRotor2dArray() {

        System.out.println("Testing createRotor2dArray...");
        String[] rotors = {
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "EKMFLGDQVZNTOWYHXUSPAIBRCJ",
        };
        char[][] expectedRotor2dArray = {{'A', 'B', 'C', 'D', 'E', 'F', 'G',
                                          'H', 'I', 'J', 'K', 'L', 'M', 'N',
                                          'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                                          'V', 'W', 'X', 'Y', 'Z'},
                                         {'E', 'K', 'M', 'F', 'L', 'G', 'D',
                                          'Q', 'V', 'Z', 'N', 'T', 'O', 'W',
                                          'Y', 'H', 'X', 'U', 'S', 'P', 'A',
                                          'I', 'B', 'R', 'C', 'J'}};
        char[][] actualRotor2dArray = Enigma.createRotor2dArray(rotors);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedRotor2dArray));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualRotor2dArray));

        if (actualRotor2dArray == null) {
            System.out.println("Test Failed: actualRotor2dArray is null.");
            return;
        }

        if (expectedRotor2dArray.length != actualRotor2dArray.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }
        for (int i = 0; i < expectedRotor2dArray.length; i++) {
            if (expectedRotor2dArray[i].length
                    != actualRotor2dArray[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }

        for (int i = 0; i < expectedRotor2dArray.length; i++) {
            for (int j = 0; j < expectedRotor2dArray[i].length; j++) {
                if (expectedRotor2dArray[i][j] != actualRotor2dArray[i][j]) {
                    System.out.println(
                            "Test Failed: array elements don't match");
                    return;
                }
            }
        }
        System.out.println("Test Passed!");
    }

    public static void testSelectRotors() {

        System.out.println("Testing selectRotors...");

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

        char[][] actualSelectedRotors =
                Enigma.selectRotors(rotor2dArray, rotorsToUse);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedSelectedRotors));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualSelectedRotors));

        if (actualSelectedRotors == null) {
            System.out.println("Test Failed: actualSelectedRotors is null.");
            return;
        }
        if (expectedSelectedRotors.length != actualSelectedRotors.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }
        for (int i = 0; i < expectedSelectedRotors.length; i++) {
            if (expectedSelectedRotors[i].length
                    != actualSelectedRotors[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }

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
        System.out.println("Test Passed!");
    }

    public static void testRotateRotors() {

        System.out.println("Testing rotateRotors...");

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

        char[][] actualRotatedRotors =
                Enigma.rotateRotors(rotorsSelected, numRotations);
        System.out.println(
                "Expected: " + Arrays.deepToString(expectedRotatedRotors));
        System.out.println(
                "Actual: " + Arrays.deepToString(actualRotatedRotors));

        if (actualRotatedRotors == null) {
            System.out.println("Test Failed: actualRotatedRotors is null.");
            return;
        }
        if (expectedRotatedRotors.length != actualRotatedRotors.length) {
            System.out.println("Test Failed: # rows in arrays don't match.");
            return;
        }
        for (int i = 0; i < expectedRotatedRotors.length; i++) {
            if (expectedRotatedRotors[i].length
                    != actualRotatedRotors[i].length) {
                System.out.println(
                        "Test Failed: # columns in arrays don't match.");
                return;
            }
        }

        for (int i = 0; i < expectedRotatedRotors.length; i++) {
            for (int j = 0; j < expectedRotatedRotors[i].length; j++) {
                if (expectedRotatedRotors[i][j] != actualRotatedRotors[i][j]) {
                    System.out.println(
                            "Test Failed: array elements don't match");
                    return;
                }
            }
        }
        System.out.println("Test Passed!");
    }

    public static void testEncryptMessage() {
        System.out.println("Testing encryptMessage...");

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

        String expectedOutput = "SVVGD GJ CI WS!";

        String actualOutput = Enigma.encryptMessage(rotorsRotated, inputText);

        System.out.println("Expected: " + expectedOutput);
        System.out.println("Actual: " + actualOutput);

        if (actualOutput == null) {
            System.out.println("Test Failed: actualOutput is null.");
            return;
        }
        if (expectedOutput.length() != actualOutput.length()) {
            System.out.println(
                    "Test Failed: The length of the strings do not match.");
            return;
        }

        if(!expectedOutput.equals(actualOutput)) {
            System.out.println("Test Failed: The strings don't match.");
            return;
        }

        System.out.println("Test Passed!");
    }

    public static void testDecryptMessage() {
        //TODO: Define the test cases for the decryptMessage method
    }
}
