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
	private JTable tableEnfermedadSelected;
	private static DefaultTableModel modeloNoSelected;
	private static Object[] rowNoSelected; 
	private static DefaultTableModel modeloSelected;
	private static Object[] rowSelected; 
	private int indexSelected;
	private int indexNoSelected;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private ArrayList<Enfermedad> enfermedadesSelected;
	private ArrayList<Enfermedad> enfermedadesNoSelected;

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
		setArrays();
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
		panel_EnfermedadNoSelected.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enfermedades no seleccionadas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_EnfermedadNoSelected.setBounds(10, 117, 219, 130);
		contentPanel.add(panel_EnfermedadNoSelected);
		panel_EnfermedadNoSelected.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel_EnfermedadNoSelected.add(scrollPane, BorderLayout.CENTER);
			
			modeloNoSelected = new DefaultTableModel();
			String headers[] = { "Nombre", "Codigo", "Sintomas" };
			modeloNoSelected.setColumnIdentifiers(headers);
			tableEnfermedadNoSelected = new JTable();
			tableEnfermedadNoSelected.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					indexNoSelected = tableEnfermedadNoSelected.getSelectedRow();
					if (indexNoSelected >= 0)
						btnAgregar.setEnabled(true);
					else {
						btnAgregar.setEnabled(false);
					}
				}
			});
			scrollPane.setViewportView(tableEnfermedadNoSelected);
			tableEnfermedadNoSelected.setModel(modeloNoSelected);
		}
		
		JPanel panel_panel_EnfermedadSelected = new JPanel();
		panel_panel_EnfermedadSelected.setBorder(new TitledBorder(null, "Enfermedades seleccionadas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_panel_EnfermedadSelected.setBounds(338, 117, 236, 130);
		contentPanel.add(panel_panel_EnfermedadSelected);
		panel_panel_EnfermedadSelected.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_panel_EnfermedadSelected.add(scrollPane, BorderLayout.CENTER);
		
		modeloSelected = new DefaultTableModel();
		String headers1[] = { "Nombre", "Codigo", "Sintomas" };
		modeloSelected.setColumnIdentifiers(headers1);
		tableEnfermedadSelected = new JTable();
		tableEnfermedadSelected.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indexSelected = tableEnfermedadSelected.getSelectedRow();
				if (indexSelected >= 0)
					btnQuitar.setEnabled(true);
				else {
					btnQuitar.setEnabled(false);
				}
			}
		});
		scrollPane.setViewportView(tableEnfermedadSelected);
		tableEnfermedadSelected.setModel(modeloSelected);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enfermedadesNoSelected.get(indexNoSelected).setEnfermedadIsSelected(true);
				btnAgregar.setEnabled(false);
				loadTableNoSelected();
				loadTableSelected();
			}
		});
		btnAgregar.setBounds(239, 144, 89, 23);
		contentPanel.add(btnAgregar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setEnabled(false);
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enfermedadesSelected.get(indexSelected)!=null)
					enfermedadesSelected.get(indexSelected).setEnfermedadIsSelected(false);
				btnQuitar.setEnabled(false);
				loadTableNoSelected();
				loadTableSelected();
			}
		});
		btnQuitar.setBounds(239, 178, 89, 23);
		contentPanel.add(btnQuitar);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(HacerConsulta.class.getResource("/imagenes/edificio-del-hospital (2).png")));
			lblNewLabel.setBounds(510, 258, 64, 70);
			contentPanel.add(lblNewLabel);
		}
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
						setDefault();
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
		loadTableNoSelected();
		loadTableSelected();
	}
	public void loadTableNoSelected() {
		  modeloNoSelected.setRowCount(0);
		  rowNoSelected = new Object[tableEnfermedadNoSelected.getColumnCount()];
		  if(Clinica.getInstance().getMisEnfermedades()!=null) {
			  for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
			        if(!enfermedad.isEnfermedadIsSelected()) {
					    rowNoSelected[0] = enfermedad.getNombreEnfermedad();
					    rowNoSelected[1] = enfermedad.getIdEnfermedad();
					    rowNoSelected[2] = enfermedad.getSintomas();
				        modeloNoSelected.addRow(rowNoSelected);
			        }
			    }
		  }
	}
	public void loadTableSelected() {
		  modeloSelected.setRowCount(0);
		  rowSelected = new Object[tableEnfermedadSelected.getColumnCount()];
		  if(Clinica.getInstance().getMisEnfermedades()!=null) {
			  for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
			        if(enfermedad.isEnfermedadIsSelected()) {
					    rowSelected[0] = enfermedad.getNombreEnfermedad();
					    rowSelected[1] = enfermedad.getIdEnfermedad();
					    rowSelected[2] = enfermedad.getSintomas();
				        modeloSelected.addRow(rowSelected);
			        }
			    }
		  }
	}
	public void setArrays() {
		int index = 0;
		if(Clinica.getInstance().getMisEnfermedades()!=null) {
			for (Enfermedad enfermedad : Clinica.getInstance().getMisEnfermedades()) {
		        if(enfermedad.isEnfermedadIsSelected()) {
				    enfermedadesSelected.add(Clinica.getInstance().getMisEnfermedades().get(index));
		        }
		        else {
		        	enfermedadesNoSelected.add(Clinica.getInstance().getMisEnfermedades().get(index));
		        }
		        index++;
		    }
		}
	}
	public void setDefault() {
		if(Clinica.getInstance().getMisEnfermedades()!=null) {
		
			for (Enfermedad enfermedad : enfermedadesSelected) {
		        if(enfermedad.isEnfermedadIsSelected()) {
				    enfermedad.setEnfermedadIsSelected(false);
		        }
		    }
		}
	}

}
