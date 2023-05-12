package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MontoDisplay extends JFrame implements restaurante.Observer {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel label;
    protected static final Color COLOR_TEXTO_DEFAULT = Color.BLACK;

    public MontoDisplay() {
	setTitle("Monitor - Observador");

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	label = new JLabel("0.0");
	label.setForeground(COLOR_TEXTO_DEFAULT);
	label.setHorizontalAlignment(SwingConstants.CENTER);
	label.setFont(new Font("Ubuntu", Font.BOLD, 32));
	label.setBounds(12, 67, 416, 111);
	contentPane.add(label);
    }

    @Override
    public void notificar(Double valorUltimaMesa) {
	label.setText(valorUltimaMesa.toString());
    }

    protected void setColortexto(Color colorTexto) {
	this.label.setForeground(colorTexto);
    }
}
