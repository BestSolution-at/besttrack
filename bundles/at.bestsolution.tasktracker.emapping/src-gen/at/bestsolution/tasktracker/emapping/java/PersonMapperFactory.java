package at.bestsolution.tasktracker.emapping.java;

import at.bestsolution.tasktracker.emapping.PersonMapper;
import at.bestsolution.persistence.java.ObjectMapperFactory;
import at.bestsolution.persistence.java.JavaSession;
import at.bestsolution.persistence.java.Util;
import at.bestsolution.persistence.java.Util.ProcessedSQL;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import at.bestsolution.persistence.PersistanceException;
import at.bestsolution.tasktracker.model.tasktracker.TasktrackerFactory;
import at.bestsolution.tasktracker.model.tasktracker.Person;
import at.bestsolution.persistence.model.ResolveDelegate;
import at.bestsolution.persistence.model.LazyEObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import at.bestsolution.persistence.java.Util;
import at.bestsolution.persistence.java.DatabaseSupport.QueryBuilder;
import at.bestsolution.persistence.MappedQuery;
import at.bestsolution.persistence.MappedUpdateQuery;
import at.bestsolution.persistence.java.query.MappedQueryImpl;
import at.bestsolution.persistence.java.query.MappedUpdateQueryImpl;
import at.bestsolution.persistence.java.query.ListDelegate;
import at.bestsolution.persistence.java.query.UpdateDelegate;
import at.bestsolution.persistence.java.query.InternalQueryCriteria;
import at.bestsolution.persistence.java.query.TypedValue;
import at.bestsolution.persistence.java.query.JDBCType;
import org.apache.log4j.Logger;
import java.util.Arrays;
import java.sql.Statement;
import at.bestsolution.persistence.java.RelationSQL;
import at.bestsolution.persistence.java.RelationSQL.Action;
import at.bestsolution.persistence.Callback;
import java.util.Collections;
import java.util.Collection;
import org.eclipse.emf.ecore.util.EcoreUtil;
import at.bestsolution.persistence.java.RefreshableObjectMapper;

// by JavaObjectMapperGenerator
@SuppressWarnings("all")
public final class PersonMapperFactory implements ObjectMapperFactory<at.bestsolution.tasktracker.emapping.PersonMapper,Person> {
	@Override
	public Class<Person> getEntityType() {
		return Person.class;
	}
	
	@Override
	public Class<at.bestsolution.tasktracker.emapping.PersonMapper> getMapperType() {
		return at.bestsolution.tasktracker.emapping.PersonMapper.class;
	}
	
	@Override
	public at.bestsolution.tasktracker.emapping.PersonMapper createMapper(JavaSession session) {
		return new PersonMapperImpl(session);
	}

	final static class PersonMapperImpl implements PersonMapper, at.bestsolution.persistence.java.JavaObjectMapper<Person>,at.bestsolution.persistence.java.RefreshableObjectMapper<Person>, ResolveDelegate {
		private final JavaSession session;
		private boolean inAutoResolve;
		private static final Logger LOGGER = Logger.getLogger(PersonMapperImpl.class);

		public PersonMapperImpl(JavaSession session) {
			this.session = session;
		}
		
		@Override
		public Class<Person> getEntityType() {
			return Person.class;
		}
		
		@Override
		public final JavaSession getSession() {
			return this.session;
		}

		// by JavaObjectMapperGenerator
		@Override
		public long selectVersion(Object id) {
			final Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
				try {
					pStmt = connection.prepareStatement("SELECT " + getLockColumn() + " FROM \"person\" WHERE p_id = ?");
					pStmt.setLong(1, (Long) id);

					set = pStmt.executeQuery();

					if (set.next()) {
						return set.getLong(1);
					}
					else {
						return -1;
					}
				}
				finally {
					if (set != null) set.close();
					if (pStmt != null) pStmt.close();
				}
			}
			catch (SQLException e) {
				throw new PersistanceException(e);
			}
			finally {
				session.returnConnection(connection);
			}
		}


		// by JavaObjectMapperGenerator
		@Override
		public final at.bestsolution.persistence.MappedUpdateQuery<Person> deleteAllMappedQuery() {
			MappedUpdateQuery<Person> deleteQuery = session.getDatabaseSupport().createMappedUpdateQuery(this, null,
				new UpdateDelegate<Person>() { public int execute(MappedUpdateQuery<Person> criteria) { return deleteAll((InternalQueryCriteria)criteria); } }
			);
			return deleteQuery;
		}

		// by JavaObjectMapperGenerator
		public final Person map_default_Person(Connection connection, ResultSet set) throws SQLException {
			Long id = set.getLong("p_id");
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
			Person rv = session.getCache().getObject(eClass,id);
			if( rv != null ) {
				if( LOGGER.isDebugEnabled() ) {
					LOGGER.debug("Using cached version");
				}
				return rv;
			}
			rv = session.getProxyFactory().createProxy(eClass);
			((EObject)rv).eSetDeliver(false);
			rv.setSid(set.getLong("p_id"));
			rv.setFirstname(set.getString("p_firstname"));
			rv.setLastname(set.getString("p_surname"));
			((LazyEObject)rv).setProxyDelegate(this);
			((EObject)rv).eSetDeliver(true);
			session.registerObject(rv,getPrimaryKeyValue(rv),getLockColumn() != null ? set.getLong(getLockColumn()) : -1);
			return rv;
		}

		private final void map_default_Person_data_refresh(Person rv, Connection connection, ResultSet set) throws SQLException {
			rv.setSid(set.getLong("p_id"));
			rv.setFirstname(set.getString("p_firstname"));
			rv.setLastname(set.getString("p_surname"));
		}

		private final void map_default_Person_complete_refresh(Person rv, Connection connection, ResultSet set, Set<Object> refreshedObjects) throws SQLException {
			rv.setSid(set.getLong("p_id"));
			rv.setFirstname(set.getString("p_firstname"));
			rv.setLastname(set.getString("p_surname"));
			((LazyEObject)rv).setProxyDelegate(this);
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("repositoryList");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.emapping.RepositoryPersonMapper m = session.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson>)m;
					List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> list = m.selectAllForPerson(((Number)getPrimaryKeyValue(rv)).longValue());
					Util.syncLists(rv.getRepositoryList(), list);
					for( at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson e : rv.getRepositoryList() ) {
						if( ! refreshedObjects.contains(e) ) {
							mr.refreshWithReferences(e,refreshedObjects);
						}
					}
				}
			}
		}

			// Utilities
			
			private List<Object> extractObjectIds(Person... object) {
				List<Object> objectIds = new ArrayList<Object>();
				for (Person o : object) {
					objectIds.add(getPrimaryKeyForTx(o));
				}
				return objectIds;
			}
			
			// Utility Methods
			
			

		// by QueryGenerator
		@Override
		public final java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> selectAll() {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "Person_selectAll_default.sql");
		
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
			if( isDebug ) LOGGER.debug("Preparing query");
			pStmt = connection.prepareStatement(query);
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final List<Person> rv = new ArrayList<Person>();
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping results started");
			while(set.next()) {
				rv.add(map_default_Person(connection, set));
			}
			if( isDebug ) LOGGER.debug("Mapping results ended. Mapped '"+rv.size()+"' objects.");
				set.close();
				set = null;
				pStmt.close();
				pStmt = null;
				if( isDebug ) LOGGER.debug("Mapping result ended");
				return rv;
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				try {
					if( set != null ) {
						set.close();
					}
		
					if( pStmt != null ) {
						pStmt.close();
					}
				} catch(SQLException e) {
					LOGGER.fatal("Unable to clean up resources", e);
				} finally {
					session.returnConnection(connection);
				}
			}
		}
		// by QueryGenerator
		public final MappedQuery<Person> selectAllMappedQuery() {
			MappedQuery<Person> dbQuery = session.getDatabaseSupport().createMappedQuery(
				this, null,
				new ListDelegate<Person>() { public List<Person> list(MappedQuery<Person> criteria) { return selectAll((MappedQueryImpl<Person>)criteria); } }
			);
			return dbQuery;
		}
		
		final List<Person> selectAll(MappedQueryImpl<Person> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "Person_selectAll_criteria_default.sql");
		
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			String join = criteria.getCriteriaJoin();
			if( join != null && ! join.isEmpty() ) {
				query += " " + join;
			}
		
			String criteriaStr = criteria.getCriteria();
			if( criteriaStr != null && ! criteriaStr.isEmpty() ) {
				query += " WHERE (" + criteriaStr + ")";
			}
			
			String orderBy = criteria.getOrderBy();
			if( orderBy != null && ! orderBy.isEmpty() ) {
				query += " ORDER BY " + orderBy;
			}
		
			if( isDebug ) LOGGER.debug("	Constructed query: " + query);
		
			query = criteria.processSQL(query);
		
			if( isDebug ) LOGGER.debug("	Final query: " + query);
		
			Connection connection = session.checkoutConnection();
			try {
				PreparedStatement pstmt = connection.prepareStatement(query);
				int idx = 1;
				for(TypedValue t : criteria.getParameters()) {
					Util.setValue(pstmt,idx++,t);
				}
		
				ResultSet set = pstmt.executeQuery();
				List<Person> rv = new ArrayList<Person>();
				// by QueryGenerator
				if( isDebug ) LOGGER.debug("Mapping results started");
				while(set.next()) {
					rv.add(map_default_Person(connection, set));
				}
				if( isDebug ) LOGGER.debug("Mapping results ended. Mapped '"+rv.size()+"' objects.");
				return rv;
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		}
		// by QueryGenerator
		@Override
		public final at.bestsolution.tasktracker.model.tasktracker.Person selectById(final long sid) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Check id cache for object");
			{
				final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
				final Person rv = session.getCache().getObject(eClass,sid);
				if( rv != null ) {
					if( isDebug ) LOGGER.debug("Using cached object");
					return rv;
				}
			}
			if( isDebug ) LOGGER.debug("Executing selectById");
		
			String query;
				query = Util.loadFile(getClass(), "Person_selectById_default.sql");
		
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
			final ProcessedSQL processedSQL = Util.processSQL(query);
		
			if( isDebug ) {
				LOGGER.debug("	Processed-Query: " + processedSQL.sql);
			}
		
			if( isDebug ) LOGGER.debug("Preparing query");
			pStmt = connection.prepareStatement(processedSQL.sql);
		
			List<String> debugParams = new ArrayList<String>();
			int paramIndex = 1;
			for(int i = 0; i < processedSQL.dynamicParameterNames.size(); i++) {
				if( "sid".equals(processedSQL.dynamicParameterNames.get(i)) ) {
					if( isDebug ) {
						debugParams.add("sid = " + sid);
					}
					pStmt.setLong(paramIndex++,sid);
				}
			}
			if( isDebug ) {
				LOGGER.debug(" Dynamic-Parameters: " + debugParams);
			}
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final Person rv;
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping result started");
			if( set.next() ) {
				rv = map_default_Person(connection,set);
			} else {
				if( isDebug ) LOGGER.debug("No result for query");
				rv = null;
			}
			if( isDebug ) LOGGER.debug("Mapping result ended.");
				set.close();
				set = null;
				pStmt.close();
				pStmt = null;
				if( isDebug ) LOGGER.debug("Mapping result ended");
				return rv;
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				try {
					if( set != null ) {
						set.close();
					}
		
					if( pStmt != null ) {
						pStmt.close();
					}
				} catch(SQLException e) {
					LOGGER.fatal("Unable to clean up resources", e);
				} finally {
					session.returnConnection(connection);
				}
			}
		}

		public final List<Long> selectAllObjectIds() {
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,Person>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,Person> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Person>)criteria );
				}
			}).list();
		}
		
		public final at.bestsolution.persistence.DynamicSelectQuery<Long,Person> selectAllObjectIdsMappedQuery() {
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,Person>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,Person> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Person>)criteria );
				}
			});
		}
		
		public final List<Long> selectAllObjectIds(at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Person> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
		
			String query = "SELECT \"p_id\" FROM \"person\"";
			
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			String join = criteria.getCriteriaJoin();
			if( join != null && ! join.isEmpty() ) {
				query += " " + join;
			}
			
			String criteriaStr = criteria.getCriteria();
			if( criteriaStr != null && ! criteriaStr.isEmpty() ) {
				query += " WHERE (" + criteriaStr + ")";
			}
			
			if( isDebug ) LOGGER.debug("	Constructed query: " + query);
		
			query = criteria.processSQL(query);
		
			if( isDebug ) LOGGER.debug("	Final query: " + query);
		
			Connection connection = session.checkoutConnection();
			try {
				PreparedStatement pstmt = connection.prepareStatement(query);
				int idx = 1;
				for(TypedValue t : criteria.getParameters()) {
					Util.setValue(pstmt,idx++,t);
				}
		
				ResultSet set = pstmt.executeQuery();
				List<Long> rv = new ArrayList<Long>();
				while( set.next() ) {
					rv.add(set.getLong(1));
				}
				return rv;
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		}



		// refresh stuff
		// by QueryGenerator
		public final void refresh(final Person object, final at.bestsolution.persistence.Session.RefreshType refreshType) {
			switch( refreshType ) {
				case DATA_ONLY:
					refreshDataOnly(object,false);
					break;
				case DATA_ONLY_SYNC_VERSION:
					refreshDataOnly(object,true);
					break;
				case COMPLETE:
					refreshWithReferences(object, new HashSet<Object>());
					break;
			}
		}
		
		public final void refreshWithReferences(final Person object, Set<Object> refreshedObjects) {
			if( ! (object instanceof LazyEObject) ) {
				LOGGER.error("Unable to refresh object '"+object+"' not loaded from database");
				return;
			}
		
			String query;
				query = Util.loadFile(getClass(), "Person_selectById_default.sql");
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
				final ProcessedSQL processedSQL = Util.processSQL(query);
				pStmt = connection.prepareStatement(processedSQL.sql);
				long id = ((Number)getPrimaryKeyValue(object)).longValue();
				pStmt.setLong(1, id);
				set = pStmt.executeQuery();
				if( set.next() ) {
					refreshedObjects.add(object);
					map_default_Person_complete_refresh(object,connection,set,refreshedObjects);
					if( getLockColumn() != null ) {
						session.getCache().updateVersion((EObject)object,id,set.getLong(getLockColumn()));
					}
				} else {
					throw new PersistanceException("Object with id '"+id+"' not available");
				}
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				try {
					if( set != null ) {
						set.close();
					}
					if( pStmt != null ) {
						pStmt.close();
					}
				} catch(SQLException e) {
					LOGGER.fatal("Unable to clean up resources", e);
				} finally {
					session.returnConnection(connection);
				}
			}
		}
		
		private final void refreshDataOnly(final Person object, boolean updateVersion) {
			String query;
				query = Util.loadFile(getClass(), "Person_selectById_default.sql");
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
				final ProcessedSQL processedSQL = Util.processSQL(query);
				pStmt = connection.prepareStatement(processedSQL.sql);
				long id = ((Number)getPrimaryKeyValue(object)).longValue();
				pStmt.setLong(1, id);
				set = pStmt.executeQuery();
				if( set.next() ) {
					map_default_Person_data_refresh(object,connection,set);
					if( updateVersion && getLockColumn() != null ) {
						session.getCache().updateVersion((EObject)object,id,set.getLong(getLockColumn()));
					}
				} else {
					throw new PersistanceException("Object with id '"+id+"' not available");
				}
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				try {
					if( set != null ) {
						set.close();
					}
					if( pStmt != null ) {
						pStmt.close();
					}
				} catch(SQLException e) {
					LOGGER.fatal("Unable to clean up resources", e);
				} finally {
					session.returnConnection(connection);
				}
			}
		}

		// update stuff
		@Override
		public final void update(final Person object) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("Starting insert of '"+object+"'");
			}
		
			if( session.getTransaction() == null ) {
				throw new PersistanceException("You can only modify data while in a transaction");
			}
		
			// Inform session about the update
			session.preExecuteUpdate(this,object);
		
			// Built the query
			at.bestsolution.persistence.java.DatabaseSupport.UpdateStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"person").createUpdateStatement("p_id", getLockColumn());
			// NEW:
			// simple direct mapped attributes
			// * firstname
			stmt.addString("p_firstname", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson_Firstname()));
			// * lastname
			stmt.addString("p_surname", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson_Lastname()));
		
			// Execute the query
			Connection connection = session.checkoutConnection();
			try {
				long version = getLockColumn() != null ? getVersionForTx(object) : -1;
				boolean success = stmt.execute(connection, object.getSid(),version);
		
				if( getLockColumn() != null && ! success ) {
					throw new PersistanceException("The entity '"+object.getClass().getName()+"' is stale");
				} else if( getLockColumn() != null ) {
					session.updateVersion(object,version+1);
				}
		
		
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.ClearChangeDescriptionAfterTx(object));
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.VersionUpdaterAfterTx(object,getPrimaryKeyForTx(object),getVersionForTx(object)));
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		}

		// insert stuff
		@Override
		public final void insert(final Person object) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("Starting insert of '"+object+"'");
			}
		
			if( session.getTransaction() == null ) {
				throw new PersistanceException("You can only modify data while in a transaction");
			}
		
			// Inform session about the insert
			session.preExecuteInsert(this,object);
		
		
			// Handle Expressions
			String sequenceExpression = null;
			if( "Postgres".equals(session.getDatabaseType()) ) {
				sequenceExpression = null;
			}
			// Build the SQL
			at.bestsolution.persistence.java.DatabaseSupport.InsertStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"person").createInsertStatement("p_id", sequenceExpression, getLockColumn());
		
		
			// handle simple direct mapped attributes
			// * firstname
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson_Firstname());
				if( o != null ) {
					stmt.addString("p_firstname", (java.lang.String)o);
				}
			}
			// * lastname
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson_Lastname());
				if( o != null ) {
					stmt.addString("p_surname", (java.lang.String)o);
				}
			}
		
		
		
		
			// Execute the query
			final Connection connection = session.checkoutConnection();
			try {
				final long primaryKey = stmt.execute(connection);
				session.registerPrimaryKey(object, primaryKey);
				session.updateVersion(object,0);
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.AfterTxRunnable() {
					@Override
					public void runAfterTx(JavaSession session) {
						object.setSid(primaryKey);
					}
				});
		
		
		
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.RegisterObjectAfterTx(object, primaryKey, getLockColumn() != null ? 0 : -1));
			} catch(SQLException e) {
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		}

		// delete stuff
		@Override
		public final void delete(Person object) {
			delete(new Person[] { object });
		}
		
		final int deleteAll(InternalQueryCriteria criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if (isDebug) LOGGER.debug("Executing deleteAll");
		
			final String criteriaStr = criteria.getCriteria();
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson());
		
			// build delete query
			String deleteQuery = "DELETE FROM \"person\"";
			if (isDebug) LOGGER.debug("Plain delete query: " + deleteQuery);
			if( criteriaStr != null && ! criteriaStr.isEmpty() ) {
				deleteQuery += " WHERE " + criteriaStr;
			}
			if (isDebug) LOGGER.debug("Final delete query: " + deleteQuery);
		
			Connection connection = session.checkoutConnection();
			try {
				// execute delete
				PreparedStatement pstmt = null;
				try {
					pstmt = connection.prepareStatement(deleteQuery);
					int idx = 1;
					for(TypedValue t : criteria.getParameters()) {
						Util.setValue(pstmt, idx++, t);
					}
					final int n = pstmt.executeUpdate();
					if (isDebug) LOGGER.debug("executed query " + n + " records were affected");
					return n;
				}
				finally {
					if (pstmt != null) {
						pstmt.close();
					}
				}
		
		
			}
			catch (SQLException e) {
				throw new PersistanceException(e);
			}
			finally {
				session.returnConnection(connection);
			}
		
		
		}
		
		@Override
		public final void deleteAll() {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("deleteAll()");
			}
		
			if( session.getTransaction() == null ) {
				throw new PersistanceException("You can only modify data while in a transaction");
			}
		
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson());
		
			// we need to clean up the session
			session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterAllObjectsAfterTx(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson()));
		
			final Connection connection = session.checkoutConnection();
			try {
		
				// find all object ids
				String objectIdSQL = "SELECT \"p_id\" FROM \"person\"";
				PreparedStatement objectIdStmt = null;
				ResultSet objectIdResultSet = null;
				List<Object> objectIds = new ArrayList<Object>();
				try {
					objectIdStmt = connection.prepareStatement(objectIdSQL);
					objectIdResultSet = objectIdStmt.executeQuery();
					while (objectIdResultSet.next()) {
						objectIds.add(objectIdResultSet.getLong("p_id"));
					}
				}
				finally {
					if (objectIdResultSet != null) {
						objectIdResultSet.close();
					}
					if (objectIdStmt != null) {
						objectIdStmt.close();
					}
				}
		
				// self-recursive: false
		
		
		
				String sql = "DELETE FROM \"person\"";
				// executing query begin
				if (isDebug) {
					LOGGER.debug(" Executing SQL: " + sql);
				}
				PreparedStatement stmt = connection.prepareStatement(sql);
				try {
					stmt.execute();
				}
				finally {
					if (stmt != null) {
						stmt.close();
					}
				}
				// executing query end
		
			} catch(SQLException e) {
				if( isDebug ) {
					LOGGER.debug("deleteAll() failed", e);
				}
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		
			if( isDebug ) {
				LOGGER.debug("deleteAll() done.");
			}
		}
		
		@Override
		public void deleteById(Object... id) {
			deleteById(Arrays.asList(id));
		}
		
		public final void deleteById(List<Object> objectIds) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("deleteById("+objectIds+")");
			}
		
			if( session.getTransaction() == null ) {
				throw new PersistanceException("You can only modify data while in a transaction");
			}
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
			session.preExecuteDeleteById(eClass,objectIds);
		
			for(Object id : objectIds) {
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterObjectByIdAfterTx(eClass, id));
			}
		
			final Connection connection = session.checkoutConnection();
			try {
		
		
				// building query begin
				final StringBuilder sqlBuilder = new StringBuilder();
				sqlBuilder.append("DELETE FROM \"person\" WHERE \"p_id\" IN (");
				Iterator<Object> sqlobjectIdsIterator = objectIds.iterator();
				while (sqlobjectIdsIterator.hasNext()) {
					sqlobjectIdsIterator.next();
					sqlBuilder.append("?");
					if (sqlobjectIdsIterator.hasNext()) {
						sqlBuilder.append(", ");
					}
				}
				sqlBuilder.append(")");
				final String sql = sqlBuilder.toString();
				// building query end
				if (!objectIds.isEmpty()) {
					// executing query begin
					if (isDebug) {
						LOGGER.debug(" Executing SQL: " + sql);
					}
					PreparedStatement stmt = connection.prepareStatement(sql);
					try {
						int sqlobjectIdsIdx = 1;
						Iterator<Object> stmtParamIt = objectIds.iterator();
								while (stmtParamIt.hasNext()) {
									final Object obj = stmtParamIt.next();
									if (isDebug) {
										LOGGER.debug(" With Parameter " + sqlobjectIdsIdx + ": " + obj);
									}
									stmt.setLong(sqlobjectIdsIdx, (Long)obj);
									sqlobjectIdsIdx++;
								}
						stmt.execute();
					}
					finally {
						if (stmt != null) {
							stmt.close();
						}
					}
					// executing query end
				}
		
			} catch(SQLException e) {
				if( isDebug ) {
					LOGGER.debug("delete() failed", e);
				}
				throw new PersistanceException(e);
			} finally {
				session.returnConnection(connection);
			}
		
			if( isDebug ) {
				LOGGER.debug("delete() done");
			}
		}
		
		@Override
		public final void delete(Person... object) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("delete("+Arrays.toString(object)+")");
			}
			
			List<Object> ids = new ArrayList<Object>();
			for (Person o : object) {
				ids.add(getPrimaryKeyValue(o));
			}
			deleteById(ids);
			
		}

		// by JavaObjectMapperGenerator
		public final boolean resolve(final LazyEObject eo, final Object proxyData, final EStructuralFeature f) {
			if( inAutoResolve ) {
				return true;
			}

			return session.runWithoutChangeTracking(new Callback<Boolean>() {
				public Boolean call() {
					return doResolve(eo,proxyData,f);
				}
			}).booleanValue();
		}

		// by JavaObjectMapperGenerator
		final boolean doResolve(LazyEObject eo, Object proxyData, EStructuralFeature f) {
			boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("Lazy resolving " + f + " from " + eo + " using " + proxyData);
			}
			if(eo instanceof Person) {
				at.bestsolution.tasktracker.model.tasktracker.Person target = (at.bestsolution.tasktracker.model.tasktracker.Person)eo;
				switch(f.getFeatureID()) {
				  // repositoryList
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.PERSON__REPOSITORY_LIST: {
				    target.getRepositoryList().addAll(session.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class).selectAllForPerson(target.getSid()));
				    return true;
				  }
				  default : {
				    return false;
				  }
				}
			}
			return false;
		}

		// by JavaObjectMapperGenerator
		public final String getTableName() {
			return "person";
		}

		private static Map<String,String> PROPERTY_COL_MAPPING = new HashMap<String,String>();
		private static Map<String,JDBCType> TYPE_MAPPING = new HashMap<String,JDBCType>();
		private static Map<String,EStructuralFeature> REF_ID_FEATURES = new HashMap<String,EStructuralFeature>();
		private static Set<EReference> REFERENCE_FEATURES = new HashSet<EReference>();
		private static Set<EReference> REFERENCE_FORCEDFK = new HashSet<EReference>();
		private static Map<String,Class<? extends at.bestsolution.persistence.ObjectMapper>> REFERENCE_MAPPER = new HashMap<String,Class<? extends at.bestsolution.persistence.ObjectMapper>>();

		static {
			PROPERTY_COL_MAPPING.put("sid","p_id");
			PROPERTY_COL_MAPPING.put("firstname","p_firstname");
			PROPERTY_COL_MAPPING.put("lastname","p_surname");
			TYPE_MAPPING.put("sid",JDBCType.LONG);
			TYPE_MAPPING.put("firstname",JDBCType.STRING);
			TYPE_MAPPING.put("lastname",JDBCType.STRING);
			REFERENCE_MAPPER.put("repositoryList",at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
		}
		
		public EClass getEClass() {
			return at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
		}
		
		// by JavaObjectMapperGenerator
		@Override
		public boolean containsForcedFkFeatures() {
			return !REFERENCE_FORCEDFK.isEmpty();
		}
		
		
		// by JavaObjectMapperGenerator
		@Override
		public final boolean isForcedFkFeature(EReference ref) {
			return REFERENCE_FORCEDFK.contains(ref);
		}
		

		public final String getLockColumn() {
			return "E_VERSION";
		}

		public final String getColumnName(String propertyName) {
			if( propertyName.contains(".") ) {
				String[] segs = Util.splitOfSegment(propertyName);
				return createMapperForReference(segs[0]).getColumnName(segs[1]);
			}
			return PROPERTY_COL_MAPPING.get(propertyName);
		}
		
		public final <M extends at.bestsolution.persistence.ObjectMapper<?>> M createMapperForReference(String propertyName) {
			return (M) session.createMapper(REFERENCE_MAPPER.get(propertyName));
		}

		public final JDBCType getJDBCType(String propertyName) {
			if( propertyName.contains(".") ) {
				String[] segs = Util.splitOfSegment(propertyName);
				at.bestsolution.persistence.java.JavaObjectMapper<?> m = createMapperForReference(segs[0]);
				return m.getJDBCType(segs[1]);
			}
			return TYPE_MAPPING.get(propertyName);
		}

		public final EStructuralFeature getReferenceId(String property) {
			return REF_ID_FEATURES.get(property);
		}

		public final Set<EReference> getReferenceFeatures() {
			return Collections.unmodifiableSet(REFERENCE_FEATURES);
		}

		public final <P> P getPrimaryKeyValue(Person o) {
			return (P)(Object)o.getSid();
		}

		protected final <P> P getPrimaryKeyForTx(Person o) {
			return session.getPrimaryKey(this, o);
		}

		protected final long getVersionForTx(Person o) {
			return session.getVersion(this, o);
		}
	}

public final NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Person> createNamedQuery(final JavaSession session, String name) {
	if( "selectAll".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Person>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.Person> queryForList(Object... parameters) {
				return createMapper(session).selectAll();
			}

			public final at.bestsolution.tasktracker.model.tasktracker.Person queryForOne(Object... parameters) {
				throw new UnsupportedOperationException("This is a list value query");
			}

			public final String[] getParameterNames() {
				String[] rv = new String[0];
				int i = 0;
				return rv;
			}
		};
	}
	if( "selectById".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Person>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.Person> queryForList(Object... parameters) {
				throw new UnsupportedOperationException("This is a single value query");
			}

			public final at.bestsolution.tasktracker.model.tasktracker.Person queryForOne(Object... parameters) {
				return createMapper(session).selectById(((Long)parameters[0]).longValue());
			}

			public final String[] getParameterNames() {
				String[] rv = new String[1];
				int i = 0;
				rv[i++] = "sid";
				return rv;
			}
		};
	}
	throw new UnsupportedOperationException("Unknown query '"+getClass().getSimpleName()+"."+name+"'");
}

public final MappedQuery<Person> mappedQuery(JavaSession session, String name) {
	if("selectAll".equals(name)) {
		return createMapper(session).selectAllMappedQuery();
	}
	throw new UnsupportedOperationException("Unknown criteria query '"+getClass().getSimpleName()+"."+name+"'");
}

}
