package main;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.List;

import domain.model.DefaultPlanillaParticipante;
import infrastructure.data.ConnectionManager;
import infrastructure.data.DBInscripcionAlmacenamiento;
import infrastructure.notificate.EmailManager;
import infrastructure.notificate.EnviarEmail;
import infrastructure.ui.AgregarParticipante;

public class Main {

    public static void main(String[] args) throws SQLException {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    new AgregarParticipante(new DefaultPlanillaParticipante(
			    new DBInscripcionAlmacenamiento(ConnectionManager.getProperties()),
			    List.of(new EnviarEmail(EmailManager.getProperties("email")))));
		} catch (Exception e) {
		    System.out.println(e);
		}
	    }
	});
    }

}
