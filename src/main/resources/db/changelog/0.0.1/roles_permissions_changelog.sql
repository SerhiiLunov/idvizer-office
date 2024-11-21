CREATE TABLE IF NOT EXISTS "roles_permissions" (
                                     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                                     create_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                                     update_date_time TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
                                     role_id UUID NOT NULL,
                                     permission_id UUID NOT NULL,
                                     FOREIGN KEY (role_id) REFERENCES "role"(id),
                                     FOREIGN KEY (permission_id) REFERENCES "permission"(id)
);