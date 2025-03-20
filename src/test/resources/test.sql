CREATE TABLE IF NOT EXISTS t_order (
    order_id   BIGINT NOT NULL,
    order_type INT,
    user_id    INT    NOT NULL,
    address_id BIGINT NOT NULL,
    status     string,
    PRIMARY KEY (order_id) disable novalidate
) STORED BY ICEBERG STORED AS ORC TBLPROPERTIES ('format-version' = '2');

CREATE TABLE IF NOT EXISTS t_order_item (
    order_item_id BIGINT NOT NULL,
    order_id      BIGINT NOT NULL,
    user_id       INT    NOT NULL,
    phone         string,
    status        string,
    PRIMARY KEY (order_item_id) disable novalidate
) STORED BY ICEBERG STORED AS ORC TBLPROPERTIES ('format-version' = '2');

CREATE TABLE IF NOT EXISTS t_address (
    address_id   BIGINT       NOT NULL,
    address_name string NOT NULL,
    PRIMARY KEY (address_id) disable novalidate
) STORED BY ICEBERG STORED AS ORC TBLPROPERTIES ('format-version' = '2');

TRUNCATE TABLE t_order;
TRUNCATE TABLE t_order_item;
TRUNCATE TABLE t_address;
