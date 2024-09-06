package org.example.comparator;

import java.util.Comparator;

public class ExchangeComparator implements Comparator<Exchange> {
    @Override
    public int compare(Exchange o1, Exchange o2) {
        return (int) (o1.getTaux() - o2.getTaux());
    }}
