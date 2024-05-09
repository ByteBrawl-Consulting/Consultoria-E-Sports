package controlador.BaseDeDatos;

import modelo.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TablaUsuarios {
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction transaction;

    public TablaUsuarios(EntityManager em, EntityManagerFactory emf, EntityTransaction transaction) {
        this.em = em;
        this.emf = emf;
        this.transaction = transaction;
    }

    public String login (Usuarios usu){
        System.out.println("tbd");
        String usuario=usu.getTipo();
        String pass = usu.getContraseña();
        transaction.begin();
        String usuariobd = em.createQuery("select tipo from Usuarios usu ", Usuarios.class).getSingleResult().getTipo();
        transaction.commit();
        System.out.println("ok");
        return null;
    }
}
