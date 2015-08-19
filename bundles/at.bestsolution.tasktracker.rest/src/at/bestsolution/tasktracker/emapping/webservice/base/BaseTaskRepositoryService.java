package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseTaskRepositoryService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/personList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> getPersonList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO(
				checkAccess_getPersonList(entity, entity.getPersonList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> checkAccess_getPersonList(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/sourceRepositoryList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> getSourceRepositoryList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper.toDTO(
				checkAccess_getSourceRepositoryList(entity, entity.getSourceRepositoryList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> checkAccess_getSourceRepositoryList(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/versionList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> getVersionList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.toDTO(
				checkAccess_getVersionList(entity, entity.getVersionList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> checkAccess_getVersionList(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/children")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> getChildren(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				checkAccess_getChildren(entity, entity.getChildren(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> checkAccess_getChildren(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> list, at.bestsolution.persistence.Session session) {
		return list;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/parent")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository getParent(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'TaskRepository' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				checkAccess_getParent(entity, entity.getParent(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_getParent(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, at.bestsolution.tasktracker.model.tasktracker.TaskRepository value, at.bestsolution.persistence.Session session) {
		return value;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.create(),
				dto
			), s);
			entity.setParent( dto.getParent() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getParent().getSid()) : null );
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.mergeToEntity( entity, dto );
			entity.setParent( dto.getParent() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getParent().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
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
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
