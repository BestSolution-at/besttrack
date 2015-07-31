package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.TaskRepository;

public interface TaskRepositoryMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.persistence.MappedQuery<TaskRepository>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_repository
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_repository
	 *   WHERE
	 *     tr_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.TaskRepository selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_repository
	 *   WHERE
	 *     tr_fk_parent = #{parentSid}
	 * </pre>
	 * 
	 * @param parentSid
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> selectAllForParent(long parentSid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   task_repository
	 *   WHERE
	 *     tr_fk_parent IS NULL
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> selectTopLevel();


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskRepository> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskRepository>("sid");};
			/**
			 * Filter on description
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskRepository> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskRepository>("description");};
			/**
			 * Filter on name
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskRepository> name() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<TaskRepository>("name");};
			/**
			 * Join with RepositoryPerson
			 */
			public static final at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<TaskRepository> personList() { return new at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<TaskRepository>("personList");};
			/**
			 * Join with SourceRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<TaskRepository> sourceRepositoryList() { return new at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<TaskRepository>("sourceRepositoryList");};
			/**
			 * Join with Version
			 */
			public static final at.bestsolution.tasktracker.emapping.VersionMapper.Join<TaskRepository> versionList() { return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<TaskRepository>("versionList");};
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<TaskRepository> children() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<TaskRepository>("children");};
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<TaskRepository> parent() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<TaskRepository>("parent");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskRepository> parent_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<TaskRepository>("parent"); };
			/**
			 * Filter on externalId
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<TaskRepository> externalId() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<TaskRepository>("externalId");};
			/**
			 * Filter on publicRepo
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<TaskRepository> publicRepo() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<TaskRepository>("publicRepo");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository>("sid");};
			/**
			 * Order by for description
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository> description() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository>("description");};
			/**
			 * Order by for name
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository> name() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository>("name");};
			/**
			 * Order by for externalId
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository> externalId() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository>("externalId");};
			/**
			 * Order by for publicRepo
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository> publicRepo() { return new at.bestsolution.persistence.order.OrderColumnFactory<TaskRepository>("publicRepo");};
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
			 * Filter on description
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> description() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".description");};
			/**
			 * Filter on name
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> name() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".name");};
			/**
			 * Join with RepositoryPerson
			 */
			public final at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<O> personList() {return new at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<O>(path+".personList");};
			/**
			 * Join with SourceRepository
			 */
			public final at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<O> sourceRepositoryList() {return new at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<O>(path+".sourceRepositoryList");};
			/**
			 * Join with Version
			 */
			public final at.bestsolution.tasktracker.emapping.VersionMapper.Join<O> versionList() {return new at.bestsolution.tasktracker.emapping.VersionMapper.Join<O>(path+".versionList");};
			/**
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> children() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".children");};
			/**
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> parent() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".parent");};
			/**
			 * Filter on externalId
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<O> externalId() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<O>(path+".externalId");};
			/**
			 * Filter on publicRepo
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<O> publicRepo() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.BooleanExpressionFactory<O>(path+".publicRepo");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   task_repository
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<TaskRepository> selectAllMappedQuery();
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   task_repository
		 *   WHERE
		 *     tr_fk_parent IS NULL
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<TaskRepository> selectTopLevelMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<TaskRepository> deleteAllMappedQuery();

}
