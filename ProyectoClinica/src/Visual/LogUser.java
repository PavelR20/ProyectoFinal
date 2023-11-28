package Visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LogUser extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField txtUsername;
    private JTextField txtPass;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            LogUser dialog = new LogUser();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public LogUser() {
        setBounds(100, 100, 536, 487);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(266, 236, 79, 23);
        panel.add(btnLogin);

        JLabel lblUser = new JLabel("Username:");
        lblUser.setBounds(143, 108, 85, 14);
        panel.add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(242, 105, 146, 20);
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        JLabel lblPass = new JLabel("Password:");
        lblPass.setBounds(143, 139, 79, 14);
        panel.add(lblPass);

        txtPass = new JTextField();
        txtPass.setBounds(242, 136, 146, 20);
        panel.add(txtPass);
        txtPass.setColumns(10);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setBounds(146, 176, 46, 14);
        panel.add(lblRol);

       
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(242, 173, 146, 20);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.addElement("Administrador");
        comboBoxModel.addElement("Medico");
        comboBox.setModel(comboBoxModel);
        panel.add(comboBox);
    }
}
