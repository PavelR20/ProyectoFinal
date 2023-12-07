package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CrearUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPassword;
	private JTextField txtUserId;
	private JTextField TXTcodID;
	private JComboBox cbxRol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearUser dialog = new CrearUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearUser() {
		setTitle("Crear Usuario");
		setBounds(100, 100, 301, 243);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JLabel lblNewLabel = new JLabel("ID:");
			lblNewLabel.setBounds(56, 40, 22, 14);
			panel.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("User ID:");
			lblNewLabel_1.setBounds(32, 65, 46, 14);
			panel.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Password:");
			lblNewLabel_2.setBounds(30, 90, 56, 14);
			panel.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Rol:");
			lblNewLabel_3.setBounds(56, 118, 22, 14);
			panel.add(lblNewLabel_3);

			txtPassword = new JTextField();
			txtPassword.setBounds(88, 87, 140, 20);
			panel.add(txtPassword);
			txtPassword.setColumns(10);

			txtUserId = new JTextField();
			txtUserId.setBounds(88, 62, 140, 20);
			panel.add(txtUserId);
			txtUserId.setColumns(10);

			TXTcodID = new JTextField();
			TXTcodID.setBounds(88, 37, 140, 20);
			panel.add(TXTcodID);
			TXTcodID.setColumns(10);

			cbxRol = new JComboBox();
			cbxRol.setModel(new DefaultComboBoxModel(new String[] {"Selecionar rol", "Medico", "Administrador", "Secretaria"}));
			cbxRol.setBounds(88, 115, 140, 20);
			panel.add(cbxRol);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Usuario user = new Usuario(TXTcodID.getText(), txtUserId.getText(), txtPassword.getText(), cbxRol.getSelectedItem().toString());
						Clinica.getInstance().agregarUsuario(user);
						JOptionPane.showMessageDialog(null, "Operación Satisfactoria", "Resgistro", JOptionPane.INFORMATION_MESSAGE);
					}
				});
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
