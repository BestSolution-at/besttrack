package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseTaskService {
	private at.bestsolution.persistence.SessionFactory sessionFactory;

	public void setSessionFactory(at.bestsolution.persistence.SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void unsetSessionFactory(at.bestsolution.persistence.SessionFactory sessionFactory) {
		if( this.sessionFactory != sessionFactory ) {
			this.sessionFactory = null;
		}
	}

	@javax.ws.rs.GET
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/repository")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository getRepository(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				checkAccess_getRepository(entity, entity.getRepository(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_getRepository(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.model.tasktracker.TaskRepository value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/commentList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> getCommentList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				checkAccess_getCommentList(entity, entity.getCommentList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> checkAccess_getCommentList(at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/changeSetList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> getChangeSetList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.toDTO(
				checkAccess_getChangeSetList(entity, entity.getChangeSetList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> checkAccess_getChangeSetList(at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/reporter")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson getReporter(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				checkAccess_getReporter(entity, entity.getReporter(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_getReporter(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.model.tasktracker.Person value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/assignee")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson getAssignee(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				checkAccess_getAssignee(entity, entity.getAssignee(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_getAssignee(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.model.tasktracker.Person value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/targetVersion")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion getTargetVersion(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO(
				checkAccess_getTargetVersion(entity, entity.getTargetVersion(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Version checkAccess_getTargetVersion(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.model.tasktracker.Version value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/productVersion")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion getProductVersion(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO(
				checkAccess_getProductVersion(entity, entity.getProductVersion(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Version checkAccess_getProductVersion(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.model.tasktracker.Version value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/attachmentList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> getAttachmentList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Task' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.toDTO(
				checkAccess_getAttachmentList(entity, entity.getAttachmentList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> checkAccess_getAttachmentList(at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> list, at.bestsolution.persistence.Session session) {
		return list;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.Task entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.create(),
				dto
			), s);
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			entity.setReporter( dto.getReporter() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getReporter().getSid()) : null );
			entity.setAssignee( dto.getAssignee() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getAssignee().getSid()) : null );
			entity.setTargetVersion( dto.getTargetVersion() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Version.class, dto.getTargetVersion().getSid()) : null );
			entity.setProductVersion( dto.getProductVersion() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Version.class, dto.getProductVersion().getSid()) : null );
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.mergeToEntity( entity, dto );
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			entity.setReporter( dto.getReporter() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getReporter().getSid()) : null );
			entity.setAssignee( dto.getAssignee() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getAssignee().getSid()) : null );
			entity.setTargetVersion( dto.getTargetVersion() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Version.class, dto.getTargetVersion().getSid()) : null );
			entity.setProductVersion( dto.getProductVersion() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Version.class, dto.getProductVersion().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			mapper.deleteById(id);
		}
	}

	protected void checkAccess_delete(long id, at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_deleteAll(s);
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("open-tasks-in-repo")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> openTaskInRepository(@javax.ws.rs.QueryParam("rId") long rId) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> rv;
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> result;
			result = checkAccess_openTaskInRepository(mapper.selectOpenTasksForRepository(rId), s);
			rv = at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				result,
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
			return rv;
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> checkAccess_openTaskInRepository(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> list , at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("complete-task")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask getCompleteTask(@javax.ws.rs.QueryParam("sid") long sid) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask rv;
			at.bestsolution.tasktracker.model.tasktracker.Task result;
			result = checkAccess_getCompleteTask(mapper.selectById(sid), s);
			rv = at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				result,
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
			resolveGreedy_getCompleteTask_Task_repository(rv,result);
			resolveGreedy_getCompleteTask_Task_commentList(rv,result);
			return rv;
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_getCompleteTask(at.bestsolution.tasktracker.model.tasktracker.Task value, at.bestsolution.persistence.Session session) {
		return value;
	}

	private static void resolveGreedy_getCompleteTask_Task_repository(
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto,
		at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setRepository(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(entity.getRepository()));
		resolveGreedy_getCompleteTask_TaskRepository_versionList(
			dto.getRepository(),
			entity.getRepository()
		);
	}
	private static void resolveGreedy_getCompleteTask_TaskRepository_versionList(
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto,
		at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setVersionList(at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO(entity.getVersionList()));
	}
	private static void resolveGreedy_getCompleteTask_Task_commentList(
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto,
		at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setCommentList(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(entity.getCommentList()));
	}
}
