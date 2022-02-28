package com.dego.awscoolsite.database;

import com.dego.awscoolsite.profile.UserProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "dego12", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "alb", null));
        USER_PROFILES.add(new UserProfile(UUID.randomUUID(), "ye", null));

    }

    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES;
    }
}
