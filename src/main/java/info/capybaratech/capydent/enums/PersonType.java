package info.capybaratech.capydent.enums;

import info.capybaratech.capydent.ultils.CnpjGroup;
import info.capybaratech.capydent.ultils.CpfGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PersonType {
    INDIVIDUAL(CpfGroup.class),
    COMPANY(CnpjGroup.class);

    private final Class<?> group;
}
