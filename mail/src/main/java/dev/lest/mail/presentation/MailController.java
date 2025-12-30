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

@RestController
@RequestMapping("api/v1/mail/")
@RequiredArgsConstructor
public class MailController {

    //Instancia dos Mapper`s:
    private CreateMailMapper createMapper;
    private UpdateMailMapper updateMapper;
    private MailMapper mapper;
    private DeleteMailMapper deleteMapper;

    //Instancia de service:
    private MailService service;

    @PostMapping("create/")
    public ResponseEntity<Map<CreateMailRespose, String>> createMailEndPoint(@RequestBody CreateMailRequest createMailRequest) {

        MailEntity entity = createMapper.map(createMailRequest);
        CreateMailRespose respose = createMapper.map(service.create(entity));
        Map<CreateMailRespose, String> resultMap = Map.of(
                respose,
                "The email was created successfully."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @GetMapping("find/")
    public ResponseEntity<Map<MailRespose, String>> findMailEndPoint(@RequestBody MailRequest mailRequest) {

        MailEntity entity = mapper.map(mailRequest);
        MailRespose respose = mapper.map(service.find(entity));
        Map<MailRespose, String> resultMap = Map.of(
                respose,
                "The email was successfully found."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @PatchMapping("update/")
    public ResponseEntity<Map<UpdateMailRespose, String>> updateMailEndPoint(@RequestBody UpdateMailRequest updateMailRequest) {

        MailEntity entity = updateMapper.map(updateMailRequest);
        UpdateMailRespose response = updateMapper.map(service.update(entity));
        Map<UpdateMailRespose, String> resultMap = Map.of(
                response,
                "The email was successfully changed."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }

    @DeleteMapping("delete/")
    public ResponseEntity<Map<DeleteMailRespose, String>> deleteMailEndPoint(@RequestBody DeleteMailRequest deleteMailRequest) {

        MailEntity entity = deleteMapper.map(deleteMailRequest);
        DeleteMailRespose respose = deleteMapper.map(service.delete(entity));
        Map<DeleteMailRespose, String> resultMap = Map.of(
                respose,
                "The email was successfully deleted."
        );
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(resultMap);
    }
}
