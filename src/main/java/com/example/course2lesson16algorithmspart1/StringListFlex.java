package com.example.course2lesson16algorithmspart1;

public class StringListFlex extends MyStringList {

    public StringListFlex() {
        super(100);
    }

    public StringListFlex(int capacity) {
        super(capacity);
    }

    @Override
    public String add(String item) {
        if (getCount() >= size()) {
            super.doubleSize();
        }
        return super.add(item);
    }

    @Override
    public String add(int index, String item) {
        if (getCount() >= size()) {
            super.doubleSize();
        }

        return super.add(index, item);
    }

}
