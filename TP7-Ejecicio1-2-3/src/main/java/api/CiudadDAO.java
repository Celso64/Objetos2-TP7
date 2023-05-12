package api;

import java.util.Optional;

import modelo.Ciudad;

public interface CiudadDAO {

    Optional<Ciudad> findCiudad();

}
