-- Criação do tipo ENUM para o status (se ele ainda não existir)
-- Nota: O bloco DO é usado para garantir que o script não falhe se o tipo já existir
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'status_email') THEN
CREATE TYPE status_email AS ENUM ('PENDING', 'FAILED', 'SENT', 'DELIVERED');
END IF;
END$$;

-- Criação da tabela TB_MAIL
CREATE TABLE IF NOT EXISTS TB_MAIL (
                                       email_id UUID PRIMARY KEY,
                                       user_id UUID NOT NULL,
                                       email_from VARCHAR(255) NOT NULL,
    email_to VARCHAR(255) NOT NULL,
    email_subject VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    send_date_email TIMESTAMP NOT NULL,
    email_status status_email NOT NULL
    );