package dev.lest.mail.service;

import dev.lest.mail.repository.MailRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MailService {

    private MailRepository repository;

    public MailService(MailRepository repository) {
        this.repository = repository;
    }

    Object create(Object mail){
        return new Object();
    }

    Object find(Object mail){
        return new Object();
    }

    Object update(Object mail){
        return new Object();
    }

    Object delete(Object mail){
        return new Object();
    }
}
