package td2pf.ex2;

import java.util.function.Predicate;

public class main {
    public static void main(String[] args){

        Paire<Integer,Double> client1 = new Paire<>(250,78.5);
        Paire<Integer,Double> client2 = new Paire<>(90,45.4);
        Paire<Integer,Double> client3 = new Paire<>(145,153.0);
        Paire<Integer,Double> client4 = new Paire<>(180,78.5);


        Predicate<Paire<Integer, Double>> troppetit = n -> n.fst < 100;
        Predicate<Paire<Integer, Double>> tropgrand = n -> n.fst > 200;
        Predicate<Paire<Integer, Double>> troplourd = n -> n.snd > 150.0;
        Predicate<Paire<Integer, Double>> taille_nop = tropgrand.negate().and(troppetit.negate());
        Predicate<Paire<Integer, Double>> taille_good = taille_nop.negate();
        Predicate<Paire<Integer, Double>> poids_ok = troplourd.negate();
        Predicate<Paire<Integer,Double>> entreeok = (x) -> taille_good.test(x) && poids_ok.test(x);







        System.out.println("client1 : " + entreeok.test(client1));
        System.out.println("client2 : " + entreeok.test(client2));
        System.out.println("client3 : " + entreeok.test(client3));
        System.out.println("client4 : " + entreeok.test(client4));


    }
}
