package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Occupation;

import java.util.Collection;
import java.util.Optional;

public interface OccupationService {
    Optional<Occupation> getById(Ulid id);
    void insert(Occupation occupation);
    void update(Occupation occupation);
    void delete(Occupation occupation);
    Collection<Occupation> filter(String description, Boolean enabled);
}
