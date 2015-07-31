package at.bestsolution.tasktracker.emapping;

import at.bestsolution.tasktracker.model.tasktracker.BaseObject;

public interface BaseObjectMapper extends at.bestsolution.persistence.ObjectMapper<at.bestsolution.tasktracker.model.tasktracker.BaseObject> {


		/**
		 * Build dynamic query filters
		 */
		public static final class Expression {
		}

		/**
		 * Build dynamic query order by
		 */
		public static final class Order {
		}

		/**
		 * Build join expressions
		 */
		public static final class Join<O> {
			private final String path;
			public Join(String path) {
				this.path = path;
			}

		}
		/**
		 * Build a delete query
		 */
		public at.bestsolution.persistence.MappedUpdateQuery<BaseObject> deleteAllMappedQuery();

}
