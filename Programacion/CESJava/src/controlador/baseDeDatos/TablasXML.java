package controlador.baseDeDatos;

import javax.swing.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * La clase TablasXML se encarga de interactuar con la base de datos para
 * generar y recuperar datos en formato XML desde tablas temporales.
 */

public class TablasXML {

   private Connection con;
   private ControladorBaseDeDatos cbd;

    /**
     * Constructor de la clase TablasXML.
     *
     * @param con Conexión a la base de datos.
     * @param cbd Instancia de ControladorBaseDeDatos.
     */

    public TablasXML(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
        proceXML();
    }

    /**
     * Ejecuta un procedimiento almacenado en la base de datos para generar
     * todas las jornadas en formato XML.
     */

    public void proceXML() {
        try {
            String proce = "GESTION_XML.generar_todas_jornadas";
            String plantilla = "{call " + proce + "(?)}";
            CallableStatement cal = con.prepareCall(plantilla);
            cal.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se ha podido ejecutar el paquete XML");
        }
    }

    /**
     * Genera y retorna un XML con la clasificación.
     *
     * @return Un string que contiene el XML de la clasificación, o null si ocurre un error.
     */

    public String generarXMLClasificacion() {
        try {
            String plantilla = "select * from TEMP_CLASIFICACION_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en generar clasificacion XML "+e.getMessage());
        }
        return null;
    }

    /**
     * Genera y retorna un XML con la última jornada.
     *
     * @return Un string que contiene el XML de la última jornada, o null si ocurre un error.
     */

    public String generarXMLJornada() {
        try {
            String plantilla = "select * from TEMP_ULTIMA_JORNADA_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en generar ultima jornada XML "+e.getMessage());

        }
        return null;
    }

    /**
     * Genera y retorna un XML con todas las jornadas.
     *
     * @return Un string que contiene el XML de todas las jornadas, o null si ocurre un error.
     */

    public String generarXMLTodasJornadas() {
        try {
            String plantilla = "select * from TEMP_JORNADAS_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en generar todas las jornadas XML "+e.getMessage());
        }
        return null;
    }
}
