SELECT
  *
FROM
  source_repository
  WHERE
    sr_fk_repository = #{rId}
