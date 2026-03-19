package Seminars;

import Seminars.Interfaces.Filter;

public class BooleanFilter implements Filter {
    private boolean [] indices;
    private int logLen;
    private int allocLen;

    public BooleanFilter() {
        this.allocLen = 4;
        this.logLen = 0;
        this.indices = new boolean[allocLen];
    }
    @Override
    public int size() {
        return this.logLen;
    }

    @Override
    public boolean isPresent(int index) {
       return index < this.allocLen && this.indices[index];
    }

    @Override
    public void add(int index) {
        if(isPresent(index)) {
            return;
        }
        if(index >= allocLen) {
            this.allocLen  = Math.max(this.allocLen * 2 , index + 1);
            boolean [] newIndices = new boolean[this.allocLen];
            System.arraycopy(indices ,0 , newIndices , 0 , this.logLen );
            newIndices[index] = true;
            this.indices = newIndices;
            this.logLen++;
        }
    }

    @Override
    public void remove(int index) {
        if(!isPresent(index)) return;
        indices[index] = false;
        this.logLen --;
    }
}
