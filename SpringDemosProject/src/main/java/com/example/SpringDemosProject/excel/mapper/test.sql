-- Oracle插入测试数据
CREATE OR REPLACE PROCEDURE insert_data (
  p_start_id IN NUMBER,
  p_end_id   IN NUMBER
) IS
  l_counter NUMBER := p_start_id;
BEGIN
  WHILE l_counter <= p_end_id LOOP
    INSERT INTO jyn.users (ID, USERNAME, PASSWORD, EMAIL, CREATED_AT) VALUES (l_counter, concat('jyn no.', l_counter), l_counter, concat(l_counter, '.cn'), null);
    l_counter := l_counter + 1;
END LOOP;
COMMIT; -- 确保数据被提交
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK; -- 如果发生异常，回滚事务
    RAISE;
END insert_data;
/

-- 调用存储过程
BEGIN
  insert_data(1, 100);
END;