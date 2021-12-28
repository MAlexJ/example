package com.malex.lecture_7_Date;

import lombok.extern.log4j.Log4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Log4j
public class StringToSQLDate {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    private static SimpleDateFormat simpleDateFormatInstance() {
        return format;
    }

    public static void main(String[] args) throws ParseException {
        java.util.Date parsed = simpleDateFormatInstance()
                .parse("20110210");
        long time = parsed.getTime();
        log.info(time);
        log.info(new java.sql.Date(time));

        SimpleDateFormat format_01 = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date parsed_01 = format_01.parse("2015/09/18");
        java.sql.Date sql_01 = new java.sql.Date(parsed_01.getTime());
        log.info(sql_01);


        SimpleDateFormat format_02 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date parsed_02 = format_02.parse("15/09/2014");
        java.sql.Date sql_02 = new java.sql.Date(parsed_02.getTime());
        log.info(sql_02);
    }
}
