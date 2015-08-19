package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BasePersonService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> list, at.bestsolution.persistence.Session session) {
		return list;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Person entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Person' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.Person entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/repositoryList")
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> getRepositoryList(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Person entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'Person' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO(
				checkAccess_getRepositoryList(entity, entity.getRepositoryList(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> checkAccess_getRepositoryList(at.bestsolution.tasktracker.model.tasktracker.Person entity, java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> list, at.bestsolution.persistence.Session session) {
		return list;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.Person entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.create(),
				dto
			), s);
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.Person entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Person entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.mergeToEntity( entity, dto );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.Person entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
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
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
