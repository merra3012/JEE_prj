package net.meryem.pres;

import net.meryem.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresSpringAnnotation {
    public static void main(String[] args) {
        ApplicationContext springContext = new AnnotationConfigApplicationContext("net.meryem.dao", "net.meryem.metier");
        IMetier metier = springContext.getBean(IMetier.class);
        System.out.println(metier.calcul());

    }
}
