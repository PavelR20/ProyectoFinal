package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;

public class RegistrarVivienda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodeVivienda;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTable tablePacienteNoVivienda;
	private JTable table_PacienteSiVivienda;

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
		setBounds(100, 100, 500, 400);
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
			lblNewLabel_2.setBounds(23, 55, 52, 14);
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
			txtTelefono.setBounds(90, 52, 86, 20);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegistrarVivienda.class.getResource("/imagenes/edificio-del-hospital (2).png")));
			lblNewLabel.setBounds(410, 245, 64, 73);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(23, 86, 57, 14);
			panel.add(lblNewLabel_3);
			
			txtDireccion = new JTextField();
			txtDireccion.setBounds(90, 83, 164, 20);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JPanel panel_PacienteNoVivienda = new JPanel();
			panel_PacienteNoVivienda.setBorder(new TitledBorder(null, "Pacientes sin vivienda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_PacienteNoVivienda.setBounds(23, 142, 166, 135);
			panel.add(panel_PacienteNoVivienda);
			panel_PacienteNoVivienda.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPanePacienteNoVivienda = new JScrollPane();
			panel_PacienteNoVivienda.add(scrollPanePacienteNoVivienda, BorderLayout.CENTER);
			
			tablePacienteNoVivienda = new JTable();
			tablePacienteNoVivienda.setBackground(SystemColor.info);
			scrollPanePacienteNoVivienda.setViewportView(tablePacienteNoVivienda);
			
			JPanel panel_PacienteSiVivienda = new JPanel();
			panel_PacienteSiVivienda.setBorder(new TitledBorder(null, "Pacientes con vivienda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_PacienteSiVivienda.setBounds(224, 142, 176, 135);
			panel.add(panel_PacienteSiVivienda);
			panel_PacienteSiVivienda.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_PacienteSiVivienda = new JScrollPane();
			panel_PacienteSiVivienda.add(scrollPane_PacienteSiVivienda, BorderLayout.CENTER);
			
			table_PacienteSiVivienda = new JTable();
			table_PacienteSiVivienda.setBackground(SystemColor.info);
			scrollPane_PacienteSiVivienda.setViewportView(table_PacienteSiVivienda);
			
			JButton btnQuitar = new JButton("Quitar");
			btnQuitar.setBounds(224, 288, 89, 23);
			panel.add(btnQuitar);
			
			JButton btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(103, 288, 89, 23);
			panel.add(btnAgregar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

