package com.malex.lecture_11_record;

public class RecordMain {

    public static void main(String[] args) {
        // MyRecord
        MyRecord myRecord = new MyRecord(1, "test");
        print("MyRecord : ", myRecord);
        print("MyRecord.number : ", myRecord.number());
        print("MyRecord.name : ", myRecord.name());
        
    }

    private static void print(String msg, Object obj) {
        System.out.println(msg + obj);
    }
}
