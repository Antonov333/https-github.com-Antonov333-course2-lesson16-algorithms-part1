package com.example.course2lesson16algorithmspart1;

import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyStringListTest {

    private MyStringList myStringList = new MyStringList(10);

    @Test
    public void MyStringListTest() {
        Random r = new Random();
        MyStringList myStringList = new MyStringList(10);
        assertEquals(0, myStringList.getCount());
        Assertions.assertThrows(MyStringListException.class, () -> callMyStringList(-1));

        int capacity = r.nextInt(100, 1000);
        MyStringList checkWithRandomCapacityValue = new MyStringList(capacity);
        assertEquals(capacity, checkWithRandomCapacityValue.size());

    }

    void callMyStringList(int i) {
        MyStringList m = new MyStringList(i);
    }

    @Test
    public void getCapacityTest() {
        int expected = getRandom().nextInt(1, 1000);
        MyStringList myStringList = new MyStringList(expected);
        assertEquals(expected, myStringList.size());
    }

    LoremIpsum loremIpsum() {
        return new LoremIpsum();
    }

    @Test
    public void getCountTest() {
        int capacity = getRandom().nextInt(2, 100);
        int count = getRandom().nextInt(1, capacity);

        System.out.println("capacity = " + capacity);
        System.out.println("count = " + count);

        MyStringList myStringList = new MyStringList(capacity);

        int[] arr = new int[count];

        for (int j : arr) {
            myStringList.add(loremIpsum().getWords(1) + " ");
        }

        assertEquals(count, myStringList.getCount());

    }


    private Random getRandom() {
        return new Random();
    }

    class MyStringListTestData {
        static MyStringList fixedWordSet10() {
            MyStringList wordSet = new MyStringList(10);

            wordSet.add("isque ");
            wordSet.add("mei ");
            wordSet.add("ei ");
            wordSet.add("ultricies");
            wordSet.add("verterem");
            wordSet.add("elitr");
            wordSet.add("porttitor");
            wordSet.add("prodesset");
            wordSet.add("civibus");
            wordSet.add("adipiscing");

            return wordSet;
        }
    }

}
