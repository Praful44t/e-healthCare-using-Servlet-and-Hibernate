select * from hospital.user_entity;
select * from hospital.faculty_entity;
select * from hospital.appointment;
select * from hospital.department;
select * from hospital.room;
select * from hospital.admin_entity;


insert into hospital.admin_entity(fname,mailid,password) 
		values('Prafult','prYda315@gmail.com','üþh|mÑð');   
		
insert into hospital.department(deptname) 
		values('Cardiologist'),
			  ('Surgeon'),
			  ('Dermatologist'),
			  ('Physician'),
			  ('Gastroenterologist'),
			  ('Neurologist'),
			  ('Gynecologist'),
			  ('Oncologist'),
			  ('Pediatrician'),
			  ('Psychiatrist'),
			  ('Pulmonologist'),
			  ('Rheumatologist'),
			  ('Urologist');


insert into hospital.room(beds,tier)
		values (2,'A'),
			   (3,'S'),
			   (1,'B'),
			   (1,'B'),
			   (1,'C'),
			   (2,'A'),
			   (3,'S'),
			   (1,'B'),
			   (1,'B'),
			   (1,'C'),
			   (2,'A'),
			   (3,'S'),	
			   (1,'B'),
			   (1,'B'),
			   (1,'C');


		
alter table appointment alter column appoint_id type serial;

alter table doctor alter column fees drop not null;
alter table doctor add column mailid varchar(30) not null unique;
alter table doctor add column password varchar(15) not null unique;
alter table user_table alter column phone drop not null;
alter table patient add column password varchar(15) not null unique;
alter table hospital.room add column available boolean default true;
alter table faculty alter column available type boolean;

delete from user_table where uid = 5;
delete from doctor where uid = 6;


alter table adminEntity
alter column password type varchar(30);

UPDATE adminEntity
SET password = 'üþh|mÑð'
WHERE adminid = 1;

select * from patient where password = '';

alter table appointment add column patient_id integer not null;
alter table appointment add column patient_id integer not null;
alter table user_table drop column phone;
alter table faculty add column available boolean default true;

ALTER TABLE public.appointment
    ADD FOREIGN KEY (patient_id)
    REFERENCES public.user_table (uid)
    NOT VALID;

ALTER TABLE public.appointment
    ADD FOREIGN KEY (doc_id)
    REFERENCES public.faculty (fid)
    NOT VALID;

UPDATE room
SET available = true
WHERE rno = 3;

alter table hospital.faculty_entity rename column maildid to mailid;
alter table hospital.faculty_entity drop column available;
alter table hospital.faculty_entity add column available boolean not null default true;

insert into admin(fullname,mailid,password)
 		values ('PrafulT','prafulthangappa@abc','üþh|mÑð');
		
SELECT 
   COUNT(available) 
FROM 
   faculty
WHERE
   available is true;			   
   
ALTER SCHEMA public RENAME TO hospital;  

