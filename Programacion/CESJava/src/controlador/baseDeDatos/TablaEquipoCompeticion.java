package controlador.baseDeDatos;

import java.sql.Connection;

public class TablaEquipoCompeticion {
    private Connection con;
    public TablaEquipoCompeticion(Connection con) {
        this.con = con;
    }
}
