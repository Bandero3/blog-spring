INSERT INTO POSTS(id, name, description, image, date)
VALUES ('15a95af7-8b83-4a08-8001-0f865db8ea27', 'Trip entry 1', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('ebdee4f9-5763-4afc-85ed-98b2fdefb35f', 'Trip entry 2', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('d06cb831-9427-41ee-adcc-271f7b02d626', 'Trip entry 3', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('ef90aee5-5337-4ebf-899f-e2823271f8c5', 'Trip entry 4', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('0e706d6b-31f1-4349-a49b-9aea3400db6a', 'Trip entry 5', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('bb2db642-6681-4e96-bff9-d226d6384efb', 'Trip entry 6', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('d96e1892-3019-4304-bd5a-1ef750be3aca', 'Trip entry 7', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35'),
       ('abdee4f9-5763-4afc-85ed-98b2fdefb35d', 'Trip entry 8', 'Description', 'https://kelioniuakademija.lt/keliones_images/shutterstock_81081028.jpg','2022-09-28 17:35');

INSERT INTO USERS(id, name, surname, username, email, country, city, password)
VALUES ('a81400ed-e6fe-43a4-83ce-87d25ec1037f', 'test_user', 'test_user', 'user','user@gmail.com', 'LT', 'Vilnius',  '{bcrypt}$2a$10$AsRCsrfh4423vjPr0xKpZeNpYixVcNtDpiGdM5xcIejUXOttH2jcu') ,
       ('6fb6b341-b44c-4247-8c2e-f172ed7222a2', 'test_admin', 'test_user', 'admin','admin@gmail.com', 'LT', 'Kaunas', '{bcrypt}$2a$10$9Ox9WgR8X5SD04lLSdCwJ.AITH/cAZmcZ9tMkqJUFYSc0krItXT9W');

INSERT INTO ROLES(id, name)
VALUES ('064bf711-f2fd-4cfc-87d9-4dade781836d','USER'),
       ('e00d4fce-10de-45e2-9f6d-899841c29622','ADMIN');

INSERT INTO USERS_ROLES(user_id, role_id)
VALUES ('a81400ed-e6fe-43a4-83ce-87d25ec1037f','064bf711-f2fd-4cfc-87d9-4dade781836d'),
       ('6fb6b341-b44c-4247-8c2e-f172ed7222a2', '064bf711-f2fd-4cfc-87d9-4dade781836d'),
       ('6fb6b341-b44c-4247-8c2e-f172ed7222a2', 'e00d4fce-10de-45e2-9f6d-899841c29622');