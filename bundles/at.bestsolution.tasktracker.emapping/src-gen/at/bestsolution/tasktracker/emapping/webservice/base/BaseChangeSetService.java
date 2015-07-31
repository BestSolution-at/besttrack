package at.bestsolution.tasktracker.emapping.webservice.base;

public abstract class BaseChangeSetService {
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
	public java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> list() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs
			);
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet get(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = mapper.selectById(id);
			if(entity == null) {
				throw new javax.ws.rs.WebApplicationException("Entity 'ChangeSet' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs );
		}
	}

	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/task")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask getTask(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'ChangeSet' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.toDTO(
				entity.getTask(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/sourceRepository")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository getSourceRepository(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'ChangeSet' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper.toDTO(
				entity.getSourceRepository(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}
	@javax.ws.rs.GET
	@javax.ws.rs.Path("{id}/person")
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson getPerson(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = mapper.selectById(id);
			if( entity == null ) {
				throw new javax.ws.rs.WebApplicationException("Entity 'ChangeSet' with ID '"+id+" is unknown.'",javax.ws.rs.core.Response.Status.NOT_FOUND);
			}
			return at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.toDTO(
				entity.getPerson(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto) {
		at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			entity.setSourceRepository( dto.getSourceRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.SourceRepository.class, dto.getSourceRepository().getSid()) : null );
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
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
