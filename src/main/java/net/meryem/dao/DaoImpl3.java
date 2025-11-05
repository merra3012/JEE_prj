package net.meryem.dao;

import org.springframework.stereotype.Component;

//@Component cree un obj de type DaoImpl
@Component("dao3")
public class DaoImpl3 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version capteur");
        double t = 9;
        return t;
    }
}
