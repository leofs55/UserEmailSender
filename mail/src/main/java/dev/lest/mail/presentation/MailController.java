package dev.lest.mail.presentation;

import dev.lest.mail.dto.request.CreateMailRequest;
import dev.lest.mail.dto.request.DeleteMailRequest;
import dev.lest.mail.dto.request.MailRequest;
import dev.lest.mail.dto.request.UpdateMailRequest;
import dev.lest.mail.dto.response.CreateMailRespose;
import dev.lest.mail.dto.response.DeleteMailRespose;
import dev.lest.mail.dto.response.MailRespose;
import dev.lest.mail.dto.response.UpdateMailRespose;
import dev.lest.mail.entity.MailEntity;
import dev.lest.mail.service.MailService;
import dev.lest.mail.util.mapper.CreateMailMapper;
import dev.lest.mail.util.mapper.DeleteMailMapper;
import dev.lest.mail.util.mapper.MailMapper;
import dev.lest.mail.util.mapper.UpdateMailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/mail/")
@RequiredArgsConstructor
public class MailController {

    //Instancia dos Mapper`s:
    private final CreateMailMapper createMapper;
    private final UpdateMailMapper updateMapper;
    private final MailMapper mapper;
    private final DeleteMailMapper deleteMapper;

    //Instancia de service:
    private final MailService service;

    @PostMapping("create/")
    public ResponseEntity<Map<String, Object>> createMailEndPoint(@RequestBody CreateMailRequest createMailRequest) {

        MailEntity entity = createMapper.createMailRequestToMailEntity(createMailRequest);
        CreateMailRespose response = createMapper.mailEntityToCreateMailRespose(service.create(entity));
        Map<String, Object> resultMap = Map.of(
                "mail: ", response,
                "result: ","The email was created successfully."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/")
    public ResponseEntity<Map<String, Object>> findMailEndPoint(@RequestBody MailRequest mailRequest) {

        MailEntity entity = mapper.mailRequestToMailEntity(mailRequest);
        MailRespose response = mapper.mailEntityToMailRespose(service.find(entity));
        Map<String, Object> resultMap = Map.of(
                "mail: ", response,
                "result: ","The email was successfully found."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/by/user/{userId}")
    public ResponseEntity<Map<String, Object>> findMailEndPoint(@PathVariable UUID userId) {

        Map<String, Object> resultMap = Map.of(
                "mail: ", service.findByUserId(userId),
                "result: ","The email was successfully found."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @PatchMapping("update/")
    public ResponseEntity<Map<String, Object>> updateMailEndPoint(@RequestBody UpdateMailRequest updateMailRequest) {

        MailEntity entity = updateMapper.updateMailRequestToMailEntity(updateMailRequest);
        UpdateMailRespose response = updateMapper.mailEntityToUpdateMailRespose(service.update(entity));
        Map<String, Object> resultMap = Map.of(
                "mail: ", response,
                "result: ","The email was successfully changed."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @DeleteMapping("delete/")
    public ResponseEntity<Map<String, Object>> deleteMailEndPoint(@RequestBody DeleteMailRequest deleteMailRequest) {

        MailEntity entity = deleteMapper.deleteMailRequestToMailEntity(deleteMailRequest);
        DeleteMailRespose respose = deleteMapper.mailEntityToDeleteMailRespose(service.delete(entity));
        Map<String, Object> resultMap = Map.of(
                "mail: ", respose,
                "result: ","The email was successfully deleted."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
