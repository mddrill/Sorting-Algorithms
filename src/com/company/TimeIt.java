package com.company;

public class TimeIt {

    /**
     * A function to time a block of code
     *
     * @param block a block of code to time
     * @return the time it took to run the code block in milliseconds
     */
    public static long timeIt(Runnable block){
        long before = System.currentTimeMillis();
        block.run();
        long after = System.currentTimeMillis();
        return after - before;
    }
}
