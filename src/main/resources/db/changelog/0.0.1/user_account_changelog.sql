CREATE TABLE IF NOT EXISTS "user_account" (
                              id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                              create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                              update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                              user_id UUID NOT NULL,
                              account_id UUID NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES "user"(id),
                              FOREIGN KEY (account_id) REFERENCES "account"(id)
);