package Seminars;

import Seminars.Interfaces.Filter;

public class BitMaskFilter implements Filter {
    private int[] data;
    private int logLen;
    private int numBuckets;

    public BitMaskFilter() {
        this.numBuckets = 1;
        this.logLen = 0;
        this.data = new int[numBuckets];
    }
    @Override
    public int size() {
        return this.logLen;
    }

    @Override
    public boolean isPresent(int index) {
        int bucketNum = index/32;
        int mask = data[bucketNum];
        int pos = index % 32;
        if(bucketNum>= this.numBuckets) {
            return false;
        }
        return (mask & (1 << pos)) != 0;
    }

    @Override
    public void add(int index) {
        int bucketNum = index/32;
        int pos = index % 32;
        if(bucketNum >= numBuckets) {
            int[] newData = new int[bucketNum + 1];
            System.arraycopy(data , 0 , newData ,0, numBuckets);
            this.numBuckets++;
            data = newData;
        }
        if((data[bucketNum] & (1 << pos)) != 0) return;
        data[bucketNum] |= (1 << pos);
        this.logLen ++;
    }

    @Override
    public void remove(int index) {
        if(!isPresent(index)) return;
        int bucketNum = index/32;
        int pos = index % 32;
        data[numBuckets] &= ~(1 << pos);
        this.logLen--;
    }
}
