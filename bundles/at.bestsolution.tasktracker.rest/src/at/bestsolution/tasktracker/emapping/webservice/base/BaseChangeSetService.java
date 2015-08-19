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
			java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> list = checkAccess_list(mapper.selectAll(), s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.toDTO(
				list,
				at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> checkAccess_list(java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> list, at.bestsolution.persistence.Session session) {
		return list;
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
			entity = checkAccess_get(entity, s);
			return at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper::fillAllProxyRefs );
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.ChangeSet checkAccess_get(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.persistence.Session session) {
		return entity;
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
				checkAccess_getTask(entity, entity.getTask(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Task checkAccess_getTask(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.tasktracker.model.tasktracker.Task value, at.bestsolution.persistence.Session session) {
		return value;
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
				checkAccess_getSourceRepository(entity, entity.getSourceRepository(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.SourceRepository checkAccess_getSourceRepository(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.tasktracker.model.tasktracker.SourceRepository value, at.bestsolution.persistence.Session session) {
		return value;
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
				checkAccess_getPerson(entity, entity.getPerson(), s),
				at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper::fillAllProxyRefs
			);
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.Person checkAccess_getPerson(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.tasktracker.model.tasktracker.Person value, at.bestsolution.persistence.Session session) {
		return value;
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = checkAccess_create(at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.mergeToEntity(
				at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.create(),
				dto
			), s);
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			entity.setSourceRepository( dto.getSourceRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.SourceRepository.class, dto.getSourceRepository().getSid()) : null );
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.ChangeSet checkAccess_create(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.persistence.Session session) {
		return entity;
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity = checkAccess_update(mapper.selectById(id), s);
			at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.mergeToEntity( entity, dto );
			entity.setTask( dto.getTask() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Task.class, dto.getTask().getSid()) : null );
			entity.setSourceRepository( dto.getSourceRepository() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.SourceRepository.class, dto.getSourceRepository().getSid()) : null );
			entity.setPerson( dto.getPerson() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.Person.class, dto.getPerson().getSid()) : null );
			s.runInTransaction(se -> {
				mapper.update(entity);
				return true;
			});
			return get(at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.getId(entity));
		}
	}

	protected at.bestsolution.tasktracker.model.tasktracker.ChangeSet checkAccess_update(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.persistence.Session session) {
		return entity;
	}



	@javax.ws.rs.DELETE
	@javax.ws.rs.Path("{id}")
	public void delete(@javax.ws.rs.PathParam("id") long id) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			checkAccess_delete(id, s);
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
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
			at.bestsolution.tasktracker.emapping.ChangeSetMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.ChangeSetMapper.class);
			mapper.deleteAll();
		}
	}

	protected void checkAccess_deleteAll(at.bestsolution.persistence.Session session) {
		// do nothing by default
	}

}
