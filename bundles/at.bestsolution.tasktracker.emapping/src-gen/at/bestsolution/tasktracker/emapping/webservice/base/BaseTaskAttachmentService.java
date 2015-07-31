package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseTaskAttachmentService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper::fillAllProxyRefs
			);
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper::fillAllProxyRefs );
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/task")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask getTask(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				entity.getTask(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/binary")
	public javax.ws.rs.core.Response getBinary(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskAttachment' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
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
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto) {
		at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity = at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskAttachmentMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskAttachmentMapper.class);
			mapper.deleteAll();
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
