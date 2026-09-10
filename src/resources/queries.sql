-- =========================================
-- CUSTOMER QUERIES
-- =========================================

-- Get all customers with address and contacts
SELECT
    c.customer_id,
    c.first_name,
    c.middle_name,
    c.last_name,
    c.birth_date,
    c.sex,
    a.brgy,
    a.municipality,
    a.province,
    a.postal_code,
    a.country,
    ct.mobile_number,
    ct.email_address,
    ct.telephone_number
FROM customers c
         LEFT JOIN address a
              ON c.customer_id = a.customer_id
         LEFT JOIN contacts ct
              ON c.customer_id = ct.customer_id;


-- Get one customer
SELECT
    c.customer_id,
    c.first_name,
    c.middle_name,
    c.last_name,
    c.birth_date,
    c.sex,
    a.brgy,
    a.municipality,
    a.province,
    a.postal_code,
    a.country,
    ct.mobile_number,
    ct.email_address,
    ct.telephone_number
FROM customers c
         LEFT JOIN address a
              ON c.customer_id = a.customer_id
         LEFT JOIN contacts ct
              ON c.customer_id = ct.customer_id
WHERE c.customer_id = 1;