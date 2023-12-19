package hw7.q3.test;

import hw7.q3.testable.List;

public class ListTest {
    public boolean testList(List list) {
        boolean a = testAddAndGet(list);
        boolean b = testException(list);
        boolean c = testEmptyList(list);
        return a & b & c;
    }
    public boolean testAddAndGet(List list){
        for (int i = 0; i < 10; i++) {
            list.add(i,i);
        }
        for (int i = 0; i < 10; i++) {
            if (list.get(i) != i) {
                return false;
            }
        }
        return true;
    }
    public boolean testException(List list){
        try {
            list.add(-1,9);
            list.get(-1);

        }catch (Exception e) {
            return true;
        }
        return false;
    }
    public boolean testEmptyList(List list) {
        list.add(0,1);
        list.add(1,4);
        list.emptyList();
        boolean isTrue = false;
        try {
            list.get(1);
        }catch (Exception e){
            isTrue = true;
        }
        return isTrue;
    }
}
