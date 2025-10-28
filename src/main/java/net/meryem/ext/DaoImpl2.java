package net.meryem.ext;

import net.meryem.dao.IDao;

public class DaoImpl2 implements IDao {

    @Override
    public double getData() {
        System.out.println("Version Web Service");
        double t = 55;
        return t;
    }
}