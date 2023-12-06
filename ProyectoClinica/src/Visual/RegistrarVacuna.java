package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RegistrarVacuna extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreVacuna;
	private JTextField txtIdVacuna;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarVacuna dialog = new RegistrarVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarVacuna() {
		setTitle("Registrar Vacuna");
		setBounds(100, 100, 579, 418);
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

			txtNombreVacuna = new JTextField();
			txtNombreVacuna.setBounds(67, 62, 166, 20);
			panel.add(txtNombreVacuna);
			txtNombreVacuna.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("ID:");
			lblNewLabel_1.setBounds(18, 26, 46, 14);
			panel.add(lblNewLabel_1);

			txtIdVacuna = new JTextField();
			txtIdVacuna.setEditable(false);
			txtIdVacuna.setEnabled(false);
			txtIdVacuna.setText("Vacuna - "+ Clinica.getInstance().generadorCodigoVacuna);
			txtIdVacuna.setBounds(67, 23, 86, 20);
			panel.add(txtIdVacuna);
			txtIdVacuna.setColumns(10);

			JSpinner spnCant = new JSpinner();
			spnCant.setBounds(187, 141, 46, 20);
			panel.add(spnCant);

			JLabel lblNewLabel_2 = new JLabel("Cantidad:");
			lblNewLabel_2.setBounds(177, 116, 65, 14);
			panel.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Enfermedades a Curar:");
			lblNewLabel_3.setBounds(10, 116, 124, 14);
			panel.add(lblNewLabel_3);

			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 141, 109, 20);
			panel.add(comboBox);

			JLabel lblNewLabel_4 = new JLabel("Descripcion:");
			lblNewLabel_4.setBounds(334, 34, 72, 14);
			panel.add(lblNewLabel_4);

			textField = new JTextField();
			textField.setBounds(334, 59, 209, 247);
			panel.add(textField);
			textField.setColumns(10);
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
}
