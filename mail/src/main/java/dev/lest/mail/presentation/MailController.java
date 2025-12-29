package dev.lest.mail.presentation;

import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.dto.request.DeleteMailRequest;
import dev.lest.mail.dto.request.MailRequest;
import dev.lest.mail.dto.request.UpdateMailRequest;
import dev.lest.mail.dto.response.CreateMailRespose;
import dev.lest.mail.dto.response.DeleteMailRespose;
import dev.lest.mail.dto.response.MailRespose;
import dev.lest.mail.dto.response.UpdateMailRespose;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/mail/")
public class MailController {
    @PostMapping("create/")
    ResponseEntity<Map<CreateMailRespose, String>> createMailEndPoint(@RequestBody CreateMailRequest createMailRequest) {
        Map<CreateMailRespose, String> resultMap = Map.of(CreateMailRespose.builder().build(), "String test.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/")
    ResponseEntity<Map<MailRespose, String>> findMailEndPoint(@RequestBody MailRequest mailRequest) {
        Map<MailRespose, String> resultMap = Map.of(MailRespose.builder().build(), "String test.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @PatchMapping("update/")
    ResponseEntity<Map<UpdateMailRespose, String>> updateMailEndPoint(@RequestBody UpdateMailRequest updateMailRequest) {
        Map<UpdateMailRespose, String> resultMap = Map.of(UpdateMailRespose.builder().build(), "String test.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @DeleteMapping("delete/")
    ResponseEntity<Map<DeleteMailRespose, String>> deleteMailEndPoint(@RequestBody DeleteMailRequest deleteMailRequest) {
        Map<DeleteMailRespose, String> resultMap = Map.of(DeleteMailRespose.builder().build(), "String test.");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
