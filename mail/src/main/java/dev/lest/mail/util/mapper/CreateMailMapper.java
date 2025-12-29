package dev.lest.mail.util.mapper;

import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.dto.response.MailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CreateMailMapper {

    MailEntity map(CreateMailRequest createMailRequest);
    MailRespose map(MailEntity mailEntity);

}
