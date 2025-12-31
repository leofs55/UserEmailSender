package dev.lest.mail.util.mapper;
import dev.lest.mail.dto.request.MailRequest;
import dev.lest.mail.dto.response.MailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailMapper {

    MailEntity mailRequestToMailEntity(MailRequest mailRequest);
    MailRespose mailEntityToMailRespose(MailEntity mailEntity);

}
