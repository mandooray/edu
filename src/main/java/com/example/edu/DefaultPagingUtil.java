package com.example.edu;

public class DefaultPagingUtil {
    public static final Integer DEFAULT_SIZE = 100;
    public static final Integer MAX_SIZE = 200;

    static public int extractSize(Integer size){
        if (size == null) {
            return DEFAULT_SIZE;
        }

        if(size > MAX_SIZE){
            return MAX_SIZE;
        }

        return size;
    }
}
