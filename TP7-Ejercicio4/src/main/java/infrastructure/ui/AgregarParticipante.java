package infrastructure.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import domain.portsin.ParticipanteDTO;
import domain.portsin.PlanillaParticipante;

public class AgregarParticipante extends JFrame {

    private static final long serialVersionUID = 1L;
    private PlanillaParticipante planilla;
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private JTextField email;

    public AgregarParticipante(PlanillaParticipante planilla) throws SQLException {
	this.planilla = planilla;
	setupUIComponents();
    }

    private void setupUIComponents() {
	setTitle("Add Participant");
	setSize(667, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.nombre = new JTextField(10);
	this.telefono = new JTextField(10);
	this.region = new JTextField(10);
	this.email = new JTextField(10);
	this.nombre.setText("");
	this.telefono.setText("");
	this.region.setText("China");
	this.email.setText("");
	JPanel contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new FlowLayout());
	contentPane.add(new JLabel("Nombre: "));
	contentPane.add(nombre);
	contentPane.add(new JLabel("Telefono: "));
	contentPane.add(telefono);
	contentPane.add(new JLabel("Region: "));
	contentPane.add(region);
	contentPane.add(new JLabel("Email "));
	contentPane.add(email);
	JButton botonCargar = new JButton("Cargar");
	botonCargar.addActionListener(e -> onBotonCargar());
	contentPane.add(botonCargar);
	setContentPane(contentPane);
	contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	pack();
	setVisible(true);
    }

    private void onBotonCargar() {

	try {
	    this.planilla.inscribir(
		    new ParticipanteDTO(nombre.getText(), telefono.getText(), region.getText(), email.getText()));
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}

	dispose();
    }

}
