#PostgreSQL

create table BRANCH(
	Branch_Code char(4) PRIMARY KEY,
	Branch_Name varchar(20) NOT NULL,
	Branch_Address1 varchar(40) NOT NULL,
	Branch_City varchar(25) NOT NULL,
	Branch_State varchar(20) NOT NULL,
	Branch_PINCODE char(6) NOT NULL
);

create table CUSTOMER(
	Cust_ID serial PRIMARY KEY,
	Branch_Code char(4),
	Cust_FirstName varchar(25) NOT NULL,
	Cust_MiddleName varchar(25),
	Cust_LastName varchar(25) NOT NULL,
	Cust_username varchar(20) NOT NULL UNIQUE,
	Cust_DOB DATE NOT NULL,
	Cust_email varchar(30) NOT NULL UNIQUE,
	Cust_passwd varchar(16) NOT NULL,
	Cust_Gender char(1) NOT NULL,
	Cust_Address1 varchar(40) NOT NULL,
	Cust_City varchar(25) NOT NULL,
	Cust_State varchar(20) NOT NULL,
	Cust_PINCODE char(6) NOT NULL
);

create table ACCOUNT(
	Acc_No serial PRIMARY KEY,
	Branch_Code char(4),
	Cust_ID int NOT NULL,
	Acc_Type varchar(10) NOT NULL,
	Acc_Balance decimal default 0.0
);

create table TRANSACTION(
	Tx_ID serial PRIMARY KEY,
	Branch_Code char(4),
	Acc_No int NOT NULL,
	Cust_ID int NOT NULL,
	Tx_type varchar(10) NOT NULL,
	Tx_time timestamp NOT NULL,
	Tx_desc varchar(40) NOT NULL,
	Tx_amount decimal NOT NULL,
);

ALTER TABLE customer
ADD CONSTRAINT cust_branch_fk FOREIGN KEY (branch_code) REFERENCES branch (branch_code) ON DELETE CASCADE;

ALTER TABLE account
ADD CONSTRAINT acc_branch_fk FOREIGN KEY (branch_code) REFERENCES branch (branch_code) ON DELETE CASCADE;

ALTER TABLE account
ADD CONSTRAINT acc_cust_fk FOREIGN KEY (cust_id) REFERENCES customer (cust_id) ON DELETE CASCADE;

ALTER TABLE transaction
ADD CONSTRAINT tx_branch_fk FOREIGN KEY (branch_code) REFERENCES branch (branch_code) ON DELETE CASCADE;

ALTER TABLE transaction
ADD CONSTRAINT tx_cust_fk FOREIGN KEY (cust_id) REFERENCES customer (cust_id) ON DELETE CASCADE;

ALTER TABLE transaction
ADD CONSTRAINT tx_acc_fk FOREIGN KEY (acc_no) REFERENCES account (acc_no) ON DELETE CASCADE;

INSERT INTO branch (Branch_Code, Branch_Name, Branch_Address1, Branch_City, Branch_State, Branch_PINCODE) VALUES
    ('A1B2', 'ECITY', '26/c, hosur road', 'Bengaluru', 'karnataka', '560100'),
    ('C1D2', 'NDL', 'A/2, CP', 'New Delhi', 'Delhi', '110001'),
    ('E1F2', 'AHMDBD', 'B/2, random chowk', 'Ahemedabad', 'Gujrat', '380024');

INSERT INTO CUSTOMER (Cust_ID, Branch_Code, Cust_FirstName, Cust_LastName, Cust_username, Cust_DOB, Cust_email,
	Cust_passwd, Cust_Gender, Cust_Address1, Cust_City, Cust_State, Cust_PINCODE) VALUES
    (DEFAULT, 'A1B2', 'Gaurav', 'Joshi', 'go_josh', '1995-01-01', 'gj@gmail.com', 'mai_hu_morgan', 'M', 'abcd chowk,gujrat', 'ahemedabad', 'gujrat', '380024'),
    (DEFAULT, 'C1D2', 'Pavan', 'Bharadiya', 'pro_gymmer', '1995-06-09', 'pkb@gmail.com', 'netapp_6', 'M', 'raj nagar,gujrat', 'gandhi nagar', 'gujrat', '380012'),
    (DEFAULT, 'E1F2', 'Rajeev', 'Shukla', 'shukla_ji', '1993-04-11', 'rps@gmail.com', 'carrom_ka_baap', 'M', 'any nagar,raipur', 'raipur', 'Chhattisgarh', '490042'),
    (DEFAULT, 'E1F2', 'Saurabh', 'Mehta', 'samsaurabh', '1993-09-27', 'sm@gmail.com', 'sports_lover', 'M', 'abcd apartment,delhi', 'New Delhi', 'Delhi', '110092');

INSERT INTO account (Acc_No, Branch_Code, Cust_ID, Acc_Type, Acc_Balance) VALUES
    (DEFAULT, 'A1B2', 1, 'Savings', 10000.00),
    (DEFAULT, 'C1D2', 2, 'Savings', 20000.00),
    (DEFAULT, 'E1F2', 3, 'Savings', 30000.00),
    (DEFAULT, 'A1B2', 4, 'Savings', 40000.00);

INSERT INTO transaction (Tx_ID, Branch_Code, Acc_No, Cust_ID, Tx_type, Tx_time, Tx_desc, Tx_amount) VALUES
    (DEFAULT, 'A1B2', 1, 1, 'credit', now(), 'add money', 10000.00),

