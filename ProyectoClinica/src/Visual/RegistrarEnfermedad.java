package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Clinica;
import Logical.Enfermedad;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarEnfermedad extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField textDescripcion;
	private JTextField txtSintomas;
	private JButton btnRegistrar;
	private Enfermedad miEnfermedad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrarEnfermedad dialog = new RegistrarEnfermedad(null,0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarEnfermedad(Enfermedad disease, int index) {
		miEnfermedad = disease;
		if( miEnfermedad == null)
			setTitle("Registrar Enfermedad");
		else
			setTitle("Actualizar Enfermedad");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.info);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistrarEnfermedad.class.getResource("/imagenes/edificio-del-hospital (2).png")));
		lblNewLabel.setBounds(356, 152, 68, 65);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo: ");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		txtCodigo = new JTextField("Enfermedad - "+Clinica.getInstance().generadorCodigoEnfermedad);
		txtCodigo.setBackground(SystemColor.info);
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(85, 8, 96, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key = e.getKeyChar();
				if (!Character.isAlphabetic(key))
					e.consume();
			}
		});
		txtNombre.setBounds(85, 39, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(85, 75, 219, 20);
		contentPanel.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(10, 42, 52, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion:");
		lblNewLabel_3.setBounds(10, 78, 65, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sintomas:");
		lblNewLabel_4.setBounds(10, 112, 52, 14);
		contentPanel.add(lblNewLabel_4);
		
		txtSintomas = new JTextField();
		txtSintomas.setBounds(85, 109, 219, 65);
		contentPanel.add(txtSintomas);
		txtSintomas.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.info);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				if( miEnfermedad == null)
					btnRegistrar = new JButton("Registrar");
				else
					btnRegistrar = new JButton("Actualizar");
				
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(miEnfermedad != null)
						{
							Enfermedad aux = new Enfermedad(txtCodigo.getText(),txtNombre.getText(),textDescripcion.getText(),txtSintomas.getText(), null,true);
							Clinica.getInstance().agregarEnfermedad(aux);
							clean();
						}
						else {
							miEnfermedad.setDescripcion(textDescripcion.getText());
							miEnfermedad.setIdEnfermedad(txtCodigo.getText());
							miEnfermedad.setNombreEnfermedad(txtNombre.getText());
							miEnfermedad.setSintomas(txtSintomas.getText());
							dispose();
						}
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
		if(miEnfermedad!=null)
			loadEnfermedad();
			
	}
	public void clean() {
		Clinica.getInstance().generadorCodigoVivienda++;
		txtCodigo.setText("Enfermedad - "+Clinica.getInstance().generadorCodigoEnfermedad);
		textDescripcion.setText("");
		txtSintomas.setText("");
		txtNombre.setText("");
	}
	public void loadEnfermedad(){
		txtCodigo.setText(miEnfermedad.getIdEnfermedad());
		textDescripcion.setText(miEnfermedad.getDescripcion());
		txtNombre.setText(miEnfermedad.getNombreEnfermedad());
		txtSintomas.setText(miEnfermedad.getSintomas());
	}
}
