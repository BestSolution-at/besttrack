package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.Comment;

public interface CommentMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Comment,at.bestsolution.persistence.MappedQuery<Comment>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment
	 *   WHERE
	 *     co_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.Comment selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   comment
	 *   WHERE
	 *     co_fk_task = #{tid}
	 * </pre>
	 * 
	 * @param tid
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> selectAllForTask(long tid);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Comment> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Comment>("sid");};
			/**
			 * Join with CommentAttachment
			 */
			public static final at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.Join<Comment> attachmentList() { return new at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.Join<Comment>("attachmentList");};
			/**
			 * Filter on description
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Comment> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Comment>("description");};
			/**
			 * Join with Task
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskMapper.Join<Comment> task() { return new at.bestsolution.tasktracker.emapping.TaskMapper.Join<Comment>("task");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Comment> task_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Comment>("task"); };
			/**
			 * Filter on title
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Comment> title() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Comment>("title");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Comment> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<Comment>("sid");};
			/**
			 * Order by for description
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Comment> description() { return new at.bestsolution.persistence.order.OrderColumnFactory<Comment>("description");};
			/**
			 * Order by for title
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Comment> title() { return new at.bestsolution.persistence.order.OrderColumnFactory<Comment>("title");};
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
			 * Join with CommentAttachment
			 */
			public final at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.Join<O> attachmentList() {return new at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.Join<O>(path+".attachmentList");};
			/**
			 * Filter on description
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".description");};
			/**
			 * Join with Task
			 */
			public final at.bestsolution.tasktracker.emapping.TaskMapper.Join<O> task() {return new at.bestsolution.tasktracker.emapping.TaskMapper.Join<O>(path+".task");};
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
		 *   comment
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<Comment> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<Comment> deleteAllMappedQuery();

}
