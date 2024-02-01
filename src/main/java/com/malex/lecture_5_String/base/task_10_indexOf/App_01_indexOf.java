package com.malex.lecture_5_String.base.task_10_indexOf;

/**

 Description:
 This method has following different variants:
 - public int indexOf(int ch)
 : Returns the index within this string of the "first" occurrence of the specified character or -1 if the character does not occur.

 - public int indexOf(int ch, int fromIndex)
 : Returns the index within this string of the "first: occurrence of the specified character, starting the search
 at the specified index or -1 if the character does not occur.

-  int indexOf(String str)
 : Returns the index within this string of the first occurrence of the specified substring.
 If it does not occur as a substring, -1 is returned.

- int indexOf(String str, int fromIndex)
 : Returns the index within this string of the first occurrence of the specified substring,
 starting at the specified index. If it does not occur, -1 is returned.





 */
public class App_01_indexOf {

    public static void main(String args[]) {
        String str = new String("Welcome to Tutorials");


        System.out.print("Found Index :" );
        //Returns the index within this string of the "first" occurrence
        System.out.println(str.indexOf('o') +"  :str.indexOf('o')");

        System.out.print("Found Index :" );
        // "first" occurrence of the specified substring, starting at the specified "index"
        System.out.println(str.indexOf( 'o', 5 ) +"  :str.indexOf( 'o', 5 )");

        System.out.print("Found Index :" );
        // "first" occurrence of the specified substring, starting at the specified "index"
        System.out.println(str.indexOf( 'o', 10 ) +"  :str.indexOf( 'o', 10 )");

    }
}
