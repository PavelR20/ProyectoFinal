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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class HacerConsulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodMed;
	private JTextField txtCodePaciente;
	private JSpinner spnFecha;

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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 86, 14);
		contentPanel.add(lblNewLabel);
		{
			txtCodMed = new JTextField("Medico - ");
			txtCodMed.setBounds(106, 8, 86, 20);
			contentPanel.add(txtCodMed);
			txtCodMed.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Codigo Medico:");
			lblNewLabel_1.setBounds(10, 11, 75, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Codigo Paciente:");
			lblNewLabel_2.setBounds(10, 47, 86, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			txtCodePaciente = new JTextField("Paciente - ");
			txtCodePaciente.setBounds(106, 44, 86, 20);
			contentPanel.add(txtCodePaciente);
			txtCodePaciente.setColumns(10);
		}
		{
			spnFecha = new JSpinner();
			spnFecha.setBounds(402, 23, 123, 20);
			spnFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
			contentPanel.add(spnFecha);
		}
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
