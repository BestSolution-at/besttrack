SELECT
  *
FROM
  task_repository
  WHERE
    tr_fk_parent = #{parentSid}
