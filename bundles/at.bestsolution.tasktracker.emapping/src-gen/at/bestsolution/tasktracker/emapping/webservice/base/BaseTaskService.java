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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs );
		}
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
				entity.getRepository(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getCommentList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getChangeSetList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getReporter(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getAssignee(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getTargetVersion(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getProductVersion(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getAttachmentList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto) {
		at.bestsolution.tasktracker.model.tasktracker.Task entity = at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
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

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Task entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.mergeToEntity( entity, dto );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
		}
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			mapper.deleteAll();
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("open-tasks-in-repo")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> selectOpenTasksForRepository(@javax.ws.rs.QueryParam("rId") long rId) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskMapper.class);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				mapper.selectOpenTasksForRepository(rId),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}

	public static class LongWrapper {
		private long value;

		public void setValue(long value) {
			this.value = value;
		}

		public long getValue() {
			return this.value;
		}

		public static LongWrapper valueOf(long value) {
			LongWrapper rv = new LongWrapper();
			rv.setValue(value);
			return rv;
		}
	}
}
