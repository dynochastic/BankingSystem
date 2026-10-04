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
	telephone_number VARCHAR(30) DEFAULT 'N/A',

	FOREIGN KEY(customer_id)
		REFERENCES customers(customer_id)
                     ON DELETE CASCADE ;
);

CREATE TABLE bank_accounts(
  account_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  customer_id BIGINT NOT NULL,

  account_no INT GENERATED ALWAYS AS IDENTITY
      (START WITH 100000)
      UNIQUE NOT NULL,

  product_id INT NOT NULL,

  balance DECIMAL(19,2) NOT NULL DEFAULT 0.00,
  opened_date DATE NOT NULL DEFAULT CURRENT_DATE,

  FOREIGN KEY(customer_id)
      REFERENCES customers(customer_id)
      ON DELETE CASCADE,

  FOREIGN KEY(product_id)
      REFERENCES account_products(product_id)
);
create table account_products(
     product_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY
         (START WITH 100) UNIQUE NOT NULL,
     product_name varchar(50),
     account_type varchar(50) NOT NULL
         CHECK (account_type IN ('savings','checking')),

     interest_rate DECIMAL (8,6),
     minimum_balance DECIMAL (19,2) NOT NULL CHECK(minimum_balance > 0)
);