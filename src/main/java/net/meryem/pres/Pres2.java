package net.meryem.pres;
import net.meryem.dao.IDao;
import net.meryem.metier.IMetier;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.io.File;
import static java.lang.Class.forName;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        //DaoImpl dao = new DaoImpl();
        Scanner sc = new Scanner(new File("config.txt"));
        String daoClassName = sc.nextLine();
        Class cDao = forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); //new Dao implementation (couplage faible)
        System.out.println(dao.getData());
        /*
        * maitenant on a assure que aussi cette classes depend juste des interfaces, puis grace a l'instanciation
        * dynamique(config.txt), on a rendu aussi cette classe Presentation fermee a la modif et ouverte a l'ext
        * */
        /*
        * Par la suite on veut utiliser la methode calcul du MetierImpl, ou on aura besoin de faire "Injection des dependances",
        * mais d''une maniere dynamique
        * */
        String metierClassName = sc.nextLine();
        Class cMetier = forName(metierClassName);
        IMetier metier =  (IMetier) cMetier.getConstructor().newInstance();
        Method setDao = cMetier.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(metier, dao); //injection des dependances dynamiquement.
        System.out.println("Resultat: " + metier.calcul());
    }
}
