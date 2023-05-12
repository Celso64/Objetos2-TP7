package infrastructure.notificate;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import domain.portsout.Observer;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EnviarEmail implements Observer {

    private Properties propiedades;
    private Session session;

    public EnviarEmail(Properties propiedades) {
	this.propiedades = Objects.requireNonNull(propiedades);
    }

    @Override
    public void notificar(Map<String, String> datos) {

	String destino = datos.get("email");

	MensajeInscripcion mensaje = new MensajeInscripcion(datos.get("usuario"));

	session = Session.getInstance(propiedades, new jakarta.mail.Authenticator() {
	    protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(propiedades.getProperty("username"),
			propiedades.getProperty("password"));
	    }
	});

	try {
	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(propiedades.getProperty("origen")));
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(destino));
	    message.setSubject(mensaje.getTitulo());
	    message.setText(mensaje.getCuerpo());
	    Transport.send(message);
	} catch (MessagingException e) {
	    throw new RuntimeException(e.getMessage());
	}

    }

}
