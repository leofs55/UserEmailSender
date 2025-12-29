package dev.lest.mail.service;

import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.repository.MailRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MailService {

    private MailRepository repository;

    public MailService(MailRepository repository) {
        this.repository = repository;
    }

    MailEntity create(MailEntity mail){
        return repository.save(mail);
    }

    MailEntity find(MailEntity mail){
        return repository.findById(mail.getEmailId()).get();
    }

    MailEntity update(MailEntity mail){
        return repository.save(mail);
    }

    MailEntity delete(MailEntity mail){
        return new MailEntity();
    }
}
