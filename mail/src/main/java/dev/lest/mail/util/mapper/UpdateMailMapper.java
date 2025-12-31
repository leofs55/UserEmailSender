package dev.lest.mail.util.mapper;

import dev.lest.mail.dto.request.UpdateMailRequest;
import dev.lest.mail.dto.response.UpdateMailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UpdateMailMapper {

    MailEntity updateMailRequestToMailEntity(UpdateMailRequest updateMailRequest);
    UpdateMailRespose mailEntityToUpdateMailRespose(MailEntity mailEntity);

}
