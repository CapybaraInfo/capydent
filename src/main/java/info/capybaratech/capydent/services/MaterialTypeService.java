package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;
import info.capybaratech.capydent.exceptions.NotFoundException;

import java.util.Collection;
import java.util.Optional;

public interface MaterialTypeService {
    Collection<MaterialType> filter(Boolean enabled);

    MaterialType insert(MaterialType materialType);

    MaterialType update(MaterialType materialType) throws NotFoundException;

    void delete(Ulid id) throws NotFoundException;

    Optional<MaterialType> getById(Ulid id);

}
