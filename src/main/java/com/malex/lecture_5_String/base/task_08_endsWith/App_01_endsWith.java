package com.malex.lecture_5_String.base.task_08_endsWith;

/**
 * Description:
 -  This method tests if this string ends with the specified suffix.

 Return Value:
- This method returns true if the character sequence represented by the argument is a suffix of the character sequence
 represented by this object;
 - false otherwise.
 Note that the result will be true if the argument is the empty string or is equal
 to this String object as determined by the equals(Object) method.


 */
public class App_01_endsWith {

    public static void main(String args[]){
        String str = new String("This is really not immutable!!");
        boolean retVal;

        retVal = str.endsWith( "immutable!!" );
        System.out.println("Returned Value = " + retVal );

        retVal = str.endsWith( "immu" );
        System.out.println("Returned Value = " + retVal );

        retVal = str.endsWith( "!" );
        System.out.println("Returned Value = " + retVal );

    }
}
