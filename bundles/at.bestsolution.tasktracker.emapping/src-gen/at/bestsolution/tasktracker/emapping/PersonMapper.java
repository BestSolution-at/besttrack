package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.Person;

public interface PersonMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.persistence.MappedQuery<Person>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   person
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   person
	 *   WHERE
	 *     p_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.Person selectById(long sid);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Person> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Person>("sid");};
			/**
			 * Filter on firstname
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Person> firstname() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Person>("firstname");};
			/**
			 * Filter on lastname
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Person> lastname() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Person>("lastname");};
			/**
			 * Join with RepositoryPerson
			 */
			public static final at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<Person> repositoryList() { return new at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<Person>("repositoryList");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Person> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<Person>("sid");};
			/**
			 * Order by for firstname
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Person> firstname() { return new at.bestsolution.persistence.order.OrderColumnFactory<Person>("firstname");};
			/**
			 * Order by for lastname
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Person> lastname() { return new at.bestsolution.persistence.order.OrderColumnFactory<Person>("lastname");};
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
			 * Filter on firstname
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> firstname() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".firstname");};
			/**
			 * Filter on lastname
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> lastname() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".lastname");};
			/**
			 * Join with RepositoryPerson
			 */
			public final at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<O> repositoryList() {return new at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.Join<O>(path+".repositoryList");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   person
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<Person> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<Person> deleteAllMappedQuery();

}
