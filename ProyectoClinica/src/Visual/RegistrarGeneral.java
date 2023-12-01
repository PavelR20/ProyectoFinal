package Visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Medico;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class RegistrarGeneral extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodeVivienda;
    private JTextField txtTelefono;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtxEspecialidad;
    private JTextField txtGenero;

    public static void main(String[] args) {
        try {
            RegistrarGeneral dialog = new RegistrarGeneral();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public RegistrarGeneral() {
        setTitle("Registrar");
        setBounds(100, 100, 473, 409);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            panel.setBackground(SystemColor.info);
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            JLabel lblNewLabel_1 = new JLabel("Codigo:");
            lblNewLabel_1.setBounds(10, 24, 46, 14);
            panel.add(lblNewLabel_1);

            txtCodeVivienda = new JTextField();
            txtCodeVivienda.setBackground(SystemColor.info);
            txtCodeVivienda.setEnabled(false);
            txtCodeVivienda.setText("Medico -" + Clinica.getInstance().generadorCodigoidMedico);
            txtCodeVivienda.setBounds(66, 21, 77, 20);
            panel.add(txtCodeVivienda);
            txtCodeVivienda.setColumns(10);

            JLabel lbltelefon = new JLabel("Telefono:");
            lbltelefon.setBounds(10, 133, 52, 14);
            panel.add(lbltelefon);

            txtTelefono = new JTextField();
            txtTelefono.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char key = e.getKeyChar();
                    if (!Character.isDigit(key))
                        e.consume();
                }
            });
            txtTelefono.setBounds(10, 158, 144, 20);
            panel.add(txtTelefono);
            txtTelefono.setColumns(10);

            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(RegistrarGeneral.class.getResource("/imagenes/edificio-del-hospital (2).png")));
            lblNewLabel.setBounds(383, 253, 64, 73);
            panel.add(lblNewLabel);

            JLabel lblNombre = new JLabel("Nombre:");
            lblNombre.setBounds(234, 65, 52, 14);
            panel.add(lblNombre);

            JLabel lblApellido = new JLabel("Cedula:");
            lblApellido.setBounds(10, 65, 52, 14);
            panel.add(lblApellido);

            txtNombre = new JTextField();
            txtNombre.setColumns(10);
            txtNombre.setBounds(234, 90, 163, 20);
            panel.add(txtNombre);

            txtCedula = new JTextField();
            txtCedula.setColumns(10);
            txtCedula.setBounds(10, 90, 163, 20);
            panel.add(txtCedula);

            JLabel lblGenero = new JLabel("Genero:");
            lblGenero.setBounds(234, 133, 52, 14);
            panel.add(lblGenero);

            txtxEspecialidad = new JTextField();
            txtxEspecialidad.setColumns(10);
            txtxEspecialidad.setBounds(10, 224, 185, 20);
            panel.add(txtxEspecialidad);

            JLabel lblEspecialidad = new JLabel("Especialidad:");
            lblEspecialidad.setBounds(10, 199, 97, 14);
            panel.add(lblEspecialidad);
            
            txtGenero = new JTextField();
            txtGenero.setColumns(10);
            txtGenero.setBounds(234, 158, 163, 20);
            panel.add(txtGenero);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setBackground(SystemColor.info);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
            	 /*  JButton btnRegistrar = new JButton("Registrar");
                btnRegistrar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Medico medicoReg = new Medico(txtCedula.getText(), txtNombre.getText(),
                               txtGenero.getText(), txtTelefono.getText(), txtxEspecialidad.getText());
                        Clinica.getInstance().getMisMedico().add(medicoReg);
                   
                });
                btnRegistrar.setActionCommand("OK");
                buttonPane.add(btnRegistrar);
                getRootPane().setDefaultButton(btnRegistrar);
            }
            { }*/
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

  
}
