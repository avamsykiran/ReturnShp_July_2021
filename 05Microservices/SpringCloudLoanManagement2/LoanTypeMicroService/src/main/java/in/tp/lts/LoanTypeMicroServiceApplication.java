package in.tp.lts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.tp.lts.entity.LoanTypeEntity;
import in.tp.lts.repo.LoanTypeRepo;

@SpringBootApplication
public class LoanTypeMicroServiceApplication implements ApplicationRunner{

	@Autowired
	private LoanTypeRepo repo;
	
	public static void main(String[] args) {
		SpringApplication.run(LoanTypeMicroServiceApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(repo.findAll().isEmpty()) {
			repo.save(new LoanTypeEntity(1,"Home Loan",6.5));
			repo.save(new LoanTypeEntity(2,"Education Loan",16.5));
			repo.save(new LoanTypeEntity(3,"Agricultural Loan",9.5));
			repo.save(new LoanTypeEntity(4,"Personal Loan",19.5));
			repo.save(new LoanTypeEntity(5,"Bussiness Loan",12.0));
		}
	}

}
