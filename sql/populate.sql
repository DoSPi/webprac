INSERT INTO department(name,address) VALUES
('Central','Russia, Moscow, Sadovnicheskaya st., 6'),
('North Star','Russia, St Petersburg, Kamskaya st., 24'),
('Sun','USA, New York, 79 Kingston Ave');
INSERT INTO client(name,address, email, phone_number) VALUES
('Ivan ivanov','Russia, Moscow, Red Square','ivan@gmail.com','89257562345'),
('Vector','Russia, St. Petersburg, Ivanovskaya st., 5','help@vector.ru','89156789823'),
('Dmitry Amerhanov','USA, Los Angeles, Graciosa Dr','holymoly@gmail.com','1');
INSERT INTO type(name, loan_max, loan_period, profitability, payment_period, add_max, sub_max) VALUES
('ez profit', 1000, 10, 1.1, 365, 5000, 5000),
('debit', 0, 0, 1.2, 365, 0, 1000),
('loan shark', 5000 ,30, 1,0, 20000, 1000);
INSERT INTO account(client_id, balance, type_id, department_id, payment_account_id, date, closed) VALUES
(1,125.35,1,1,1,'2019-03-02','False'),
(1,10.1,2,1,2,'2019-12-21','False'),
(2,0,3,3,3,'2020-02-02','False');
INSERT INTO transaction(account_id, date, value, details) VALUES
(1, '2020-02-20 15:24:23', -15.23,'Buy 15.23 Pyatorochka'),
(1,'2020-02-25 10:10:10', 100,'tesss'),
(2,'2020-02-28 23:00:05', -2, NULL);
 
