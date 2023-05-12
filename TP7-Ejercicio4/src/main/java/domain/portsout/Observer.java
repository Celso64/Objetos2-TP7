package domain.portsout;

import java.util.Map;

public interface Observer {

    void notificar(Map<String, String> datos);

}
