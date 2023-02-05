-- DROP TABLE IF EXISTS users;
CREATE TABLE use112222rs(
    id INT,
    username  VARCHAR(50),
    password VARCHAR(50),
    enabled INT
);
--
--
-- DROP TABLE IF EXISTS authorities;
-- CREATE TABLE authorities(
--     id INT NOT NULL AUTO_INCREMENT,
--     username VARCHAR(45) NOT NULL,
--     authority VARCHAR(45) NOT NULL,
--
-- );
-- -- DROP TABLE IF EXISTS Products;
-- --
-- -- CREATE TABLE Products
-- -- (
-- --     prod_id     IDENTITY        PRIMARY KEY,
-- --     prod_name   VARCHAR(255)    NOT NULL,
-- --     prod_price  INT             NOT NULL
-- -- );
-- --
-- -- -- 회원
-- -- DROP TABLE IF EXISTS MB_MBR;
-- --
-- -- -- 회원
-- -- CREATE TABLE "MB_MBR" (
-- --                           "MBR_ID"    IDENTITY        PRIMARY KEY, -- 회원식별번호
-- --                           "MBR_NM"    VARCHAR(50) NOT NULL, -- 회원이름
-- --                           "MBR_CP_NO" VARCHAR(30) NOT NULL, -- 회원연락처
-- --                           "REG_DT"    DATETIME        NOT NULL, -- 등록일시
-- --                           "MOD_DT"    DATETIME        NULL      -- 수정일시
-- -- );