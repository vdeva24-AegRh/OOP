package Seminars;

import Seminars.Interfaces.Filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class ListFilter implements Filter {
    private List<Integer> indices;

    public ListFilter() {

        indices = new ArrayList<>();
    }
    @Override
    public int size() {

        return indices.size();
    }

    @Override
    public boolean isPresent(int index) {

        return indices.contains(index);
    }

    @Override
    public void add(int index) {
        if(isPresent(index)) {
            return;
        }
        int pos = -Collections.binarySearch(indices , index) - 1;
        indices.add(pos , index);
    }

    @Override
    public void remove(int index) {
        if(isPresent(index)) {
            indices.remove(index);
        }
    }
}