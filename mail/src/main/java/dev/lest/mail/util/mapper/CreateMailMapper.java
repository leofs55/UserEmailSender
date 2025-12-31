package dev.lest.mail.util.mapper;

import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.dto.response.CreateMailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateMailMapper {

    MailEntity createMailRequestToMailEntity(CreateMailRequest createMailRequest);
    CreateMailRespose mailEntityToCreateMailRespose(MailEntity mailEntity);

}
