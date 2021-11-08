package td2pf.ex2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtrage<T> {
    public boolean filtragePredicatif(List<Predicate<T>> liste, T element) {
        Predicate<T> composition = x -> true;
        for(Predicate<T> pre: liste ){
            composition = composition.and(pre);
        }
        return composition.test(element);
    }

    public List<T> filtragePredicatifGeneral(List<Predicate<T>> predicats, List<T> liste) {
        return liste.stream().filter(x -> filtragePredicatif(predicats, x)).collect(Collectors.toList());
    }
}