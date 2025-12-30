package dev.lest.mail.service;

import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.repository.MailRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class MailService {

    private MailRepository repository;

    public MailEntity create(MailEntity mail){
        return repository.save(mail);
    }

    public MailEntity find(MailEntity mail){
        return repository.findById(mail.getEmailId()).get();
    }

    public MailEntity update(MailEntity mail){
        return repository.save(mail);
    }

    public MailEntity delete(MailEntity mail){
        repository.delete(mail);
        return mail;
    }
}
