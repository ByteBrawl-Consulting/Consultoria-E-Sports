package controlador.resultados_todas_jornadas;

import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Enfrentamiento;
import modelo.Equipo;
import view.VentanaResultadosTodasJornadas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * ControladorResultadosTJornadas es el controlador que gestiona la interacción entre la vista de resultados de todas
 * las jornadas (VentanaResultadosTodasJornadas) y el modelo de negocio a través del ControladorVista.
 */

public class ControladorResultadosTJornadas {
    private VentanaResultadosTodasJornadas vrtj;
    private ControladorVista cv;

    /**
     * Constructor de ControladorResultadosTJornadas.
     *
     * @param cv El controlador principal de la vista.
     */

    public ControladorResultadosTJornadas(ControladorVista cv) {
        this.cv = cv;

        vrtj = new VentanaResultadosTodasJornadas();

        llenarCB();

        vrtj.getTaConsulta().setEditable(false);
        vrtj.getTaConsulta().setBackground(new Color(205, 205, 205));

        vrtj.addCBCompeticionAL(new bAceptarJornada());
        vrtj.addBSalirAL(new bSalir());

        vrtj.setVisible(true);
    }

    /**
     * Método para llenar el ComboBox con las competiciones disponibles.
     */

    public void llenarCB() {
        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vrtj.getCbCompeticion().addItem("Seleccione una competición");
            for (int x = 0; x < lista.size(); x++) {
                vrtj.getCbCompeticion().addItem(lista.get(x).getNombre());
            }
        } catch (Exception ex) {
            // Manejo de excepciones
            ex.printStackTrace();
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Aceptar" para mostrar los resultados de todas las jornadas.
     */

    public class bAceptarJornada implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String competicionSeleccionada = vrtj.getCbCompeticion().getSelectedItem().toString();
            if (!competicionSeleccionada.equals("Seleccione una competición")) {
                Competicion com = new Competicion();
                com.setNombre(competicionSeleccionada);
                ArrayList<Enfrentamiento> lista = cv.obtenerTodasJornadas(com);

                StringBuilder total = new StringBuilder();
                for (Enfrentamiento enfre : lista) {
                    Equipo equipoLocal = cv.getNombreEquipoPorCodigo(enfre.getCodEquipoLocal().getCodEquipo());
                    Equipo equipoVisitante = cv.getNombreEquipoPorCodigo(enfre.getCodEquipoVisitante().getCodEquipo());

                    total.append("Número de jornada:  " ).append(enfre.getCodJornada().getNumJornada()).append("\n")
                            .append("Hora: ").append(enfre.getHora()).append("\n")
                            .append("Fecha del enfrentamiento: ").append(enfre.getFecha()).append("\n")
                            .append("Equipo Ganador: ").append(enfre.getResultado()).append("\n")
                            .append("Equipo local: ").append(equipoLocal.getNombre()).append("\n")
                            .append("Equipo visitante: ").append(equipoVisitante.getNombre()).append("\n")
                            .append(" --------------------------------------  \n");
                }
                vrtj.getTaConsulta().setText(total.toString());
            }
        }
    }

    /**
     * Clase interna que maneja el evento de clic en el botón "Salir".
     */

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vrtj.dispose();
        }
    }
}
