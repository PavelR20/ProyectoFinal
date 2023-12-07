package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Consultas;
import Logical.Enfermedad;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class HacerConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodMed;
	private JTextField txtCodePaciente;
	private JSpinner spnFecha;
	private JTextField txtConsulta;
	private JTable tableEnfermedadNoSelected;
	private static DefaultTableModel modeloNoSelected;
	private static Object[] rowNoSelected; 
	private JButton btnAgregar;
	private JButton btnQuitar;
	private ArrayList<Enfermedad> enfermedadesSelected;
	private JTextField txtEnfermedad;
	private Enfermedad consultEnfermedad = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerConsulta dialog = new HacerConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerConsulta() {
		enfermedadesSelected = new ArrayList<Enfermedad>();
		setTitle("Hacer Consulta");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.info);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtCodMed = new JTextField("Medico - ");
			txtCodMed.setBounds(406, 30, 86, 20);
			contentPanel.add(txtCodMed);
			txtCodMed.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo Medico:");
			lblNewLabel_1.setBounds(269, 33, 127, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Codigo Paciente:");
			lblNewLabel_2.setBounds(10, 66, 104, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtCodePaciente = new JTextField("Paciente - ");
			txtCodePaciente.setBounds(143, 63, 86, 20);
			contentPanel.add(txtCodePaciente);
			txtCodePaciente.setColumns(10);
		}
		{
			spnFecha = new JSpinner();
			spnFecha.setBounds(406, 61, 123, 20);
			spnFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(spnFecha);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Fecha Consulta:");
			lblNewLabel_3.setBounds(269, 66, 127, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Codigo Consulta:");
			lblNewLabel_4.setBounds(10, 30, 104, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtConsulta = new JTextField("Consulta - "+Clinica.generadorCodigoConsulta);
			txtConsulta.setEnabled(false);
			txtConsulta.setBounds(143, 30, 86, 20);
			contentPanel.add(txtConsulta);
			txtConsulta.setColumns(10);
		}
		
		JPanel panel_EnfermedadNoSelected = new JPanel();
		panel_EnfermedadNoSelected.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enfermedades ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_EnfermedadNoSelected.setBounds(355, 117, 219, 130);
		contentPanel.add(panel_EnfermedadNoSelected);
		panel_EnfermedadNoSelected.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel_EnfermedadNoSelected.add(scrollPane, BorderLayout.CENTER);
			
			modeloNoSelected = new DefaultTableModel();
			String headers[] = { "Nombre", "Codigo", "Sintomas" };
			modeloNoSelected.setColumnIdentifiers(headers);
			tableEnfermedadNoSelected = new JTable();
			tableEnfermedadNoSelected.getTableHeader().setReorderingAllowed(false);
			scrollPane.setViewportView(tableEnfermedadNoSelected);
			tableEnfermedadNoSelected.setModel(modeloNoSelected);
		}
		
		
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (consultEnfermedad != null) {
					enfermedadesSelected.add(consultEnfermedad);
					btnAgregar.setEnabled(false);
				}
				txtEnfermedad.setText("Enfermedad - ");
				
			}
		});
		btnAgregar.setBounds(256, 146, 89, 23);
		contentPanel.add(btnAgregar);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(HacerConsulta.class.getResource("/imagenes/edificio-del-hospital (2).png")));
			lblNewLabel.setBounds(510, 258, 64, 70);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_5 = new JLabel("Codigo de la Enfermedad:");
		lblNewLabel_5.setBounds(10, 128, 134, 14);
		contentPanel.add(lblNewLabel_5);
		
		txtEnfermedad = new JTextField();
		txtEnfermedad.setText("Enfermedad - ");
		txtEnfermedad.setBounds(10, 147, 104, 20);
		contentPanel.add(txtEnfermedad);
		txtEnfermedad.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				consultEnfermedad = Clinica.getInstance().obtenerEnfermedadById(txtEnfermedad.getText());
				if (consultEnfermedad != null) {
					btnAgregar.setEnabled(true);
				}
			}
		});
		btnBuscar.setBounds(124, 146, 89, 23);
		contentPanel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Consultas consultaReg = new Consultas(txtConsulta.getText(),(Date)spnFecha.getValue(),
								enfermedadesSelected, Clinica.getInstance().obtenerMedicoById(txtCodMed.getText()),
										Clinica.getInstance().obtenerPacienteById(txtCodePaciente.getText()));
						Clinica.getInstance().agregarConsulta(consultaReg);
						
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
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
		loadTable();
	}
	public void loadTable() {
		modeloNoSelected.setRowCount(0);
		rowNoSelected = new Object[tableEnfermedadNoSelected.getColumnCount()];
		if(Clinica.getInstance().getMisEnfermedades()!=null) {
			for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
			        
				rowNoSelected[0] = enfermedad.getNombreEnfermedad();
			    rowNoSelected[1] = enfermedad.getIdEnfermedad();
			    rowNoSelected[2] = enfermedad.getSintomas();
		        modeloNoSelected.addRow(rowNoSelected);
		        
		    	}
			}
	}
	public void clean() {
		txtCodePaciente.setText("Paciente - ");
		Clinica.getInstance().generadorCodigoConsulta++;
		txtConsulta.setText("Consulta - "+Clinica.getInstance().generadorCodigoConsulta);
		txtCodMed.setText("Medico - ");
		txtEnfermedad.setText("Enfermedad - ");
	}
	
}