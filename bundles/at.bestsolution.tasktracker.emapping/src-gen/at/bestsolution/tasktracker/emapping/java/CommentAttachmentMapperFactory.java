package at.bestsolution.tasktracker.emapping.java;

import at.bestsolution.tasktracker.emapping.CommentAttachmentMapper;
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
import at.bestsolution.tasktracker.model.tasktracker.CommentAttachment;
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
public final class CommentAttachmentMapperFactory implements ObjectMapperFactory<at.bestsolution.tasktracker.emapping.CommentAttachmentMapper,CommentAttachment> {
	@Override
	public Class<CommentAttachment> getEntityType() {
		return CommentAttachment.class;
	}
	
	@Override
	public Class<at.bestsolution.tasktracker.emapping.CommentAttachmentMapper> getMapperType() {
		return at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class;
	}
	
	@Override
	public at.bestsolution.tasktracker.emapping.CommentAttachmentMapper createMapper(JavaSession session) {
		return new CommentAttachmentMapperImpl(session);
	}

	final static class CommentAttachmentMapperImpl implements CommentAttachmentMapper, at.bestsolution.persistence.java.JavaObjectMapper<CommentAttachment>,at.bestsolution.persistence.java.RefreshableObjectMapper<CommentAttachment>, ResolveDelegate {
		private final JavaSession session;
		private boolean inAutoResolve;
		private static final Logger LOGGER = Logger.getLogger(CommentAttachmentMapperImpl.class);

		public CommentAttachmentMapperImpl(JavaSession session) {
			this.session = session;
		}
		
		@Override
		public Class<CommentAttachment> getEntityType() {
			return CommentAttachment.class;
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
					pStmt = connection.prepareStatement("SELECT " + getLockColumn() + " FROM \"comment_attachment\" WHERE ca_id = ?");
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
		public final at.bestsolution.persistence.MappedUpdateQuery<CommentAttachment> deleteAllMappedQuery() {
			MappedUpdateQuery<CommentAttachment> deleteQuery = session.getDatabaseSupport().createMappedUpdateQuery(this, null,
				new UpdateDelegate<CommentAttachment>() { public int execute(MappedUpdateQuery<CommentAttachment> criteria) { return deleteAll((InternalQueryCriteria)criteria); } }
			);
			return deleteQuery;
		}

		// by JavaObjectMapperGenerator
		public final CommentAttachment map_default_CommentAttachment(Connection connection, ResultSet set) throws SQLException {
			Long id = set.getLong("ca_id");
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment();
			CommentAttachment rv = session.getCache().getObject(eClass,id);
			if( rv != null ) {
				if( LOGGER.isDebugEnabled() ) {
					LOGGER.debug("Using cached version");
				}
				return rv;
			}
			rv = session.getProxyFactory().createProxy(eClass);
			((EObject)rv).eSetDeliver(false);
			rv.setSid(set.getLong("ca_id"));
			rv.setBinary(session.handleBlob("comment_attachment","ca_binary","ca_id",set));
			rv.setDescription(set.getString("ca_description"));
			rv.setMimetype(set.getString("ca_mimetype"));
			rv.setTitle(set.getString("ca_title"));
			ProxyData_CommentAttachment proxy = new ProxyData_CommentAttachment(set.getLong("ca_fk_comment"));
			((LazyEObject)rv).setProxyData(proxy);
			((LazyEObject)rv).setProxyDelegate(this);
			((EObject)rv).eSetDeliver(true);
			session.registerObject(rv,getPrimaryKeyValue(rv),getLockColumn() != null ? set.getLong(getLockColumn()) : -1);
			return rv;
		}

		private final void map_default_CommentAttachment_data_refresh(CommentAttachment rv, Connection connection, ResultSet set) throws SQLException {
			rv.setSid(set.getLong("ca_id"));
			rv.setBinary(session.handleBlob("comment_attachment","ca_binary","ca_id",set));
			rv.setDescription(set.getString("ca_description"));
			rv.setMimetype(set.getString("ca_mimetype"));
			rv.setTitle(set.getString("ca_title"));
		}

		private final void map_default_CommentAttachment_complete_refresh(CommentAttachment rv, Connection connection, ResultSet set, Set<Object> refreshedObjects) throws SQLException {
			rv.setSid(set.getLong("ca_id"));
			rv.setBinary(session.handleBlob("comment_attachment","ca_binary","ca_id",set));
			rv.setDescription(set.getString("ca_description"));
			rv.setMimetype(set.getString("ca_mimetype"));
			rv.setTitle(set.getString("ca_title"));
			ProxyData_CommentAttachment proxy = new ProxyData_CommentAttachment(set.getLong("ca_fk_comment"));
			((LazyEObject)rv).setProxyData(proxy);
			((LazyEObject)rv).setProxyDelegate(this);
			{
				EObject eo = (EObject)rv;
				EReference r = (EReference)eo.eClass().getEStructuralFeature("comment");
				if( ((LazyEObject)rv).isResolved(r) ) {
					at.bestsolution.tasktracker.model.tasktracker.Comment v = rv.getComment();
					RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Comment> mr = (RefreshableObjectMapper<at.bestsolution.tasktracker.model.tasktracker.Comment>)session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
					if( v != null && ! refreshedObjects.contains(v) ) {
						mr.refreshWithReferences(v,refreshedObjects);
					} else {
						long currentId = v == null ? 0 : ((Number)mr.getPrimaryKeyValue(v)).longValue();
						if( currentId != proxy.comment ) {
							EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getComment();
							v = session.getCache().getObject(eClass,proxy.comment);
							if( v != null ) {
								resolve((LazyEObject)rv,proxy,r);
								if( ! refreshedObjects.contains(v) ) {
									mr.refreshWithReferences(v,refreshedObjects);
								}
							} else {
								resolve((LazyEObject)rv,proxy,r);
								v = rv.getComment();
								if( v != null ) {
									refreshedObjects.add(v);
								}
							}
						}
					}
				}
			}
		}

			// Utilities
			
			private List<Object> extractObjectIds(CommentAttachment... object) {
				List<Object> objectIds = new ArrayList<Object>();
				for (CommentAttachment o : object) {
					objectIds.add(getPrimaryKeyForTx(o));
				}
				return objectIds;
			}
			
			// Utility Methods
			
			

		// by QueryGenerator
		@Override
		public final java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> selectAll() {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectAll_default.sql");
		
			if( isDebug ) LOGGER.debug("	Plain-Query: " + query);
		
			Connection connection = session.checkoutConnection();
			PreparedStatement pStmt = null;
			ResultSet set = null;
			try {
			if( isDebug ) LOGGER.debug("Preparing query");
			pStmt = connection.prepareStatement(query);
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final List<CommentAttachment> rv = new ArrayList<CommentAttachment>();
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping results started");
			while(set.next()) {
				rv.add(map_default_CommentAttachment(connection, set));
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
		public final MappedQuery<CommentAttachment> selectAllMappedQuery() {
			MappedQuery<CommentAttachment> dbQuery = session.getDatabaseSupport().createMappedQuery(
				this, null,
				new ListDelegate<CommentAttachment>() { public List<CommentAttachment> list(MappedQuery<CommentAttachment> criteria) { return selectAll((MappedQueryImpl<CommentAttachment>)criteria); } }
			);
			return dbQuery;
		}
		
		final List<CommentAttachment> selectAll(MappedQueryImpl<CommentAttachment> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAll");
		
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectAll_criteria_default.sql");
		
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
				List<CommentAttachment> rv = new ArrayList<CommentAttachment>();
				// by QueryGenerator
				if( isDebug ) LOGGER.debug("Mapping results started");
				while(set.next()) {
					rv.add(map_default_CommentAttachment(connection, set));
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
		public final at.bestsolution.tasktracker.model.tasktracker.CommentAttachment selectById(final long sid) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Check id cache for object");
			{
				final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment();
				final CommentAttachment rv = session.getCache().getObject(eClass,sid);
				if( rv != null ) {
					if( isDebug ) LOGGER.debug("Using cached object");
					return rv;
				}
			}
			if( isDebug ) LOGGER.debug("Executing selectById");
		
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectById_default.sql");
		
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
		
			final CommentAttachment rv;
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping result started");
			if( set.next() ) {
				rv = map_default_CommentAttachment(connection,set);
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
		public final java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> selectAllForComment(final long coId) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) LOGGER.debug("Executing selectAllForComment");
		
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectAllForComment_default.sql");
		
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
				if( "coId".equals(processedSQL.dynamicParameterNames.get(i)) ) {
					if( isDebug ) {
						debugParams.add("coId = " + coId);
					}
					pStmt.setLong(paramIndex++,coId);
				}
			}
			if( isDebug ) {
				LOGGER.debug(" Dynamic-Parameters: " + debugParams);
			}
			if( isDebug ) LOGGER.debug("Executing query");
			set = pStmt.executeQuery();
		
			final List<CommentAttachment> rv = new ArrayList<CommentAttachment>();
			// by QueryGenerator
			if( isDebug ) LOGGER.debug("Mapping results started");
			while(set.next()) {
				rv.add(map_default_CommentAttachment(connection, set));
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
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,CommentAttachment>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,CommentAttachment> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,CommentAttachment>)criteria );
				}
			}).list();
		}
		
		public final at.bestsolution.persistence.DynamicSelectQuery<Long,CommentAttachment> selectAllObjectIdsMappedQuery() {
			return session.getDatabaseSupport().createMappedSelectQuery(this, null, new at.bestsolution.persistence.java.query.DynamicListDelegate<Long,CommentAttachment>() {
				public List<Long> list(at.bestsolution.persistence.DynamicSelectQuery<Long,CommentAttachment> criteria) {
					return selectAllObjectIds( (at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,CommentAttachment>)criteria );
				}
			});
		}
		
		public final List<Long> selectAllObjectIds(at.bestsolution.persistence.java.query.DynamicSelectQueryImpl<Long,CommentAttachment> criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
		
			String query = "SELECT \"ca_id\" FROM \"comment_attachment\"";
			
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
		public final void refresh(final CommentAttachment object, final at.bestsolution.persistence.Session.RefreshType refreshType) {
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
		
		public final void refreshWithReferences(final CommentAttachment object, Set<Object> refreshedObjects) {
			if( ! (object instanceof LazyEObject) ) {
				LOGGER.error("Unable to refresh object '"+object+"' not loaded from database");
				return;
			}
		
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectById_default.sql");
		
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
					map_default_CommentAttachment_complete_refresh(object,connection,set,refreshedObjects);
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
		
		private final void refreshDataOnly(final CommentAttachment object, boolean updateVersion) {
			String query;
				query = Util.loadFile(getClass(), "CommentAttachment_selectById_default.sql");
		
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
					map_default_CommentAttachment_data_refresh(object,connection,set);
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
		public final void update(final CommentAttachment object) {
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
			at.bestsolution.persistence.java.DatabaseSupport.UpdateStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"comment_attachment").createUpdateStatement("ca_id", getLockColumn());
			// NEW:
			// simple direct mapped attributes
			// * description
			stmt.addString("ca_description", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Description()));
			// * mimetype
			stmt.addString("ca_mimetype", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Mimetype()));
			// * title
			stmt.addString("ca_title", (java.lang.String)session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Title()));
			// blob direct mapped attributes
			// * binary
			if( object.getBinary() != null ) {
				if( Util.isModified(session, object, "binary") ) {
					stmt.addBlob("ca_binary", object.getBinary());
				}
			} else {
				stmt.addNull("ca_binary",getJDBCType("binary"));
			}
			// one to one references
			// * comment
			if( object.getComment() != null ) {
				final at.bestsolution.tasktracker.emapping.CommentMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getComment());
				stmt.addLong("ca_fk_comment", refKey);
			} else {
				stmt.addNull("ca_fk_comment",getJDBCType("comment"));
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
		public final void insert(final CommentAttachment object) {
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
			at.bestsolution.persistence.java.DatabaseSupport.InsertStatement stmt = session.getDatabaseSupport().createQueryBuilder(this,"comment_attachment").createInsertStatement("ca_id", sequenceExpression, getLockColumn());
		
		
			// handle simple direct mapped attributes
			// * description
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Description());
				if( o != null ) {
					stmt.addString("ca_description", (java.lang.String)o);
				}
			}
			// * mimetype
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Mimetype());
				if( o != null ) {
					stmt.addString("ca_mimetype", (java.lang.String)o);
				}
			}
			// * title
			{
				Object o = session.getTransactionAttribute(object,at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getAttachment_Title());
				if( o != null ) {
					stmt.addString("ca_title", (java.lang.String)o);
				}
			}
		
			// handle blob attributes
			// * binary
			if( object.getBinary() != null ) {
				stmt.addBlob("ca_binary", object.getBinary());
			}
		
		
			// handle one to one references
			// * comment
			if( object.getComment() != null ) {
				final at.bestsolution.tasktracker.emapping.CommentMapper refMapper = session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
				final long refKey = session.getPrimaryKey(refMapper, object.getComment());
				stmt.addLong("ca_fk_comment", refKey);
				//stmt.addLong("ca_fk_comment",object.getComment().getSid());
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
		public final void delete(CommentAttachment object) {
			delete(new CommentAttachment[] { object });
		}
		
		final int deleteAll(InternalQueryCriteria criteria) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if (isDebug) LOGGER.debug("Executing deleteAll");
		
			final String criteriaStr = criteria.getCriteria();
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment());
		
			// build delete query
			String deleteQuery = "DELETE FROM \"comment_attachment\"";
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
		
			session.preExecuteDeleteMany(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment());
		
			// we need to clean up the session
			session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterAllObjectsAfterTx(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment()));
		
			final Connection connection = session.checkoutConnection();
			try {
		
				// find all object ids
				String objectIdSQL = "SELECT \"ca_id\" FROM \"comment_attachment\"";
				PreparedStatement objectIdStmt = null;
				ResultSet objectIdResultSet = null;
				List<Object> objectIds = new ArrayList<Object>();
				try {
					objectIdStmt = connection.prepareStatement(objectIdSQL);
					objectIdResultSet = objectIdStmt.executeQuery();
					while (objectIdResultSet.next()) {
						objectIds.add(objectIdResultSet.getLong("ca_id"));
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
		
		
		
				String sql = "DELETE FROM \"comment_attachment\"";
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
			final EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment();
			session.preExecuteDeleteById(eClass,objectIds);
		
			for(Object id : objectIds) {
				session.scheduleAfterTransaction(new at.bestsolution.persistence.java.UnregisterObjectByIdAfterTx(eClass, id));
			}
		
			final Connection connection = session.checkoutConnection();
			try {
		
		
				// building query begin
				final StringBuilder sqlBuilder = new StringBuilder();
				sqlBuilder.append("DELETE FROM \"comment_attachment\" WHERE \"ca_id\" IN (");
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
		public final void delete(CommentAttachment... object) {
			final boolean isDebug = LOGGER.isDebugEnabled();
			if( isDebug ) {
				LOGGER.debug("delete("+Arrays.toString(object)+")");
			}
			
			List<Object> ids = new ArrayList<Object>();
			for (CommentAttachment o : object) {
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
			if(eo instanceof CommentAttachment) {
				at.bestsolution.tasktracker.model.tasktracker.CommentAttachment target = (at.bestsolution.tasktracker.model.tasktracker.CommentAttachment)eo;
				switch(f.getFeatureID()) {
				  // comment
				  case at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.COMMENT_ATTACHMENT__COMMENT: {
				    {
				      EClass eClass = at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getComment();
				      at.bestsolution.tasktracker.model.tasktracker.Comment o = session.getCache().getObject(eClass, ((ProxyData_CommentAttachment)proxyData).comment);
				      if( o == null ) {
				        o = session.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class).selectById(((ProxyData_CommentAttachment)proxyData).comment);
				      } else {
				        if( LOGGER.isDebugEnabled() ) {
				          LOGGER.debug("Using cached version");
				        }
				      }
				     
				      if (o != null) {
				      	target.setComment(o);
				      }
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
			return "comment_attachment";
		}

		private static Map<String,String> PROPERTY_COL_MAPPING = new HashMap<String,String>();
		private static Map<String,JDBCType> TYPE_MAPPING = new HashMap<String,JDBCType>();
		private static Map<String,EStructuralFeature> REF_ID_FEATURES = new HashMap<String,EStructuralFeature>();
		private static Set<EReference> REFERENCE_FEATURES = new HashSet<EReference>();
		private static Set<EReference> REFERENCE_FORCEDFK = new HashSet<EReference>();
		private static Map<String,Class<? extends at.bestsolution.persistence.ObjectMapper>> REFERENCE_MAPPER = new HashMap<String,Class<? extends at.bestsolution.persistence.ObjectMapper>>();

		static {
			PROPERTY_COL_MAPPING.put("sid","ca_id");
			PROPERTY_COL_MAPPING.put("binary","ca_binary");
			PROPERTY_COL_MAPPING.put("comment","ca_fk_comment");
			PROPERTY_COL_MAPPING.put("description","ca_description");
			PROPERTY_COL_MAPPING.put("mimetype","ca_mimetype");
			PROPERTY_COL_MAPPING.put("title","ca_title");
			TYPE_MAPPING.put("sid",JDBCType.LONG);
			TYPE_MAPPING.put("binary",JDBCType.BLOB);
			TYPE_MAPPING.put("comment",JDBCType.LONG);
			TYPE_MAPPING.put("description",JDBCType.STRING);
			TYPE_MAPPING.put("mimetype",JDBCType.STRING);
			TYPE_MAPPING.put("title",JDBCType.STRING);
			REF_ID_FEATURES.put("comment",at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getBaseObject_Sid());
			REFERENCE_MAPPER.put("comment",at.bestsolution.tasktracker.emapping.CommentMapper.class);
			REFERENCE_FEATURES.add(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment_Comment());
		}
		
		public EClass getEClass() {
			return at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment();
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

		public final <P> P getPrimaryKeyValue(CommentAttachment o) {
			return (P)(Object)o.getSid();
		}

		protected final <P> P getPrimaryKeyForTx(CommentAttachment o) {
			return session.getPrimaryKey(this, o);
		}

		protected final long getVersionForTx(CommentAttachment o) {
			return session.getVersion(this, o);
		}
	}

public final NamedQuery<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> createNamedQuery(final JavaSession session, String name) {
	if( "selectAll".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> queryForList(Object... parameters) {
				return createMapper(session).selectAll();
			}

			public final at.bestsolution.tasktracker.model.tasktracker.CommentAttachment queryForOne(Object... parameters) {
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
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> queryForList(Object... parameters) {
				throw new UnsupportedOperationException("This is a single value query");
			}

			public final at.bestsolution.tasktracker.model.tasktracker.CommentAttachment queryForOne(Object... parameters) {
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
	if( "selectAllForComment".equals(name) ) {
		return new NamedQuery<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment>() {
			public final List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> queryForList(Object... parameters) {
				return createMapper(session).selectAllForComment(((Long)parameters[0]).longValue());
			}

			public final at.bestsolution.tasktracker.model.tasktracker.CommentAttachment queryForOne(Object... parameters) {
				throw new UnsupportedOperationException("This is a list value query");
			}

			public final String[] getParameterNames() {
				String[] rv = new String[1];
				int i = 0;
				rv[i++] = "coId";
				return rv;
			}
		};
	}
	throw new UnsupportedOperationException("Unknown query '"+getClass().getSimpleName()+"."+name+"'");
}

public final MappedQuery<CommentAttachment> mappedQuery(JavaSession session, String name) {
	if("selectAll".equals(name)) {
		return createMapper(session).selectAllMappedQuery();
	}
	throw new UnsupportedOperationException("Unknown criteria query '"+getClass().getSimpleName()+"."+name+"'");
}

final static class ProxyData_CommentAttachment {
  public final long comment;
  public ProxyData_CommentAttachment(long comment) {
    this.comment = comment;
  }
}
}
