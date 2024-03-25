package com.xxharutoxx.sjelnextprogressbar.utils;

public enum ProgressStartPoint {
    DEFAULT(-90), LEFT(180), RIGHT(0), BOTTOM(90);
    int value;
    private ProgressStartPoint(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
