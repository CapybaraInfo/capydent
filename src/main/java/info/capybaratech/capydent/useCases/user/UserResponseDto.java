package info.capybaratech.capydent.useCases.user;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Collection;

import com.github.f4b6a3.ulid.Ulid;

import info.capybaratech.capydent.entities.Occupation;
import info.capybaratech.capydent.enums.FederationUnit;
import info.capybaratech.capydent.enums.Gender;
import info.capybaratech.capydent.enums.PersonType;
import info.capybaratech.capydent.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Ulid id;
    private String fullName;
    private String userName;
    private PersonType personType;
    private String brazilianId;
    private String taxId;
    private String registrationNumber;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String addressLineOne;
    private String addressLineTwo;
    private String neighbourhood;
    private String city;
    private FederationUnit federationUnit;
    private String country;
    private String zipCode;
    private Double commission;
    private String mobiePhone;
    private String phone;
    private boolean enabled;
    private LocalDate hiringDate;
    private LocalDate terminationDate;
    private Role authority;
    private Collection<Occupation> occupations;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
