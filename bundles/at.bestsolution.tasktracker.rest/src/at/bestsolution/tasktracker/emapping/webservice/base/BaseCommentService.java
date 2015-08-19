package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseCommentService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Comment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Comment checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.Comment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/task")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask getTask(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Comment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				checkAccess_getTask(entity, entity.getTask(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_getTask(at.bestsolution.tasktracker.model.tasktracker.Comment entity, at.bestsolution.tasktracker.model.tasktracker.Task value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/attachmentList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> getAttachmentList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Comment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.toDTO(
				checkAccess_getAttachmentList(entity, entity.getAttachmentList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> checkAccess_getAttachmentList(at.bestsolution.tasktracker.model.tasktracker.Comment entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> list, at.bestsolution.persistence.Session session) {
		return list;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.create(),
				dto
			), s);
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Comment checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.Comment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.mergeToEntity( entity, dto );
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Comment checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.Comment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
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
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("comments-per-task")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> commentsPerTask(@javax.ws.rs.QueryParam("tid") long tid) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> rv;
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> result;
			result = checkAccess_commentsPerTask(mapper.selectAllForTask(tid), s);
			rv = at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				result,
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
			return rv;
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> checkAccess_commentsPerTask(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> list , at.bestsolution.persistence.Session session) {
		return list;
	}

}
