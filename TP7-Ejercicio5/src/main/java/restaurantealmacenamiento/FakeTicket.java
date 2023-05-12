package restaurantealmacenamiento;

import java.time.LocalDate;

import restaurante.Ticket;

public class FakeTicket implements Ticket {

    @Override
    public void registrarPago(LocalDate fecha, Double monto) {
	System.out.println("Pago registrado: " + fecha.toString() + " || " + monto);

    }

}
