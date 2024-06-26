package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Unit;
import info.capybaratech.capydent.exceptions.NotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface UnitService {
    Optional<Unit> getById(Ulid id);
    Unit insert(Unit unit);
    Unit update(Unit unit) throws NotFoundException;
    void delete(Ulid id) throws NotFoundException;
    Collection<Unit> filter(Boolean enabled);

}
