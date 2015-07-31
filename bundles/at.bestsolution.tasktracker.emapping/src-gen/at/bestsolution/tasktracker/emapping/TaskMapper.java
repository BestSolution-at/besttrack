package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.Task;

public interface TaskMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.persistence.MappedQuery<Task>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task
	 *   WHERE
	 *     t_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.Task selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task
	 *   WHERE
	 *     t_fk_repository = #{rId}
	 * </pre>
	 * 
	 * @param rId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> selectOpenTasksForRepository(long rId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("sid");};
			/**
			 * Join with Person
			 */
			public static final at.bestsolution.tasktracker.emapping.PersonMapper.Join<Task> assignee() { return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<Task>("assignee");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> assignee_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("assignee"); };
			/**
			 * Join with TaskAttachment
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.Join<Task> attachmentList() { return new at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.Join<Task>("attachmentList");};
			/**
			 * Join with ChangeSet
			 */
			public static final at.bestsolution.tasktracker.emapping.ChangeSetMapper.Join<Task> changeSetList() { return new at.bestsolution.tasktracker.emapping.ChangeSetMapper.Join<Task>("changeSetList");};
			/**
			 * Join with Comment
			 */
			public static final at.bestsolution.tasktracker.emapping.CommentMapper.Join<Task> commentList() { return new at.bestsolution.tasktracker.emapping.CommentMapper.Join<Task>("commentList");};
			/**
			 * Filter on description
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task>("description");};
			/**
			 * Filter on externalBugId
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task> externalBugId() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task>("externalBugId");};
			/**
			 * Join with Version
			 */
			public static final at.bestsolution.tasktracker.emapping.VersionMapper.Join<Task> productVersion() { return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<Task>("productVersion");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> productVersion_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("productVersion"); };
			/**
			 * Join with Person
			 */
			public static final at.bestsolution.tasktracker.emapping.PersonMapper.Join<Task> reporter() { return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<Task>("reporter");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> reporter_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("reporter"); };
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<Task> repository() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<Task>("repository");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> repository_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("repository"); };
			/**
			 * Filter on state
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.EnumExpressionFactory<Task,at.bestsolution.tasktracker.model.tasktracker.TaskState> state() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.EnumExpressionFactory<Task,at.bestsolution.tasktracker.model.tasktracker.TaskState>("state");};
			/**
			 * Join with Version
			 */
			public static final at.bestsolution.tasktracker.emapping.VersionMapper.Join<Task> targetVersion() { return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<Task>("targetVersion");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task> targetVersion_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Task>("targetVersion"); };
			/**
			 * Filter on title
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task> title() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Task>("title");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Task> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<Task>("sid");};
			/**
			 * Order by for description
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Task> description() { return new at.bestsolution.persistence.order.OrderColumnFactory<Task>("description");};
			/**
			 * Order by for externalBugId
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Task> externalBugId() { return new at.bestsolution.persistence.order.OrderColumnFactory<Task>("externalBugId");};
			/**
			 * Order by for state
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Task> state() { return new at.bestsolution.persistence.order.OrderColumnFactory<Task>("state");};
			/**
			 * Order by for title
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Task> title() { return new at.bestsolution.persistence.order.OrderColumnFactory<Task>("title");};
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
			 * Join with Person
			 */
			public final at.bestsolution.tasktracker.emapping.PersonMapper.Join<O> assignee() {return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<O>(path+".assignee");};
			/**
			 * Join with TaskAttachment
			 */
			public final at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.Join<O> attachmentList() {return new at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.Join<O>(path+".attachmentList");};
			/**
			 * Join with ChangeSet
			 */
			public final at.bestsolution.tasktracker.emapping.ChangeSetMapper.Join<O> changeSetList() {return new at.bestsolution.tasktracker.emapping.ChangeSetMapper.Join<O>(path+".changeSetList");};
			/**
			 * Join with Comment
			 */
			public final at.bestsolution.tasktracker.emapping.CommentMapper.Join<O> commentList() {return new at.bestsolution.tasktracker.emapping.CommentMapper.Join<O>(path+".commentList");};
			/**
			 * Filter on description
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".description");};
			/**
			 * Filter on externalBugId
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> externalBugId() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".externalBugId");};
			/**
			 * Join with Version
			 */
			public final at.bestsolution.tasktracker.emapping.VersionMapper.Join<O> productVersion() {return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<O>(path+".productVersion");};
			/**
			 * Join with Person
			 */
			public final at.bestsolution.tasktracker.emapping.PersonMapper.Join<O> reporter() {return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<O>(path+".reporter");};
			/**
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> repository() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".repository");};
			/**
			 * Filter on state
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,at.bestsolution.tasktracker.model.tasktracker.TaskState> state() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,at.bestsolution.tasktracker.model.tasktracker.TaskState>(path+".state");};
			/**
			 * Join with Version
			 */
			public final at.bestsolution.tasktracker.emapping.VersionMapper.Join<O> targetVersion() {return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<O>(path+".targetVersion");};
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
		 *   task
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<Task> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<Task> deleteAllMappedQuery();

}
