package at.bestsolution.tasktracker.emapping.java;

import at.bestsolution.tasktracker.emapping.TaskMapper;
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
import at.bestsolution.tasktracker.model.tasktracker.Task;
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
public final class TaskMapperFactory implements ObjectMapperFactory<at.bestsolution.tasktracker.emapping.TaskMapper,Task> {
	@Override
	public Class<Task> getEntityType() {
		return Task.class;
	}
	
	@Override
	public Class<at.bestsolution.tasktracker.emapping.TaskMapper> getMapperType() {
		return at.bestsolution.tasktracker.emapping.TaskMapper.class;
	}
	
	@Override
	public at.bestsolution.tasktracker.emapping.TaskMapper createMapper(JavaSession session) {
		return new TaskMapperImpl(session);
	}

	final static class TaskMapperImpl implements TaskMapper, at.bestsolution.persistence.java.JavaObjectMapper<Task>,at.bestsolution.persistence.java.RefreshableObjectMapper<Task>, ResolveDelegate {
		private final JavaSession session;
		private boolean inAutoResolve;
		private static final Logger LOGGER = Logger.getLogger(TaskMapperImpl.class);

		public TaskMapperImpl(JavaSession session) {
			this.session = session;
		}
		
		@Override
		public Class<Task> getEntityType() {
			return Task.class;
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
					pStmt = connection.prepareStatement("SELECT " + getLockColumn() + " FROM \"task\" WHERE t_id = ?");
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
		public final at.bestsolution.persistence.MappedUpdateQuery<Task> deleteAllMappedQuery() {
			MappedUpdateQuery<Task> deleteQuery = session.getDatabaseSupport().createMappedUpdateQuery(this, null,
				new UpdateDelegate<Task>() { public int execute(MappedUpdateQuery<Task> criteria) { return deleteAll((InternalQueryCriteria)criteria); } }
			);
			return deleteQuery;
		}

		// by JavaObjectMapperGenerator
		public final Task map_default_Task(Connection connection, ResultSet set) throws SQLException {
			Long id = set.getLong("t_id");
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask();
			Task rv = session.getCache().getObject(eClass,id);
			if( rv != null ) {
				if( LOGGER.isDebugEnabled() ) {
					LOGGER.debug("Using cached version");
				}
				return rv;
			}
			rv = session.getProxyFactory().createProxy(eClass);
			((EObject)rv).eSetDeliver(false);
			rv.setSid(set.getLong("t_id"));
			rv.setDescription(set.getString("t_description"));
			rv.setExternalBugId(set.getString("t_external_bugid"));
			rv.setState((at.bestsolution.tasktracker.model.tasktracker.TaskState) session.convertType(at.bestsolution.tasktracker.model.tasktracker.TaskState.class, set.getObject("t_state")));
			rv.setTitle(set.getString("t_title"));
			ProxyData_Task proxy = new ProxyData_Task(set.getLong("t_fk_assignee"),set.getLong("t_fk_product_version"),set.getLong("t_fk_person"),set.getLong("t_fk_repository"),set.getLong("t_fk_target_version"));
			((LazyEObject)rv).setProxyData(proxy);
			((LazyEObject)rv).setProxyDelegate(this);
			((EObject)rv).eSetDeliver(true);
			session.registerObject(rv,getPrimaryKeyValue(rv),getLockColumn() != null ? set.getLong(getLockColumn()) : -1);
			return rv;
		}

		private final void map_default_Task_data_refresh(Task rv, Connection connection, ResultSet set) throws SQLException {
			rv.setSid(set.getLong("t_id"));
			rv.setDescription(set.getString("t_description"));
			rv.setExternalBugId(set.getString("t_external_bugid"));
			rv.setState((at.bestsolution.tasktracker.model.tasktracker.TaskState) session.convertType(at.bestsolution.tasktracker.model.tasktracker.TaskState.class, set.getObject("t_state")));
			rv.setTitle(set.getString("t_title"));
		}

		private final void map_default_Task_complete_refresh(Task rv, Connection connection, ResultSet set, Set<Object> refreshedObjects) throws SQLException {
			rv.setSid(set.getLong("t_id"));
			rv.setDescription(set.getString("t_description"));
			rv.setExternalBugId(set.getString("t_external_bugid"));
			rv.setState((at.bestsolution.tasktracker.model.tasktracker.TaskState) session.convertType(at.bestsolution.tasktracker.model.tasktracker.TaskState.class, set.getObject("t_state")));
			rv.setTitle(set.getString("t_title"));
			ProxyData_Task proxy = new ProxyData_Task(set.getLong("t_fk_assignee"),set.getLong("t_fk_product_version"),set.getLong("t_fk_person"),set.getLong("t_fk_repository"),set.getLong("t_fk_target_version"));
			((LazyEObject)rv).setProxyData(proxy);
			((LazyEObject)rv).setProxyDelegate(this);
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("assignee");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.Person v = rv.getAssignee();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Person> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Person>)session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.assignee ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
							v = session.getCache().getObject(eClass,proxy.assignee);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getAssignee();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("productVersion");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.Version v = rv.getProductVersion();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Version> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Version>)session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.productVersion ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getVersion();
							v = session.getCache().getObject(eClass,proxy.productVersion);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getProductVersion();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("reporter");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.Person v = rv.getReporter();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Person> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Person>)session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.reporter ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
							v = session.getCache().getObject(eClass,proxy.reporter);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getReporter();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("repository");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.TaskRepository v = rv.getRepository();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskRepository>)session.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.repository ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTaskRepository();
							v = session.getCache().getObject(eClass,proxy.repository);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getRepository();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("targetVersion");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.Version v = rv.getTargetVersion();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Version> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Version>)session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.targetVersion ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getVersion();
							v = session.getCache().getObject(eClass,proxy.targetVersion);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getTargetVersion();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("attachmentList");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.emapping.TaskAttachmentMapper m = session.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment>)m;
					List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> list = m.selectAllForTask(((Number)getPrimaryKeyValue(rv)).longValue());
					Util.syncLists(rv.getAttachmentList(), list);
					for( at.bestsolution.tasktracker.model.tasktracker.TaskAttachment e : rv.getAttachmentList() ) {
						if( ! refreshedObjects.contains(e) ) {
							mr.refreshWithReferences(e,refreshedObjects);
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("changeSetList");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.emapping.ChangeSetMapper m = session.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.ChangeSet>)m;
					List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> list = m.selectAllForTask(((Number)getPrimaryKeyValue(rv)).longValue());
					Util.syncLists(rv.getChangeSetList(), list);
					for( at.bestsolution.tasktracker.model.tasktracker.ChangeSet e : rv.getChangeSetList() ) {
						if( ! refreshedObjects.contains(e) ) {
							mr.refreshWithReferences(e,refreshedObjects);
						}
					}
				}
			}
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("commentList");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.emapping.CommentMapper m = session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Comment> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Comment>)m;
					List<at.bestsolution.tasktracker.model.tasktracker.Comment> list = m.selectAllForTask(((Number)getPrimaryKeyValue(rv)).longValue());
					Util.syncLists(rv.getCommentList(), list);
					for( at.bestsolution.tasktracker.model.tasktracker.Comment e : rv.getCommentList() ) {
						if( ! refreshedObjects.contains(e) ) {
							mr.refreshWithReferences(e,refreshedObjects);
						}
					}
				}
			}
		}

			// Utilities
			
			private List<Object> extractObjectIds(Task... object) {
				List<Object> objectIds = new ArrayList<Object>();
				for (Task o : object) {
					objectIds.add(getPrimaryKeyForTx(o));
				}
				return objectIds;
			}
			
			// Utility Methods
			
			

		// by QueryGenerator
		@Override
		public final java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> selectAll() {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "Task_selectAll_default.sql");
		
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
			if( isDebug ) LOGGER.debug("Preparing query");
			pStmt = connection.prepareStatement(query);
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final List<Task> rv = new ArrayList<Task>();
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping results started");
			while(set.next()) {
				rv.add(map_default_Task(connection, set));
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
		public final MappedQuery<Task> selectAllMappedQuery() {
			MappedQuery<Task> dbQuery = session.getDatabaseSupport().createMappedQuery(
				this, null,
				new ListDelegate<Task>() { public List<Task> list(MappedQuery<Task> criteria) { return selectAll((MappedQueryImpl<Task>)criteria); } }
			);
			return dbQuery;
		}
		
		final List<Task> selectAll(MappedQueryImpl<Task> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "Task_selectAll_criteria_default.sql");
		
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
				List<Task> rv = new ArrayList<Task>();
				// by QueryGenerator
				if( isDebug ) LOGGER.debug("Mapping results started");
				while(set.next()) {
					rv.add(map_default_Task(connection, set));
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
		public final at.bestsolution.tasktracker.model.tasktracker.Task selectById(final long sid) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Check id cache for object");
			{
				final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask();
				final Task rv = session.getCache().getObject(eClass,sid);
				if( rv != null ) {
					if( isDebug ) LOGGER.debug("Using cached object");
					return rv;
				}
			}
			if( isDebug ) LOGGER.debug("Executing selectById");
		
			String query;
				query = Util.loadFile(getClass(), "Task_selectById_default.sql");
		
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
		
			final Task rv;
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping result started");
			if( set.next() ) {
				rv = map_default_Task(connection,set);
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
		// by QueryGenerator
		@Override
		public final java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> selectOpenTasksForRepository(final long rId) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectOpenTasksForRepository");
		
			String query;
				query = Util.loadFile(getClass(), "Task_selectOpenTasksForRepository_default.sql");
		
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
				if( "rId".equals(processedSQL.dynamicParameterNames.get(i)) ) {
					if( isDebug ) {
						debugParams.add("rId = " + rId);
					}
					pStmt.setLong(paramIndex++,rId);
				}
			}
			if( isDebug ) {
				LOGGER.debug(" Dynamic-Parameters: " + debugParams);
			}
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final List<Task> rv = new ArrayList<Task>();
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping results started");
			while(set.next()) {
				rv.add(map_default_Task(connection, set));
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

		public final List<Long> selectAllObjectIds() {
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,Task>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,Task> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Task>)criteria );
				}
			}).list();
		}
		
		public final at.bestsolution.persistence.DynamicSelectQuery<Long,Task> selectAllObjectIdsMappedQuery() {
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,Task>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,Task> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Task>)criteria );
				}
			});
		}
		
		public final List<Long> selectAllObjectIds(at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,Task> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
		
			String query = "SELECT \"t_id\" FROM \"task\"";
			
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
		public final void refresh(final Task object, final at.bestsolution.persistence.Session.RefreshType refreshType) {
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
		
		public final void refreshWithReferences(final Task object, Set<Object> refreshedObjects) {
			if( ! (object instanceof LazyEObject) ) {
				LOGGER.error("Unable to refresh object '"+object+"' not loaded from database");
				return;
			}
		
			String query;
				query = Util.loadFile(getClass(), "Task_selectById_default.sql");
		
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
					map_default_Task_complete_refresh(object,connection,set,refreshedObjects);
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
		
		private final void refreshDataOnly(final Task object, boolean updateVersion) {
			String query;
				query = Util.loadFile(getClass(), "Task_selectById_default.sql");
		
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
					map_default_Task_data_refresh(object,connection,set);
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
		public final void update(final Task object) {
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
			at.bestsolution.persistence.java.DatabaseSupport.UpdateStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"task").createUpdateStatement("t_id", getLockColumn());
			// NEW:
			// simple direct mapped attributes
			// * description
			stmt.addString("t_description", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Description()));
			// * externalBugId
			stmt.addString("t_external_bugid", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_ExternalBugId()));
			// * state
			stmt.addEnum("t_state", (at.bestsolution.tasktracker.model.tasktracker.TaskState)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_State()));
			// * title
			stmt.addString("t_title", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Title()));
			// one to one references
			// * assignee
			if( object.getAssignee() != null ) {
				final at.bestsolution.tasktracker.emapping.PersonMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getAssignee());
				stmt.addLong("t_fk_assignee", refKey);
			} else {
				stmt.addNull("t_fk_assignee",getJDBCType("assignee"));
			}
			// * productVersion
			if( object.getProductVersion() != null ) {
				final at.bestsolution.tasktracker.emapping.VersionMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getProductVersion());
				stmt.addLong("t_fk_product_version", refKey);
			} else {
				stmt.addNull("t_fk_product_version",getJDBCType("productVersion"));
			}
			// * reporter
			if( object.getReporter() != null ) {
				final at.bestsolution.tasktracker.emapping.PersonMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getReporter());
				stmt.addLong("t_fk_person", refKey);
			} else {
				stmt.addNull("t_fk_person",getJDBCType("reporter"));
			}
			// * repository
			if( object.getRepository() != null ) {
				final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getRepository());
				stmt.addLong("t_fk_repository", refKey);
			} else {
				stmt.addNull("t_fk_repository",getJDBCType("repository"));
			}
			// * targetVersion
			if( object.getTargetVersion() != null ) {
				final at.bestsolution.tasktracker.emapping.VersionMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getTargetVersion());
				stmt.addLong("t_fk_target_version", refKey);
			} else {
				stmt.addNull("t_fk_target_version",getJDBCType("targetVersion"));
			}
		
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
		public final void insert(final Task object) {
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
			at.bestsolution.persistence.java.DatabaseSupport.InsertStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"task").createInsertStatement("t_id", sequenceExpression, getLockColumn());
		
		
			// handle simple direct mapped attributes
			// * description
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Description());
				if( o != null ) {
					stmt.addString("t_description", (java.lang.String)o);
				}
			}
			// * externalBugId
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_ExternalBugId());
				if( o != null ) {
					stmt.addString("t_external_bugid", (java.lang.String)o);
				}
			}
			// * state
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_State());
				if( o != null ) {
					stmt.addEnum("t_state", (at.bestsolution.tasktracker.model.tasktracker.TaskState)o);
				}
			}
			// * title
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Title());
				if( o != null ) {
					stmt.addString("t_title", (java.lang.String)o);
				}
			}
		
		
		
			// handle one to one references
			// * assignee
			if( object.getAssignee() != null ) {
				final at.bestsolution.tasktracker.emapping.PersonMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getAssignee());
				stmt.addLong("t_fk_assignee", refKey);
				//stmt.addLong("t_fk_assignee",object.getAssignee().getSid());
			}
			// * productVersion
			if( object.getProductVersion() != null ) {
				final at.bestsolution.tasktracker.emapping.VersionMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getProductVersion());
				stmt.addLong("t_fk_product_version", refKey);
				//stmt.addLong("t_fk_product_version",object.getProductVersion().getSid());
			}
			// * reporter
			if( object.getReporter() != null ) {
				final at.bestsolution.tasktracker.emapping.PersonMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getReporter());
				stmt.addLong("t_fk_person", refKey);
				//stmt.addLong("t_fk_person",object.getReporter().getSid());
			}
			// * repository
			if( object.getRepository() != null ) {
				final at.bestsolution.tasktracker.emapping.TaskRepositoryMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getRepository());
				stmt.addLong("t_fk_repository", refKey);
				//stmt.addLong("t_fk_repository",object.getRepository().getSid());
			}
			// * targetVersion
			if( object.getTargetVersion() != null ) {
				final at.bestsolution.tasktracker.emapping.VersionMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getTargetVersion());
				stmt.addLong("t_fk_target_version", refKey);
				//stmt.addLong("t_fk_target_version",object.getTargetVersion().getSid());
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
		public final void delete(Task object) {
			delete(new Task[] { object });
		}
		
		final int deleteAll(InternalQueryCriteria criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if (isDebug) LOGGER.debug("Executing deleteAll");
		
			final String criteriaStr = criteria.getCriteria();
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask());
		
			// build delete query
			String deleteQuery = "DELETE FROM \"task\"";
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
		
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask());
		
			// we need to clean up the session
			session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterAllObjectsAfterTx(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask()));
		
			final Connection connection = session.checkoutConnection();
			try {
		
				// find all object ids
				String objectIdSQL = "SELECT \"t_id\" FROM \"task\"";
				PreparedStatement objectIdStmt = null;
				ResultSet objectIdResultSet = null;
				List<Object> objectIds = new ArrayList<Object>();
				try {
					objectIdStmt = connection.prepareStatement(objectIdSQL);
					objectIdResultSet = objectIdStmt.executeQuery();
					while (objectIdResultSet.next()) {
						objectIds.add(objectIdResultSet.getLong("t_id"));
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
		
		
		
				String sql = "DELETE FROM \"task\"";
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
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask();
			session.preExecuteDeleteById(eClass,objectIds);
		
			for(Object id : objectIds) {
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterObjectByIdAfterTx(eClass, id));
			}
		
			final Connection connection = session.checkoutConnection();
			try {
		
		
				// building query begin
				final StringBuilder sqlBuilder = new StringBuilder();
				sqlBuilder.append("DELETE FROM \"task\" WHERE \"t_id\" IN (");
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
		public final void delete(Task... object) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("delete("+Arrays.toString(object)+")");
			}
			
			List<Object> ids = new ArrayList<Object>();
			for (Task o : object) {
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
			if(eo instanceof Task) {
				at.bestsolution.tasktracker.model.tasktracker.Task target = (at.bestsolution.tasktracker.model.tasktracker.Task)eo;
				switch(f.getFeatureID()) {
				  // assignee
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__ASSIGNEE: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
				      at.bestsolution.tasktracker.model.tasktracker.Person o = session.getCache().getObject(eClass, ((ProxyData_Task)proxyData).assignee);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class).selectById(((ProxyData_Task)proxyData).assignee);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      	target.setAssignee(o);
				    }
				    return true;
				  }
				  // attachmentList
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__ATTACHMENT_LIST: {
				    target.getAttachmentList().addAll(session.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class).selectAllForTask(target.getSid()));
				    return true;
				  }
				  // changeSetList
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__CHANGE_SET_LIST: {
				    target.getChangeSetList().addAll(session.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class).selectAllForTask(target.getSid()));
				    return true;
				  }
				  // commentList
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__COMMENT_LIST: {
				    target.getCommentList().addAll(session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class).selectAllForTask(target.getSid()));
				    return true;
				  }
				  // productVersion
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__PRODUCT_VERSION: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getVersion();
				      at.bestsolution.tasktracker.model.tasktracker.Version o = session.getCache().getObject(eClass, ((ProxyData_Task)proxyData).productVersion);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class).selectById(((ProxyData_Task)proxyData).productVersion);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      	target.setProductVersion(o);
				    }
				    return true;
				  }
				  // reporter
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__REPORTER: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson();
				      at.bestsolution.tasktracker.model.tasktracker.Person o = session.getCache().getObject(eClass, ((ProxyData_Task)proxyData).reporter);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class).selectById(((ProxyData_Task)proxyData).reporter);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      	target.setReporter(o);
				    }
				    return true;
				  }
				  // repository
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__REPOSITORY: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTaskRepository();
				      at.bestsolution.tasktracker.model.tasktracker.TaskRepository o = session.getCache().getObject(eClass, ((ProxyData_Task)proxyData).repository);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class).selectById(((ProxyData_Task)proxyData).repository);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      	target.setRepository(o);
				    }
				    return true;
				  }
				  // targetVersion
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.TASK__TARGET_VERSION: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getVersion();
				      at.bestsolution.tasktracker.model.tasktracker.Version o = session.getCache().getObject(eClass, ((ProxyData_Task)proxyData).targetVersion);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class).selectById(((ProxyData_Task)proxyData).targetVersion);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      	target.setTargetVersion(o);
				    }
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
			return "task";
		}

		private static Map<String,String> PROPERTY_COL_MAPPING = new HashMap<String,String>();
		private static Map<String,JDBCType> TYPE_MAPPING = new HashMap<String,JDBCType>();
		private static Map<String,EStructuralFeature> REF_ID_FEATURES = new HashMap<String,EStructuralFeature>();
		private static Set<EReference> REFERENCE_FEATURES = new HashSet<EReference>();
		private static Set<EReference> REFERENCE_FORCEDFK = new HashSet<EReference>();
		private static Map<String,Class<? extends at.bestsolution.persistence.ObjectMapper>> REFERENCE_MAPPER = new HashMap<String,Class<? extends at.bestsolution.persistence.ObjectMapper>>();

		static {
			PROPERTY_COL_MAPPING.put("sid","t_id");
			PROPERTY_COL_MAPPING.put("assignee","t_fk_assignee");
			PROPERTY_COL_MAPPING.put("description","t_description");
			PROPERTY_COL_MAPPING.put("externalBugId","t_external_bugid");
			PROPERTY_COL_MAPPING.put("productVersion","t_fk_product_version");
			PROPERTY_COL_MAPPING.put("reporter","t_fk_person");
			PROPERTY_COL_MAPPING.put("repository","t_fk_repository");
			PROPERTY_COL_MAPPING.put("state","t_state");
			PROPERTY_COL_MAPPING.put("targetVersion","t_fk_target_version");
			PROPERTY_COL_MAPPING.put("title","t_title");
			TYPE_MAPPING.put("sid",JDBCType.LONG);
			TYPE_MAPPING.put("assignee",JDBCType.LONG);
			TYPE_MAPPING.put("description",JDBCType.STRING);
			TYPE_MAPPING.put("externalBugId",JDBCType.STRING);
			TYPE_MAPPING.put("productVersion",JDBCType.LONG);
			TYPE_MAPPING.put("reporter",JDBCType.LONG);
			TYPE_MAPPING.put("repository",JDBCType.LONG);
			TYPE_MAPPING.put("state",JDBCType.UNKNOWN);
			TYPE_MAPPING.put("targetVersion",JDBCType.LONG);
			TYPE_MAPPING.put("title",JDBCType.STRING);
			REF_ID_FEATURES.put("assignee",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REF_ID_FEATURES.put("productVersion",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REF_ID_FEATURES.put("reporter",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REF_ID_FEATURES.put("repository",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REF_ID_FEATURES.put("targetVersion",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REFERENCE_MAPPER.put("assignee",at.bestsolution.tasktracker.emapping.PersonMapper.class);
			REFERENCE_MAPPER.put("attachmentList",at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			REFERENCE_MAPPER.put("changeSetList",at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			REFERENCE_MAPPER.put("commentList",at.bestsolution.tasktracker.emapping.CommentMapper.class);
			REFERENCE_MAPPER.put("productVersion",at.bestsolution.tasktracker.emapping.VersionMapper.class);
			REFERENCE_MAPPER.put("reporter",at.bestsolution.tasktracker.emapping.PersonMapper.class);
			REFERENCE_MAPPER.put("repository",at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			REFERENCE_MAPPER.put("targetVersion",at.bestsolution.tasktracker.emapping.VersionMapper.class);
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Assignee());
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_ProductVersion());
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Reporter());
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_Repository());
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask_TargetVersion());
		}
		
		public EClass getEClass() {
			return at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask();
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

		public final <P> P getPrimaryKeyValue(Task o) {
			return (P)(Object)o.getSid();
		}

		protected final <P> P getPrimaryKeyForTx(Task o) {
			return session.getPrimaryKey(this, o);
		}

		protected final long getVersionForTx(Task o) {
			return session.getVersion(this, o);
		}
	}

public final NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Task> createNamedQuery(final JavaSession session, String name) {
	if( "selectAll".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Task>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.Task> queryForList(Object... parameters) {
				return createMapper(session).selectAll();
			}

			public final at.bestsolution.tasktracker.model.tasktracker.Task queryForOne(Object... parameters) {
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
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Task>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.Task> queryForList(Object... parameters) {
				throw new UnsupportedOperationException("This is a single value query");
			}

			public final at.bestsolution.tasktracker.model.tasktracker.Task queryForOne(Object... parameters) {
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
	if( "selectOpenTasksForRepository".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.Task>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.Task> queryForList(Object... parameters) {
				return createMapper(session).selectOpenTasksForRepository(((Long)parameters[0]).longValue());
			}

			public final at.bestsolution.tasktracker.model.tasktracker.Task queryForOne(Object... parameters) {
				throw new UnsupportedOperationException("This is a list value query");
			}

			public final String[] getParameterNames() {
				String[] rv = new String[1];
				int i = 0;
				rv[i++] = "rId";
				return rv;
			}
		};
	}
	throw new UnsupportedOperationException("Unknown query '"+getClass().getSimpleName()+"."+name+"'");
}

public final MappedQuery<Task> mappedQuery(JavaSession session, String name) {
	if("selectAll".equals(name)) {
		return createMapper(session).selectAllMappedQuery();
	}
	throw new UnsupportedOperationException("Unknown criteria query '"+getClass().getSimpleName()+"."+name+"'");
}

final static class ProxyData_Task {
  public final long assignee;
  public final long productVersion;
  public final long reporter;
  public final long repository;
  public final long targetVersion;
  public ProxyData_Task(long assignee,long productVersion,long reporter,long repository,long targetVersion) {
    this.assignee = assignee;
    this.productVersion = productVersion;
    this.reporter = reporter;
    this.repository = repository;
    this.targetVersion = targetVersion;
  }
}
}
