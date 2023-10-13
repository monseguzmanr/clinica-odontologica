package com.backend.clase.test;

import com.backend.clase.model.Mail;
import com.backend.clase.service.MailService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailServiceTest {

    private final MailService mailService = new MailService();

    @Test
    void deberiaPasarASpam(){
        //arrange
        Mail mail = new Mail("lkuylkjghlkjh", "lu@gmail.com", "ldkjghdi@colmena.com");
        String rtaEsperada = "SPAM";

        //act
        String rtaObtenida = mailService.procesarMail(mail);

        //assert
        assertEquals(rtaEsperada, rtaObtenida);
    }
}