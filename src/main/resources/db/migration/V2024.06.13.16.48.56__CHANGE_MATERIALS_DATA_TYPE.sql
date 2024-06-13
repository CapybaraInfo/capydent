alter table materials drop column created_at;
alter table materials drop column updated_at;
alter table materials add column created_at timestamp with time zone DEFAULT current_timestamp;
alter table materials add column updated_at timestamp with time zone DEFAULT current_timestamp;