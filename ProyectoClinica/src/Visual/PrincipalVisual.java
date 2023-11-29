package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import javax.swing.JMenu;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 532);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mCitas = new JMenu("CITAS");
		menuBar.add(mCitas);
		
		JMenu mConsultas = new JMenu("CONSULTAS");
		menuBar.add(mConsultas);
		
		JMenu mRegistro = new JMenu("REGISTROS");
		menuBar.add(mRegistro);
		
		JMenu mInventario = new JMenu("INVENTARIO");
		menuBar.add(mInventario);
		
		JMenu mUtilidades = new JMenu("UTILIDADES");
		menuBar.add(mUtilidades);
		
		JMenu mUSER = new JMenu("USUARIO");
		menuBar.add(mUSER);
		
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
	}
}
