INSERT INTO customers (customer_id, first_name, last_name, email)
VALUES (1, 'John', 'Doe', 'john.doe@example.com'),
       (2, 'Jane', 'Smith', 'jane.smith@example.com'),
       (3, 'Alice', 'Johnson', 'alice.johnson@example.com'),
       (4, 'Bob', 'Williams', 'bob.williams@example.com'),
       (5, 'Carol', 'Brown', 'carol.brown@example.com');

INSERT INTO products (product_id, product_name, price)
VALUES (10, 'Notebook', 12.99),
       (20, 'Pen', 1.50),
       (30, 'Desk Lamp', 23.99),
       (40, 'Backpack', 49.99),
       (50, 'Stapler', 7.99);

INSERT INTO orders (order_id, customer_id, product_id, quantity, order_date)
VALUES (100, 1, 10, 2, '2024-04-20'),
       (200, 2, 20, 5, '2024-04-21'),
       (300, 3, 10, 1, '2024-04-22'),
       (400, 4, 30, 1, '2024-04-23'),
       (500, 5, 40, 1, '2024-04-24'),
       (600, 1, 50, 3, '2024-04-25'),
       (700, 2, 10, 2, '2024-04-26'),
       (800, 3, 40, 1, '2024-04-27'),
       (900, 4, 20, 10, '2024-04-28'),
       (10000, 5, 30, 2, '2024-04-29');

INSERT INTO students (id, name, score, teacher_note)
VALUES (1, 'Alex', 100, 'Alex did perfectly every day in the class.');
INSERT INTO students (id, name, score, teacher_note)
VALUES (2, 'Alice', 70, 'Alice needs a lot of improvements.');
INSERT INTO students (id, name, score, teacher_note)
VALUES (3, 'Jack', 75, 'Event it is not the best, Jack has already improved.');
INSERT INTO students (id, name, score, teacher_note)
VALUES (4, 'Ophelia', 0, 'Unfortunately, Ophelia missed the test.');
INSERT INTO students (id, name, score, teacher_note)
VALUES (5, 'Zack', 60, 'Zack needs to do better.');
INSERT INTO students (id, name, score, teacher_note)
VALUES (6, 'HamaWhite', 95, 'Keep going.');

INSERT INTO parents (id, student_name, parent_name, parent_mobile)
VALUES (1, 'Alex', 'Barry', '088121');
INSERT INTO parents (id, student_name, parent_name, parent_mobile)
VALUES (2, 'Alice', 'Jessica', '088122');
INSERT INTO parents (id, student_name, parent_name, parent_mobile)
VALUES (3, 'Jack', 'Simon', '088123');
INSERT INTO parents (id, student_name, parent_name, parent_mobile)
VALUES (5, 'Ophelia', 'Tracy', '088124');
INSERT INTO parents (id, student_name, parent_name, parent_mobile)
VALUES (6, 'HamaWhite', 'Harper', '088125');

