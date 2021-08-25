package in.tp.lms;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import in.tp.lms.entity.LoanEntity;
import in.tp.lms.entity.LoanStatus;
import in.tp.lms.repo.LoanRepo;

@SpringBootApplication
@EnableFeignClients("in.tp.lms.service")
@EnableDiscoveryClient
public class LoanMicroServiceApplication implements ApplicationRunner{

	@Autowired
	private LoanRepo loanRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LoanMicroServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(loanRepo.findAll().isEmpty()) {
			loanRepo.save(new LoanEntity(1,"Vamsy",LocalDate.now(),550000,4,LoanStatus.APPROVED,1));
			loanRepo.save(new LoanEntity(2,"Kiran",LocalDate.now(),650000,5,LoanStatus.APPROVED,2));
			loanRepo.save(new LoanEntity(3,"Rahul",LocalDate.now(),500000,6,LoanStatus.APPROVED,1));
			loanRepo.save(new LoanEntity(4,"Vijay",LocalDate.now(),750000,4,LoanStatus.APPROVED,3));
		}
	}
}
