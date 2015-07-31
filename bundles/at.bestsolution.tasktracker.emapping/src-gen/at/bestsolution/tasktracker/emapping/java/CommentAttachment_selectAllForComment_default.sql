SELECT
  *
FROM
  comment_attachment
  WHERE
    ca_fk_comment = #{coId}
