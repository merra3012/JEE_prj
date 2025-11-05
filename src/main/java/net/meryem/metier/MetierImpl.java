package net.meryem.metier;
import net.meryem.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    @Autowired //Ici c'est comme on dit a Spring: "Quand tu cree un obj de MetierImpl, affecte a la var 'dao' un obj de type IDao"
    //Mais @Autowired est déconseillé, car Spring prefere l'injection via constructeur plusque via le setter ou via la propriete.
    @Qualifier("dao3") //donc a chaque fois on veut changer la version il faut juste changer le contenu entre prentheses
    private IDao dao;  //couplage faible

    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t * 12 * (Math.PI/2);
        return res;
    }
    // Maintenant j'ai 2 facons pour remplir la valeur de l'attribut dao: soit avec un constructeur ou avec un setter.
    // Ou bien plutot l'expression exacte de ce processus s'appelle:
    // "Injecter dans l'attribut 'dao' un objet d'une classe qui implemente l'interface IDao"
    /*  1ere FACON:
      Je cree un constructeur avec parametre que je dois passer au moment de l'instantiation.
      Ce dernier qui va s'attribuer automatiquement a l'attr 'dao'
      * */
    public MetierImpl(IDao dao) {this.dao = dao;}
    /*  2eme FACON:
      Je cree un setter. Pour ce faire il faut avoir un constructeur sans parametres.
      * */
    public MetierImpl() {}
    public void setDao(IDao dao) { this.dao = dao; }
}