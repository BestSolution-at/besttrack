SELECT
  *
FROM
  task_attachment
  WHERE
    ta_fk_task = #{tId}
