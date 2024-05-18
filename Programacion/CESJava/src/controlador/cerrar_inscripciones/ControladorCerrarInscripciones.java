package controlador.cerrar_inscripciones;

import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Equipo;
import view.VentanaCerrarInscripciones;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ControladorCerrarInscripciones {
    private VentanaCerrarInscripciones vci;
    private ControladorVista cv;

    public ControladorCerrarInscripciones(ControladorVista cv) {
        this.cv = cv;

        vci = new VentanaCerrarInscripciones();

        llenarCB();

        vci.getTaConsulta().setEditable(false);
        vci.getTaConsulta().setBackground(new Color(205, 205, 205));

        // Agregar el ItemListener al JComboBox
        vci.getCbCompeticion().addItemListener(new ItemListenerCompeticion());
        vci.bAceptarAL(new bAceptar());
        vci.bSalirAL(new bSalir());

        vci.setVisible(true);
    }

    public void llenarCB() {
        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vci.getCbCompeticion().addItem("Seleccione una competición");
            for (Competicion competicion : lista) {
                vci.getCbCompeticion().addItem(competicion.getNombre());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class ItemListenerCompeticion implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String competicionSeleccionada = (String) e.getItem();
                if (!"Seleccione una competición".equals(competicionSeleccionada)) {
                    Competicion com = new Competicion();
                    com.setNombre(competicionSeleccionada);
                    ArrayList<Equipo> lista = cv.getEquiposPorCompeticion(com);

                    StringBuilder total = new StringBuilder();
                    for (Equipo equipos : lista) {
                        Equipo equipo = cv.getNombreEquipoPorCodigo(equipos.getCodEquipo());
                        total.append(equipo.getNombre()).append("\n");
                    }
                    vci.getTaConsulta().setText(total.toString());
                } else {
                    vci.getTaConsulta().setText("");
                }
            }
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String competicionSeleccionada = vci.getCbCompeticion().getSelectedItem().toString();

            if (!"Seleccione una competición".equals(competicionSeleccionada)) {
                cv.cerrarIncripcionCompeticion(competicionSeleccionada);
            }
        }
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vci.dispose();
        }
    }
}
