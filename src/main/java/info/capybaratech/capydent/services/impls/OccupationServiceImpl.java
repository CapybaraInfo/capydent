package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Occupation;
import info.capybaratech.capydent.repositories.OccupationRepository;
import info.capybaratech.capydent.services.OccupationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OccupationServiceImpl implements OccupationService {

    private OccupationRepository repository;
    @Override
    public Optional<Occupation> getById(Ulid id) {
        return repository.getById(id);
    }
    @Override
    public void insert(Occupation occupation) {
        repository.insert(occupation);
    }

    @Override
    public void update(Occupation occupation) {
        repository.update(occupation);
    }

    @Override
    public void delete(Occupation occupation) {
        repository.delete(occupation);
    }

    @Override
    public Collection<Occupation> filter(String description, Boolean enabled) {
        return repository.filter(description, enabled);
    }
}
