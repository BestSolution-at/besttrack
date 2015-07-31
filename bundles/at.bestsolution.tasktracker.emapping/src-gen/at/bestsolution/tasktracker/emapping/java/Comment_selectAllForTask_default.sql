SELECT
  *
FROM
  comment
  WHERE
    co_fk_task = #{tid}
