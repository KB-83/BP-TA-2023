package hw7.q3.test;

import hw7.q3.testable.Stack;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StackTestTest {
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
        assertTrue(new StackTest().testPush(new CorrectStack()));
        assertTrue(new StackTest().testPop(new CorrectStack()));
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
        assertFalse(new StackTest().testPop(new WrongStack()));
        assertTrue(new StackTest().testPush(new WrongStack()));
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
        assertFalse(new StackTest().testPush(new FalseStack()));
        assertTrue(new StackTest().testPop(new FalseStack()));
    }
    //this test checking if code handled exceptions
    @Test
    public void test2(){
        class ExceptionStack implements Stack {
            ArrayList<Integer> elements = new ArrayList<>();

            @Override
            public void push(int i) {
                elements.add(0, i);
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
        assertFalse(new StackTest().testPush(new ExceptionStack()));
        assertFalse(new StackTest().testPop(new ExceptionStack()));
        test1();
    }
}