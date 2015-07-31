SELECT
  *
FROM
  task
  WHERE
    t_fk_repository = #{rId}
