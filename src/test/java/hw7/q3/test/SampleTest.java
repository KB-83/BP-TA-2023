package hw7.q3.test;

import hw7.q3.testable.List;
import hw7.q3.testable.ListHelper;
import hw7.q3.testable.Stack;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SampleTest {
    @Test(timeout = 5000)
    public void listTesterTest(){
        class MyList implements List{
            int[] ints = new int[0];
            @Override
            public void add(int i, int v) {
                int[] newInts = new int[ints.length + 1];
                for (int j = 0 ; j < i; j++) {
                    newInts[j] = ints[j];
                }
                newInts[i] = v;
                for (int j = i+1 ; j < ints.length+1 ; j++) {
                    newInts[j] = ints[j-1];
                }
                ints = newInts;
            }
            @Override
            public int get(int i) {
                return ints[i];
            }
            @Override
            public void emptyList() {
                ints = new int[0];
            }
        }
        assertTrue(new ListTester().testList(new MyList()));

        class MyList2 implements List{
            @Override
            public void add(int i, int v) {
            }
            @Override
            public int get(int i) {
                return 0;
            }
            @Override
            public void emptyList() {
            }
        }

        assertFalse(new ListTester().testList(new MyList2()));

    }
    @Test
    public void ListHelperTesterTest(){
        class TrueListHelper implements ListHelper {

            @Override
            public void sort(List list) {
            }

            @Override
            public int findMax(List list) {
                return SampleTest.findMax(list);
            }
        }
        assertFalse(new ListHelperTester().testSort(new TrueListHelper()));
        assertTrue(new ListHelperTester().testFindMax(new TrueListHelper()));

    }
    @Test
    public void stackTesterTest(){
        class FalseStack implements Stack{
            @Override
            public void push(int i) {

            }

            @Override
            public int pop() {
                return 0;
            }
        }
        assertFalse(new StackTester().testStack(new FalseStack()));
        class CorrectStack implements Stack{
            ArrayList<Integer> elements = new ArrayList<>();

            @Override
            public void push(int i) {
                elements.add(i);
            }

            @Override
            public int pop() {
                int output = elements.get(elements.size() - 1);
                elements.remove(elements.size() - 1);
                return output;
            }
        }
        assertTrue(new StackTester().testStack(new CorrectStack()));
    }

    private static int findMax(List list){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < listSize(list) ; i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
    private static int listSize(List list){
        boolean hasNext = true;
        int length = 0;
        while (hasNext) {
            length++;
            try {
                list.get(length-1);
            }catch (Exception e) {
                length--;
                hasNext = false;
            }
        }
        return length;
    }
}
