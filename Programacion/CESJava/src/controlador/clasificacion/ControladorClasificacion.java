package controlador.clasificacion;

import controlador.ControladorPrincipal;
import controlador.ControladorVista;
import modelo.Clasificacion;
import view.VentanaClasificacionAdmin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorClasificacion {
    private VentanaClasificacionAdmin vca;
    private ControladorVista cv;

    public ControladorClasificacion(ControladorVista cv) {
        this.cv=cv;
        vca = new VentanaClasificacionAdmin();
        vca.setVisible(true);
        vca.getTaClasi().setEditable(false);
        llenarCB();

    }
        public void llenarCB (){
            try {
                ArrayList<Clasificacion> lista = cv.clasiEquipos();
                for (int x=0;x<lista.size();x++){
                    vca.getCbClasi().setSelectedIndex(lista.get(x).getCodequipo().getCodEquipo());
                }
            }catch (Exception ex){

            }

        }
    }

