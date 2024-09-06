package org.example.algoLuhn;

import java.util.Arrays;

public class Luhn {
    private String numero;

    public Luhn(String numero) {
        this.numero = numero;
    }
    public boolean isValid() {
        int len = this.numero.length();
        int[] numTab = new int[len];

        for (int i = 0; i < len; i++) {
            int value = Character.getNumericValue(this.numero.charAt(i));
            if ((len % 2 == 0 && i % 2 == 0) || (len % 2 == 1 && i % 2 == 1)) {
                int doubleValue = value * 2;
                numTab[i] = (doubleValue > 9) ? doubleValue - 9 : doubleValue;
            } else {
                numTab[i] = value;
            }
        }
        return Arrays.stream(numTab).sum() % 10 == 0;
    }
}
