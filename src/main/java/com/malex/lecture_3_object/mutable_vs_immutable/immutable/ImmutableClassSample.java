package com.malex.lecture_3_object.mutable_vs_immutable.immutable;

import com.malex.utils.AbstractUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Link do info <a href="https://www.youtube.com/watch?v=8Hk1t_OF3Nk&list=PLtNPgSbW9TX5IQAKzgrJnaayjaDoCjkio&index=8">tutorial</a>
 */
public class ImmutableClassSample extends AbstractUtils {

    private final List<Integer> initList = List.of(1, 2, 3, 4);

    @Test
    public void testIncomingList() {
        // given
        var list = new ArrayList<>(initList);
        var myClass = new MyImmutableClass(list);

        // when
        list.add(-1);
        print("List after mutation:", list);

        // then
        assertNotEquals(list, myClass.getList());
        // and
        assertEquals(initList, myClass.getList());
    }

    @Test
    public void testGetter() {
        // given
        var myClass = new MyImmutableClass(initList);

        // when
        List<Integer> list = myClass.getList();
        list.add(-1);
        print("List after mutation:", list);

        // then
        assertEquals(initList, myClass.getList());
    }

    private static class MyImmutableClass extends AbstractUtils {

        private final List<Integer> list;

        MyImmutableClass(List<Integer> list) {
            print("Init state MyImmutableClass, list = ", list);
            this.list = new ArrayList<>(list);
        }

        public List<Integer> getList() {
            return new ArrayList<>(list);
        }
    }

}
