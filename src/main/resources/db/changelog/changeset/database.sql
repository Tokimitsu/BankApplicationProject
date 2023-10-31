INSERT INTO clients(status, first_name, last_name, email, password, address, phone, created_at, updated_at)
values('ACTIVE', 'John', 'Doe', 'johndoe@example.com', 'password123', '123 Main St', '+1 123-456-7890',
       TIMESTAMP '2022-01-15 10:30:00', TIMESTAMP '2022-01-15 15:45:00'),
      ('ACTIVE', 'Jane', 'Smith', 'janesmith@example.com', 'password456', '456 Elm St', '+1 987-654-3210',
       TIMESTAMP '2022-02-20 12:15:00', TIMESTAMP '2022-02-20 16:30:00'),
      ('INACTIVE', 'Bob', 'Johnson', 'bjohnson@example.com', 'password789', '789 Oak St', '+1 555-555-5555',
       TIMESTAMP '2022-03-25 09:45:00', TIMESTAMP '2022-03-25 13:20:00'),
      ('ACTIVE', 'Alice', 'Brown', 'abrown@example.com', 'passwordABC', '101 Pine St', '+1 333-333-3333',
       TIMESTAMP '2022-04-10 14:00:00', TIMESTAMP '2022-04-10 18:10:00'),
      ('INACTIVE', 'David', 'Lee', 'dlee@example.com', 'passwordXYZ', '222 Cedar St', '+1 777-777-7777',
       TIMESTAMP '2022-05-05 08:30:00', TIMESTAMP '2022-05-05 11:45:00'),
      ('ACTIVE', 'Sarah', 'Wilson', 'swilson@example.com', 'password456', '789 Willow St', '+1 999-999-9999',
       TIMESTAMP '2022-06-15 16:20:00', TIMESTAMP '2022-06-15 20:40:00'),
      ('ACTIVE', 'Michael', 'Taylor', 'mtaylor@example.com', 'password789', '567 Birch St', '+1 111-222-3333',
       TIMESTAMP '2022-07-30 11:10:00', TIMESTAMP '2022-07-30 17:25:00'),
      ('INACTIVE', 'Laura', 'Anderson', 'landerson@example.com', 'passwordXYZ', '345 Maple St', '+1 222-333-4444',
       TIMESTAMP '2022-08-10 15:55:00', TIMESTAMP '2022-08-10 19:05:00'),
      ('ACTIVE', 'James', 'Harris', 'jharris@example.com', 'password123', '678 Oak St', '+1 444-555-6666',
       TIMESTAMP '2022-09-05 14:40:00', TIMESTAMP '2022-09-05 18:50:00'),
      ('INACTIVE', 'Emily', 'Martinez', 'emartinez@example.com', 'passwordABC', '444 Cedar St', '+1 666-777-8888',
       TIMESTAMP '2022-10-20 10:00:00', TIMESTAMP '2022-10-20 15:15:00');

INSERT INTO products(name,status,currency_code,min_interest_rate,max_offer_limit,created_at,updated_at)
values ('Product 1', 'ACTIVE', 1, 2.5, 10000.00, TIMESTAMP '2022-01-05 10:30:00', TIMESTAMP '2022-01-05 11:45:00'),
       ('Product 2', 'ACTIVE', 2, 3.0, 15000.00, TIMESTAMP '2022-01-15 09:45:00', TIMESTAMP '2022-01-15 10:50:00'),
       ('Product 3', 'INACTIVE', 1, 3.5, 12000.00, TIMESTAMP '2022-02-10 15:15:00', TIMESTAMP '2022-02-10 16:30:00'),
       ('Product 4', 'ACTIVE', 2, 4.0, 18000.00, TIMESTAMP '2022-03-20 13:45:00', TIMESTAMP '2022-03-20 15:20:00'),
       ('Product 5', 'ACTIVE', 1, 2.0, 9000.00, TIMESTAMP '2022-03-25 11:30:00', TIMESTAMP '2022-03-25 14:10:00'),
       ('Product 6', 'INACTIVE', 2, 3.8, 13000.00, TIMESTAMP '2022-04-05 14:55:00', TIMESTAMP '2022-04-05 17:30:00'),
       ('Product 7', 'ACTIVE', 1, 3.2, 11000.00, TIMESTAMP '2022-04-15 08:30:00', TIMESTAMP '2022-04-15 10:45:00'),
       ('Product 8', 'ACTIVE', 2, 4.2, 16000.00, TIMESTAMP '2022-05-25 16:20:00', TIMESTAMP '2022-05-25 18:40:00'),
       ('Product 9', 'INACTIVE', 1, 3.5, 13000.00, TIMESTAMP '2022-06-10 12:10:00', TIMESTAMP '2022-06-10 17:25:00'),
       ('Product 10', 'ACTIVE', 2, 4.5, 20000.00, TIMESTAMP '2022-07-20 15:55:00', TIMESTAMP '2022-07-20 18:05:00');

INSERT INTO accounts(id, client_id, name, status,balance, currency_code, created_at, updated_at)
values (1, 1, 'Savings', 'ACTIVE', 5000.00, 1, TIMESTAMP '2022-01-15 14:30:00', TIMESTAMP '2022-01-15 15:45:00'),
       (2, 1, 'Checking', 'ACTIVE', 2500.00, 1, TIMESTAMP '2022-01-15 14:45:00', TIMESTAMP '2022-01-15 15:50:00'),
       (3, 2, 'Main', 'ACTIVE', 7500.00, 1, TIMESTAMP '2022-02-20 13:15:00', TIMESTAMP '2022-02-20 15:30:00'),
       (4, 3, 'Savings', 'BLOCKED', 3000.00, 1, TIMESTAMP '2022-03-25 10:45:00', TIMESTAMP '2022-03-25 13:20:00'),
       (5, 4, 'Checking', 'ACTIVE', 6000.00, 1, TIMESTAMP '2022-04-10 14:30:00', TIMESTAMP '2022-04-10 17:10:00'),
       (6, 4, 'Main', 'ACTIVE', 8500.00, 1, TIMESTAMP '2022-04-10 14:45:00', TIMESTAMP '2022-04-10 17:30:00'),
       (7, 5, 'Savings', 'ACTIVE', 4500.00, 1, TIMESTAMP '2022-05-05 09:30:00', TIMESTAMP '2022-05-05 11:45:00'),
       (8, 6, 'Checking', 'BLOCKED', 2000.00, 1, TIMESTAMP '2022-06-15 16:20:00', TIMESTAMP '2022-06-15 18:40:00'),
       (9, 7, 'Main', 'ACTIVE', 7500.00, 1, TIMESTAMP '2022-07-30 12:10:00', TIMESTAMP '2022-07-30 17:25:00'),
       (10, 8, 'Savings', 'DELETED', 5500.00, 1, TIMESTAMP '2022-08-10 15:55:00', TIMESTAMP '2022-08-10 18:05:00');

INSERT INTO agreements(id,account_id,product_id,status,interest_rate,debt,created_at,updated_at)
values (1, 1, 1, 'ACTIVE', 3.5, 5000.00, TIMESTAMP '2022-01-15 14:30:00', TIMESTAMP '2022-01-15 15:45:00'),
       (2, 2, 2, 'ACTIVE', 4.0, 2500.00, TIMESTAMP '2022-01-15 14:45:00', TIMESTAMP '2022-01-15 15:50:00'),
       (3, 3, 3, 'INACTIVE', 5.0, 7500.00, TIMESTAMP '2022-02-20 13:15:00', TIMESTAMP '2022-02-20 15:30:00'),
       (4, 4, 4, 'ACTIVE', 4.5, 3000.00, TIMESTAMP '2022-03-25 10:45:00', TIMESTAMP '2022-03-25 13:20:00'),
       (5, 5, 5, 'ACTIVE', 3.0, 6000.00, TIMESTAMP '2022-04-10 14:30:00', TIMESTAMP '2022-04-10 17:10:00'),
       (6, 6, 6, 'INACTIVE', 4.2, 8500.00, TIMESTAMP '2022-04-10 14:45:00', TIMESTAMP '2022-04-10 17:30:00'),
       (7, 7, 1, 'ACTIVE', 3.8, 4500.00, TIMESTAMP '2022-05-05 09:30:00', TIMESTAMP '2022-05-05 11:45:00'),
       (8, 8, 8, 'ACTIVE', 4.5, 2000.00, TIMESTAMP '2022-06-15 16:20:00', TIMESTAMP '2022-06-15 18:40:00'),
       (9, 9, 9, 'INACTIVE', 4.0, 7500.00, TIMESTAMP '2022-07-30 12:10:00', TIMESTAMP '2022-07-30 17:25:00'),
       (10, 10, 10, 'ACTIVE', 3.5, 5500.00, TIMESTAMP '2022-08-10 15:55:00', TIMESTAMP '2022-08-10 18:05:00');

INSERT INTO transactions(debit_account_id,credit_account_id,amount,description,created_at,updated_at)
values(1, 2, 1000.00, 'Payment for services', TIMESTAMP '2022-01-05 10:30:00', TIMESTAMP '2022-01-05 11:45:00'),
      (3, 1, 1500.00, 'Loan repayment', TIMESTAMP '2022-01-15 09:45:00', TIMESTAMP '2022-01-15 10:50:00'),
      (2, 4, 500.00, 'Purchase', TIMESTAMP '2022-02-10 15:15:00', TIMESTAMP '2022-02-10 16:30:00'),
      (1, 3, 2000.00, 'Salary deposit', TIMESTAMP '2022-03-20 13:45:00', TIMESTAMP '2022-03-20 15:20:00'),
      (4, 2, 750.00, 'Online shopping', TIMESTAMP '2022-03-25 11:30:00', TIMESTAMP '2022-03-25 14:10:00'),
      (3, 5, 1200.00, 'Payment for services', TIMESTAMP '2022-04-05 14:55:00', TIMESTAMP '2022-04-05 17:30:00'),
      (2, 6, 800.00, 'Loan repayment', TIMESTAMP '2022-04-15 08:30:00', TIMESTAMP '2022-04-15 10:45:00'),
      (5, 4, 300.00, 'Online shopping', TIMESTAMP '2022-05-25 16:20:00', TIMESTAMP '2022-05-25 18:40:00'),
      (4, 1, 900.00, 'Payment for services', TIMESTAMP '2022-06-10 12:10:00', TIMESTAMP '2022-06-10 17:25:00'),
      (6, 5, 400.00, 'Loan repayment', TIMESTAMP '2022-07-20 15:55:00', TIMESTAMP '2022-07-20 18:05:00');

