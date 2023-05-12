package domain.portsout;

public interface InscripcionAlmacenamiento {

    void inscribir(String nombre, String telefono, String region, String email) throws InfrastructureDataException;

}
