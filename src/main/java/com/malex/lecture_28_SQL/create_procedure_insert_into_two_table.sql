CREATE TABLE order_table
(
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  creation_date DATE,
  CONSTRAINT id_pk PRIMARY KEY (id)
);

CREATE TABLE order_book
(
  id INT NOT NULL AUTO_INCREMENT,
  order_id INT NOT NULL,
  book_id INT NOT NULL,
  CONSTRAINT id_pk PRIMARY KEY (id)
);

delimiter //
CREATE PROCEDURE CREATE_NEW_ORDER(user_id INT, book_ids TEXT)
	proc_label:BEGIN
        -- step 1: set temporary variable for input book_ids
        SET @book_ids = book_ids;
        
		-- step 2: determine length of book_ids string
        SET @string_length = LENGTH(@book_ids) - LENGTH(REPLACE(@book_ids, ',', ''));
		
        -- step 2.1: if book_ids wasn't passed, then exit
        IF (@string_length = 0) THEN 
             LEAVE proc_label;
        END IF;
        
        -- step 2.2: if user_id wasn't passed, then exit
        if(user_id is null) THEN 
             LEAVE proc_label;
        END IF;
        
		-- step 3: create new order 
        INSERT INTO order_table (user_id, creation_date) VALUES (user_id, CURDATE()); 
        
        -- step 4: get order id
        SET @last_order_id = LAST_INSERT_ID();
        
        -- step 5: init loop for book_ids
        loop_label: WHILE (@string_length > 0)
        DO 
            -- step 6: get first book_id from book_ids 
            SET @book_id = SUBSTRING_INDEX(@book_ids, ',', 1);
            
            -- step 6.1: insert value into table
            IF (@book_id != '') THEN
				INSERT INTO order_book (order_id, book_id) VALUES (@last_order_id,  @book_id);  
            
            -- step 6.2: if book_id wasn't found then exit loop
            ELSE
                LEAVE loop_label; 
            END IF;
            
            -- step 7: calculate remaining string length 
            SET @string_length = LENGTH(@book_ids) - LENGTH(REPLACE(@book_ids, ',', ''));
            
            -- step 7.1: if book_ids length is 0 then exit loop
            IF (@string_length = 0) THEN 
                LEAVE loop_label; 
            END IF;
            
             -- step 8: exclude received book_id from string and set new value for book_ids
            SET @book_ids = SUBSTRING(@book_ids, LENGTH(SUBSTRING_INDEX(@book_ids, ',', 1)) + 2);
        END WHILE;                  
   END //

call CREATE_NEW_ORDER(1, '1,22,333,444,5555,66666,777777');

SELECT * FROM order_table;
SELECT * FROM order_book;