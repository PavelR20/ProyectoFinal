package Visual;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Medico;

import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarGeneral extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtCodeVivienda;
    private JTextField txtTelefono;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtxEspecialidad;
    private JSpinner spnFecha;
	private JRadioButton rdbtnPaciente;
	private JRadioButton rdbtnMedico;
	private JPanel panel_Medico;
	private JTextField textCodigoPaciente;
	private JTextField textFieldInfoEmergencia;
	private JPanel panel_Paciente;

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
        setBounds(100, 100, 756, 530);
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

            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setIcon(new ImageIcon(RegistrarGeneral.class.getResource("/imagenes/edificio-del-hospital (2).png")));
            lblNewLabel.setBounds(666, 374, 64, 73);
            panel.add(lblNewLabel);
            
            
            JPanel panel_DatosGenerales = new JPanel();
            panel_DatosGenerales.setBorder(new TitledBorder(null, "Datos generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel_DatosGenerales.setBackground(SystemColor.info);
            panel_DatosGenerales.setBounds(10, 11, 678, 203);
            panel.add(panel_DatosGenerales);
            panel_DatosGenerales.setLayout(null);
            
                        JLabel lblApellido = new JLabel("Cedula:");
                        lblApellido.setBounds(10, 26, 52, 14);
                        panel_DatosGenerales.add(lblApellido);
                        
                                    txtCedula = new JTextField();
                                    txtCedula.addKeyListener(new KeyAdapter() {
                                    	@Override
                                    	public void keyTyped(KeyEvent e) {
                                    		char key = e.getKeyChar();
                            				if (!Character.isDigit(key))
                            					e.consume();
                                    	}
                                    });
                                    txtCedula.setBounds(66, 23, 152, 20);
                                    panel_DatosGenerales.add(txtCedula);
                                    txtCedula.setColumns(10);
                                    
                                                JLabel lbltelefon = new JLabel("Telefono:");
                                                lbltelefon.setBounds(10, 110, 52, 14);
                                                panel_DatosGenerales.add(lbltelefon);
                                                
                                                            txtTelefono = new JTextField();
                                                            txtTelefono.setBounds(74, 107, 144, 20);
                                                            panel_DatosGenerales.add(txtTelefono);
                                                            txtTelefono.addKeyListener(new KeyAdapter() {
                                                                @Override
                                                                public void keyTyped(KeyEvent e) {
                                                                    char key = e.getKeyChar();
                                                                    if (!Character.isDigit(key))
                                                                        e.consume();
                                                                }
                                                            });
                                                            txtTelefono.setColumns(10);
                                                            
                                                                        JLabel lblNombre = new JLabel("Nombre:");
                                                                        lblNombre.setBounds(10, 69, 52, 14);
                                                                        panel_DatosGenerales.add(lblNombre);
                                                                        
                                                                                    txtNombre = new JTextField();
                                                                                    txtNombre.addKeyListener(new KeyAdapter() {
                                                                                    	@Override
                                                                                    	public void keyTyped(KeyEvent e) {
                                                                                    		char key = e.getKeyChar();
                                                                            				if (!Character.isAlphabetic(key))
                                                                            					e.consume();
                                                                                    	}
                                                                                    });
                                                                                    txtNombre.setBounds(66, 66, 152, 20);
                                                                                    panel_DatosGenerales.add(txtNombre);
                                                                                    txtNombre.setColumns(10);
                                                                                    
                                                                                                JLabel lblGenero = new JLabel("Genero:");
                                                                                                lblGenero.setBounds(10, 156, 52, 14);
                                                                                                panel_DatosGenerales.add(lblGenero);
                                                                                                
                                                                                                JComboBox comboBox = new JComboBox();
                                                                                                comboBox.setModel(new DefaultComboBoxModel(new String[] {"Elegir", "Masculino", "Femenino"}));
                                                                                                comboBox.setEditable(true);
                                                                                                comboBox.setMaximumRowCount(3);
                                                                                                comboBox.setBounds(82, 153, 94, 20);
                                                                                                panel_DatosGenerales.add(comboBox);
                                                                                                
                                                                                                rdbtnMedico = new JRadioButton("Medico");
                                                                                                rdbtnMedico.addActionListener(new ActionListener() {
                                                                                                	public void actionPerformed(ActionEvent e) {
                                                                                                		rdbtnPaciente.setSelected(false);
                                                                                                		panel_Medico.setVisible(true);
                                                                                                		panel_Paciente.setVisible(false);
                                                                                                	}
                                                                                                });
                                                                                                rdbtnMedico.setBackground(SystemColor.info);
                                                                                                rdbtnMedico.setBounds(402, 152, 109, 23);
                                                                                                panel_DatosGenerales.add(rdbtnMedico);
                                                                                                
                                                                                                rdbtnPaciente = new JRadioButton("Paciente");
                                                                                                rdbtnPaciente.addActionListener(new ActionListener() {
                                                                                                	public void actionPerformed(ActionEvent e) {
                                                                                                		rdbtnMedico.setSelected(false);
                                                                                                		panel_Medico.setVisible(false);
                                                                                                		panel_Paciente.setVisible(true);
                                                                                                	}
                                                                                                });
                                                                                                rdbtnPaciente.setBackground(SystemColor.info);
                                                                                                rdbtnPaciente.setBounds(402, 124, 109, 23);
                                                                                                panel_DatosGenerales.add(rdbtnPaciente);
                                                                                                
                                                                                                JLabel lblNewLabel_2 = new JLabel("Rol:");
                                                                                                lblNewLabel_2.setBounds(333, 128, 46, 14);
                                                                                                panel_DatosGenerales.add(lblNewLabel_2);
                                                                                                
                                                                                                spnFecha = new JSpinner();
                                                                                    			spnFecha.setBounds(402, 23, 123, 20);
                                                                                    			spnFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
                                                                                    			panel_DatosGenerales.add(spnFecha);
                                                                                    			
                                                                                    			JLabel lblNewLabel_3 = new JLabel("Fecha de Naciemiento:");
                                                                                    			lblNewLabel_3.setBounds(276, 26, 116, 14);
                                                                                    			panel_DatosGenerales.add(lblNewLabel_3);
                                                                                    			
                                                                                    			JLabel lblNewLabel_4 = new JLabel("Vivienda:");
                                                                                    			lblNewLabel_4.setBounds(276, 86, 52, 14);
                                                                                    			panel_DatosGenerales.add(lblNewLabel_4);
                                                                                    			                                                
                                                                                    			                                                panel_Medico = new JPanel();
                                                                                    			                                                panel_Medico.setBorder(new TitledBorder(null, "Datos de Medico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                                                                                    			                                                panel_Medico.setBackground(SystemColor.info);
                                                                                    			                                                panel_Medico.setBounds(10, 225, 653, 224);
                                                                                    			                                                panel.add(panel_Medico);
                                                                                    			                                                panel_Medico.setLayout(null);
                                                                                    			                                                panel_Medico.setVisible(false);
                                                                                    			                                                
                                                                                    			                                                            JLabel lblNewLabel_1 = new JLabel("Codigo:");
                                                                                    			                                                            lblNewLabel_1.setBounds(10, 25, 46, 14);
                                                                                    			                                                            panel_Medico.add(lblNewLabel_1);
                                                                                    			                                                            
                                                                                    			                                                                        txtCodeVivienda = new JTextField();
                                                                                    			                                                                        txtCodeVivienda.setBounds(65, 22, 77, 20);
                                                                                    			                                                                        panel_Medico.add(txtCodeVivienda);
                                                                                    			                                                                        txtCodeVivienda.setBackground(SystemColor.info);
                                                                                    			                                                                        txtCodeVivienda.setEnabled(false);
                                                                                    			                                                                        txtCodeVivienda.setText("Medico -" + Clinica.getInstance().generadorCodigoidMedico);
                                                                                    			                                                                        txtCodeVivienda.setColumns(10);
                                                                                    			                                                                        
                                                                                    			                                                                                    JLabel lblEspecialidad = new JLabel("Especialidad:");
                                                                                    			                                                                                    lblEspecialidad.setBounds(10, 74, 97, 14);
                                                                                    			                                                                                    panel_Medico.add(lblEspecialidad);
                                                                                    			                                                                                    
                                                                                    			                                                                                                txtxEspecialidad = new JTextField();
                                                                                    			                                                                                                txtxEspecialidad.addKeyListener(new KeyAdapter() {
                                                                                    			                                                                                                	@Override
                                                                                    			                                                                                                	public void keyTyped(KeyEvent e) {
                                                                                    			                                                                                                		char key = e.getKeyChar();
                                                                                    			                                                                                        				if (!Character.isAlphabetic(key))
                                                                                    			                                                                                        					e.consume();
                                                                                    			                                                                                                	}
                                                                                    			                                                                                                });
                                                                                    			                                                                                                txtxEspecialidad.setBounds(86, 71, 185, 20);
                                                                                    			                                                                                                panel_Medico.add(txtxEspecialidad);
                                                                                    			                                                                                                txtxEspecialidad.setColumns(10);
                                                                                    			                                                                                                
                                                                                    			                                                                                                panel_Paciente = new JPanel();
                                                                                    			                                                                                                panel_Paciente.setBorder(new TitledBorder(null, "Datos Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                                                                                    			                                                                                                panel_Paciente.setBackground(SystemColor.info);
                                                                                    			                                                                                                panel_Paciente.setBounds(10, 223, 646, 224);
                                                                                    			                                                                                                panel.add(panel_Paciente);
                                                                                    			                                                                                                panel_Paciente.setLayout(null);
                                                                                    			                                                                                                panel_Paciente.setVisible(false);
                                                                                    			                                                                                                JLabel lblNewLabel_5 = new JLabel("Codigo:");
                                                                                    			                                                                                                lblNewLabel_5.setBounds(10, 36, 46, 14);
                                                                                    			                                                                                                panel_Paciente.add(lblNewLabel_5);
                                                                                    			                                                                                                
                                                                                    			                                                                                                textCodigoPaciente = new JTextField("Paciente - "+Clinica.getInstance().generadorCodigoPaciente);
                                                                                    			                                                                                                textCodigoPaciente.setEnabled(false);
                                                                                    			                                                                                                textCodigoPaciente.setBounds(66, 33, 86, 20);
                                                                                    			                                                                                                panel_Paciente.add(textCodigoPaciente);
                                                                                    			                                                                                                textCodigoPaciente.setColumns(10);
                                                                                    			                                                                                                
                                                                                    			                                                                                                JLabel lblNewLabel_6 = new JLabel("Informacion de emergencia:");
                                                                                    			                                                                                                lblNewLabel_6.setBounds(10, 83, 142, 14);
                                                                                    			                                                                                                panel_Paciente.add(lblNewLabel_6);
                                                                                    			                                                                                                
                                                                                    			                                                                                                textFieldInfoEmergencia = new JTextField();
                                                                                    			                                                                                                textFieldInfoEmergencia.setBounds(171, 80, 281, 20);
                                                                                    			                                                                                                panel_Paciente.add(textFieldInfoEmergencia);
                                                                                    			                                                                                                textFieldInfoEmergencia.setColumns(10);
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
