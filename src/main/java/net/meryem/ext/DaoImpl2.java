package net.meryem.ext;

import net.meryem.dao.IDao;
import org.springframework.stereotype.Component;

@Component("dao2")
public class DaoImpl2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version Web Service");
        double t = 55;
        return t;
    }
}