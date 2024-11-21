CREATE TABLE IF NOT EXISTS "session"
(
    id               UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    create_date_time TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP,
    update_date_time TIMESTAMPTZ      DEFAULT CURRENT_TIMESTAMP,
    auth_token       VARCHAR(255) NOT NULL,
    refresh_token    VARCHAR(255) NOT NULL,
    user_id          UUID         NOT NULL,
    role_id          UUID,                  -- Якщо роль є обов’язковою, можна додати NOT NULL
    permission_id    UUID,                  -- Якщо permission є обов’язковим, можна додати NOT NULL
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES "role" (id),
    FOREIGN KEY (permission_id) REFERENCES "permission" (id)
);


-- DROP TABLE "session" CASCADE ;
-- DELETE FROM DATABASECHANGELOG WHERE filename = 'db/changelog/0.0.1/session_changelog.sql';