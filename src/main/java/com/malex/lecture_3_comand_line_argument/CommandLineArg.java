package com.malex.lecture_3_comand_line_argument;

public class CommandLineArg {
    public static void main(String[] args) {
        if(args.length>0){
            for (String arg : args) System.out.println(arg);
        }else {
            System.out.println("Command line: The Arguments is empty. ");
        }
    }
}
