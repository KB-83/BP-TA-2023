package hw7.q3.test;

import hw7.q3.testable.ListHelper;

public class ListHelperTest {
    public boolean testSort(ListHelper arrayHelper){
        MyList myList = new MyList();
        myList.add(0,4);
        myList.add(1,3);
        myList.add(2,2);
        myList.add(3,1);
        arrayHelper.sort(myList);
        for (int i = 0 ; i < myList.size();i++) {
            if (myList.get(i) != i+1){
                return false;
            }
        }
        return true;
    }
    public boolean testFindMax(ListHelper arrayHelper){
        MyList myList = new MyList();
        myList.add(0,4);
        myList.add(1,3);
        myList.add(2,2);
        myList.add(3,1);
        if (arrayHelper.findMax(myList) != 4) {
            return false;
        }
        return true;
    }
}
