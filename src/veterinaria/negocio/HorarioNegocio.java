/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.negocio;

import Conexion.Conexion;
import entidades.Horarios;
import entidades.UsuarioEn;
import java.awt.BorderLayout;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import veterinaria.persistencia.HorarioDAO;
import veterinaria.persistencia.TareaDAO;
import veterinaria.persistencia.UsuarioHelper;
import static veterinaria.vista.frMenu.jPanelPrincipal;
import veterinaria.vista.jpMenuHorarios;
import veterinaria.vista.jpNuevoTurno;

/**
 *
 * @author felipe
 */
public class HorarioNegocio {

    TareaDAO tarea = new TareaDAO();
    private UsuarioEn user = UsuarioHelper.user;

    public void menuHorarios() {
        if (this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 6 || this.user.getIdPerfil() == 5 || this.user.getIdPerfil() == 3) {
            jpMenuHorarios jpMenuHorarios = new jpMenuHorarios();
            jpMenuHorarios.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpMenuHorarios, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void nuevoTurno() {
        if (this.user.getIdPerfil() == 2) {
            jpNuevoTurno jpNuevoTurno = new jpNuevoTurno();
            jpNuevoTurno.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpNuevoTurno, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void crearTurno(Horarios h) {

        HorarioDAO tDAO = new HorarioDAO();
        boolean respuesta = tDAO.crearTurno(h);
        if (!respuesta) {
            menuHorarios();
        }
    }

    public ArrayList<Horarios> lista(String andQuery) {
        if (this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 6 || this.user.getIdPerfil() == 3 || this.user.getIdPerfil() == 5) {
            return HorarioDAO.lista(andQuery);
        } else {
            ArrayList<Horarios> horariosLista = new ArrayList<>();
            return horariosLista;
        }
    }

    public void generarReporte() throws SQLException, JRException {
        String ruta = new File("src\\reportes\\reporteHorario.jasper").getAbsolutePath();
        Connection conn = Conexion.getConnection();
        // descarga dentro del mismo proyecto
        JasperPrint jasperPrint = JasperFillManager.fillReport(ruta, null, conn);
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteAlumnos.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();

        // se muestra en una ventana aparte para su descarga
        JasperPrint jasperPrintWindow = JasperFillManager.fillReport(ruta, null, conn);
        JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
        jasperViewer.setVisible(true);
    }
}
