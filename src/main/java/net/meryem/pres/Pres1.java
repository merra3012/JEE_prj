package net.meryem.pres;
import net.meryem.dao.DaoImpl;
import net.meryem.metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl(); //instanciation statique
//        DaoImpl2 dao = new DaoImpl2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); //injection des dependances
        System.out.println("Resultat: " + metier.calcul());
        /* Maintenant c'est bon, toutes les classes sont fermee a la modification et ouvertes a l'extension,
        sauf la classe Presentation.
        * */

    }
}
