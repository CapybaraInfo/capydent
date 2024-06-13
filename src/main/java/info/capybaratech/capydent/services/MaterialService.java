package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.Material;
import info.capybaratech.capydent.exceptions.NotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface MaterialService {
    Collection<Material> filter(Boolean enabled, Ulid materialTypeId, String description);
    Material insert(Material material);
    Material update(Material material) throws NotFoundException;
    void delete(Ulid id) throws NotFoundException;
    Optional<Material> getById(Ulid id);
}
