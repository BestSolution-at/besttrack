package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseCommentAttachmentService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'CommentAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.CommentAttachment checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/comment")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment getComment(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'CommentAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.toDTO(
				checkAccess_getComment(entity, entity.getComment(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Comment checkAccess_getComment(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, at.bestsolution.tasktracker.model.tasktracker.Comment value, at.bestsolution.persistence.Session session) {
		return value;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/binary")
	public javax.ws.rs.core.Response getBinary(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'CommentAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}

			java.sql.Blob blob = entity.getBinary();
			try {
				if( blob != null ) {
					return javax.ws.rs.core.Response.ok().entity(blob.getBinaryStream()).build();
				}
				return javax.ws.rs.core.Response.ok().build();
			} catch(java.sql.SQLException e) {
				throw new javax.ws.rs.WebApplicationException(e);
			}

		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.create(),
				dto
			), s);
			entity.setComment( dto.getComment() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Comment.class, dto.getComment().getSid()) : null );
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.CommentAttachment checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.mergeToEntity( entity, dto );
			entity.setComment( dto.getComment() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Comment.class, dto.getComment().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.CommentAttachment checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
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
			at.bestsolution.tasktracker.emapping.CommentAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.CommentAttachmentMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
