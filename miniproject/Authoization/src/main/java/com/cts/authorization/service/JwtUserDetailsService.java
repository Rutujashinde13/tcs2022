package com.cts.authorization.service;



import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.hibernate.annotations.common.util.impl.Log;

import com.cts.authorization.model.MyUserDeails;
import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserDao;



@Service 

public class JwtUserDetailsService implements UserDetailsService {
	private static final org.jboss.logging.Logger LOGGER = LoggerFactory.logger(JwtUserDetailsService.class);

	
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unused")
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		/** fetching user by userName, if user is null the throw exception, otherwise
		 * return user
		 */
		User user = userDao.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + userName);
		}
		
		
		LOGGER.info("User found");
		LOGGER.info("user successfully located");
	//	org.springframework.security.core.userdetails.User u=new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
		
		return new MyUserDeails(user);
		//return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
	}

}