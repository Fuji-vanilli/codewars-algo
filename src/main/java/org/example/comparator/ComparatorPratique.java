package org.example.comparator;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ComparatorPratique {
    public static void main(String[] args) {
        Exchange exchange= new Exchange("euro", 4870.24, new Date());
        Exchange exchange2= new Exchange("dolar", 4570, new Date());
        Exchange exchange3= new Exchange("livre", 5670.87, new Date());

        List<Exchange> exchanges= new java.util.ArrayList<>(List.of(exchange, exchange2, exchange3));
        exchanges.sort(new ExchangeComparator());

        exchanges.forEach(ex-> {
            System.out.println(ex.getName()+" - "+ex.getTaux()+" - "+ex.getDate());
        });
    }
}
