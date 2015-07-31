package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.ChangeSet;

public interface ChangeSetMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.ChangeSet,at.bestsolution.persistence.MappedQuery<ChangeSet>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   change_set
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   change_set
	 *   WHERE
	 *     cs_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.ChangeSet selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   change_set
	 *   WHERE
	 *     cs_fk_person = #{pId}
	 * </pre>
	 * 
	 * @param pId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> selectAllForPerson(long pId);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   change_set
	 *   WHERE
	 *     cs_fk_repository = #{srId}
	 * </pre>
	 * 
	 * @param srId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> selectAllForSourceRepository(long srId);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   change_set
	 *   WHERE
	 *     cs_fk_task = #{tId}
	 * </pre>
	 * 
	 * @param tId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> selectAllForTask(long tId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet>("sid");};
			/**
			 * Filter on comment
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<ChangeSet> comment() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<ChangeSet>("comment");};
			/**
			 * Filter on id
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<ChangeSet> id() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<ChangeSet>("id");};
			/**
			 * Join with Person
			 */
			public static final at.bestsolution.tasktracker.emapping.PersonMapper.Join<ChangeSet> person() { return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<ChangeSet>("person");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet> person_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet>("person"); };
			/**
			 * Join with SourceRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<ChangeSet> sourceRepository() { return new at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<ChangeSet>("sourceRepository");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet> sourceRepository_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet>("sourceRepository"); };
			/**
			 * Join with Task
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskMapper.Join<ChangeSet> task() { return new at.bestsolution.tasktracker.emapping.TaskMapper.Join<ChangeSet>("task");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet> task_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<ChangeSet>("task"); };
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet>("sid");};
			/**
			 * Order by for comment
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet> comment() { return new at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet>("comment");};
			/**
			 * Order by for id
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet> id() { return new at.bestsolution.persistence.order.OrderColumnFactory<ChangeSet>("id");};
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
			 * Filter on comment
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> comment() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".comment");};
			/**
			 * Filter on id
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> id() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".id");};
			/**
			 * Join with Person
			 */
			public final at.bestsolution.tasktracker.emapping.PersonMapper.Join<O> person() {return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<O>(path+".person");};
			/**
			 * Join with SourceRepository
			 */
			public final at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<O> sourceRepository() {return new at.bestsolution.tasktracker.emapping.SourceRepositoryMapper.Join<O>(path+".sourceRepository");};
			/**
			 * Join with Task
			 */
			public final at.bestsolution.tasktracker.emapping.TaskMapper.Join<O> task() {return new at.bestsolution.tasktracker.emapping.TaskMapper.Join<O>(path+".task");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   change_set
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<ChangeSet> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<ChangeSet> deleteAllMappedQuery();

}
