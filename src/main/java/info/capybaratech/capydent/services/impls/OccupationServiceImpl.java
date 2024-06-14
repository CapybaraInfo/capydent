package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Occupation;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.repositories.OccupationRepository;
import info.capybaratech.capydent.services.OccupationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
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
    public Occupation insert(Occupation occupation) {
        repository.insert(occupation);
        return occupation;
    }

    @Override
    public Occupation update(Occupation occupation) throws NotFoundException {
        var dbOccupationOptional = getById(occupation.getId());
        if (dbOccupationOptional.isPresent()) {
            var dbOccupation = dbOccupationOptional.get();
            BeanUtils.copyProperties(occupation, dbOccupation, "id", "createdAt");
            repository.update(dbOccupation);
            return occupation;
        }
        throw new NotFoundException("Occupation with id " + occupation.getId() + " not found");
    }

    @Override
    public void delete(Ulid id) throws NotFoundException {
        var dbOccupationOptional = getById(id);
        if (dbOccupationOptional.isPresent()){
            var dbOccupation = dbOccupationOptional.get();
            dbOccupation.setUpdatedAt(OffsetDateTime.now());
            dbOccupation.setEnabled(false);
            repository.delete(dbOccupation);
        }
        throw new NotFoundException("Occupation with id " + id + " not found");
    }

    @Override
    public Collection<Occupation> filter(String description, Boolean enabled) {
        return repository.filter(description, enabled);
    }
}
