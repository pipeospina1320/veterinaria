/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.negocio;

import entidades.Personal;
import entidades.UsuarioEn;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import veterinaria.persistencia.PersonalDAO;
import veterinaria.persistencia.UsuarioHelper;
import static veterinaria.vista.frMenu.jPanelPrincipal;
import veterinaria.vista.jpConsultaPersonal;
import veterinaria.vista.jpMenuPersonal;
import veterinaria.vista.jpNuevoPersonal;

/**
 *
 * @author felipe
 */
public class PersonalNegocio {

    private UsuarioEn user = UsuarioHelper.user;

    public void menuPersonal() {
        if (this.user.getIdPerfil() == 1 || this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 3 || this.user.getIdPerfil() == 4) {
            jpMenuPersonal jpMenuPersonal = new jpMenuPersonal();
            jpMenuPersonal.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpMenuPersonal, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void nuevoPersonal() {
        if (this.user.getIdPerfil() == 1 || this.user.getIdPerfil() == 2) {
            jpNuevoPersonal jpNuevoPersonal = new jpNuevoPersonal(true);
            jpNuevoPersonal.setSize(1130, 570);
            jPanelPrincipal.removeAll();
            jPanelPrincipal.add(jpNuevoPersonal, BorderLayout.CENTER);
            jPanelPrincipal.revalidate();
            jPanelPrincipal.repaint();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void consultarPersonal() {
        if (this.user.getIdPerfil() == 1 || this.user.getIdPerfil() == 2 || this.user.getIdPerfil() == 3 || this.user.getIdPerfil() == 4) {
            String ducumento = JOptionPane.showInputDialog("Ingrese el documento a consultar");
            Personal p = PersonalDAO.buscarCedula(ducumento);
            if (p.getId() > 0) {
                jpConsultaPersonal consultaPersonal = new jpConsultaPersonal(p);
                consultaPersonal.setSize(1130, 570);
                jPanelPrincipal.removeAll();
                jPanelPrincipal.add(consultaPersonal, BorderLayout.CENTER);
                jPanelPrincipal.revalidate();
                jPanelPrincipal.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Cedula no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void editarPersonal() {
        if (this.user.getIdPerfil() == 1 || this.user.getIdPerfil() == 2) {
            String ducumento = JOptionPane.showInputDialog("Ingrese el documento a modificar");
            Personal p = PersonalDAO.buscarCedula(ducumento);
            if (p.getId() > 0) {
                jpNuevoPersonal jpNuevoPersonal = new jpNuevoPersonal(p);
                jpNuevoPersonal.setSize(1130, 570);
                jPanelPrincipal.removeAll();
                jPanelPrincipal.add(jpNuevoPersonal, BorderLayout.CENTER);
                jPanelPrincipal.revalidate();
                jPanelPrincipal.repaint();
            } else {
                JOptionPane.showMessageDialog(null, "Cedula no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void activarDesactivarPersonal() {
        if (this.user.getIdPerfil() == 1 || this.user.getIdPerfil() == 2) {
            String ducumento = JOptionPane.showInputDialog("Ingrese el documento a modificar");
            Personal p = PersonalDAO.buscarCedula(ducumento);
            boolean respuesta;
            if (p.getId() > 0) {
                String menu[] = {"Licencia", "Vacaciones", "Retiro"};
                String op;
                if (p.getActivo() == 1) {
                    op = (String) JOptionPane.showInputDialog(null, "Seleccione algo", "Menu",
                            1, null, menu, menu[0]);
                    switch (op) {
                        case "Licencia":
                            respuesta = PersonalDAO.activarDesactivarPersonal(0, "Licencia", p.getId());
                            if (!respuesta) {
                                JOptionPane.showMessageDialog(null, "Empleado Desctivado");
                                menuPersonal();
                            }
                            break;
                        case "Vacaciones":
                            respuesta = PersonalDAO.activarDesactivarPersonal(0, "Vacaciones", p.getId());
                            if (!respuesta) {
                                JOptionPane.showMessageDialog(null, "Empleado Desctivado");
                                menuPersonal();
                            }
                            break;
                        case "Retiro":
                            respuesta = PersonalDAO.activarDesactivarPersonal(0, "Retiro", p.getId());
                            if (!respuesta) {
                                JOptionPane.showMessageDialog(null, "Empleado Desctivado");
                                menuPersonal();
                            }
                            break;
                    }
                } else {
                    String opciones[] = {"Si", "No"};
                    op = (String) JOptionPane.showInputDialog(null, "Desea activar el empleado", "Menu",
                            1, null, opciones, opciones[0]);
                    switch (op) {
                        case "Si":
                            respuesta = PersonalDAO.activarDesactivarPersonal(1, "Activo", p.getId());
                            if (!respuesta) {
                                JOptionPane.showMessageDialog(null, "Empleado Activado");
                                menuPersonal();
                            }
                            break;
                        case "No":

                            break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cedula no encontrada", "Error", JOptionPane.WARNING_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene permisos");
        }
    }

    public void crearPersonal(Personal p) {
        PersonalDAO ph = new PersonalDAO();
        boolean respuesta = ph.crearPersona(p);
        if (!respuesta) {
            this.menuPersonal();
        }
    }

    public void modificarPersonal(Personal p) {
        boolean respuesta = PersonalDAO.modificarPersonal(p);
        if (!respuesta) {
            menuPersonal();
        }
    }

    public boolean validarPersonal(String doc) {
        boolean existe = false;
        Personal personal = null;
        try {
            personal = PersonalDAO.buscarCedula(doc);
            if (personal.getId() > 0) {
                existe = true;
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return existe;
    }

    public Personal buscar(String idPersonal) {
        if (PersonalDAO.buscar(idPersonal).getId() != 0) {
            return PersonalDAO.buscar(idPersonal);
        }
        return null;
    }
}
