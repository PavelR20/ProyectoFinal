package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PrincipalVisual extends JFrame {

	private JPanel contentPane;
	public JLabel lblSepa;
	private JMenuBar menuBar;
	public JLabel lblUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVisual frame = new PrincipalVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalVisual() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalVisual.class.getResource("/imagenes/edificio-del-hospital.png")));
		setTitle("MENU CLINICA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 532);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mCitas = new JMenu("CITAS");
		menuBar.add(mCitas);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Hacer Cita");
		mCitas.add(mntmNewMenuItem_12);
		
		JMenu mConsultas = new JMenu("CONSULTAS");
		menuBar.add(mConsultas);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Hacer Consulta");
		mConsultas.add(mntmNewMenuItem_11);
		
		JMenu mRegistro = new JMenu("REGISTROS");
		menuBar.add(mRegistro);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Crear Medico");
		mRegistro.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Crear Paciente");
		mRegistro.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Crear Vacuna");
		mRegistro.add(mntmNewMenuItem_10);
		
		JMenu mInventario = new JMenu("INVENTARIO");
		menuBar.add(mInventario);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado Paciente");
		mInventario.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado Medico");
		mInventario.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listado Vacunas");
		mInventario.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado Enfermedades");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				//LogUser logUserDialog = new LogUser();
		        //logUserDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        //logUserDialog.setVisible(true);
			}
		});
		mInventario.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Listado Vivienda");
		mInventario.add(mntmNewMenuItem_7);
		
		JMenu mUtilidades = new JMenu("UTILIDADES");
		menuBar.add(mUtilidades);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("WORKING");
		mUtilidades.add(mntmNewMenuItem_2);
		
		JMenu mUSER = new JMenu("USUARIO");
		menuBar.add(mUSER);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Crear Usuario");
		mUSER.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Borrar Usuario");
		mUSER.add(mntmNewMenuItem_1);
		
		lblSepa = new JLabel("--------------INFO-EXTRA---------------");
		menuBar.add(lblSepa);
		
		JLabel lblNewLabel = new JLabel(" USUARIO ACTIVO: - ");
		menuBar.add(lblNewLabel);
		
		lblUser = new JLabel("          ");
		lblUser.setForeground(new Color(0, 153, 0));
		menuBar.add(lblUser);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PrincipalVisual.class.getResource("/imagenes/caduceo.png")));
		lblNewLabel_1.setBounds(411, 153, 64, 104);
		panel.add(lblNewLabel_1);
	}
}
