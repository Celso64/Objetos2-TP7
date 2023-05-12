package infrastructure.notificate;

public class MensajeInscripcion {

    private static final String TITULO = "Inscripcion";
    private static final String[] CUERPO = { "El usuario ", " ha sido inscrito en el sistema" };

    private String cuerpo;

    public MensajeInscripcion(String usuario) {

	StringBuilder sb = new StringBuilder(64);

	sb.append(CUERPO[0]).append(usuario).append(CUERPO[1]);

	this.cuerpo = sb.toString();
    }

    public String getTitulo() {
	return TITULO;
    }

    public String getCuerpo() {
	return cuerpo;
    }

}
