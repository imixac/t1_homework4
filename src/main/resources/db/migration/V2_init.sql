CREATE TABLE products
(
    id BIGSERIAL PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    balance NUMERIC NOT NULL,
    product_type VARCHAR(255) NOT NULL,
    user_id BIGSERIAL references users (id)
);

INSERT INTO products (id, account_number, balance, product_type, user_id)
VALUES (1, '1000000', 101.0, 'VISA', 1),
       (2, '1000001', 102.0, 'MASTER_CARD', 2),
       (3, '1000002', 103.0, 'MIR', 1),
       (4, '46 1000001', 104.0, 'BANK_ACCOUNT', 3),
       (5, '46 1000002', 105.0, 'BANK_ACCOUNT', 2),
       (6, '1000003', 106.0, 'MIR', 3),
       (7, '1000004', 107.0, 'MIR', 4);