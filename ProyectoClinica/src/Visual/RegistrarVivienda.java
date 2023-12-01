package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Vivienda;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarVivienda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodeVivienda;
	private JTextField txtTelefono;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarVivienda dialog = new RegistrarVivienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarVivienda() {
		setTitle("Ingresar Vivienda");
		setBounds(100, 100, 400, 250);
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
			lblNewLabel_1.setBounds(23, 24, 46, 14);
			panel.add(lblNewLabel_1);
			
			txtCodeVivienda = new JTextField();
			txtCodeVivienda.setBackground(SystemColor.info);
			txtCodeVivienda.setEnabled(false);
			txtCodeVivienda.setText("Vivienda -"+ Clinica.getInstance().generadorCodigoVivienda);
			txtCodeVivienda.setBounds(90, 21, 64, 20);
			panel.add(txtCodeVivienda);
			txtCodeVivienda.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(23, 73, 52, 14);
			panel.add(lblNewLabel_2);
			
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char key = e.getKeyChar();
					if (!Character.isDigit(key) )
						e.consume();
				}
			});
			txtTelefono.setBounds(90, 70, 86, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarVivienda.class.getResource("/imagenes/edificio-del-hospital (2).png")));
			lblNewLabel.setBounds(310, 95, 64, 73);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(23, 118, 57, 14);
			panel.add(lblNewLabel_3);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(90, 115, 164, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
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
						Vivienda casaReg =  new Vivienda(txtCodeVivienda.getText(),txtDireccion.getText(),
								txtTelefono.getText(), null);
						Clinica.getInstance().getMisViviendas().add(casaReg);
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
}

