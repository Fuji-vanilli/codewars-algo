package org.example.countIpAdresses;

import java.util.Arrays;
/*
Implement a function that receives two IPv4 addresses, and returns the number
of addresses between them (including the first one, excluding the last one).
All inputs will be valid IPv4 addresses in the form of strings. The last address
will always be greater than the first one.

 */
public class CountIpAdresses {
    public static long ipsBetween(String start, String end) {
        long[] ipOne= Arrays.stream(start.split("\\."))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] ipTwo= Arrays.stream(end.split("\\."))
                .mapToLong(Long::parseLong)
                .toArray();
        long res= 0;

        for(int i= 0; i< 4; i++){
            long dif= 0;
            if(ipOne[i]!= ipTwo[i]){
                if(ipTwo[i]== 1){
                    dif= 256-ipOne[i];
                }else{
                    dif= ipTwo[i]-ipOne[i];
                }
                res+= dif;
            }
        }

        return res;
    }
    public static long ipsBetweenB(String start, String end){
        final String[] ipStarts = start.split("\\.");
        final String[] ipEnds = end.split("\\.");

        long ipStart= 0;
        long ipEnd= 0;

        for(int i= 0; i< 4; i++){
            ipStart= ipStart*256 + Long.parseLong(ipStarts[i]);
            ipEnd= ipEnd*256 + Long.parseLong(ipStarts[i]);
        }
        return ipEnd-ipStart;
    }
}
