SELECT
  *
FROM
  version
  WHERE
    v_fk_repository = #{rId}
