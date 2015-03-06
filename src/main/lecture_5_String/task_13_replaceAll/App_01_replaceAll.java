package task_13_replaceAll;

/**

 Description:
 This method replaces each substring of this string that matches
 the given regular expression with the given replacement.

 Syntax:
 Here is the syntax of this method:
 public String replaceAll(String regex, String replacement)

 Return Value:
 This method returns the resulting String.

 */
public class App_01_replaceAll {

    public static void main(String args[]) {
        String str = "aabfooaabfooabfoob";

        System.out.println("str.replaceAll(\"a*b\",\"+\") -> ");
        System.out.println(str.replaceAll("a*b","+"));
    }
}
