package info.capybaratech.capydent.services.impls;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Material;
import info.capybaratech.capydent.exceptions.NotFoundException;
import info.capybaratech.capydent.repositories.MaterialRepository;
import info.capybaratech.capydent.services.MaterialService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private MaterialRepository materialRepository;
    @Override
    public Collection<Material> filter(Boolean enabled, Ulid materialTypeId, String description) {
        return materialRepository.filter(enabled,materialTypeId,description) ;
    }

    @Override
    public Material insert(Material material) {
        materialRepository.insert(material);
        return materialRepository.getById(material.getId()).orElse(null);
    }

    @Override
    public Material update(Material material) throws NotFoundException {
        var optional = materialRepository.getById(material.getId());
        if(optional.isPresent()) {
            var dbMaterial = optional.get();
            BeanUtils.copyProperties(material, dbMaterial,"id", "createdAt");
            materialRepository.update(dbMaterial);
            return materialRepository.getById(material.getId()).orElse(null);
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public void delete(Ulid id) throws NotFoundException {
        var optional = materialRepository.getById(id);
        if(optional.isPresent()) {
            var dbMaterial = optional.get();
            dbMaterial.setEnabled(false);
            dbMaterial.setUpdatedAt(OffsetDateTime.now());
            materialRepository.delete(dbMaterial);
            return;
        }
        throw new NotFoundException("Recurso não existe");
    }

    @Override
    public Optional<Material> getById(Ulid id) {
        return materialRepository.getById(id);
    }
}
