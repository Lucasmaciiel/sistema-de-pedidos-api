package com.lmg.cursomc.service;

import com.lmg.cursomc.domain.Cliente;
import com.lmg.cursomc.repository.ClienteRepository;
import com.lmg.cursomc.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void sendNewPassword(String email) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();

        cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
        clienteRepository.save(cliente);
        emailService.sendNewPasswordEmail(cliente, newPass);
    }

    /**
     * Método que gera uma nova senha com 10 caracteres
     * @return retorna a nova senha gerada
     */
    private String newPassword() {
        char[] vet = new char[10];
        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    /**
     * Método que gera um caracter randomico
     * @return um caracter
     */
    private char randomChar() {
        int opt = rand.nextInt();

        if (opt == 0) { //gera um divito
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) { // gera letra maíscula
            return (char) (rand.nextInt(26) + 65);
        } else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }
}
