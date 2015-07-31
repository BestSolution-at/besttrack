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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
		}
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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs );
		}
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
				entity.getTask(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getAttachmentList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto) {
		at.bestsolution.tasktracker.model.tasktracker.Comment entity = at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Comment entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			mapper.deleteAll();
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("commentsPerTask")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> selectAllForTask(@javax.ws.rs.QueryParam("tid") long tid) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentMapper.class);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				mapper.selectAllForTask(tid),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
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
