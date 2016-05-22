package supfirst.domain.validation;

import supfirst.domain.entity.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
