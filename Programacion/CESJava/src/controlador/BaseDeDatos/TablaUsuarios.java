package controlador.BaseDeDatos;

public class TablaUsuarios {
   
        public void login (Usuarios usu){
        String usuario=usu.getTipo();
        String pass = usu.getContraseña();
        transaction.begin();
        String usuariobd = em.createQuery("select tipo from Usuarios usu ", Usuarios.class).getSingleResult().getTipo();
        transaction.commit();
        System.out.println("ok");
    }
}
