package com.example.course2lesson16algorithmspart1;

import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MyStringListTest {

    private MyStringList myStringList = new MyStringList(10);

    private static MyStringList fixedWordSet10() {
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

    @Test
    public void MyStringListTest() {
        Random r = new Random();
        MyStringList myStringList = new MyStringList(10);
        assertEquals(0, myStringList.getCount());
        Assertions.assertThrows(MyStringListException.class, () -> getMyStringList(-1));

        int capacity = r.nextInt(100, 1000);
        MyStringList checkWithRandomCapacityValue = new MyStringList(capacity);
        assertEquals(capacity, checkWithRandomCapacityValue.size());

    }

    private MyStringList getMyStringList(int i) {
        MyStringList m = new MyStringList(i);
        return m;
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

    @Test
    public void addTest() {
        MyStringList myStringList = getMyStringList(10);
        assertEquals(0, myStringList.getCount());

        String expectedString = loremIpsum().getWords(3);
        assertEquals(expectedString, myStringList.add(expectedString));

        myStringList = fixedWordSet10();
        assertEquals(10, myStringList.size());
        assertEquals(10, myStringList.getCount());

        MyStringList finalMyStringList = myStringList;
        assertThrows(MyStringListException.class, () -> finalMyStringList.add(expectedString));
    }

    @Test
    public void addByIndexTest() {
        int capacity = 10;
        MyStringList myStringList = new MyStringList(capacity);

        myStringList = fixedWordSet10();

        MyStringList finalMyStringList = myStringList;
        String expectedOnException = "expected on exception";
        assertThrows(MyStringListException.class, () -> finalMyStringList.add(-1, expectedOnException));
        assertThrows(MyStringListException.class, () -> finalMyStringList.add(0, null));

        myStringList.expand(1);

        int index = getRandom().nextInt(0, 9);
        System.out.println("index = " + index);
        System.out.println("myStringList.size() = " + myStringList.size());
        System.out.println("myStringList.getCount() = " + myStringList.getCount());

        String expected = loremIpsum().getWords(getRandom().nextInt(1, 5));

        assertEquals(expected, myStringList.add(index, expected));
        assertEquals(expected, myStringList.get(index));

        assertEquals(fixedWordSet10().get(index), myStringList.get(index + 1));

        MyStringList finalMyStringList1 = myStringList;
        assertThrows(MyStringListException.class, () -> finalMyStringList1.add(finalMyStringList1.getCount(),
                expectedOnException));

    }

    private Random getRandom() {
        return new Random();
    }
}

