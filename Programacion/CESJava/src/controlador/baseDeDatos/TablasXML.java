package controlador.baseDeDatos;

import java.sql.Connection;

public class TablasXML {

    Connection con;
    ControladorBaseDeDatos cbd;

    public TablasXML(Connection con, ControladorBaseDeDatos cbd) {
        this.con = con;
        this.cbd = cbd;
    }
}
