package domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.portsin.DomainException;
import domain.portsin.ParticipanteDTO;
import domain.portsin.PlanillaParticipante;
import domain.portsout.InfrastructureDataException;
import domain.portsout.InscripcionAlmacenamiento;
import domain.portsout.Observer;

public class DefaultPlanillaParticipante extends Observado implements PlanillaParticipante {

    private InscripcionAlmacenamiento almacenamiento;

    public DefaultPlanillaParticipante(InscripcionAlmacenamiento almacenamiento, List<Observer> observadores) {
	this.almacenamiento = almacenamiento;
	super.observadores = observadores;
    }

    @Override
    public void inscribir(ParticipanteDTO participanteDTO) throws InfrastructureDataException, DomainException {

	Participante participante = new Participante(participanteDTO.nombre(), participanteDTO.telefono(),
		participanteDTO.region(), participanteDTO.email());

	Map<String, String> datos = new HashMap<>();

	datos.put("usuario", participante.getNombre());
	datos.put("email", participante.getEmail());

	super.notificar(datos);

	this.almacenamiento.inscribir(participante.getNombre(), participante.getTelefono(), participante.getRegion(),
		participante.getEmail());

    }

}
