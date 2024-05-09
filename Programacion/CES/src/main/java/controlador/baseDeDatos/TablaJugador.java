package controlador.baseDeDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TablaJugador {
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction transaction;
    public TablaJugador(EntityManager em, EntityManagerFactory emf, EntityTransaction transaction){
        this.em = em;
        this.emf = emf;
        this.transaction = transaction;
    }
    public void altaJugador(Jugadores j){
        //Inserta un Jugador
        transaction.begin();
        em.persist(j);
        transaction.commit();
    }
    public void consultaJugador(Jugadores j){
        //Select de Jugador
    }
    public void borrarJugador(Jugadores j){
        transaction.begin();
        em.remove(j);
        transaction.commit();
    }
}
