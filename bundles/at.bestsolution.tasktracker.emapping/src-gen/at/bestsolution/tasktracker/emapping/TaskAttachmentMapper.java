package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.TaskAttachment;

public interface TaskAttachmentMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment,at.bestsolution.persistence.MappedQuery<TaskAttachment>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_attachment
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_attachment
	 *   WHERE
	 *     ta_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.TaskAttachment selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_attachment
	 *   WHERE
	 *     ta_fk_task = #{tId}
	 * </pre>
	 * 
	 * @param tId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> selectAllForTask(long tId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskAttachment> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskAttachment>("sid");};
			/**
			 * Filter on binary
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<TaskAttachment,java.sql.Blob> binary() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<TaskAttachment,java.sql.Blob>("binary");};
			/**
			 * Filter on description
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment>("description");};
			/**
			 * Filter on mimetype
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment> mimetype() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment>("mimetype");};
			/**
			 * Join with Task
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskMapper.Join<TaskAttachment> task() { return new at.bestsolution.tasktracker.emapping.TaskMapper.Join<TaskAttachment>("task");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskAttachment> task_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskAttachment>("task"); };
			/**
			 * Filter on title
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment> title() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskAttachment>("title");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment>("sid");};
			/**
			 * Order by for binary
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment> binary() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment>("binary");};
			/**
			 * Order by for description
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment> description() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment>("description");};
			/**
			 * Order by for mimetype
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment> mimetype() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment>("mimetype");};
			/**
			 * Order by for title
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment> title() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskAttachment>("title");};
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
			 * Filter on description
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".description");};
			/**
			 * Filter on mimetype
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> mimetype() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".mimetype");};
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
		 *   task_attachment
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<TaskAttachment> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<TaskAttachment> deleteAllMappedQuery();

}
