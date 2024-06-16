package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Unit;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.repositories.UnitRepository;
import info.capybaratech.capydent.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collection;
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
    public Unit update(Unit unit) throws NotFoundException {
        var dbUnitOptional = getById(unit.getId());
        if (dbUnitOptional.isPresent()) {
            var dbUnit = dbUnitOptional.get();
            BeanUtils.copyProperties(unit, dbUnit, "id", "createdAt");
            unitRepository.update(dbUnit);
            return dbUnit;
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public void delete(Ulid id) throws NotFoundException {
        var dbUnitOptional = getById(id);
        if (dbUnitOptional.isPresent()) {
            var dbUnit = dbUnitOptional.get();
            dbUnit.setUpdatedAt(OffsetDateTime.now());
            dbUnit.setEnabled(false);
            unitRepository.delete(dbUnit);
            return ;
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public Collection<Unit> filter(Boolean enabled) {
        return unitRepository.filter(enabled);
    }
}
