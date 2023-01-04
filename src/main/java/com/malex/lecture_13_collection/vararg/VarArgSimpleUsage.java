package com.malex.lecture_13_collection.vararg;

import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class VarArgSimpleUsage {

    @Test
    public void test() {
        varArg(1);
        varArg();
        varArg(1, 2, 3, 7);

        // example 2
        varArg_1(1);
        varArg_1(1, 1, 2, 6, 9);
    }

    private void varArg(int... varArg) {
        StringBuilder sb = new StringBuilder("varArg: ");
        for (int item : varArg) {
            sb.append(item).append(",");
        }
        log.info(sb.toString());
    }

    private void varArg_1(int first, int... varArg) {
        StringBuilder sb = new StringBuilder("first: ");
        sb.append(first).append("; ");
        for (int item : varArg) {
            sb.append(item).append(",");
        }
        log.info(sb.toString());
    }

    //    static void varArg_2(int ... var, int i){} //Error
    //    static void varArg_2(int ... var, int ... i){} //Error
    private void varArg_2(int q, int f, int... i) {
    }
}
