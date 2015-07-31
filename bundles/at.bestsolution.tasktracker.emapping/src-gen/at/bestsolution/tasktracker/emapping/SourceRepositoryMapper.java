package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.SourceRepository;

public interface SourceRepositoryMapper extends at.bestsolution.persistence.ConcreteObjectMapper<at.bestsolution.tasktracker.model.tasktracker.SourceRepository,at.bestsolution.persistence.MappedQuery<SourceRepository>> {
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   source_repository
	 * </pre>
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> selectAll();
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   source_repository
	 *   WHERE
	 *     sr_id = #{sid}
	 * </pre>
	 * 
	 * @param sid
	 * 
	 */
	public at.bestsolution.tasktracker.model.tasktracker.SourceRepository selectById(long sid);
	/**
	 * Find elements managed Domain-Elements with a query like this:
	 * <pre>
	 * SELECT
	 *   *
	 * FROM
	 *   source_repository
	 *   WHERE
	 *     sr_fk_repository = #{rId}
	 * </pre>
	 * 
	 * @param rId
	 * 
	 */
	public java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> selectAllForRepository(long rId);


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
			/**
			 * Filter on sid
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<SourceRepository> sid() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<SourceRepository>("sid");};
			/**
			 * Join with TaskRepository
			 */
			public static final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<SourceRepository> repository() { return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<SourceRepository>("repository");};
			/**
			 * Join directly on the fk avoiding unneeded joins
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<SourceRepository> repository_fk() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.LongExpressionFactory<SourceRepository>("repository"); };
			/**
			 * Filter on sourceUrl
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<SourceRepository> sourceUrl() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<SourceRepository>("sourceUrl");};
			/**
			 * Filter on type
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.EnumExpressionFactory<SourceRepository,at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType> type() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.EnumExpressionFactory<SourceRepository,at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType>("type");};
			/**
			 * Filter on webUrl
			 */
			public static final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<SourceRepository> webUrl() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<SourceRepository>("webUrl");};
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
			/**
			 * Order by for sid
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository> sid() { return new at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository>("sid");};
			/**
			 * Order by for sourceUrl
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository> sourceUrl() { return new at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository>("sourceUrl");};
			/**
			 * Order by for type
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository> type() { return new at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository>("type");};
			/**
			 * Order by for webUrl
			 */
			public static final at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository> webUrl() { return new at.bestsolution.persistence.order.OrderColumnFactory<SourceRepository>("webUrl");};
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
			 * Join with TaskRepository
			 */
			public final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O> repository() {return new at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.Join<O>(path+".repository");};
			/**
			 * Filter on sourceUrl
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> sourceUrl() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".sourceUrl");};
			/**
			 * Filter on type
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType> type() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.GenericExpressionFactory<O,at.bestsolution.tasktracker.model.tasktracker.SourceRepositoryType>(path+".type");};
			/**
			 * Filter on webUrl
			 */
			public final at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O> webUrl() { return new at.bestsolution.persistence.expr.PropertyExpressionFactory.StringExpressionFactory<O>(path+".webUrl");};
		}
		/**
		 * Build a query elements for <b>managed</b> Domain-Elements from a base query like this:
		 * <pre>
		 * SELECT
		 *   *
		 * FROM
		 *   source_repository
		 * </pre>
		 */
		public at.bestsolution.persistence.MappedQuery<SourceRepository> selectAllMappedQuery();
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<SourceRepository> deleteAllMappedQuery();

}
