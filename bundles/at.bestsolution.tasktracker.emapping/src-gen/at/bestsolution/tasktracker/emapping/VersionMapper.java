package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.Version;

public interface VersionMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.persistence.MappedQuery<Version>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   version
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   version
	 *   WHERE
	 *     v_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.Version selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   version
	 *   WHERE
	 *     v_fk_repository = #{rId}
	 * </pre>
	 * 
	 * @param rId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> selectAllForRepository(long rId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Version> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Version>("sid");};
			/**
			 * Filter on codename
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Version> codename() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Version>("codename");};
			/**
			 * Filter on date
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.DateExpressionFactory<Version> date() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.DateExpressionFactory<Version>("date");};
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<Version> repository() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<Version>("repository");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Version> repository_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<Version>("repository"); };
			/**
			 * Filter on value
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Version> value() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<Version>("value");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Version> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<Version>("sid");};
			/**
			 * Order by for codename
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Version> codename() { return new at.bestsolution.persistence.order.OrderColumnFactory<Version>("codename");};
			/**
			 * Order by for date
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Version> date() { return new at.bestsolution.persistence.order.OrderColumnFactory<Version>("date");};
			/**
			 * Order by for value
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<Version> value() { return new at.bestsolution.persistence.order.OrderColumnFactory<Version>("value");};
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
			 * Filter on codename
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> codename() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".codename");};
			/**
			 * Filter on date
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.DateExpressionFactory<O> date() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.DateExpressionFactory<O>(path+".date");};
			/**
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> repository() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".repository");};
			/**
			 * Filter on value
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> value() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".value");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   version
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<Version> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<Version> deleteAllMappedQuery();

}
