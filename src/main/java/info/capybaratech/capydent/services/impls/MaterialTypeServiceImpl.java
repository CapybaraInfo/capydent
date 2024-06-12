package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.repositories.MaterialTypeRepository;
import info.capybaratech.capydent.services.MaterialTypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public MaterialType insert(MaterialType materialType) {
        materialTypeRepository.insert(materialType);
        return materialType;
    }

    @Override
    public MaterialType update(MaterialType materialType) throws NotFoundException {
        var materialTypeOptional = getById(materialType.getId());
        if (materialTypeOptional.isPresent()) {
            var material = materialTypeOptional.get();
            BeanUtils.copyProperties(materialType, material, "id,createdAt");
            materialTypeRepository.update(material);
            return material;
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public void delete(Ulid id) throws NotFoundException {
        var materialTypeOptional = materialTypeRepository.getById(id);
        if (materialTypeOptional.isPresent()) {
            var type = materialTypeOptional.get();
            type.setUpdatedAt(OffsetDateTime.now());
            type.setEnabled(false);
            materialTypeRepository.delete(type);
            return;
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public Optional<MaterialType> getById(Ulid id) {
        return materialTypeRepository.getById(id);
    }
}
