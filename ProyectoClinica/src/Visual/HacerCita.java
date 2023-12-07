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

import Logical.Cita;
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

public class HacerCita extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodMed;
	private JTextField txtCodePaciente;
	private JSpinner spnFecha;
	private JTextField txtCita;
	private static DefaultTableModel modeloNoSelected;
	private static Object[] rowNoSelected; 
	private int indexSelected;
	private int indexNoSelected;
	private JButton btnQuitar;
	private ArrayList<Enfermedad> enfermedadesSelected;
	private Enfermedad consultEnfermedad = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			HacerCita dialog = new HacerCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HacerCita() {
		setTitle("Hacer Cita");
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.info);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtCodMed = new JTextField("Medico - ");
			txtCodMed.setBounds(124, 98, 86, 20);
			contentPanel.add(txtCodMed);
			txtCodMed.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo Medico:");
			lblNewLabel_1.setBounds(10, 101, 127, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Codigo Paciente:");
			lblNewLabel_2.setBounds(10, 66, 104, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtCodePaciente = new JTextField("Paciente - ");
			txtCodePaciente.setBounds(124, 63, 86, 20);
			contentPanel.add(txtCodePaciente);
			txtCodePaciente.setColumns(10);
		}
		{
			spnFecha = new JSpinner();
			spnFecha.setBounds(124, 129, 123, 20);
			spnFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(spnFecha);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Fecha Consulta:");
			lblNewLabel_3.setBounds(10, 132, 127, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Codigo Cita:");
			lblNewLabel_4.setBounds(10, 30, 73, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			txtCita = new JTextField("Cita - "+Clinica.getInstance().generadorCodigoCita);
			txtCita.setEnabled(false);
			txtCita.setBounds(124, 27, 86, 20);
			contentPanel.add(txtCita);
			txtCita.setColumns(10);
		}
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(HacerConsulta.class.getResource("/imagenes/edificio-del-hospital (2).png")));
			lblNewLabel.setBounds(310, 147, 64, 70);
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
						Cita citaReg = new Cita(txtCita.getText(),Clinica.getInstance().obtenerPacienteById(txtCodePaciente.getText()),
								Clinica.getInstance().obtenerMedicoById(txtCodMed.getText()),(Date)spnFecha.getValue());
						Clinica.getInstance().agregarCitas(citaReg);
						clean();
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
		
	}
	
	public void clean() {
		txtCodePaciente.setText("Paciente - ");
		Clinica.getInstance().generadorCodigoCita++;
		txtCita.setText("Consulta - "+Clinica.getInstance().generadorCodigoCita);
		txtCodMed.setText("Medico - ");
	}
	
}
