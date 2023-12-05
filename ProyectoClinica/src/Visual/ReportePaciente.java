package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Paciente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ReportePaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtIdVacuna;
	private JTextField txtDescripcion;
	private JTextField txtCedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ReportePaciente dialog = new ReportePaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ReportePaciente() {
		setTitle("Reporte de Paciente");
		setBounds(100, 100, 628, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 192, 203));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(10, 65, 54, 14);
			panel.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setEnabled(false);
			txtNombre.setBounds(67, 62, 166, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("ID:");
			lblNewLabel_1.setBounds(18, 26, 46, 14);
			panel.add(lblNewLabel_1);
			
			txtIdVacuna = new JTextField();
			txtIdVacuna.setBounds(67, 23, 166, 20);
			panel.add(txtIdVacuna);
			txtIdVacuna.setColumns(10);
			
		    JButton btnBuscar = new JButton("Buscar");
		    btnBuscar.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        
		            buscarID();
		        }
		    });
		    btnBuscar.setBounds(243, 23, 80, 20);
		    panel.add(btnBuscar);

			
			JLabel lblNewLabel_3 = new JLabel("Diagnosticar Enfermedades: ");
			lblNewLabel_3.setBounds(10, 169, 173, 14);
			panel.add(lblNewLabel_3);
			
			JComboBox cmbDiagnostico = new JComboBox();
			cmbDiagnostico.setBounds(10, 207, 141, 20);
			panel.add(cmbDiagnostico);
			
			JLabel lblNewLabel_4 = new JLabel("Descripcion de Paciente:");
			lblNewLabel_4.setBounds(334, 34, 147, 14);
			panel.add(lblNewLabel_4);
			
			txtDescripcion = new JTextField();
			txtDescripcion.setBounds(334, 59, 225, 316);
			panel.add(txtDescripcion);
			txtDescripcion.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(10, 109, 46, 14);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.setEditable(false);
			txtCedula.setEnabled(false);
			txtCedula.setColumns(10);
			txtCedula.setBounds(67, 106, 166, 20);
			panel.add(txtCedula);
			
			JLabel lblVacunasSugeridas = new JLabel("Vacunas Sugeridas: ");
			lblVacunasSugeridas.setBounds(10, 279, 173, 14);
			panel.add(lblVacunasSugeridas);
			
			JComboBox cmbVacunas = new JComboBox();
			cmbVacunas.setBounds(10, 304, 141, 20);
			panel.add(cmbVacunas);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	  private void buscarID() {
	        String idPaciente = txtIdVacuna.getText();
	        if (!idPaciente.isEmpty()) {
	            Paciente paciente = Clinica.getInstance().obtenerPacienteById(idPaciente);
	            if (paciente != null) {
	                txtNombre.setText(paciente.getNombre());
	                txtCedula.setText(paciente.getCedula());
                

	                txtNombre.setEnabled(false);
	                txtCedula.setEnabled(false);

	                JOptionPane.showMessageDialog(null, "Paciente encontrado.");
	            } else {
	            	txtNombre.setEnabled(true);
	                txtCedula.setEnabled(true);

	                JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
	            }
	        }
	    }
	}
