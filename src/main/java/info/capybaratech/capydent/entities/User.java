package info.capybaratech.capydent.entities;

import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import info.capybaratech.capydent.enums.FederationUnit;
import info.capybaratech.capydent.enums.Gender;
import info.capybaratech.capydent.enums.PersonType;
import info.capybaratech.capydent.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private Ulid id = UlidCreator.getUlid();
    private String fullName;
    private String userName;
    private String encodedPass;
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
    private Double commission = 0.0d;
    private String mobiePhone;
    private String phone;
    private boolean enabled = true;
    private LocalDate hiringDate = LocalDate.now();
    private LocalDate terminationDate;
    private Role authority = Role.STAFF;
    private Collection<Occupation> occupations = new ArrayList<>();
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
}
