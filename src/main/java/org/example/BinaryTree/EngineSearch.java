package org.example.BinaryTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class EngineSearch {
    private BinarySearch index;

    public EngineSearch() {
        this.index= new BinarySearch();
    }

    public void indexPage(String title, String url, List<String> keywords) {
        Page page= new Page(title, url);
        for (String keyword: keywords) {
            index.add(keyword, page);
        }
        /*keyword.stream()
                .map(key-> index.add(key, new Page(title, url)));

         */
    }

}
