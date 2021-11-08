package td2pf.ex2;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class main {
    public static void main(String[] args){

        Paire<Integer,Double> client1 = new Paire<>(250,78.5);
        Paire<Integer,Double> client2 = new Paire<>(90,45.4);
        Paire<Integer,Double> client3 = new Paire<>(145,153.0);
        Paire<Integer,Double> client4 = new Paire<>(180,78.5);

        Predicate<Integer> tailleTropPetit = taille -> taille < 100;
        Predicate<Integer> tailleTropGrand = taille -> taille > 200;
        Predicate<Integer> tailleNop = taille -> tailleTropPetit.or(tailleTropGrand).test(taille);
        Predicate<Integer> tailleGood = taille -> tailleTropPetit.negate().and(tailleTropGrand.negate()).test(taille);

        Predicate<Double> poidsTropLourd = poids -> poids > 150;
        Predicate<Double> poidsCorrecte = poids -> poidsTropLourd.negate().test(poids);


        Predicate<Paire<Integer, Double>> troppetit = n -> n.fst < 100;
        Predicate<Paire<Integer, Double>> tropgrand = n -> n.fst > 200;
        Predicate<Paire<Integer, Double>> troplourd = n -> n.snd > 150.0;
        Predicate<Paire<Integer, Double>> taille_nop = tropgrand.negate().and(troppetit.negate());
        Predicate<Paire<Integer, Double>> taille_good = taille_nop.negate();
        Predicate<Paire<Integer, Double>> poids_ok = troplourd.negate();
        Predicate<Paire<Integer,Double>> entreeok = (x) -> taille_good.test(x) && poids_ok.test(x);

        //question 1

        System.out.println("client1 : " + entreeok.test(client1));
        System.out.println("client2 : " + entreeok.test(client2));
        System.out.println("client3 : " + entreeok.test(client3));
        System.out.println("client4 : " + entreeok.test(client4));

        // question 2
        List<Predicate<Integer>> liste1 = List.of(tailleTropGrand, tailleNop);
        List<Predicate<Integer>> liste2 = List.of(tailleTropGrand, tailleTropPetit, tailleNop);
        List<Predicate<Integer>> liste3 = List.of(tailleTropGrand, tailleNop);
        // Filtrage un element
        Filtrage<Integer> f = new Filtrage<>();

        System.out.println("un seul element");
        System.out.println(f.filtragePredicatif(liste1, 235));
        System.out.println(f.filtragePredicatif(liste1, 200));
        System.out.println(f.filtragePredicatif(liste2, 200));
        System.out.println(f.filtragePredicatif(liste3, 92));

        // Filtrage d'une liste d'elements
        List<Integer> listeEl1 = List.of(220, 77, 235, 241, 200, 137, 57);

        System.out.println("liste d'elements");
        System.out.println(f.filtragePredicatifGeneral(liste1, listeEl1));
        System.out.println(f.filtragePredicatifGeneral(liste2, listeEl1));
        System.out.println(f.filtragePredicatifGeneral(liste3, listeEl1));
    }

}
