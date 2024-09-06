package org.example.kyu5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ManipulateDepartement {
    public static void main(String[] args) throws IOException {
        final String pathOfDepartment= "D:\\IXML\\departement.txt";
        final String pathOfCommune= "D:\\IXML\\commune.txt";

        List<Departement> departments= getDepartments(pathOfDepartment);
        List<Commune> communes = getCommunes(pathOfCommune);

        Function<Commune, String> toCodeDepartment= commune ->
                commune.getCodePostal().startsWith("97") ?
                        commune.getCodePostal().substring(0, 3) :
                        commune.getCodePostal().substring(0, 2);

        Map<String, List<Commune>> departmentsGrouping = communes.stream()
                .collect(Collectors.groupingBy(toCodeDepartment));

        Map<String, Long> numberCommunePerDepartment = communes.stream()
                .collect(Collectors.groupingBy(toCodeDepartment, Collectors.counting()));

        Consumer<Departement> departmentConsumer= d->
                communes.stream()
                                .filter(c-> c.getCodePostal().startsWith(d.getCodePostal()))
                                        .forEach(d::addCommune);

        departments.forEach(departmentConsumer);

         Map.Entry<String, Long> maxCommuneDepartment = numberCommunePerDepartment.entrySet().stream()
                //.max(Comparator.comparing(Map.Entry::getValue))
                 .max(Map.Entry.comparingByValue())
                .orElseThrow();

        numberCommunePerDepartment.forEach(
                (key, value)-> {
                    System.out.println(key+" : "+value);
                }
        );
    }

    private static List<Commune> getCommunes(String path) throws IOException {
        Path pathOfCommune= Paths.get(path);
        Predicate<String> isComment= line-> line.startsWith("#");

        Function<String, String> toName= x->
                x.substring(0, x.indexOf("(")).replaceAll("\\s+$", "");
        Function<String, String> toCodePostal= x->
                x.substring(x.indexOf("(")+1, x.length()-1);
        Function<String, Commune> toCommune=
                e-> new Commune(toName.apply(e), toCodePostal.apply(e));

        return Files.lines(pathOfCommune)
                .filter(isComment.negate())
                .map(toCommune)
                .toList();
    }

    private static List<Departement> getDepartments(String path) throws IOException {
        Path pathDepartment= Paths.get(path);

        Predicate<String> isComment= line-> line.startsWith("#");
        Function<String, String> toCodePostal= x->
                x.substring(0, x.indexOf(" -"));
        Function<String, String> toName= x->
                x.substring(x.indexOf(" ")+3, x.length());
        Function<String, Departement> toDepartment= e->
                new Departement(toName.apply(e), toCodePostal.apply(e));

        return Files.lines(pathDepartment)
                .filter(isComment.negate())
                .map(toDepartment)
                .toList();
    }

}
