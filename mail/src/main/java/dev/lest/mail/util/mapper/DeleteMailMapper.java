package dev.lest.mail.util.mapper;
import dev.lest.mail.dto.request.DeleteMailRequest;
import dev.lest.mail.dto.response.DeleteMailRespose;
import dev.lest.mail.entity.MailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeleteMailMapper {

    MailEntity deleteMailRequestToMailEntity(DeleteMailRequest deleteMailRequest);
    DeleteMailRespose mailEntityToDeleteMailRespose(MailEntity mailEntity);

}
