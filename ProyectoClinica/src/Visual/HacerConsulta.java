package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
		setTitle("Hacer Consulta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtCodMed = new JTextField("Medico - ");
			txtCodMed.setBounds(332, 30, 86, 20);
			contentPanel.add(txtCodMed);
			txtCodMed.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo Medico:");
			lblNewLabel_1.setBounds(213, 33, 98, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Codigo Paciente:");
			lblNewLabel_2.setBounds(10, 66, 86, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtCodePaciente = new JTextField("Paciente - ");
			txtCodePaciente.setBounds(106, 66, 86, 20);
			contentPanel.add(txtCodePaciente);
			txtCodePaciente.setColumns(10);
		}
		{
			spnFecha = new JSpinner();
			spnFecha.setBounds(301, 63, 123, 20);
			spnFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(spnFecha);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Fecha Consulta:");
			lblNewLabel_3.setBounds(213, 66, 86, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Codigo Consulta:");
			lblNewLabel_4.setBounds(10, 30, 86, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtConsulta = new JTextField("Consulta - "+Clinica.generadorCodigoConsulta);
			txtConsulta.setEnabled(false);
			txtConsulta.setBounds(106, 30, 86, 20);
			contentPanel.add(txtConsulta);
			txtConsulta.setColumns(10);
		}
		
		JPanel panel_EnfermedadNoSelected = new JPanel();
		panel_EnfermedadNoSelected.setBounds(10, 106, 173, 111);
		contentPanel.add(panel_EnfermedadNoSelected);
		panel_EnfermedadNoSelected.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			panel_EnfermedadNoSelected.add(scrollPane, BorderLayout.CENTER);
			
			tableEnfermedadNoSelected = new JTable();
			scrollPane.setViewportView(tableEnfermedadNoSelected);
		}
		
		JPanel panel_panel_EnfermedadSelected = new JPanel();
		panel_panel_EnfermedadSelected.setBounds(213, 106, 173, 111);
		contentPanel.add(panel_panel_EnfermedadSelected);
		panel_panel_EnfermedadSelected.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_panel_EnfermedadSelected.add(scrollPane, BorderLayout.CENTER);
		
		tableEnfermedadSelected = new JTable();
		scrollPane.setViewportView(tableEnfermedadSelected);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
