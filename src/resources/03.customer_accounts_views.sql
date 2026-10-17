CREATE VIEW customer_account_details as
SELECT
	c.customer_id,
	c.first_name || ' ' || middle_name || ' ' || last_name as customer_name,
	ba.account_no,
	ap.product_name,
	ap.account_type,
	ba.balance,
	ba.opened_date
		FROM customers c LEFT JOIN bank_accounts ba ON c.customer_id = ba.customer_id
	  JOIN account_products ap ON ba.product_id = ap.product_id
