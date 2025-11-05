package net.meryem.pres;

import net.meryem.dao.IDao;
import net.meryem.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.Class.forName;

public class Pres22 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner la classe de la couche dao: ");
        String daoClassName = sc.nextLine();
        Class cDao = forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); //new Dao implementation (couplage faible)

        System.out.println("Donner la classe de la couche metier: ");
        String metierClassName = sc.nextLine();
        Class cMetier = forName(metierClassName);
        IMetier metier =  (IMetier) cMetier.getConstructor().newInstance();
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier, dao); //injection des dependances dynamiquement.
        System.out.println("Resultat: " + metier.calcul());
    }
}
