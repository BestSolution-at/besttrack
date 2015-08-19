package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseRepositoryPersonService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'RepositoryPerson' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/person")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson getPerson(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'RepositoryPerson' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				checkAccess_getPerson(entity, entity.getPerson(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_getPerson(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.tasktracker.model.tasktracker.Person value, at.bestsolution.persistence.Session session) {
		return value;
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/repository")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository getRepository(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'RepositoryPerson' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				checkAccess_getRepository(entity, entity.getRepository(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.TaskRepository checkAccess_getRepository(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.tasktracker.model.tasktracker.TaskRepository value, at.bestsolution.persistence.Session session) {
		return value;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson create(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.create(),
				dto
			), s);
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.mergeToEntity( entity, dto );
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
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
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
