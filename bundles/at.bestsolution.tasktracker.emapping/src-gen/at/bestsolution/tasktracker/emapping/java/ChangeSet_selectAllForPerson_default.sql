SELECT
  *
FROM
  change_set
  WHERE
    cs_fk_person = #{pId}
