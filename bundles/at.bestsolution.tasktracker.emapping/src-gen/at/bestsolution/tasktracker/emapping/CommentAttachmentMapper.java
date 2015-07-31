package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.CommentAttachment;

public interface CommentAttachmentMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment,at.bestsolution.persistence.MappedQuery<CommentAttachment>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment_attachment
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment_attachment
	 *   WHERE
	 *     ca_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.CommentAttachment selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment_attachment
	 *   WHERE
	 *     ca_fk_comment = #{coId}
	 * </pre>
	 * 
	 * @param coId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> selectAllForComment(long coId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<CommentAttachment> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<CommentAttachment>("sid");};
			/**
			 * Filter on binary
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<CommentAttachment,java.sql.Blob> binary() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<CommentAttachment,java.sql.Blob>("binary");};
			/**
			 * Join with Comment
			 */
			public static final at.bestsolution.tasktracker.emapping.CommentMapper.Join<CommentAttachment> comment() { return new at.bestsolution.tasktracker.emapping.CommentMapper.Join<CommentAttachment>("comment");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<CommentAttachment> comment_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<CommentAttachment>("comment"); };
			/**
			 * Filter on description
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment>("description");};
			/**
			 * Filter on mimetype
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment> mimetype() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment>("mimetype");};
			/**
			 * Filter on title
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment> title() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<CommentAttachment>("title");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment>("sid");};
			/**
			 * Order by for binary
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment> binary() { return new at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment>("binary");};
			/**
			 * Order by for description
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment> description() { return new at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment>("description");};
			/**
			 * Order by for mimetype
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment> mimetype() { return new at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment>("mimetype");};
			/**
			 * Order by for title
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment> title() { return new at.bestsolution.persistence.order.OrderColumnFactory<CommentAttachment>("title");};
		}

		/**
		 * Build join expressions
		 */
		public static final class Join<O> {
			private final String path;
			public Join(String path) {
				this.path = path;
			}

			/**
			 * Filter on sid
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<O> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<O>(path+".sid");};
			/**
			 * Filter on binary
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,java.sql.Blob> binary() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,java.sql.Blob>(path+".binary");};
			/**
			 * Join with Comment
			 */
			public final at.bestsolution.tasktracker.emapping.CommentMapper.Join<O> comment() {return new at.bestsolution.tasktracker.emapping.CommentMapper.Join<O>(path+".comment");};
			/**
			 * Filter on description
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".description");};
			/**
			 * Filter on mimetype
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> mimetype() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".mimetype");};
			/**
			 * Filter on title
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> title() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".title");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   comment_attachment
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<CommentAttachment> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<CommentAttachment> deleteAllMappedQuery();

}
