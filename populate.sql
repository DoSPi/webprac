INSERT INTO department VALUES
(1,'Central','Russia, Moscow, Sadovnicheskaya st., 6'),
(2,'North Star','Russia, St Petersburg, Kamskaya st., 24'),
(3,'Sun','USA, New York, 79 Kingston Ave');
INSERT INTO client VALUES
(1,'Ivan ivanov','{"Russia, Moscow, Red Square"}','{"ivan@gmail.com","ivan1950@yandex.ru"}','{"89257562345"}'),
(2,'Vector','{"Russia, St. Petersburg, Ivanovskaya st., 5"}','{"help@vector.ru"}','{"89156789823"}'),
(3,'Dmitry Amerhanov','{"USA, Los Angeles, Graciosa Dr"}','{"holymoly@gmail.com","amerhanovus@gmail.com"}','{"1"}');
INSERT INTO type VALUES
(1, 'ez profit', 1000, 10, 1.1, 365, 5000, 5000),
(2, 'debit', 0, 0, 1.2, 365, 0, 1000),
(3,'loan shark', 5000 ,30, 1,0, 20000, 1000);
INSERT INTO account VALUES
(1,1,125.35,1,1,1,'2019-03-02','False'),
(2,1,10.1,2,1,2,'2019-12-21','False'),
(3,2,0,3,3,3,'2020-02-02','False');
INSERT INTO transaction VALUES
(1, 1, '2020-02-20 15:24:23', -15.23,'Покупка 15.23 в магазине Пятерочка'),
(2,1,'2020-02-25 10:10:10', 100, NULL),
(3,2,'2020-02-28 23:00:05', -2, NULL);
 
