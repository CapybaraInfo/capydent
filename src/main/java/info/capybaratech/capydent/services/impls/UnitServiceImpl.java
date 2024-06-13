package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Unit;
import info.capybaratech.capydent.repositories.UnitRepository;
import info.capybaratech.capydent.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    @Override
    public Optional<Unit> getById(Ulid id) {
        return unitRepository.getById(id);
    }

    @Override
    public Unit insert(Unit unit) {
        unitRepository.insert(unit);
        return unit;
    }

    @Override
    public Unit update(Unit unit) {
        unitRepository.update(unit);
        return unit;
    }

    @Override
    public void delete(Ulid id) {
        unitRepository.delete(id);
    }

    @Override
    public Collection<Unit> filter(Boolean enabled) {
        return unitRepository.filter(enabled);
    }
}
