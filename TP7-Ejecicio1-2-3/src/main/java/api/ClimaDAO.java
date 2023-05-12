package api;

import java.util.Optional;

import modelo.Clima;

public interface ClimaDAO {

    Optional<Clima> getClimaPorCiudad();

}
