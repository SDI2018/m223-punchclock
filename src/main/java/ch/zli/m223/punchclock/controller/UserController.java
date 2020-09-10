package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import ch.zli.m223.punchclock.domain.ApplicationUser;
import ch.zli.m223.punchclock.repository.ApplicationUserRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private ApplicationUserRepository applicationUserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    public UserController(ApplicationUserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    /**
     * Registriert ein neuen Benutzerkonto
     * @param user
     */

    @PostMapping("/sign-up" )
    public void signUp(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }

    /**
     * Löscht einen bestehenden User Datensatz anhand der ID
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable("id") Long id){ applicationUserRepository.deleteById(id);}

    /**
     * Aktualisiert einen bestehenden Benutzer Datensatz
     * @param applicationUser
     * @return applicationUser
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ApplicationUser updateEntry(@Valid @RequestBody ApplicationUser applicationUser){ return userService.updateUser(applicationUser);}

}
