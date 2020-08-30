CREATE TABLE department(
	department_id SERIAL PRIMARY KEY,
	name varchar(64) NOT NULL,
	address varchar(256) NOT NULL
);
CREATE TABLE client(
	client_id SERIAL PRIMARY KEY,
	name varchar(64) NOT NULL,
	address varchar(256),
	email varchar(64),
	phone_number varchar(32)

);
CREATE TABLE type(
	type_id SERIAL PRIMARY KEY,
	name varchar(64) NOT NULL,
	loan_max numeric(16,3) CHECK (loan_max >= 0),
	loan_period INT CHECK(loan_period>= 0),
	profitability numeric(10,5) CHECK (profitability >=0),
	payment_period INT CHECK(payment_period >=0),
	add_max numeric(16,3) CHECK (add_max >=0),
	sub_max numeric(16,3) CHECK(sub_max >=0)
);
CREATE TABLE account(
	account_id SERIAL PRIMARY KEY,
	client_id INT REFERENCES client ON DELETE CASCADE,
	balance numeric(16,3) NOT NULL,
	type_id INT REFERENCES type,
	department_id INT REFERENCES department ON DELETE CASCADE,
	payment_account_id INT REFERENCES account,
	date TIMESTAMP NOT NULL,
	closed BOOLEAN NOT NULL
);
CREATE TABLE transaction(
	transaction_id SERIAL PRIMARY KEY,
	account_id INT REFERENCES account ON DELETE CASCADE,
	date TIMESTAMP NOT NULL,
	value numeric(16,3) NOT NULL,
	details varchar(256)
);