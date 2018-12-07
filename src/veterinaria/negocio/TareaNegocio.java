/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.negocio;

import entidades.AsignacionTareas;
import entidades.Tarea;
import entidades.TareaObservaciones;
import entidades.UsuarioEn;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import veterinaria.persistencia.TareaDAO;
import veterinaria.persistencia.UsuarioHelper;

import static veterinaria.vista.frMenu.jPanelPrincipal;
import veterinaria.vista.jpAsignarTarea;
import veterinaria.vista.jpMenuTareas;
import veterinaria.vista.jpNuevaTarea;

/**
 *
 * @author felipe
 */
public class TareaNegocio {

    TareaDAO tarea = new TareaDAO();
    private UsuarioEn user = UsuarioHelper.user;

    public void menuTareas() {

        jpMenuTareas jpMenuTareas = new jpMenuTareas();
        jpMenuTareas.setSize(1130, 570);
        jPanelPrincipal.removeAll();
        jPanelPrincipal.add(jpMenuTareas, BorderLayout.CENTER);
        jPanelPrincipal.revalidate();
        jPanelPrincipal.repaint();

    }

    public void nuevaTarea() {
        if (this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 5) {
            jpNuevaTarea jpNuevTarea = new jpNuevaTarea();
            jpNuevTarea.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpNuevTarea, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void crearTarea(Tarea t) {

        TareaDAO tDAO = new TareaDAO();
        boolean respuesta = tDAO.crearTarea(t);
        if (!respuesta) {
            menuTareas();
        }
    }

    public void asignarTarea(AsignacionTareas as) {
        TareaDAO tDAO = new TareaDAO();
        boolean respuesta = tDAO.asignarTarea(as);
        if (!respuesta) {
            menuTareas();
        }
    }

    public void asignarTarea() {
        if (this.user.getIdPerfil() == 2) {
            jpAsignarTarea jpAsignarTarea = new jpAsignarTarea();
            jpAsignarTarea.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpAsignarTarea, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void editarTarea(Tarea t) {
        TareaDAO tDAO = new TareaDAO();
        boolean respuesta = tDAO.editarTarea(t);
        if (!respuesta) {
            menuTareas();
        }
    }

    public void activarDesactivar() {
        if (this.user.getIdPerfil() == 2) {
            String idTarea = JOptionPane.showInputDialog("Ingrese el la tarea a modificar");
            TareaDAO tDAO = new TareaDAO();
            Tarea t = tDAO.buscar(idTarea);
            if (t != null) {
                boolean respuesta = tDAO.activarDesactivar(t);
                if (!respuesta) {
                    if (t.getActivo() == 1) {
                        JOptionPane.showMessageDialog(null, "Tarea desactivada.\n"
                                + "La tarea no será tenida en cuenta en los recordatorios enviados por el sistema");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tarea activada");
                    }
                }
                menuTareas();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

// carga el objeto 
    public void editarTarea() {
        if (this.user.getIdPerfil() == 2) {
            String idTarea = JOptionPane.showInputDialog("Ingrese el la tarea a modificar");
            Tarea t = buscar(idTarea);
            if (t != null) {
                jpNuevaTarea jpNuevTarea = new jpNuevaTarea(t);
                jpNuevTarea.setSize(1130, 570);
                jPanelPrincipal.removeAll();
                jPanelPrincipal.add(jpNuevTarea, BorderLayout.CENTER);
                jPanelPrincipal.revalidate();
                jPanelPrincipal.repaint();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public Tarea buscar(String idTarea) {
        if (tarea.buscar(idTarea).getId() == 0) {
            JOptionPane.showMessageDialog(null, "Tarea no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            return null;
        } else {
            return tarea.buscar(idTarea);
        }
    }

    public ArrayList<Tarea> lista() {
        return TareaDAO.lista(null);
    }

    public ArrayList<AsignacionTareas> listaTareasAsignadas(String andQuery) {
        return TareaDAO.listaTareasAsignadas(andQuery);
    }

    public void terminarTarea(String idTarea) {
        if (this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 3 || this.user.getIdPerfil() == 4 || this.user.getIdPerfil() == 6) {
            AsignacionTareas t = TareaDAO.buscarAsignadas(idTarea);
            TareaObservacionesNegocio tareaObs = new TareaObservacionesNegocio();
            if (t.getId() > 0) {
                String op1, op2;
                String opTerminar[] = {"Si", "No"};
                op1 = (String) JOptionPane.showInputDialog(null, "Desea terminar la tarea", "Menu",
                        1, null, opTerminar, opTerminar[0]);
                switch (op1) {
                    case "Si":
//                        if (t.getObjTarea().getActivo() == 1) {
                        tarea.terminarTareaAsignada(t);
                        do {
                            String opciones[] = {"Si", "No"};
                            op2 = (String) JOptionPane.showInputDialog(null, "Desea agregar una observación", "Menu",
                                    1, null, opciones, opciones[0]);
                            switch (op2) {
                                case "Si":
                                    TareaObservaciones obs = new TareaObservaciones();
                                    String strObs = JOptionPane.showInputDialog("Ingrese la observación");
                                    obs.setObservacion(strObs);
                                    obs.setIdTareaAsignada(t.getId());
                                    tareaObs.insetarObservacion(obs);
                                    break;
                                case "No":
                                    menuTareas();
                                    break;
                                default:
                                    menuTareas();
                                    break;
                            }
                        } while (op2.equals("Si"));
//                        } else {
//                            JOptionPane.showMessageDialog(null, "La tarea no se encuentra activa", "Error", JOptionPane.WARNING_MESSAGE);
//                        }
                        break;
                    default:
                        menuTareas();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }
}
