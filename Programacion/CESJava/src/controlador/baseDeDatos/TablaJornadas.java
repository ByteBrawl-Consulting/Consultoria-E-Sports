package controlador.baseDeDatos;

import modelo.Competiciones;

import java.sql.Connection;

public class TablaJornadas {
    private Connection con;

    public TablaJornadas(Connection con) {
        this.con = con;
    }

    public void ultimaJornada(Competiciones com) {
        int numCompe = com.getCodCompe();
        String plantilla = "select max()"
    }
}
