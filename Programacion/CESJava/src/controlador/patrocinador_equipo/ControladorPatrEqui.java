package controlador.patrocinador_equipo;

import controlador.ControladorVista;
import view.VentanaAsociacionPatroEqui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPatrEqui {
    private VentanaAsociacionPatroEqui vape;
    private ControladorVista cv;

    public ControladorPatrEqui(ControladorVista cv) {
        this.cv = cv;
        vape = new VentanaAsociacionPatroEqui();

        //placeholder

        vape.bAceptarAL(new bAceptar());
        vape.bSalirAL(new bSalir());
        vape.bRbAltaAL(new bAlta());
        vape.bRbBajaAL(new bBaja());
        vape.bRbModiAL(new bModi());
        vape.bRbConsPatrAL(new bConsPatr());
        vape.bRbConsEquiAL(new bConsEqui());
    }

    private class bSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.dispose();
        }
    }

    private class bAlta implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionAlta();
        }
    }

    private class bBaja implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionBaja();
        }
    }

    private class bModi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionModi();
        }
    }

    private class bConsPatr implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsPatr();
        }
    }

    private class bConsEqui implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vape.eleccionConsEqui();
        }
    }

    private class bAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (vape.getAltaRadioButton().isSelected()){

            }else if (vape.getBajaRadioButton().isSelected()){

            }else if (vape.getModificaciónRadioButton().isSelected()){

            }else if (vape.getConsultaPorPatrocinadorRadioButton().isSelected()){

            }else if (vape.getConsultaPorEquipoRadioButton().isSelected()){

            }
        }
    }
}
