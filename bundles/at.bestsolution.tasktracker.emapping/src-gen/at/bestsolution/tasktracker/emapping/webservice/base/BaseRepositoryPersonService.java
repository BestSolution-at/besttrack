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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs );
		}
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
				entity.getPerson(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getRepository(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto) {
		at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			entity.setRepository( dto.getRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getRepository().getSid()) : null );
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.RepositoryPersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.RepositoryPersonMapper.class);
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
