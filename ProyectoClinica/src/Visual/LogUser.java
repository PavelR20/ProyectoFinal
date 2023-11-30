package Visual;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import Logical.Clinica;
import Logical.Enfermedad;

public class LogUser extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JFreeChart barChart;
    private ChartPanel chartPanel;

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
    	setTitle("Enfermedades Propensas");
        setBounds(100, 100, 662, 487);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        contentPanel.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        barChart = createChart(createDataset());
        chartPanel = new ChartPanel(barChart);
        chartPanel.setBounds(0, 44, 596, 360);
        panel.add(chartPanel);

        JButton btnDiagnose = new JButton("Diagnose");
        btnDiagnose.addActionListener(e -> {
            updateDataset();
            chartPanel.repaint();
        });
        btnDiagnose.setBounds(10, 10, 100, 23);
        panel.add(btnDiagnose);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0, "Enfermedades", "Categoría 1");
        dataset.addValue(0, "Enfermedades", "Categoría 2");
        return dataset;
    }

    private void updateDataset() {
        Clinica clinica = Clinica.getInstance();
        DefaultCategoryDataset dataset = (DefaultCategoryDataset) barChart.getCategoryPlot().getDataset();

        dataset.clear(); 

        for (Enfermedad enfermedad : clinica.getEnfermedadesDiagnosticadas()) {
            dataset.addValue(clinica.getEnfermedadesDiagnosticadas().stream()
                    .filter(e -> e.getIdEnfermedad().equals(enfermedad.getIdEnfermedad())).count(),
                    "Enfermedades", enfermedad.getNombreEnfermedad());
        }
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Enfermedades Propensas",
                "Enfermedades",
                "Cantidad de personas con Enfermedad",
                dataset);

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.getRenderer().setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        plot.getRenderer().setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

        return chart;
    }
}