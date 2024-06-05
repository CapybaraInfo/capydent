package info.capybaratech.capydent.enums;

import lombok.Getter;
public enum FederationUnit {
    AMAZONAS("Amazonas", "AM"), ALAGOAS("Alagoas", "AL"), ACRE("Acre", "AC"), AMAPA("Amapá", "AP"), BAHIA("Bahia", "BA"), PARA("Pará", "PA"), MATO_GROSSO("Mato Grosso", "MT"), MINAS_GERAIS("Minas Gerais", "MG"), MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"), GOIAS("Goiás", "GO"), MARANHAO("Maranhão", "MA"), RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"), TOCANTINS("Tocantins", "TO"), PIAUI("Piauí", "PI"), SAO_PAULO("São Paulo", "SP"), RONDONIA("Rondônia", "RO"), RORAIMA("Roraima", "RR"), PARANA("Paraná", "PR"), CEARA("Ceará", "CE"), PERNAMBUCO("Pernambuco", "PE"), SANTA_CATARINA("Santa Catarina", "SC"), PARAIBA("Paraíba", "PB"), RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN"), ESPIRITO_SANTO("Espírito Santo", "ES"), RIO_DE_JANEIRO("Rio de Janeiro", "RJ"), SERGIPE("Sergipe", "SE"), DISTRITO_FEDERAL("Distrito Federal", "DF");
    @Getter
    private final String displayName;
    private final String abbreviation;

    FederationUnit(final String name, final String abbreviation) {
        this.displayName = name;
        this.abbreviation = abbreviation;
    }


    public static FederationUnit fromAbbreviation(final String abbreviation) {
        for (final FederationUnit unit : values()) {
            if (unit.abbreviation.equalsIgnoreCase(abbreviation)) {
                return unit;
            }
        }

        throw new IllegalArgumentException(abbreviation);
    }

    public static FederationUnit fromName(final String name) {
        for (final FederationUnit unit : values()) {
            if (unit.displayName.equalsIgnoreCase(name)) {
                return unit;
            }
        }

        throw new IllegalArgumentException(name);
    }

}
