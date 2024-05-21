package controlador.baseDeDatos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TablasXML {

    Connection con;
    ControladorBaseDeDatos cbd;

    public TablasXML(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
        proceXML();
    }

    public void proceXML() {
        try {
            String proce = "GESTION_XML.generar_todas_jornadas";
            String plantilla = "{call " + proce + "(?)}";
            CallableStatement cal = con.prepareCall(plantilla);
            cal.execute();
        } catch (Exception e) {
        }
    }

    public String generarXMLClasificacion() {
        try {
            String plantilla = "select * from TEMP_CLASIFICACION_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
        }
        return null;
    }

    public String generarXMLJornada() {
        try {
            String plantilla = "select * from TEMP_ULTIMA_JORNADA_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
        }
        return null;
    }

    public String generarXMLTodasJornadas() {
        try {
            String plantilla = "select * from TEMP_JORNADAS_TAB";
            PreparedStatement pre = con.prepareCall(plantilla);
            ResultSet res = pre.executeQuery();
            res.next();
            String datos = res.getString(1);
            return datos;
        } catch (Exception e) {
        }
        return null;
    }
}


