package hw7.q3.test;

import hw7.q3.testable.Stack;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StackTesterTest {
    @Test
    public void test1(){
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
        class WrongStack implements Stack{
            ArrayList<Integer> elements = new ArrayList<>();

            @Override
            public void push(int i) {
                elements.add(i);
            }

            @Override
            public int pop() {
                return elements.get(elements.size() - 1);
            }

        }
        assertFalse(new StackTester().testStack(new WrongStack()));
        class FalseStack implements Stack{
            ArrayList<Integer> elements = new ArrayList<>();

            @Override
            public void push(int i) {
                elements.add(0,i);
            }

            @Override
            public int pop(){
                int output = elements.get(elements.size() - 1);
                elements.remove(elements.size() - 1);
                return output;
            }
        }
        assertFalse(new StackTester().testStack(new FalseStack()));
    }
    //this test checking if code handled exceptions
    @Test
    public void test2(){
        class ExceptionStack implements Stack {
            ArrayList<Integer> elements = new ArrayList<>();

            @Override
            public void push(int i) {
                elements.add( i);
            }

            @Override
            public int pop() {
                int output = 0;
                try {
                    output = elements.get(elements.size() - 1);
                    elements.remove(elements.size() - 1);
                } catch (Exception e) {
                }
                return output;
            }
        }
        assertFalse(new StackTester().testStack(new ExceptionStack()));
        test1();
    }
}