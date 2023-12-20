package hw7.q3.test;

import hw7.q3.testable.List;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListTesterTest {

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

            @Override
            public void emptyList() {
                array.clear();
            }
        }
        assertTrue(new ListTester().testList(new CorrectImpl()));
        class Wrong implements List {
            ArrayList<Integer> array = new ArrayList<>();
            @Override
            public void add(int i,int v) {
                array.add(i,v);
            }

            @Override
            public int get(int i) {
                return array.get(i);
            }

            @Override
            public void emptyList() {
            }
        }
        assertFalse(new ListTester().testList(new Wrong()));
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

            @Override
            public void emptyList() {
                array.clear();
            }
        }
        assertFalse(new ListTester().testList(new WrongImpl()));
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

            @Override
            public void emptyList() {
                array.clear();
            }
        }
        assertFalse(new ListTester().testList(new ExceptionList()));
        test1();
    }
}