package com.mycompany.datastructuresalgorithms;

/**
 *
 * @author bethan
 */
public class Capture {
    private final long time;
    private final String location;
    private final String regNum;

    public Capture(long time, String location, String regNum) {
        this.time = time;
        this.location = location;
        this.regNum = regNum;
    }

    public long getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getRegNum() {
        return regNum;
    }
}
