package org.example.BinaryTree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SearchEngine engineSearch= new SearchEngine();

        engineSearch.addPage("java", new Page("java bigening", "http://www.lac.com"));
        engineSearch.addPage("Ada", new Page("ada", "http://www.ada.com"));
        engineSearch.addPage("C/C++", new Page("C/C++ language","http://www.c-cplus.com"));
        engineSearch.addPage("Perl", new Page("Perl language","http://www.perl.com"));
        engineSearch.addPage("Lisp", new Page("Lisp language","http://www.lisp.com"));

        engineSearch.deepFirst();

        
    }
}
