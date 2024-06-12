package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import info.capybaratech.capydent.repositories.MaterialTypeRepository;
import info.capybaratech.capydent.services.MaterialTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaterialTypeServiceImpl implements MaterialTypeService {

    private MaterialTypeRepository materialTypeRepository;

    @Override
    public Collection<MaterialType> filter(Boolean enabled) {
        return materialTypeRepository.filter(enabled);
    }

    @Override
    public void insert(MaterialType materialType) {
        materialTypeRepository.insert(materialType);
    }

    @Override
    public void update(MaterialType materialType) {
        materialTypeRepository.update(materialType);
    }

    @Override
    public void delete(Ulid id) {
        materialTypeRepository.delete(id, OffsetDateTime.now());
    }

    @Override
    public Optional<MaterialType> getById(Ulid id) {
        return materialTypeRepository.getById(id);
    }
}
