INSERT INTO customers (customer_id, customer_first_name, customer_last_name, email_address, street_address, city, province, country, postal_code)
VALUES
    ('6b2214d8-8d17-42f3-82bd-1b9264f19c64', 'Susana', 'Maxfield', 'smaxfield6@themeforest.net', '4509 Mifflin Road', 'Acton Vale', 'Québec', 'USA', 'G0E N6E'),
    ('a11014c8-85bc-4f8a-b627-7dfd645764ce', 'Elias', 'Plaxton', 'eplaxton7@house.gov', '382 Dorton Terrace', 'London', 'Ontario', 'Canada', 'N6C 2E4'),
    ('13526a90-506f-4981-a9da-06ba21fc610b', 'Ralina', 'Sussex', 'rsussex8@nymag.com', '624 Gale Alley', 'Waterloo', 'Ontario', 'Canada', 'N2L 7K8'),
    ('cc9c2c7f-afc9-46fb-8119-17158e54d02f', 'Pen', 'Carruthers', 'pcarruthers9@gov.uk', '3 4th Terrace', 'Hearst', 'Ontario', 'Canada', 'S4A 8Y2'),
    ('7d6f95ab-8343-4db5-a417-2d4a53c35a6f', 'Raphael', 'Gonzalez', 'rgonzalez10@example.com', '789 Elm Street', 'Vancouver', 'British Columbia', 'Canada', 'V6B 1V5'),
    ('2b6d4f32-1d63-4c9c-b0d1-29de9467fc2a', 'Amelia', 'Chambers', 'achambers11@example.com', '456 Oak Avenue', 'Calgary', 'Alberta', 'Canada', 'T2P 1J9'),
    ('cf3f62e7-d1d0-48d4-a611-631be2e1eabb', 'Finn', 'Galloway', 'fgalloway12@example.com', '123 Pine Street', 'Toronto', 'Ontario', 'Canada', 'M5G 2N2'),
    ('8e192238-5c62-4968-97ac-6e91aeb96dc2', 'Zara', 'Hassan', 'zhassan13@example.com', '789 Maple Avenue', 'Edmonton', 'Alberta', 'Canada', 'T5J 2G9'),
    ('6f657f68-4e7e-4425-a618-4d9d348c1a06', 'Oscar', 'Li', 'oli14@example.com', '456 Birch Street', 'Montreal', 'Québec', 'Canada', 'H2X 1W2'),
    ('4becc7bc-65f7-4730-84f7-8a9d3d70f170', 'Lila', 'Patel', 'lpatel15@example.com', '123 Cedar Street', 'Ottawa', 'Ontario', 'Canada', 'K1P 5E1'),
    ('ee3db749-4cf2-4f8a-9138-87dfbb59d47e', 'Giovanni', 'Mancini', 'gmancini16@example.com', '789 Walnut Street', 'Victoria', 'British Columbia', 'Canada', 'V8W 1W6');

INSERT INTO customer_phonenumbers(customer_id, type, number)
VALUES
    (1, 'WORK', '515-555-1234'),
    (1, 'MOBILE', '416-555-1234'),
    (2, 'WORK', '515-555-9999'),
    (3, 'MOBILE', '416-555-3333'),
    (5, 'HOME', '515-555-1234'),
    (6, 'MOBILE', '416-555-1234'),
    (6, 'WORK', '515-555-9999'),
    (7, 'MOBILE', '416-555-3333'),
    (8, 'WORK', '515-555-1234'),
    (9, 'MOBILE', '416-555-1234'),
    (10, 'WORK', '515-555-9999'),
    (11, 'MOBILE', '416-555-3333'),
    (11, 'WORK', '515-555-9999'),
    (6, 'HOME', '416-555-3333');
--
-- INSERT INTO furniture (furniture_id, furniture_name, description, category, furniture_condition, country, manufacturer_name, furniture_cost, currency_type)
-- VALUES
--     ('2b16459e-9d8a-4f85-8337-39ae0af871a1', 'Crazy Sofa', 'Comfortable sofa for the living room', 'Furniture', 'SLIGHTLYUSED', 'USA', 'Manufacturer1', 200.90, 'EUR'),
--     ('8f3c7d88-f1a2-44d7-b722-c9f1196019c1', 'Love Bed', 'King-size bed with orthopedic mattress', 'Furniture', 'VERYUSED', 'Canada', 'Manufacturer2', 800.00, 'CAD'),
--     ('63f3f786-9a29-4424-8938-2c71b1a92f61', 'Standing Desk', 'Wooden desk with drawers', 'Furniture', 'BRANDNEW', 'USA', 'Manufacturer3', 600.33, 'USD'),
--     ('9d5beec2-51a2-4e6e-8343-82e0e35b943c', 'Bookshelf', 'Tall bookshelf with adjustable shelves', 'Furniture', 'SLIGHTLYUSED', 'Canada', 'Manufacturer4', 420.50, 'CAD'),
--     ('f2ec4f85-6779-4f7b-8c7f-92a11b214d65', 'Coffee Table', 'Round coffee table with storage', 'Furniture', 'VERYUSED', 'USA', 'Manufacturer5', 150.32, 'USD'),
--     ('d5e8bcb2-d9dc-4f53-bdb4-42f8c7d2e3cb', 'Comfy Chair', 'Soft and cozy chair for relaxation', 'Furniture', 'SLIGHTLYUSED', 'Canada', 'Manufacturer6', 300.00, 'CAD'),
--     ('47661190-0879-4037-a9a6-2dcd50b654f4', 'Dining Table', 'Large wooden dining table with seating for six', 'Furniture', 'BRANDNEW', 'USA', 'Manufacturer7', 700.00, 'USD'),
--     ('0d5e1b41-2064-45a9-bafe-5b004f8f2c8e', 'Lounge Sofa', 'L-shaped sofa perfect for lounging', 'Furniture', 'VERYUSED', 'Canada', 'Manufacturer8', 250.00, 'CAD'),
--     ('7f7cf46e-7b51-4dd4-9487-228c0ee585e3', 'Office Chair', 'Ergonomic office chair with lumbar support', 'Furniture', 'SLIGHTLYUSED', 'USA', 'Manufacturer9', 180.00, 'USD'),
--     ('97df7328-8a5b-4ba6-8c67-9d1d7d3a1b34', 'Bedside Table', 'Small bedside table with drawer', 'Furniture', 'BRANDNEW', 'Canada', 'Manufacturer10', 100.00, 'CAD'),
--     ('b9b1d77b-65ed-4c81-ae30-7204f406fd64', 'Bean Bag', 'Large bean bag for casual seating', 'Furniture', 'VERYUSED', 'USA', 'Manufacturer11', 80.23, 'EUR');
--

--
-- INSERT INTO delivery (delivery_id, first_name,last_name, address, email, warehouse_location, delivery_date, eta, shipping_number)
-- VALUES
--     ('f3a4e8b1-e8d2-47a9-bd80-3d8f5c281f44', 'Susana', 'Maxfield', '4509 Mifflin Road', 'smaxfield6@themeforest.net', 'Warehouse3', '2024-03-25', '4 days', '345678' ),
--     ('4a7b032f-2a9f-4ec4-9a0b-5d3b9e3a8f65', 'Elias', 'Plaxton', '382 Dorton Terrace', 'eplaxton7@house.gov', 'Warehouse4', '2024-03-18', '2 days', '901234' ),
--     ('7e5b12fd-43b7-48eb-9dae-07e2e4a8c3d1', 'Nina', 'Chung', '123 Oak Street', 'nchung17@example.com', 'Warehouse5', '2024-03-22', '3 days', '567890' ),
--     ('88a6eda4-53e7-4f1f-a9bc-4d34a386c115', 'Ethan', 'Nguyen', '456 Elm Street', 'enguyen18@example.com', 'Warehouse6', '2024-03-19', '2 days', '123789' ),
--     ('e3f89c5e-67b8-49d2-b87b-8d31b8a4aabd', 'Leah', 'Robinson', '789 Pine Street', 'lrobinson19@example.com', 'Warehouse7', '2024-03-24', '4 days', '890123' ),
--     ('2f66b3a8-3bfa-46b6-97ae-ccf5a6f726e8', 'Hugo', 'Silva', '456 Maple Street', 'hsilva20@example.com', 'Warehouse8', '2024-03-17', '2 days', '456789' ),
--     ('9aed2d1b-4f5b-4b7d-8b2f-2e6f638baeab', 'Lila', 'Patel', '123 Cedar Street', 'lpatel15@example.com', 'Warehouse9', '2024-03-21', '3 days', '234567' ),
--     ('b41f27d8-9c25-4f5a-8f58-1de6c5a5ccec', 'Giovanni', 'Mancini', '789 Walnut Street', 'gmancini16@example.com', 'Warehouse10', '2024-03-23', '4 days', '678901' ),
--     ('0c1e24f5-3b0e-4ec1-8ee0-f58d4e5e3251', 'Amelia', 'Chambers', '456 Oak Avenue', 'achambers11@example.com', 'Warehouse1', '2024-03-15', '2 days', '123456'),
--     ('5e3c8bc7-98f7-4d6b-8503-1c9a5c9d5c8b', 'Raphael', 'Gonzalez', '789 Elm Street', 'rgonzalez10@example.com', 'Warehouse2', '2024-03-20', '3 days', '789012' ),
--     ('c91e62b3-f2c8-44e3-abe1-efd6c883202e', 'Finn', 'Galloway', '123 Pine Street', 'fgalloway12@example.com', 'Warehouse3', '2024-03-25', '4 days', '345678' );

--
-- INSERT INTO purchase (purchase_id, delivery_id, customer_id, furniture_id, payment_type, purchase_date,status)
-- VALUES
--     ('23hdta90-506f-4931-a9da-06ba21fc110b','f3a4e8b1-e8d2-47a9-bd80-3d8f5c281f44','6b2214d8-8d17-42f3-82bd-1b9264f19c64','2b16459e-9d8a-4f85-8337-39ae0af871a1','CASH','2024-11-13','PURCHASE_SUCCESSFUL'),
--     ('13f63fd8-25c7-4b84-a2d2-84e38b306dca','4a7b032f-2a9f-4ec4-9a0b-5d3b9e3a8f65','a11014c8-85bc-4f8a-b627-7dfd645764ce','8f3c7d88-f1a2-44d7-b722-c9f1196019c1','CREDIT_CARD','2024-06-15','PURCHASE_SUCCESSFUL'),
--     ('43b7f058-b08b-4b62-8ef7-787a480fae7e','7e5b12fd-43b7-48eb-9dae-07e2e4a8c3d1','13526a90-506f-4981-a9da-06ba21fc610b','63f3f786-9a29-4424-8938-2c71b1a92f61','DEBIT_CARD','2024-08-1','PURCHASE_SUCCESSFUL'),
--     ('10c5abde-ef2f-4146-b76a-42912a5240c9','88a6eda4-53e7-4f1f-a9bc-4d34a386c115','cc9c2c7f-afc9-46fb-8119-17158e54d02f','9d5beec2-51a2-4e6e-8343-82e0e35b943c','CASH','2024-03-15','PURCHASE_SUCCESSFUL'),
--     ('7dd5c982-8313-4f51-bc5e-3e476e1b9c39','e3f89c5e-67b8-49d2-b87b-8d31b8a4aabd','7d6f95ab-8343-4db5-a417-2d4a53c35a6f','f2ec4f85-6779-4f7b-8c7f-92a11b214d65','DEBIT_CARD','2024-03-3','PURCHASE_SUCCESSFUL'),
--     ('94e61191-2d7e-4924-bdf8-75b4b381f12c','2f66b3a8-3bfa-46b6-97ae-ccf5a6f726e8','2b6d4f32-1d63-4c9c-b0d1-29de9467fc2a','d5e8bcb2-d9dc-4f53-bdb4-42f8c7d2e3cb','CASH','2024-03-15','PURCHASE_SUCCESSFUL'),
--     ('ee91c42c-4d3c-4a87-b0de-f2550cb04544','9aed2d1b-4f5b-4b7d-8b2f-2e6f638baeab','cf3f62e7-d1d0-48d4-a611-631be2e1eabb','47661190-0879-4037-a9a6-2dcd50b654f4','CHECK','2024-04-5','PURCHASE_SUCCESSFUL'),
--     ('320af1e8-d28e-43d4-bb8a-d11c7eef10d1','b41f27d8-9c25-4f5a-8f58-1de6c5a5ccec','8e192238-5c62-4968-97ac-6e91aeb96dc2','0d5e1b41-2064-45a9-bafe-5b004f8f2c8e','CASH','2024-12-23','PURCHASE_SUCCESSFUL'),
--     ('8d3b199b-3b7f-4782-aabc-9814f0c97cbf','0c1e24f5-3b0e-4ec1-8ee0-f58d4e5e3251','2b6d4f32-1d63-4c9c-b0d1-29de9467fc2a','7f7cf46e-7b51-4dd4-9487-228c0ee585e3','DEBIT_CARD','2024-03-4','PURCHASE_SUCCESSFUL'),
--     ('4d3b329b-3b7f-4782-aab2-9814f0c97cAf','0c1e24f5-3b0e-4ec1-8ee0-f58d4e5e3251','2b6d4f32-1d63-4c9c-b0d1-29de9467fc2a','0d5e1b41-2064-45a9-bafe-5b004f8f2c8e','CASH','2024-04-24','PURCHASE_SUCCESSFUL'),
--     ('6f3d5e27-fb56-4d81-a04b-826d91803b99','5e3c8bc7-98f7-4d6b-8503-1c9a5c9d5c8b','4becc7bc-65f7-4730-84f7-8a9d3d70f170','97df7328-8a5b-4ba6-8c67-9d1d7d3a1b34','CASH','2024-06-11','PURCHASE_SUCCESSFUL'),
--     ('b75ccf6c-7e94-4e3b-93a3-51943000d657','c91e62b3-f2c8-44e3-abe1-efd6c883202e','ee3db749-4cf2-4f8a-9138-87dfbb59d47e','b9b1d77b-65ed-4c81-ae30-7204f406fd64','CREDIT_CARD','2024-02-25','PURCHASE_SUCCESSFUL');
--


