package com.spring.wecare.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.wecare.customlogindetails.CustomAdminDetails;
import com.spring.wecare.customlogindetails.CustomOfficerDetails;
import com.spring.wecare.customlogindetails.CustomUserDetails;
import com.spring.wecare.entities.Admin;
import com.spring.wecare.entities.Officer;
import com.spring.wecare.entities.User;
import com.spring.wecare.repositories.AdminRepo;
import com.spring.wecare.repositories.OfficerRepo;
import com.spring.wecare.repositories.UserRepo;

@Service
public class CustomUserDetailsImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private OfficerRepo officerRepo;
	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		Officer officer = officerRepo.findByEmail(username);
		Admin admin = adminRepo.findByEmail(username);

		if (user != null) {
			return new CustomUserDetails(user);
		} else if (officer != null) {
			return new CustomOfficerDetails(officer);
		} else if (admin != null) {
			return new CustomAdminDetails(admin);
		} else {
			throw new UsernameNotFoundException("user not found");
		}
	}
}