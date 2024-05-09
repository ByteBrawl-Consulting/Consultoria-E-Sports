package controlador.baseDeDatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TablaEquipos {
    private EntityManager em;
    private EntityManagerFactory emf;
    private EntityTransaction transaction;
    public TablaEquipos(EntityManager em, EntityManagerFactory emf, EntityTransaction transaction){
        this.em = em;
        this.emf = emf;
        this.transaction = transaction;
    }
    public void altaEquipo(Equipos e){
        transaction.begin();
        em.persist(e);
        transaction.commit();
    }
    public void bajaEquipo(Equipos e){
        transaction.begin();
        em.remove(e);
        transaction.commit();
    }
    public void modificarEquipo(Equipos e){
        // Buscar el equipo existente en la base de datos
        Equipos equipoexistente = em.find(Equipos.class, e.getNombre());
        if (equipoexistente == null) {
            try {
                throw new Exception("La persona con DNI " + e.getNombre() + " no existe");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        // Comenzar la transacción
        transaction.begin();
        // Actualizar los atributos de la persona existente con los de la nueva persona
        equipoexistente.setNombre(e.getNombre()); // Actualizar nombre u otros atributos según sea necesario
        // Commit de la transacción
        transaction.commit();

    }
    public void consultaEquipo(Equipos e){
        transaction.begin();

    }
}
