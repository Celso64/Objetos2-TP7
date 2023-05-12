package ui;

import java.util.List;
import java.util.Optional;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import restaurante.Bebida;
import restaurante.Comida;
import restaurante.Cuenta;
import restaurante.Observer;
import restaurante.Tarjeta;
import restaurante.Ticket;
import restaurante.Viedma;

public class Caja extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final Tarjeta TARJETA_DEFAULT = new Viedma();
    private JPanel contentPane;

    private JButton btnNuevaCuenta;
    private JComboBox<String> comboBox;
    private JButton btnAgregarComida;
    private JButton btnAgregarBebida;
    private JButton btnPagar;

    private Cuenta cuenta;
    private final Ticket ticket;
    private List<Tarjeta> tarjetas;
    private List<Observer> observadores;

    public Caja(Ticket ticket, List<Tarjeta> tarjetasDisponibles, List<Observer> observadores) {
	setTitle("Cajero - Observado");
	setResizable(false);

	this.ticket = ticket;
	this.tarjetas = tarjetasDisponibles;
	this.observadores = observadores;

	iniciarCuenta();

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);

	btnNuevaCuenta = new JButton("Nueva Cuenta");
	btnNuevaCuenta.addActionListener(e -> iniciarCuenta());
	btnNuevaCuenta.setBounds(12, 32, 170, 40);
	contentPane.add(btnNuevaCuenta);

	comboBox = new JComboBox<>();
	comboBox.setBounds(258, 32, 175, 37);
	iniciarComboBox();
	contentPane.add(comboBox);

	btnAgregarComida = new JButton("Agregar Comida");
	btnAgregarComida.addActionListener(x -> agregarComida());
	btnAgregarComida.setBounds(12, 120, 170, 64);
	contentPane.add(btnAgregarComida);

	btnAgregarBebida = new JButton("Agregar Bebida");
	btnAgregarBebida.addActionListener(x -> agregarBebida());
	btnAgregarBebida.setBounds(258, 120, 180, 64);
	contentPane.add(btnAgregarBebida);

	btnPagar = new JButton("PAGAR");
	btnPagar.addActionListener(x -> pagarCuenta());
	btnPagar.setBounds(12, 210, 426, 37);
	contentPane.add(btnPagar);
    }

    private void agregarComida() {
	String nombre = JOptionPane.showInputDialog(null, "Ingrese el valor: ");
	Double monto = Double.valueOf(nombre);
	this.cuenta.addProducto(new Comida(monto));
    }

    private void pagarCuenta() {

	String propina = JOptionPane.showInputDialog(null, "Porcentaje de Propina: ");

	Integer propinaNumber = Integer.parseInt(propina);

	Tarjeta tarjetaParaPagar = getItemComboBox().orElse(TARJETA_DEFAULT);

	Double monto = tarjetaParaPagar.pagarCuenta(cuenta, propinaNumber);

	this.observadores.forEach(x -> x.notificar(monto));

	iniciarCuenta();

    }

    private Optional<Tarjeta> getItemComboBox() {

	Integer index = this.comboBox.getSelectedIndex();

	if (index != -1)
	    return Optional.of(this.tarjetas.get(index));

	return Optional.empty();
    }

    private void agregarBebida() {
	String nombre = JOptionPane.showInputDialog(null, "Ingrese el valor: ");
	Double monto = Double.valueOf(nombre);
	this.cuenta.addProducto(new Bebida(monto));
    }

    private void iniciarComboBox() {
	this.tarjetas.forEach(x -> this.comboBox.addItem(x.getClass().getSimpleName()));
    }

    private void iniciarCuenta() {
	this.cuenta = new Cuenta(ticket);
    }
}
