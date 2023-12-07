package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Enfermedad;
import Logical.Paciente;
import Logical.archivoManager;

import java.awt.Color;

public class ReportePaciente extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtNombre;
    private JTextField txtIdVacuna;
    private JTextArea txtDescripcion;
    private JTextField txtCedula;
    private JTable tableEnfermedades;
    private static DefaultTableModel modeloEnfermedades;
    private static Object[] rowEnfermedades;

    public static void main(String[] args) {
        try {
            ReportePaciente dialog = new ReportePaciente();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ReportePaciente() {
        setTitle("Reporte de Paciente");
        setBounds(100, 100, 705, 673);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBackground(new Color(224, 255, 255));
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Nombre:");
        lblNewLabel.setBounds(10, 65, 54, 14);
        contentPanel.add(lblNewLabel);

        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        txtNombre.setEnabled(false);
        txtNombre.setBounds(67, 62, 166, 20);
        contentPanel.add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setBounds(18, 26, 46, 14);
        contentPanel.add(lblNewLabel_1);

        txtIdVacuna = new JTextField();
        txtIdVacuna.setBounds(67, 23, 166, 20);
        contentPanel.add(txtIdVacuna);
        txtIdVacuna.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // buscarID();
            }
        });
        btnBuscar.setBounds(243, 23, 80, 20);
        contentPanel.add(btnBuscar);

        JLabel lblNewLabel_3 = new JLabel("Diagnosticar Enfermedades: ");
        lblNewLabel_3.setBounds(10, 421, 173, 14);
        contentPanel.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Descripcion de Paciente:");
        lblNewLabel_4.setBounds(334, 34, 147, 14);
        contentPanel.add(lblNewLabel_4);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(334, 59, 225, 316);
        contentPanel.add(scrollPane);

        txtDescripcion = new JTextArea();
        scrollPane.setViewportView(txtDescripcion);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);

        JLabel lblCedula = new JLabel("Cedula:");
        lblCedula.setBounds(10, 109, 46, 14);
        contentPanel.add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setEditable(false);
        txtCedula.setEnabled(false);
        txtCedula.setColumns(10);
        txtCedula.setBounds(67, 106, 166, 20);
        contentPanel.add(txtCedula);

        JLabel lblVacunasSugeridas = new JLabel("Vacunas Sugeridas: ");
        lblVacunasSugeridas.setBounds(10, 147, 173, 14);
        contentPanel.add(lblVacunasSugeridas);

        JComboBox cmbVacunas = new JComboBox();
        cmbVacunas.setBounds(10, 172, 141, 20);
        contentPanel.add(cmbVacunas);

       
        JScrollPane scrollPaneEnfermedades = new JScrollPane();
        scrollPaneEnfermedades.setBounds(10, 446, 549, 150);
        contentPanel.add(scrollPaneEnfermedades);

       
        modeloEnfermedades = new DefaultTableModel();
        String headersEnfermedades[] = { "Nombre", "Código", "Síntomas" };
        modeloEnfermedades.setColumnIdentifiers(headersEnfermedades);

        tableEnfermedades = new JTable();
        tableEnfermedades.getTableHeader().setReorderingAllowed(false);
        scrollPaneEnfermedades.setViewportView(tableEnfermedades);
        tableEnfermedades.setModel(modeloEnfermedades);

 

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);

        JButton okButton = new JButton("Agregar");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton);
        
        cargarDatosDesdeArchivo("enfermedad.txt");
    }


    
    private void cargarDatosDesdeArchivo(String archivo) {
        ArrayList<Enfermedad> listaEnf = archivoManager.leerEnfermedad();
        DefaultTableModel model = (DefaultTableModel) tableEnfermedades.getModel();

      
        model.setRowCount(0);

        for (Enfermedad enfermedad : listaEnf) {
            model.addRow(new Object[]{enfermedad.getNombreEnfermedad(), enfermedad.getIdEnfermedad(), enfermedad.getSintomas()});
        }
    }
}