package com.dego.awscoolsite.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository)
    {
        this.userProfileRepository = userProfileRepository;
    }

    public List<UserProfile> getUserProfiles()
    {
        return this.userProfileRepository.getUserProfiles();
    }

    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file) {

    }
}
