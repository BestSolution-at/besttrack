package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseVersionService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Version entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Version' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Version checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.Version entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/repository")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository getRepository(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Version entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Version' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				checkAccess_getRepository(entity, entity.getRepository(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_getRepository(at.bestsolution.tasktracker.model.tasktracker.Version entity, at.bestsolution.tasktracker.model.tasktracker.TaskRepository value, at.bestsolution.persistence.Session session) {
		return value;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.Version entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.create(),
				dto
			), s);
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Version checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.Version entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Version entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.mergeToEntity( entity, dto );
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Version checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.Version entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
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
			at.bestsolution.tasktracker.emapping.VersionMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.VersionMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
