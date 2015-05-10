package task_11_lastIndexOf;

/**
 Description:
 This method has the following variants:
- int lastIndexOf(int ch)
 : Returns the index within this string of the last occurrence
 of the specified character or -1 if the character does not occur.

- public int lastIndexOf(int ch, int fromIndex)
 : Returns the index of the last occurrence of the character in the character
 sequence represented by this object that is less than or equal to fromIndex,
 or -1 if the character does not occur before that point.

- public int lastIndexOf(String str)
 : If the string argument occurs one or more times as a substring within this object,
 then it returns the index of the first character of the last such substring is returned.
 If it does not occur as a substring, -1 is returned.

- public int lastIndexOf(String str, int fromIndex)
 : Returns the index within this string of the last occurrence of the specified substring,
 searching backward starting at the specified index.
 */

public class App_01_lastIndexOf {
    public static void main(String args[]) {
        String Str = new String("Welcome to Tutorialspoint");

        // Returns the index of the "last" occurrence of the character
        System.out.print("Found Last Index :");
        System.out.println(Str.lastIndexOf('o'));
        // Returns the index of the "last" occurrence of the character in the character
        // sequence represented by this object that is less than or equal to fromIndex
        System.out.print("Found Last Index :");
        System.out.println(Str.lastIndexOf('o', 6));

    }
}
