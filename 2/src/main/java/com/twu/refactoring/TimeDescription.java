package com.twu.refactoring;

public class TimeDescription {
    int start;
    int end;
    String stringIndexOutOfBoundsException;
    String numberFormatException;
    int min;
    int max;
    String illegalArgumentException;

    public TimeDescription() {
    }
    public TimeDescription(int start, int end, String stringIndexOutOfBoundsException, String numberFormatException, int min, int max, String illegalArgumentException) {
        this.start = start;
        this.end = end;
        this.stringIndexOutOfBoundsException = stringIndexOutOfBoundsException;
        this.numberFormatException = numberFormatException;
        this.min = min;
        this.max = max;
        this.illegalArgumentException = illegalArgumentException;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getStringIndexOutOfBoundsException() {
        return stringIndexOutOfBoundsException;
    }

    public void setStringIndexOutOfBoundsException(String stringIndexOutOfBoundsException) {
        this.stringIndexOutOfBoundsException = stringIndexOutOfBoundsException;
    }

    public String getNumberFormatException() {
        return numberFormatException;
    }

    public void setNumberFormatException(String numberFormatException) {
        this.numberFormatException = numberFormatException;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getIllegalArgumentException() {
        return illegalArgumentException;
    }

    public void setIllegalArgumentException(String illegalArgumentException) {
        this.illegalArgumentException = illegalArgumentException;
    }


}
