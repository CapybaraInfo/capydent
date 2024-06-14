package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Occupation;
import info.capybaratech.capydent.entities.Unit;
import info.capybaratech.capydent.exceptions.NotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface OccupationService {
    Optional<Occupation> getById(Ulid id);
    Occupation insert(Occupation occupation);
    Occupation update(Occupation occupation) throws NotFoundException;
    void delete(Ulid id) throws NotFoundException;
    Collection<Occupation> filter(String description, Boolean enabled);
}
