package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Paciente;
import Logical.Usuario;
import Logical.archivoManager;

import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class HistorialPacienteBuscar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtNombre;
	
	private static DefaultTableModel model;
	private static Object[] row;

	public static void main(String[] args) {
		try {
			HistorialPacienteBuscar dialog = new HistorialPacienteBuscar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public HistorialPacienteBuscar() {
		setTitle("Ver usuarios");
		setBounds(100, 100, 750, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel ListPanel = new JPanel();
		ListPanel.setBounds(10, 75, 714, 275);
		contentPanel.add(ListPanel);
		ListPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		ListPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		String[] headear = {"ID","Usuario","Password", "Rol"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headear);
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel OpcionesPanel = new JPanel();
		OpcionesPanel.setBackground(SystemColor.scrollbar);
		OpcionesPanel.setBounds(10, 11, 714, 59);
		contentPanel.add(OpcionesPanel);
		OpcionesPanel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(57, 28, 599, 20);
		OpcionesPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(10, 31, 58, 14);
		OpcionesPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lista de Pacientes");
		lblNewLabel_1.setBounds(10, 3, 694, 14);
		OpcionesPanel.add(lblNewLabel_1);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorNombre();
			}
		});
		btnBuscar.setIcon(new ImageIcon(HistorialPacienteBuscar.class.getResource("/imagenes/busqueda-de-lupa (1).png")));
		btnBuscar.setBounds(666, 28, 38, 22);
		OpcionesPanel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Borrar");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cargarDatosDesdeArchivo("paciente.txt");
	}
	
	private void cargarDatosDesdeArchivo(String archivo) {
		ArrayList<Paciente> listaPaciente = archivoManager.leerPacientes();
        DefaultTableModel model = (DefaultTableModel) table.getModel();

    }
	
		private void buscarPorNombre() {
        String nombreABuscar = txtNombre.getText().trim();
        boolean usuarioEncontrado = false;

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        ArrayList<Usuario> listaUsuarios = archivoManager.LeerUsuario();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUser().equalsIgnoreCase(nombreABuscar)) {
                model.addRow(new Object[]{usuario.getIdUsuario(), usuario.getNombreUser(), usuario.getPassword(),usuario.getRol()});
                usuarioEncontrado = true;
            }
        }
        if (!usuarioEncontrado) {
            JOptionPane.showMessageDialog(null, "Error No existe", "Busqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
}
