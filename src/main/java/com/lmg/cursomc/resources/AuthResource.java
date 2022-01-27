package com.lmg.cursomc.resources;

import com.lmg.cursomc.dto.EmailDTO;
import com.lmg.cursomc.security.JWTUtil;
import com.lmg.cursomc.security.UserSS;
import com.lmg.cursomc.service.AuthService;
import com.lmg.cursomc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    /**
     * Endpoint para atualizar a validade do token
     * @param response
     * @return
     */
    @RequestMapping(value = "/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response){
        UserSS user = UserService.authenticated();
        String token = jwtUtil.generateToken(user.getUsername());
        response.addHeader("Authorization", "Bearer "+ token);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/forgot")
    @PostMapping
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto){
        authService.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }

}
