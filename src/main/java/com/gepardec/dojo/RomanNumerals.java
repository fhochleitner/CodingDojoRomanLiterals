package com.gepardec.dojo;

import java.util.stream.Stream;

public class RomanNumerals {

    public RomanNumerals() {
    }

    public int transformRomanToArab(String input) {

        if (null == input || input.isEmpty()) {
            return 0;
        }

        input = input.toUpperCase();
        char[] romanNumbers = input.toCharArray();
        int[] arabicNumbers = new int[romanNumbers.length];

        for (int i = 0; i < romanNumbers.length; i++) {
            arabicNumbers[i] = transformSingleRomanToArab(romanNumbers[i]);
        }


        int result = 0;
        for (int i = 0; i < romanNumbers.length; i++) {
            checkValidRomanNumber(romanNumbers, arabicNumbers, i);
            if (i < romanNumbers.length - 1 && arabicNumbers[i] < arabicNumbers[i + 1]) {
                result += arabicNumbers[i + 1] - arabicNumbers[i];
                i++;
            } else {
                result += arabicNumbers[i];
            }
        }
        return result;
    }

    private void checkValidRomanNumber(char[] romanNumbers, int[] arabicNumbers, final int index) {
        if (index < romanNumbers.length - 3) {
            if (romanNumbers[index] == romanNumbers[index + 1]
                    && romanNumbers[index] == romanNumbers[index + 2]
                    && romanNumbers[index] == romanNumbers[index + 3]) {
                throw new IllegalArgumentException("Cannot have 4 same characters in a row");
            }
        }

        if (index < romanNumbers.length - 2) {
            if (arabicNumbers[index] < arabicNumbers[index + 1]
                    && arabicNumbers[index + 1] < arabicNumbers[index + 2]) {
                throw new IllegalArgumentException("not valid");
            }
        }

        if (index < romanNumbers.length - 1) {
            if ((romanNumbers[index] == 'I' || romanNumbers[index] == 'V') && Stream.of('C', 'D', 'M', 'L').anyMatch(c -> c == romanNumbers[index + 1])) {
                throw new IllegalArgumentException("I cannot be followed by C, D, M or L");
            }
            if ((romanNumbers[index] == 'X' || romanNumbers[index] == 'L') && Stream.of('D', 'M').anyMatch(c -> c == romanNumbers[index + 1])) {
                throw new IllegalArgumentException("X cannot be followed by D or M");
            }
        }
    }

    public int transformSingleRomanToArab(char character) {
        switch (character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case ' ':
                return 0;
            default:
                throw new IllegalArgumentException("FAIL: " + character);
        }
    }

}
