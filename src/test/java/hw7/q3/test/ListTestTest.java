package hw7.q3.test;

import hw7.q3.testable.List;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListTestTest {

    @Test
    public void test1() {
        class CorrectImpl implements List {
            ArrayList<Integer> array = new ArrayList<>();
            @Override
            public void add(int i,int v) {
                array.add(i,v);
            }

            @Override
            public int get(int i) {
                return array.get(i);
            }
        }
        assertTrue(new ListTest().testList(new CorrectImpl()));
        class WrongImpl implements List {
            ArrayList<Integer> array = new ArrayList<>();
                @Override
                public void add(int i,int v) {
                    array.add(i,v);
                }

                @Override
                public int get(int i) {
                    if (i >= 5){
                        return 0;
                    }
                    return array.get(i);
                }
        }
        assertFalse(new ListTest().testList(new WrongImpl()));
    }

    @Test
    public void test2(){
        class ExceptionList implements List {
            ArrayList<Integer> array = new ArrayList();
            @Override
            public void add(int i,int v) {
                try {
                    array.add(i, v);
                }catch (Exception e){}
            }

            @Override
            public int get(int i) {
                try {
                    return array.get(i);
                }catch (Exception e) {
                    return 0;
                }

            }
        }
        assertFalse(new ListTest().testList(new ExceptionList()));
        test1();
    }
}