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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs );
		}
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
				entity.getRepositoryList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto) {
		at.bestsolution.tasktracker.model.tasktracker.Person entity = at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.Person entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.PersonMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.PersonMapper.class);
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
