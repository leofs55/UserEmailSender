

CREATE TABLE TB_MAIL(
    email_id UUID PRIMARY KEY,
    user_id UUID,
    email_from VARCHAR(255) NOT NULL,
    email_to VARCHAR(255) NOT NULL,
    email_subject VARCHAR(255) NOT NULL,
    body TEXT,
    send_date_email ,
    email_status
);