--zapytanie ze złączeniami, które pobiera product i kategorię
select * from category_products as cp
left join product as p on cp.products_id = p.id
left join category as c on cp.category_id = c.id
where c.id = 1;

