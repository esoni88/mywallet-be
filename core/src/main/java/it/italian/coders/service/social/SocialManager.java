package it.italian.coders.service.social;

import it.italian.coders.model.authentication.User;
import it.italian.coders.model.social.SocialEnum;

public interface SocialManager {

    User updInsSocialUser(SocialEnum socialEnum, String userId, String accessToken);

}
