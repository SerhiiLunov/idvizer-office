CREATE TABLE IF NOT EXISTS "verification" (
                                id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                                update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                                enduser_id UUID NOT NULL,
                                package_id UUID,
                                FOREIGN KEY (enduser_id) REFERENCES "user"(id),
                                FOREIGN KEY (package_id) REFERENCES "package"(id)
);