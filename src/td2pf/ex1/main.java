package td2pf.ex1;

import td2pf.ex1.Somme;

import java.util.List;
import java.util.Map;

public class main{

    public static void main(String[] args)
    {
        /* Question 1,
        En comparant Somme et Sommable on se rend compte que Somme est beaucoup plus simple.
        On n'a pas besoin de nouvelles classes pour l'interface. On fait tout avec une seul méthode.
        */
        //Implémentation de la méthode pour les 4 types
        Somme<Integer> sommeinteger =(x, y)-> x+y;
        Somme<Double>  sommedouble = (x,y)-> x+y;
        Somme<Long>    sommelong = (x,y) -> x+y;
        Somme<String>  sommestring = (x,y) -> x+y;
        //test des implémentations de somme déclarer juste avant
        System.out.println("Question 1:");
        System.out.println("Résultat de somme integer="+sommeinteger.somme(4,5));
        System.out.println("Résultat de somme double="+sommedouble.somme(4.5,5.5));
        System.out.println("Résultat de somme long="+sommelong.somme(4l,5l));
        System.out.println("Résultat de somme String="+sommestring.somme("ixe","igrec"));

        // Question 2

        //toString Liste
        ToString<List<String>> l2s = l -> {
            StringBuilder stringbuilder = new StringBuilder();
            l.forEach(l2 -> stringbuilder.append(l2).append(" "));
            return stringbuilder.toString();
        };

        //toString Map
        ToString<Map<String, Integer>> m2s = m -> {
            StringBuilder stringbuilder = new StringBuilder();
            m.entrySet().forEach(m2 -> stringbuilder.append(String.format("%s: %s ", m2.getKey(), m2.getValue())));
            return stringbuilder.toString();
        };

        List<String> list = List.of("Un", "Deux", "Trois");
        Map<String, Integer> map = Map.of("un", 1, "deux", 2, "trois", 3);

        System.out.println("Question 2:");
        System.out.println(l2s.toString(list));
        System.out.println(m2s.toString(map));


        System.out.println("Question 3: ");
    }





}

