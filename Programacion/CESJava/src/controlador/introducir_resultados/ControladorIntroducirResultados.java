package controlador.introducir_resultados;

import controlador.ControladorVista;
import modelo.Competicion;
import modelo.Enfrentamiento;
import view.VentanaIntroducirResultados;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class ControladorIntroducirResultados {

    private VentanaIntroducirResultados vir;
    private ControladorVista cv;

    public ControladorIntroducirResultados(ControladorVista cv) {
        this.cv = cv;
        this.vir = new VentanaIntroducirResultados();

        vir.getTfJornada().addFocusListener(new PlaceholderListener("Numero Jornada"));
        vir.getTfCodEnfrentamiento().addFocusListener(new PlaceholderListener("Codigo Enfrentamiento"));
        vir.getTfEquipoGanador().addFocusListener(new PlaceholderListener("Equipo Ganador"));

        vir.getTfJornadaModi().addFocusListener(new PlaceholderListener("Numero Jornada"));
        vir.getTfCodEnfreModi().addFocusListener(new PlaceholderListener("Codigo Enfrentamiento"));
        vir.getTfEquiGanadorModi().addFocusListener(new PlaceholderListener("Equipo Ganador"));

        vir.getTfJornada().getDocument().addDocumentListener(new JornadaDocumentListener());
        vir.getTfJornadaModi().getDocument().addDocumentListener(new JornadaDocumentListenerModi());

        vir.bAceptarAL(new bAceptar());
        vir.bSalirAL(new bSalir());

        vir.bRbAltaAL(new RadioButtonAltaListener());
        vir.bRbModiAl(new RadioButtonModiListener());

        llenarCB();

        mostrar();

        vir.getTaConsultaAlta().setEditable(false);
        vir.getTaConsultaAlta().setBackground(new Color(205, 205, 205));
        vir.getTaConsultaModi().setEditable(false);
        vir.getTaConsultaModi().setBackground(new Color(205, 205, 205));

        vir.setVisible(true);
    }

    public void mostrar() {
        vir.setVisible(true);
        vir.getpAlta().setVisible(false);
        vir.getpModi().setVisible(false);
    }

    public void llenarCB() {
        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vir.getCbCompeticion().addItem("Seleccione una competición");
            for (Competicion competicion : lista) {
                vir.getCbCompeticion().addItem(competicion.getNombre());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            ArrayList<Competicion> lista = cv.clasiEquipos();
            vir.getCbCompeticionModi().addItem("Seleccione una competición");
            for (Competicion competicion : lista) {
                vir.getCbCompeticionModi().addItem(competicion.getNombre());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private class JornadaDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            actualizarEnfrentamientos();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            actualizarEnfrentamientos();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            actualizarEnfrentamientos();
        }

        private void actualizarEnfrentamientos() {
            try {
                String nombreCompeticion = (String) vir.getCbCompeticion().getSelectedItem();
                if (nombreCompeticion == null || nombreCompeticion.equals("Seleccione una competición")) {
                    return;
                }
                String jornadaTexto = vir.getTfJornada().getText();
                if (jornadaTexto.isEmpty()) {
                    return;
                }
                int numJornada = Integer.parseInt(jornadaTexto);

                Competicion competicion = new Competicion();
                competicion.setNombre(nombreCompeticion);

                ArrayList<Enfrentamiento> enfrentamientos = cv.obtenerEnfrentamientosPorCompeticionYJornada(competicion, numJornada);

                StringBuilder resultados = new StringBuilder();
                for (Enfrentamiento enfrentamiento : enfrentamientos) {
                    resultados.append("Código de Enfrentamiento: ").append(enfrentamiento.getCodEnfrentamiento()).append("\n");
                    resultados.append("Hora: ").append(enfrentamiento.getHora()).append("\n");
                    resultados.append("Fecha: ").append(enfrentamiento.getFecha()).append("\n");
                    resultados.append("Resultado: ").append(enfrentamiento.getResultado()).append("\n");
                    resultados.append("Equipo Local: ").append(enfrentamiento.getCodEquipoLocal().getNombre()).append("\n");
                    resultados.append("Equipo Visitante: ").append(enfrentamiento.getCodEquipoVisitante().getNombre()).append("\n");
                    resultados.append("\n");
                }

                vir.getTaConsultaAlta().setText(resultados.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vir, "Error al obtener los enfrentamientos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class JornadaDocumentListenerModi implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            actualizarEnfrentamientosModi();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            actualizarEnfrentamientosModi();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            actualizarEnfrentamientosModi();
        }

        private void actualizarEnfrentamientosModi() {
            try {
                String nombreCompeticion = (String) vir.getCbCompeticionModi().getSelectedItem();
                if (nombreCompeticion == null || nombreCompeticion.equals("Seleccione una competición")) {
                    return;
                }
                String jornadaTexto = vir.getTfJornadaModi().getText();
                if (jornadaTexto.isEmpty()) {
                    return;
                }
                int numJornada = Integer.parseInt(jornadaTexto);

                Competicion competicion = new Competicion();
                competicion.setNombre(nombreCompeticion);

                ArrayList<Enfrentamiento> enfrentamientos = cv.obtenerEnfrentamientosPorCompeticionYJornada(competicion, numJornada);

                StringBuilder resultados = new StringBuilder();
                for (Enfrentamiento enfrentamiento : enfrentamientos) {
                    resultados.append("Código de Enfrentamiento: ").append(enfrentamiento.getCodEnfrentamiento()).append("\n");
                    resultados.append("Hora: ").append(enfrentamiento.getHora()).append("\n");
                    resultados.append("Fecha: ").append(enfrentamiento.getFecha()).append("\n");
                    resultados.append("Resultado: ").append(enfrentamiento.getResultado()).append("\n");
                    resultados.append("Equipo Local: ").append(enfrentamiento.getCodEquipoLocal().getNombre()).append("\n");
                    resultados.append("Equipo Visitante: ").append(enfrentamiento.getCodEquipoVisitante().getNombre()).append("\n");
                    resultados.append("\n");
                }

                vir.getTaConsultaModi().setText(resultados.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(vir, "Error al obtener los enfrentamientos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vir.getAltaRadioButton().isSelected()) {
                try {
                    String nombreCompe = String.valueOf(vir.getCbCompeticion().getSelectedItem());
                    String codEnfrentamiento = vir.getTfCodEnfrentamiento().getText();
                    String equipoGanador = vir.getTfEquipoGanador().getText();

                    if (codEnfrentamiento.isEmpty() || equipoGanador.isEmpty()) {
                        JOptionPane.showMessageDialog(vir, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    cv.insertarResultadoEnfrentamiento(codEnfrentamiento, equipoGanador, nombreCompe);

                    JOptionPane.showMessageDialog(vir, "Resultado insertado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(vir, "Error al insertar el resultado del enfrentamiento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (vir.getModificaciónRadioButton().isSelected()) {
                try {
                    String codEnfrentamiento = vir.getTfCodEnfreModi().getText();
                    String equipoGanador = vir.getTfEquiGanadorModi().getText();

                    if (codEnfrentamiento.isEmpty() || equipoGanador.isEmpty()) {
                        JOptionPane.showMessageDialog(vir, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    cv.actualizarResultadoEnfrentamiento(codEnfrentamiento, equipoGanador);

                    JOptionPane.showMessageDialog(vir, "Resultado actualizado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(vir, "Error al actualizar el resultado del enfrentamiento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vir.dispose();
        }
    }

    private class RadioButtonAltaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vir.eleccionAlta();
        }
    }

    private class RadioButtonModiListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vir.eleccionModi();
        }
    }

    public class PlaceholderListener implements FocusListener {
        private String placeholder;

        public PlaceholderListener(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        public void focusGained(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            JTextField textField = (JTextField) e.getSource();
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
            }
        }
    }
}
