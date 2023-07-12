package com.example.course2lesson16algorithmspart1;

import com.thedeanda.lorem.LoremIpsum;

import java.util.Arrays;

public class CallMyStringList {

    public static void main(String[] args) {
        MyStringList myStringList = new MyStringList(10);
        myStringList.add("Hi! ))");
        myStringList.add("How are you?");
        for (int i = 0; i < myStringList.getCount(); i++) {
            System.out.println(myStringList.get(i));
        }

        System.out.println("myStringList.indexOf(\"How are you?\") = " + myStringList.indexOf("How are you?"));
        System.out.println("myStringList.lastIndexOf(\"How are you?\") = " +
                myStringList.lastIndexOf("How are you?"));

        System.out.println(Arrays.toString(myStringList.toArray()));


        myStringList.doubleSize();
        System.out.println("myStringList.size() = " + myStringList.size());

        String[] arr = myStringList.toArray();
        System.out.println(Arrays.toString(arr));

        LoremIpsum loremIpsum = new LoremIpsum();

        System.out.println(loremIpsum.getWords(10));


    }
}
