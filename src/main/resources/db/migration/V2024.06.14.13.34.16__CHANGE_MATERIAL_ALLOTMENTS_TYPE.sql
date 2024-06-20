alter table materials_allotments drop column created_at;
alter table materials_allotments drop column updated_at;
alter table materials_allotments add column created_at timestamp with time zone DEFAULT current_timestamp;
alter table materials_allotments add column updated_at timestamp with time zone DEFAULT current_timestamp;