package org.example.didyoumean;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Je suis sûr que vous connaissez le "Voulez-vous dire ... ?" de Google,
 * lorsque vous avez saisi un terme de recherche et que vous avez mal tapé un mot.
 * Dans ce kata, nous voulons implémenter quelque chose de similaire.
 * Vous obtiendrez un terme saisi (chaîne en minuscules) et un tableau de mots
 * connus (également des chaînes en minuscules). Votre tâche est de découvrir quel mot du
 * dictionnaire est le plus similaire à celui saisi. La similitude est décrite par
 * le nombre minimum de lettres que vous devez ajouter, supprimer ou remplacer pour passer du
 * mot saisi à l'un des mots du dictionnaire. Plus le nombre de changements requis est faible,
 * plus la similitude entre chacun des deux mots est élevée.
 * Les mêmes mots sont évidemment les plus similaires. Un mot qui a besoin d'une lettre pour être changé est
 * plus similaire à un autre mot qui a besoin de 2 (ou plus) lettres pour être changé. Par exemple. le terme mal
 * orthographié berr ressemble plus à beer (1 lettre à remplacer) qu'à baril (3 lettres à changer au total).
 */
public class Dictionary {
    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String to) {
        int[] weigth= new int[words.length];
        int index= 0;

        for(String word: words){
            int inv= 0;
            for(int i= 0; i< to.length(); i++){
                if(to.charAt(i)!= word.charAt(i))
                    inv++;
            }
            weigth[index++]= inv;
        }
        int indexMin= IntStream.range(0, weigth.length)
                .reduce((i,j)-> weigth[i]<weigth[j]? i: j)
                .orElse(-1);

        return words[indexMin];
    }
}
