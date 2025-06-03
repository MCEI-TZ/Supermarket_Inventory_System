package com.mceit_z.Inventory_System.services.user.impl;

import com.mceit_z.Inventory_System.models.UserProfile;
import com.mceit_z.Inventory_System.repo.IUser;
import com.mceit_z.Inventory_System.services.generic.Impl.GenericServiceIImpl;
import com.mceit_z.Inventory_System.services.user.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl extends GenericServiceIImpl<UserProfile, Long, IUser> implements UserProfileService {
}
