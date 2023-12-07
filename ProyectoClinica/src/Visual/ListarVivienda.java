package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Clinica;
import Logical.Usuario;
import Logical.Vivienda;
import Logical.archivoManager;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class ListarVivienda extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtID;
	private static DefaultTableModel model;
	private static Object[] row;
	private JButton borrar;
	private Vivienda selected = null;

	public static void main(String[] args) {
		try {
			ListarVivienda dialog = new ListarVivienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarVivienda() {
		setTitle("Ver Vivienda");
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
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		ListPanel.add(scrollPane, BorderLayout.CENTER);


		String[] headear = {"ID","Telefono","Direccion"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(headear);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index >= 0) {
					borrar.setEnabled(true);

					String idVivienda = table.getValueAt(index, 0).toString();
					selected = Clinica.getInstance().obtenervivienda(idVivienda);
					System.out.println("Usuario seleccionado para borrar: " + selected);
				}
			}
		});
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		JPanel OpcionesPanel = new JPanel();
		OpcionesPanel.setBackground(SystemColor.scrollbar);
		OpcionesPanel.setBounds(10, 11, 714, 59);
		contentPanel.add(OpcionesPanel);
		OpcionesPanel.setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(53, 28, 603, 20);
		OpcionesPanel.add(txtID);
		txtID.setColumns(10);

		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setBounds(0, 31, 53, 14);
		OpcionesPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Lista de Viviendas");
		lblNewLabel_1.setBounds(10, 3, 694, 14);
		OpcionesPanel.add(lblNewLabel_1);

		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPorId();
			}
		});
		btnBuscar.setIcon(new ImageIcon(VerMisUsuarios.class.getResource("/imagenes/busqueda-de-lupa (1).png")));
		btnBuscar.setBounds(666, 28, 38, 22);
		OpcionesPanel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				borrar = new JButton("Borrar");
				borrar.setEnabled(false);
				borrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {


						int confirmacion = JOptionPane.showConfirmDialog(null, "�Seguro que desea borrar esta vivienda?",
								"Confirmaci�n", JOptionPane.YES_NO_OPTION);

						if (confirmacion == JOptionPane.YES_OPTION) {
							
						}

					}
				});
				borrar.setActionCommand("OK");
				buttonPane.add(borrar);
				getRootPane().setDefaultButton(borrar);
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

		cargarDatosDesdeArchivo("vivienda.txt");
	}

	private void cargarDatosDesdeArchivo(String archivo) {
		ArrayList<Vivienda> listaVivienda = archivoManager.leerVivienda();
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		for (Vivienda vivienda : listaVivienda) {
			model.addRow(new Object[]{vivienda.getIdVivienda(), vivienda.getTelefono(), vivienda.getDireccion()});
		}
	}

	private void buscarPorId() {
		String idABuscar = txtID.getText().trim();
		boolean viviendaEncontrado = false;

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		ArrayList<Vivienda> listaViviendas = archivoManager.leerVivienda();

		for (Vivienda vivienda : listaViviendas) {
			if (vivienda.getIdVivienda().equalsIgnoreCase(idABuscar)) {
				model.addRow(new Object[]{vivienda.getIdVivienda(), vivienda.getTelefono(), vivienda.getDireccion()});
				viviendaEncontrado = true;
			}
		}
		if (!viviendaEncontrado) {
			JOptionPane.showMessageDialog(null, "Error No existe", "Busqueda", JOptionPane.ERROR_MESSAGE);
		}
	}
}
