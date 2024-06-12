package info.capybaratech.capydent.services;

import com.github.f4b6a3.ulid.Ulid;
import info.capybaratech.capydent.entities.MaterialType;

import java.util.Collection;
import java.util.Optional;

public interface MaterialTypeService {
    Collection<MaterialType> filter(Boolean enabled);

    void insert(MaterialType materialType);

    void update(MaterialType materialType);

    void delete(Ulid id);

    Optional<MaterialType> getById(Ulid id);

}
