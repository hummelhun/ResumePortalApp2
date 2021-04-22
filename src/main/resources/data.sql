insert into user(id, user_name, password, active, roles) values
(1, 'foo', 'foo', true, 'USER'),
(2, 'bar', 'bar', true, 'USER'),
(3, 'bar2', 'bar2', true, 'USER');

insert into user_profile(id, user_name, theme, summary) values
(1, 'foo', '1', 'User name foo'),
(2, 'bar', '2', 'User name bar'),
(3, 'bar2', '3', 'User name bar2');