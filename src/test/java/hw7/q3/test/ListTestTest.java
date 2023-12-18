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
            public int get(int i) throws Exception {
                if(i < 0 || i >= array.size()) {
                    throw new Exception();
                }
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
                public int get(int i) throws Exception {
                    if(i < 0 || i >= array.size()) {
                        throw new Exception();
                    }
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
        class Exception implements List {
            ArrayList<Integer> array = new ArrayList();
            @Override
            public void add(int i,int v) {
                array.add(i,v);
            }

            @Override
            public int get(int i) {
                return array.get(i);
            }
        }
        assertFalse(new ListTest().testList(new Exception()));
        test1();
    }
}