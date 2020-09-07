package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private ApplicationUserRepository applicationUserRepository;

    public UserService(ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;}

        public Optional<ApplicationUser> findById(Long id){ return applicationUserRepository.findById(id);}

    }


