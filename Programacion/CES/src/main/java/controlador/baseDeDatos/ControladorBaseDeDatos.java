package controlador.baseDeDatos;

import controlador.ControladorPrincipal;
import modelo.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ControladorBaseDeDatos {
    private ControladorPrincipal cp;
    private TablaUsuarios tu;
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction transaction;
    public ControladorBaseDeDatos(ControladorPrincipal cp) {
        this.cp=cp;
        emf=Persistence.createEntityManagerFactory("default");
        em=emf.createEntityManager();
        transaction=em.getTransaction();
        tu=new controlador.baseDeDatos.TablaUsuarios(em,emf,transaction);
    }
    public String login (Usuarios usu){
        System.out.println("bd");
       return tu.login(usu);
    }
}
