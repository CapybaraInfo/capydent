package info.capybaratech.capydent.ultils;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import info.capybaratech.capydent.entities.User;

public class UserValidatorProvider implements DefaultGroupSequenceProvider<User>{
    @Override
    public List<Class<?>> getValidationGroups(User user) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(User.class);

        if (isUserSelect(user)) {
            groups.add(user.getPersonType().getGroup());
        }
        return groups;
    }

    private boolean isUserSelect(User user) {
        return user != null && user.getPersonType() != null;
    }
}
