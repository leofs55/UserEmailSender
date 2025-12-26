package dev.lest.mail.presentation;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mail/")
public class MailController {
    @PostMapping()
    Object createMailEndPoint(Object createMailRequest) {
        return new Object();
    }

    @GetMapping()
    Object findMailEndPoint(Object mailRequest) {
        return new Object();
    }

    @PatchMapping()
    Object updateMailEndPoint(Object updateMailRequest) {
        return new Object();
    }

    @DeleteMapping()
    Object deleteMailEndPoint(Object deleteMailRequest) {
        return new Object();
    }
}
