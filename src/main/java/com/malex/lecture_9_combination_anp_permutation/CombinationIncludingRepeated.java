package com.malex.lecture_9_combination_anp_permutation;

import java.util.Objects;

public class CombinationIncludingRepeated {

    private static final String ERROR_MSG_ELEMENT_NOT_FOUND = "Element - '%s' not fount in sequence !";

    private static final String[] sequence;

    /*
     * Fill in the sequence with base characters  A to Z
     */
    static {
        char first = 'A';
        char last = 'Z' + 1;
        sequence = new String[last - first];
        char temp = first;
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = String.valueOf(temp);
            temp++;
        }
    }

    /**
     * https://stackoverflow.com/questions/5113707/getting-every-possible-permutation-of-a-string-or-combination-including-repeated
     */
    public static void main(String[] args) {
        // 1. find position by letters
        System.out.println("Element - AAA, position - " + str2int("AAA"));
        System.out.println("Element - AA, position - " + str2int("AA"));
        System.out.println("Element - A, position - " + str2int("A"));

        System.out.println("Element - ZZZ, position - " + str2int("ZZZ"));
        System.out.println("Element - ZZ, position - " + str2int("ZZ"));
        System.out.println("Element - Z, position - " + str2int("Z"));

        // 2. find letters by position
        System.out.println("Position - 1, element - " + int2str(1));
        System.out.println("Position - 2, element - " + int2str(2));
        System.out.println("Position - 26, element - " + int2str(26));
        System.out.println("Position - 27, element - " + int2str(27));
        System.out.println("Position - 28, element - " + int2str(28));

        // 3. right column
        System.out.println("Element - A, right column - " + rightColumn("A"));
        System.out.println("Element - AA, right column - " + rightColumn("AA"));
        System.out.println("Element - ZZ, right column - " + rightColumn("ZZ"));
        System.out.println("Element - AAA, right column - " + rightColumn("AAA"));
    }


    /**
     * using the column letter number, write a method of defining the number of the column that is placed on the right side of the given one.
     * Example: A => B; B => C; ...; Y => Z; Z => AA; AA => AB; …
     */
    public static String rightColumn(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("Invalid input String number, please enter correct alphabet value");
        }
        // find count of group
        int group = searchNumberGroupByChars(number);
        // marker
        boolean isNumberFound = false;
        for (int i = 1; i <= group + 1; i++) {
            for (String num : generateNewSequence(sequence, i)) {
                if (isNumberFound) {
                    return num;
                }
                if (num.equalsIgnoreCase(number)) {
                    isNumberFound = true;
                }
            }
        }
        throw new IllegalArgumentException(String.format(ERROR_MSG_ELEMENT_NOT_FOUND, number));
    }

    /**
     * method of defining the column sequence number by its letter number
     * Example:  A => 1; B => 2; ...; Z => 26; AA => 27; AB => 28; ...
     */
    public static int str2int(String number) {
        if (Objects.isNull(number) || number.isEmpty()) {
            throw new IllegalArgumentException("Invalid input String number, please enter correct alphabet value");
        }
        // find count of group
        int group = searchNumberGroupByChars(number);
        // counter
        int count = 1;
        for (int i = 1; i <= group; i++) {
            for (String num : generateNewSequence(sequence, i)) {
                if (num.equalsIgnoreCase(number)) {
                    return count;
                }
                count++;
            }
        }
        throw new IllegalArgumentException(String.format(ERROR_MSG_ELEMENT_NOT_FOUND, number));
    }


    /**
     * Method of defining the column letter number by its sequence number
     * Example: : 1 => A; 2 => B; ...; 26 => Z; 27 ==> AA; 28 ==> AB; ... ;
     */
    public static String int2str(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("Invalid input number, please enter value greater than zero");
        }
        // find count of group
        int group = searchNumberGroupByNumber(number);
        // counter
        int count = 1;
        for (int i = 1; i <= group; i++) {
            for (String num : generateNewSequence(sequence, i)) {
                if (count == number) {
                    return num;
                }
                count++;
            }
        }
        throw new IllegalArgumentException(String.format(ERROR_MSG_ELEMENT_NOT_FOUND, number));
    }

    /**
     * Search number of group by characters
     * Example:
     * group number = 1 if A....Z
     * group number = 2 if AA .... ZZ
     * group number = 3 if AAA .... ZZZ
     */
    private static int searchNumberGroupByChars(String characters) {
        return characters.length();
    }

    /**
     * Search number of group by number
     * Example:
     * group number = 1 if A....Z (1 ... 26)
     * group number = 2 if AA .... ZZ (27 ... 702)
     * group number = 3 if AAA .... ZZZ (703 ... )
     */
    private static int searchNumberGroupByNumber(int number) {
        int length = sequence.length;
        int remainder = number % length;
        int division = number / length;
        if (remainder == 0) {
            return division;
        }
        return (remainder == 1 || division == 0 || remainder > division || remainder == division - 1)
                ? division + 1
                : remainder + 1;
    }

    /**
     * Generate new Sequence
     * Step 1: initialize our returned list with the number of elements calculated above
     * Step 2: check that lists of length 1 are just the original elements
     * Step 3: //the recursion--get all lists of length 3, length 2, all the way up to 1
     * Step 4: //append the sub lists to each element
     * sTEP 5: add the newly appended combination to the list
     */
    public static String[] generateNewSequence(String[] elements, int lengthOfList) {
        String[] allLists = new String[(int) Math.pow(elements.length, lengthOfList)];
        if (lengthOfList == 1) {
            return elements;
        } else {
            String[] subList = generateNewSequence(elements, lengthOfList - 1);
            int arrayIndex = 0;
            for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < subList.length; j++) {
                    allLists[arrayIndex] = elements[i] + subList[j];
                    arrayIndex++;
                }
            }
            return allLists;
        }
    }
}