package testlang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSubList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        System.out.println(list.size());
        int startIndex = 2;
        int endIndex = 4;
        int large = -1;
        int small = -1;
        if (endIndex > startIndex) {
            large = endIndex;
            small = startIndex;
        } else {
            large = startIndex;
            small = endIndex;
        }
        System.out.println(large);
        System.out.println(small);
        list.subList(large, large + 1).clear();
        list.subList(small, small + 1).clear();
        System.out.println(list);
    }
}
