package ar.utn.ba.ddsi.repositories.inMemory;

import ar.utn.ba.ddsi.models.RegistroClimatico;
import ar.utn.ba.ddsi.repositories.ClimaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryClimaRepository implements ClimaRepository {
    private final ClimaInMemoryStore store;

    public InMemoryClimaRepository(ClimaInMemoryStore store) {
        this.store = store;
    }
    @Override
    public RegistroClimatico guardar(RegistroClimatico registro){
        RegistroClimatico guardado = store.guardar(registro);
        return guardado;
    }
    @Override
    public RegistroClimatico obtenerUltimo(){
        RegistroClimatico obtenido = store.obtenerUltimo();
        return obtenido;
    }
}
