package com.example.course2lesson16algorithmspart1;

import com.thedeanda.lorem.LoremIpsum;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListFlexTest {
    @Test
    public void addByItemTest() {
        int volume = random().nextInt(10, 100);
        StringListFlex stringListFlex = new StringListFlex(volume);
        for (int i = 0; i < volume; i++) {
            stringListFlex.add(loremIpsum().getWords(2, 5));
        }
        assertEquals(volume, stringListFlex.size());
        String testString = loremIpsum().getWords(2, 5);
        stringListFlex.add(testString);
        assertEquals(volume * 2, stringListFlex.size());
        assertEquals(testString, stringListFlex.get(volume));
    }

    @Test
    public void addByIndexTest() {
        int capacity = random().nextInt(10, 100);
        StringListFlex stringListFlex = new StringListFlex(capacity);
        for (int i = 0; i < capacity; i++) {
            stringListFlex.add(loremIpsum().getWords(2, 5));
        }
        int index = random().nextInt(0, stringListFlex.getCount() - 1);
        String testString = loremIpsum().getWords(7, 10);
        stringListFlex.add(index, testString);
        assertEquals(capacity * 2, stringListFlex.size());
        assertEquals(testString, stringListFlex.get(index));
    }

    LoremIpsum loremIpsum() {
        return new LoremIpsum();
    }

    Random random() {
        return new Random();
    }
}
