package Visual;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalVisual extends JFrame {

    private JPanel contentPane;
    public JLabel lblSepa;
    private JMenuBar menuBar;
    public JLabel lblUser;
    public JMenuItem hacerCita;
    public JMenuItem HacerConsultas;
    public JMenu mRegistro;
    public JMenuItem mntmNewMenuItem_9;
    public JMenuItem crearVacuna;
    public JMenu mUSER;
    public JMenu mUtilidades;
    public JMenu mInvertario;
    public JMenu mConsultas;
    public JMenu mCitas;
    public JMenuItem crearUsuario;
    public JMenuItem borrarUsuario;
    public JMenuItem listaPaciente;
    public JMenuItem listaMedico;
    public JMenuItem listadoVacuna;
    public JMenuItem listadoEnfermedad;
    public JMenuItem listaVivienda;
    private Dimension dim;
    public JMenuItem crearEnfermedad;
    public JMenuItem crearVivienda;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
    	
    	dim = getToolkit().getScreenSize();
        setIconImage(Toolkit.getDefaultToolkit().getImage(PrincipalVisual.class.getResource("/imagenes/edificio-del-hospital.png")));
        setTitle("MENU CLINICA");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setSize(dim.width, dim.height-40);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuBar.setBackground(SystemColor.activeCaption);
        setJMenuBar(menuBar);

        mCitas = new JMenu("CITAS");
        menuBar.add(mCitas);

        hacerCita = new JMenuItem("Hacer Cita");
        hacerCita.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HacerCita hacerCita = new HacerCita();
        		hacerCita.setModal(true);
        		hacerCita.setVisible(true);
        		
        	}
        });
        stylizeMenuItem(hacerCita);
        mCitas.add(hacerCita);

        mConsultas = new JMenu("CONSULTAS");
        menuBar.add(mConsultas);

        HacerConsultas = new JMenuItem("Hacer Consulta");
        HacerConsultas.setBackground(SystemColor.activeCaption);
        HacerConsultas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HacerConsulta hacerCons = new HacerConsulta();
        		hacerCons.setModal(true);
        		hacerCons.setVisible(true);
        	}
        });
        stylizeMenuItem(HacerConsultas);
        mConsultas.add(HacerConsultas);

        mRegistro = new JMenu("REGISTROS");
        menuBar.add(mRegistro);

        mntmNewMenuItem_9 = new JMenuItem("Crear Persona");
        mntmNewMenuItem_9.setBackground(SystemColor.activeCaption);
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegistrarGeneral regisGen = new RegistrarGeneral(null,0);
        		regisGen.setModal(true);
        		regisGen.setVisible(true);
        	}
        });
        stylizeMenuItem(mntmNewMenuItem_9);
        mRegistro.add(mntmNewMenuItem_9);

        crearVacuna = new JMenuItem("Crear Vacuna");
        crearVacuna.setBackground(SystemColor.activeCaption);
        crearVacuna.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		RegistrarVacuna regisVac = new RegistrarVacuna();
        		regisVac.setModal(true);
        		regisVac.setVisible(true);
        	}
        });
        stylizeMenuItem(crearVacuna);
        mRegistro.add(crearVacuna);
        
        crearEnfermedad = new JMenuItem("Crear enfermedad");
        crearEnfermedad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegistrarEnfermedad enfer = new RegistrarEnfermedad(null, 0);
        		enfer.setModal(true);
        		enfer.setVisible(true);
        	}
        });
        crearEnfermedad.setBackground(SystemColor.activeCaption);
        mRegistro.add(crearEnfermedad);
        
        crearVivienda = new JMenuItem("crear Vivienda");
        crearVivienda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		RegistrarVivienda vivienda = new RegistrarVivienda(null, 0);
        		vivienda.setModal(true);
        		vivienda.setVisible(true);
        	}
        });
        crearVivienda.setBackground(SystemColor.activeCaption);
        mRegistro.add(crearVivienda);

        mInvertario = new JMenu("INVENTARIO");
        menuBar.add(mInvertario);

        listaPaciente = new JMenuItem("Listado Paciente");
        listaPaciente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ListarPaciente listar1 = new ListarPaciente();
        		listar1.setModal(true);
        		listar1.setVisible(true);
        	}
        });
        listaPaciente.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(listaPaciente);
        mInvertario.add(listaPaciente);

        listaMedico = new JMenuItem("Listado Medico");
        listaMedico.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ListarMedico lista2 = new ListarMedico();
        		lista2.setModal(true);
        		lista2.setVisible(true);
        	}
        });
        listaMedico.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(listaMedico);
        mInvertario.add(listaMedico);

        listadoVacuna = new JMenuItem("Listado Vacunas");
        listadoVacuna.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(listadoVacuna);
        mInvertario.add(listadoVacuna);

        listadoEnfermedad = new JMenuItem("Listado Enfermedades");
        listadoEnfermedad.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(listadoEnfermedad);
        listadoEnfermedad.addActionListener(e -> {
            // LogUser logUserDialog = new LogUser();
            // logUserDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            // logUserDialog.setVisible(true);
        });
        mInvertario.add(listadoEnfermedad);

        listaVivienda = new JMenuItem("Listado Vivienda");
        listaVivienda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		ListarVivienda listarV = new ListarVivienda();
        		listarV.setModal(true);
        		listarV.setVisible(true);
        	}
        });
        listaVivienda.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(listaVivienda);
        mInvertario.add(listaVivienda);

        mUtilidades = new JMenu("UTILIDADES");
        menuBar.add(mUtilidades);

        JMenuItem mntmNewMenuItem_2 = new JMenuItem("WORKING");
        mntmNewMenuItem_2.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(mntmNewMenuItem_2);
        mUtilidades.add(mntmNewMenuItem_2);

        mUSER = new JMenu("USUARIO");
        menuBar.add(mUSER);

        crearUsuario = new JMenuItem("Crear Usuario");
        crearUsuario.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(crearUsuario);
        crearUsuario.addActionListener(e -> {
            CrearUser user = new CrearUser();
            user.setModal(true);
            user.setVisible(true);
        });
        mUSER.add(crearUsuario);

        borrarUsuario = new JMenuItem("Borrar Usuario");
        borrarUsuario.setBackground(SystemColor.activeCaption);
        stylizeMenuItem(borrarUsuario);
        borrarUsuario.addActionListener(e -> {
            VerMisUsuarios usuarios = new VerMisUsuarios();
            usuarios.setModal(true);
            usuarios.setVisible(true);
        });
        mUSER.add(borrarUsuario);

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
        lblNewLabel_1.setBounds(870, 367, 64, 104);
        panel.add(lblNewLabel_1);
    }

  
    private void stylizeMenuItem(JMenuItem menuItem) {
        menuItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));  
        menuItem.setForeground(Color.BLACK);  
        menuItem.setBackground(SystemColor.activeCaption);  
        menuItem.setPreferredSize(new Dimension(180, 40));  
        menuItem.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); 
    }
}


