package domain.model;

import domain.portsin.DomainException;

public class Participante {

    private String nombre;
    private String telefono;
    private String region;
    private String email;

    public Participante(String nombre, String telefono, String region, String email) throws DomainException {

	this.nombre = new Nombre(nombre).toString();
	this.telefono = new Telefono(telefono).toString();
	this.region = new Region(region).toString();
	this.email = new Email(email).toString();

    }

    public String getNombre() {
	return nombre;
    }

    public String getTelefono() {
	return telefono;
    }

    public String getRegion() {
	return region;
    }

    public String getEmail() {
	return email;
    }

}
