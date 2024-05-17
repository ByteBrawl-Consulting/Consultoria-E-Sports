package controlador.baseDeDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TablaPatrocinadorEquipo {

    private Connection con;
    private TablaEquipos tablaEquipos;
    private TablaPatrocinadores tablaPatrocinadores;

    public TablaPatrocinadorEquipo(Connection con, TablaEquipos tablaEquipos, TablaPatrocinadores tablaPatrocinadores) {
        this.con = con;
        this.tablaEquipos = tablaEquipos;
        this.tablaPatrocinadores = tablaPatrocinadores;
    }

    public void altaPatrocinadorEquipo(String nombreEquipo, String nombreCompeticion) {
        try {

        } catch (Exception e) {
            e.printStackTrace(); // Logs Depuracion
            throw new RuntimeException(e);
        }
    }

    public void bajaPatrocinadorEquipo(String nombreEquipo, String nombreCompeticion) {
        try {

        } catch (Exception e) {
            e.printStackTrace(); // Logs Depuracion
            throw new RuntimeException(e);
        }
    }
}
