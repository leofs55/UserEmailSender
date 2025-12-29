package dev.lest.mail.util.mapper;
import dev.lest.mail.dto.request.DeleteMailRequest;
import dev.lest.mail.dto.response.DeleteMailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeleteMailMapper {

    MailEntity map(DeleteMailRequest deleteMailRequest);
    DeleteMailRespose map(MailEntity mailEntity);

}
