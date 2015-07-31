SELECT
  *
FROM
  repository_person
  WHERE
    rp_fk_repository = #{rId}
