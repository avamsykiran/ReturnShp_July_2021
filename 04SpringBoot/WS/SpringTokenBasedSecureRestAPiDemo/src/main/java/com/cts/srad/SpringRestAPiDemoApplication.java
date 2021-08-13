package com.cts.srad;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.srad.entity.D2HUser;
import com.cts.srad.entity.D2HUserRole;
import com.cts.srad.repo.D2HUserRepo;

@SpringBootApplication
public class SpringRestAPiDemoApplication implements ApplicationRunner{

	@Autowired
	private D2HUserRepo userRepo;
	
	@Autowired
	private PasswordEncoder pwdEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestAPiDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(userRepo.findByEmailId("admin@d2h.com")==null) {
			userRepo.save(new D2HUser("admin@d2h.com", pwdEncoder.encode("admin"), D2HUserRole.ADMIN));
			LoggerFactory.getLogger(this.getClass()).info("Default admin user created");
		}else {
			LoggerFactory.getLogger(this.getClass()).info("Default admin user found already");
		}
	}

}
