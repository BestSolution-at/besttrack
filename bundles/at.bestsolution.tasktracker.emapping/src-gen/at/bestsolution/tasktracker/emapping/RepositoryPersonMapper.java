package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson;

public interface RepositoryPersonMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson,at.bestsolution.persistence.MappedQuery<RepositoryPerson>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   repository_person
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   repository_person
	 *   WHERE
	 *     rp_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   repository_person
	 *   WHERE
	 *     rp_fk_person = #{pId}
	 * </pre>
	 * 
	 * @param pId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> selectAllForPerson(long pId);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   repository_person
	 *   WHERE
	 *     rp_fk_repository = #{rId}
	 * </pre>
	 * 
	 * @param rId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> selectAllForRepository(long rId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson>("sid");};
			/**
			 * Join with Person
			 */
			public static final at.bestsolution.tasktracker.emapping.PersonMapper.Join<RepositoryPerson> person() { return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<RepositoryPerson>("person");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson> person_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson>("person"); };
			/**
			 * Filter on privilegeMask
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson> privilegeMask() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson>("privilegeMask");};
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<RepositoryPerson> repository() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<RepositoryPerson>("repository");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson> repository_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<RepositoryPerson>("repository"); };
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<RepositoryPerson> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<RepositoryPerson>("sid");};
			/**
			 * Order by for privilegeMask
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<RepositoryPerson> privilegeMask() { return new at.bestsolution.persistence.order.OrderColumnFactory<RepositoryPerson>("privilegeMask");};
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
			public final at.bestsolution.tasktracker.emapping.PersonMapper.Join<O> person() {return new at.bestsolution.tasktracker.emapping.PersonMapper.Join<O>(path+".person");};
			/**
			 * Filter on privilegeMask
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<O> privilegeMask() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<O>(path+".privilegeMask");};
			/**
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> repository() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".repository");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   repository_person
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<RepositoryPerson> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<RepositoryPerson> deleteAllMappedQuery();

}
