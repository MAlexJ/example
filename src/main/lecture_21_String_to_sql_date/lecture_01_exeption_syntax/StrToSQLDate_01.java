package lecture_01_exeption_syntax;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StrToSQLDate_01 {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        java.util.Date parsed = format.parse("20110210");
        System.out.println(parsed.getTime());
        java.sql.Date sql = new java.sql.Date(parsed.getTime());
        System.out.println(sql);

        SimpleDateFormat format_01 = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date parsed_01 = format_01.parse("2015/09/18");
        java.sql.Date sql_01 = new java.sql.Date(parsed_01.getTime());
        System.out.println(sql_01);


        SimpleDateFormat format_02 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed_02 = format_02.parse("15/09/2014");
        java.sql.Date sql_02 = new java.sql.Date(parsed_02.getTime());
        System.out.println(sql_02);

    }
}
