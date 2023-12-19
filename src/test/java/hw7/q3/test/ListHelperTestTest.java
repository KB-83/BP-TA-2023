package hw7.q3.test;

import hw7.q3.testable.List;
import hw7.q3.testable.ListHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class ListHelperTestTest {
    @Test
    public void test1(){
        class TrueListHelper implements ListHelper{

            @Override
            public void sort(List list) {
                ArrayList<Integer> list1 = new ArrayList();
                boolean hasNext = true;
                int length = 0;
                while (hasNext) {
                    length++;
                    try {
                        list1.add(list.get(length-1));
                    }catch (Exception e) {
                        length--;
                        hasNext = false;
                    }
                }
                list1.sort(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return (int)o1 > (int)o2 ? 0:1;
                    }
                });
                for (int i = 0 ; i < list1.size() ; i++) {
                    list.add(i,list1.get(i));
                }
            }

            @Override
            public int findMax(List list) {
                int length = 0;
                int max = Integer.MIN_VALUE;
                boolean hasNext = true;
                while (hasNext) {
                    length++;
                    try {
                        if (list.get(length-1)>max){
                            max = list.get(length-1);
                        }
                    }catch (Exception e) {
                        length--;
                        hasNext = false;
                    }
                }
                return max;
            }
        }
        assertTrue(new ListHelperTest().testSort(new TrueListHelper()));
        assertTrue(new ListHelperTest().testFindMax(new TrueListHelper()));

        class FalseListHelper implements ListHelper{

            @Override
            public void sort(List list) {
            }

            @Override
            public int findMax(List list) {
                return 12;
            }
        }
        assertFalse(new ListHelperTest().testSort(new FalseListHelper()));
        assertFalse(new ListHelperTest().testFindMax(new FalseListHelper()));

    }
}