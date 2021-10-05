package base.main.fx_deals.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import base.main.fx_deals.controller.JwtAuthenticationController;
import base.main.fx_deals.extraClasses.JwtRequest;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	FxService FxService;

	@Autowired
	private JwtAuthenticationController auth;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtRequest req = auth.getUserInfo();
		//System.out.println(req.toString());
		if (FxService.isAuthenticUser(username, req.getPassword())) {
			String pass = auth.encodeData(req.getPassword());
			return new User(username, pass, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}