package dev.lest.mail.util.mapper;

import dev.lest.mail.dto.request.UpdateMailRequest;
import dev.lest.mail.dto.response.UpdateMailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdadeMailMapper {

    MailEntity map(UpdateMailRequest updateMailRequest);
    UpdateMailRespose map(MailEntity mailEntity);

}
