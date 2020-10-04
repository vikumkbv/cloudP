package com.giga.FashionStore.controller;

import com.giga.FashionStore.model.Role;
import com.giga.FashionStore.model.Roles;
import com.giga.FashionStore.model.SiteUser;
import com.giga.FashionStore.model.User;
import com.giga.FashionStore.repository.RoleRepository;
import com.giga.FashionStore.repository.UserRepository;
import com.giga.FashionStore.request.SignInRequest;
import com.giga.FashionStore.request.SignUpRequest;
import com.giga.FashionStore.response.JwtResponse;
import com.giga.FashionStore.response.MessageResponse;
import com.giga.FashionStore.security.GigaAuthProvider;
import com.giga.FashionStore.security.JwtUtils;
import com.giga.FashionStore.service.SequenceGenerateService;
import com.giga.FashionStore.service.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * route controller for authentication requests.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SequenceGenerateService sequenceGenerateService;
    @Autowired
    GigaAuthProvider authenticationManager;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder encoder;

    // user sign up
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        SiteUser user = new SiteUser(sequenceGenerateService.generateSequence(User.SEQUENCE_NAME),
                signUpRequest.getFirstName(), signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(Roles.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
        roles.add(userRole);

        // add roles to the created user
        user.setRoles(roles);
        // save the user into the db
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }
}
