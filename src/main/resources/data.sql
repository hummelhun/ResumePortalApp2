insert into user(id, user_name, password, active, roles) values
(1, 'testuser', 'testuser', true, 'USER'),
(2, 'einstein', 'einstein', true, 'USER'),
(3, 'newton', 'newton', true, 'USER');

insert into user_profile(id, user_name, theme, summary, first_name, last_name, email, phone, designation) values
(1, 'einstein', '1', 'Developing the theory of relativity, but also I made important contributions to the development of the theory of quantum mechanics.', 'Albert', 'Einstein', 'einstein@mail.com', '0641-852-8993', 'theoretical physicist'),
(2, 'newton', '2', 'I am an English mathematician, physicist, astronomer, theologian, and author who is widely recognised as one of the greatest mathematicians and most influential scientists of all time and as a key figure in the scientific revolution.', 'Isaac', 'Newton', 'newton@mail.com', '0639-561-3289', 'mathematician, physicist, astronomer, theologian');