package org.example.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Theoreme {

    public static Map<Integer, Long> mem= new HashMap<>();
    public long fib(int n){
        if(n== 0 || n== 1)
            return 1;
        return fib(n-2) + fib(n-1);
    }
    public long fibMem(int n){
        if(n<= 1)
            return n;
        Long value= mem.get(n);
        if(!Objects.isNull(value)){
            return value;
        }
        value= fibMem(n-2)+fibMem(n-1);
        mem.put(n, value);
        return value;
    }
    public long fibDP(int n){
        long[] tFib= new long[n+1];
        tFib[1]= 1;
        for(int i= 2; i<= n; i++) {
            tFib[i]= tFib[i-2]+tFib[i-1];
        }
        return tFib[n];
    }
}
