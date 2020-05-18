package com.exigent.verify.portal;

import java.util.List;
import lombok.Data;

@Data
public class LoggedInUser{

    private String username;
    private String displayName;
    private String profileId;
    private List<UserMessages> messages;
    private List<UserNotifications> notifications;

}
