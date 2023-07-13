package com.example.course2lesson16algorithmspart1;

import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class MyStringListTest {

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

    @Test
    public void setTest() {
        String expectedOnException = "Expected On Exception";
        MyStringList myStringList = fixedWordSet10();
        assertThrows(MyStringListException.class, () -> myStringList.set(-1, expectedOnException));
        assertThrows(MyStringListException.class, () -> myStringList.set(myStringList.size(), expectedOnException));

        int index = getRandom().nextInt(0, 9);
        String expected = "My New String";
        assertEquals(expected, myStringList.set(index, expected));
        assertEquals(expected, myStringList.get(index));

    }

    @Test
    public void removeByStringTest() {
        final MyStringList myStringList = fixedWordSet10();

        assertThrows(MyStringListException.class, () -> myStringList.remove(null));

        int index = getRandom().nextInt(0, 9);
        String expected = fixedWordSet10().get(index);
        assertTrue(myStringList.indexOf(expected) >= 0);
        assertEquals(expected, myStringList.remove(expected));
        assertEquals(null, myStringList.remove(expected));
        assertEquals(-1, myStringList.indexOf(expected));
    }

    @Test
    public void removeByIndexTest() {
        final MyStringList myStringList = fixedWordSet10();

        assertThrows(MyStringListException.class, () -> myStringList.remove(-1));
        assertThrows(MyStringListException.class, () -> myStringList.remove(myStringList.getCount() + 1));

        int index = getRandom().nextInt(0, 9);

        String expected = myStringList.get(index);

        assertEquals(expected, myStringList.remove(index));
        assertEquals(-1, myStringList.indexOf(expected));
    }

    private MyStringList randomSetOfStrings(int capacity) {
        MyStringList myStringList = getMyStringList(capacity);
        IntStream.iterate(0, i -> i < capacity, i -> i + 1).forEach(i ->
                myStringList.add(loremIpsum().getWords(getRandom().nextInt(1, 5))));

        return myStringList;

    }

    @Test
    public void randomSetOfStringsTest() {
        System.out.println(Arrays.toString(randomSetOfStrings(getRandom().nextInt(5, 10)).toArray()));
    }


    @Test
    public void containsTest() {
        final MyStringList myStringList = randomSetOfStrings(getRandom().nextInt(10, 100));
        int index = getRandom().nextInt(0, myStringList.getCount() - 1);
        String testString = myStringList.get(index);

        assertTrue(myStringList.contains(testString));

        myStringList.remove(index);
        assertFalse(myStringList.contains(testString));

        assertThrows(MyStringListException.class, () -> myStringList.contains(null));
    }

    @Test
    public void indexOfTest() {
        MyStringList mySL = randomSetOfStrings(50);
        String testString;

        do {
            testString = loremIpsum().getWords(3);
        }
        while (mySL.contains(testString));

        int indexCount = 3;
        int[] indexes = new int[indexCount + 1];
        indexes[0] = -1;
        for (int i = 1; i <= indexCount; i++) {

            indexes[i] = getRandom().nextInt(indexes[i - 1] + 1, mySL.getCount() - 1);
            System.out.println("indexOfTest: index = " + indexes[i]);
            mySL.set(indexes[i], testString);
        }

        assertEquals(indexes[1], mySL.indexOf(testString));

    }

    private MyStringList getRandomStringListAndPutTestPattern(int capacity, String testPattern, int testPatternTimes) {

        System.out.println("testPattern = " + testPattern);

        if (capacity < testPatternTimes & testPatternTimes < 1) {
            throw new MyStringListException("getRandomStringListAndPutTestPattern parameters invalid");
        }

        MyStringList mySL = randomSetOfStrings(capacity);

        while (mySL.contains(testPattern)) {
            mySL = randomSetOfStrings(capacity);
        }

        int indexCount = testPatternTimes;
        int[] indexes = new int[indexCount + 1];
        indexes[0] = -1;
        for (int i = 1; i <= indexCount; i++) {
            indexes[i] = getRandom().nextInt(indexes[i - 1] + 1, mySL.getCount() - 1);
            mySL.set(indexes[i], testPattern);
        }
        System.out.println("Arrays.toString(mySL.toArray()) = " + Arrays.toString(mySL.toArray()));

        return mySL;
    }

    @Test
    public void lastIndexOfTest() {
        MyStringList myStringList = randomSetOfStrings(15);
        int firstTestPatternPosition = getRandom().nextInt(0, 5);
        int middleTestPatterPosition = getRandom().nextInt(6, 10);
        int lastTestPatternPosition = getRandom().nextInt(11, 15);

        String testPattern = loremIpsum().getWords(5, 10);

        while (myStringList.contains(testPattern)) {
            myStringList = randomSetOfStrings(15);
        }

        myStringList.set(firstTestPatternPosition, testPattern);
        myStringList.set(middleTestPatterPosition, testPattern);
        myStringList.set(lastTestPatternPosition, testPattern);

        assertEquals(lastTestPatternPosition, myStringList.lastIndexOf(testPattern));

        String missingPattern = loremIpsum().getWords(4, 5);
        while (myStringList.contains(missingPattern)) {
            myStringList = randomSetOfStrings(15);
        }

        assertEquals(myStringList.lastIndexOf(missingPattern), -1);

    }

    private Random getRandom() {
        return new Random();
    }

    private class DataForIndexMethodChecking {
        private MyStringList myStringList;
        private int[] indexes;
        String testPattern;
    }
}

