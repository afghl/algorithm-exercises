package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 电话目录管理系统
 *
 * https://leetcode-cn.com/problems/design-phone-directory/
 * medium
 */
public class PhoneDirectory {

    private Set<Integer> allocateNums;
    private int maxNumbers;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.allocateNums = new HashSet<>(maxNumbers);
        this.maxNumbers = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (allocateNums.size() == maxNumbers) {
            return -1;
        }

        Random random = new Random();
        int nextInt = random.nextInt(maxNumbers);
        while (allocateNums.contains(nextInt)) {
            nextInt = random.nextInt(maxNumbers);
        }

        allocateNums.add(nextInt);
        return nextInt;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return allocateNums.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        allocateNums.remove(number);
    }
}
