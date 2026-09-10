CREATE DATABASE bank_management_db;

CREATE TABLE customers (
	customer_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
	birth_date DATE NOT NULL,
	sex CHAR(1) NOT NULL CHECK(sex IN ('M','F'))
);


CREATE TABLE address(
	address_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_id BIGINT,
	brgy VARCHAR(50) NOT NULL,
	municipality VARCHAR(50) NOT NULL,
	province VARCHAR(50) NOT NULL,
	postal_code VARCHAR(4) NOT NULL,
	country VARCHAR(50) NOT NULL,
	FOREIGN KEY(customer_id)
		REFERENCES customers(customer_id)
                    ON DELETE CASCADE

);


CREATE TABLE contacts(
	contact_id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_id BIGINT,
	mobile_number VARCHAR(15) NOT NULL,
	email_address VARCHAR(100),
	telephone_number VARCHAR(30) DEFAULT "N/A",

	FOREIGN KEY(customer_id)
		REFERENCES customers(customer_id)
                     ON DELETE CASCADE ;
);


CREATE TABLE bank_accounts(
	account_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	customer_id BIGINT,
	account_no VARCHAR(12) UNIQUE NOT NULL ,
	account_type VARCHAR(50) NOT NULL,
	balance DECIMAL(19,2) NOT NULL DEFAULT 0.00,


	FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
                          ON DELETE CASCADE
);

CREATE TABLE savings_account(
	account_id INT PRIMARY KEY REFERENCES bank_accounts(account_id) ON DELETE CASCADE ,
	interest_rate decimal(5,4) NOT NULL,
	daily_withdrawal_limit INT DEFAULT 6

);

CREATE TABLE checking_accounts(
	account_id INT PRIMARY KEY REFERENCES bank_accounts(account_id) ON DELETE CASCADE ,
	overdraft_limit DECIMAL(15,2) DEFAULT 0.00, -- P0 means overdraft is turned off
	overdraft_interest_rate DECIMAL(5,4) DEFAULT 0.00,
	bounced_check_fee DECIMAL(15,2) DEFAULT 2000.00
);