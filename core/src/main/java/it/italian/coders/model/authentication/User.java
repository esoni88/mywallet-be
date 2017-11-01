package it.italian.coders.model.authentication;


import com.fasterxml.jackson.annotation.JsonIgnore;
import it.italian.coders.model.BaseDocument;
import it.italian.coders.model.social.SocialEnum;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Document
public class User extends BaseDocument {

    @Id
    @Size(min = 4, max = 30)
    @NotNull
    private String username;


    @JsonIgnore
    private String password;

    @Email
    @Indexed
    private String email;

    private String firstname;

    private String lastname;

    private String displayName;

    private SocialEnum socialEnum;

    /*
        Used to disable an user
     */
    private boolean enabled=false;

    /*
        this field is set to true after password reset
        in order to reject jwt to force a new login
     */
    private boolean isResetPassword=false;



    private List<String> authorities;

    private GenderEnum gender;

    private String profileImageUrl;

    @Builder(builderMethodName = "newBuilder")
    public User(Long version, Date created, Date updated, String username, String password, String email, String firstname, String lastname, String displayName, SocialEnum socialEnum, boolean enabled, boolean isResetPassword, List<String> authorities, GenderEnum gender, String profileImageUrl) {
        super(version, created, updated);
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.displayName = displayName;
        this.socialEnum = socialEnum;
        this.enabled = enabled;
        this.isResetPassword = isResetPassword;
        this.authorities = authorities;
        this.gender = gender;
        this.profileImageUrl = profileImageUrl;
    }
}
