package dev.lest.mail.presentation;

import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.dto.request.DeleteMailRequest;
import dev.lest.mail.dto.request.MailRequest;
import dev.lest.mail.dto.request.UpdateMailRequest;
import dev.lest.mail.dto.response.CreateMailRespose;
import dev.lest.mail.dto.response.DeleteMailRespose;
import dev.lest.mail.dto.response.MailRespose;
import dev.lest.mail.dto.response.UpdateMailRespose;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mail/")
public class MailController {
    @PostMapping("create/")
    CreateMailRespose createMailEndPoint(CreateMailRequest createMailRequest) {
        return new CreateMailRespose();
    }

    @GetMapping("find/")
    MailRespose findMailEndPoint(MailRequest mailRequest) {
        return new MailRespose();
    }

    @PatchMapping("update/")
    UpdateMailRespose updateMailEndPoint(UpdateMailRequest updateMailRequest) {
        return new UpdateMailRespose();
    }

    @DeleteMapping("delete/")
    DeleteMailRespose deleteMailEndPoint(DeleteMailRequest deleteMailRequest) {
        return new DeleteMailRespose();
    }
}
