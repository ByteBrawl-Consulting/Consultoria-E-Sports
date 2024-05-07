package Controlador.BaseDeDatos;

import Controlador.ControladorPrincipal;
import Modelo.Usuarios;
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
    public ControladorBaseDeDatos() {
        emf=Persistence.createEntityManagerFactory("default");
        em=emf.createEntityManager();
        transaction=em.getTransaction();
        tu=new TablaUsuarios(em,emf,transaction);
    }
    public void login (Usuarios usu){
        tu.login(usu);
    }
}
