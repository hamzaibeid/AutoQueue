package javaapplication14;

import java.util.concurrent.TimeUnit;

public class TimeElapsed {

    private long seconds;
    private long timeElapsed;

    public TimeElapsed() {
        seconds = 2;
    }

    public long countTime(long seconds) throws InterruptedException {

        long start = System.nanoTime();
        TimeUnit.SECONDS.sleep(seconds);
        long end = System.nanoTime();
        timeElapsed = end - start;
        long result = timeElapsed / 1000000; //results in MilliSecond
        return result;
    }

    public void setSecond(long seconds) {
        this.seconds = seconds;
    }

    public boolean timePattern() throws InterruptedException {

        long pattern1 = seconds * 1000;
        long pattern2 = pattern1 - 1;

        return (countTime(seconds) == pattern1 || countTime(seconds) == pattern2);

    }

}
