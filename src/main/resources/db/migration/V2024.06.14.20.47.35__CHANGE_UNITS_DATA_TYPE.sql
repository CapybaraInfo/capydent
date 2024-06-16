alter table units drop column created_at;
alter table units drop column updated_at;
alter table units add column created_at timestamp with time zone DEFAULT current_timestamp;
alter table units add column updated_at timestamp with time zone DEFAULT current_timestamp;