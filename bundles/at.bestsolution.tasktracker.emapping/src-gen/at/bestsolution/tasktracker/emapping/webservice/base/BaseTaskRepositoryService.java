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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO(
				mapper.selectAll(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
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
			return at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.toDTO( entity, at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs );
		}
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
				entity.getPersonList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getSourceRepositoryList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getVersionList(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getChildren(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
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
				entity.getParent(),
				at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper::fillAllProxyRefs
			);
		}
	}


	@javax.ws.rs.PUT
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public LongWrapper create(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto) {
		at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.mergeToEntity(
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.create(),
			dto
		);
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			entity.setParent( dto.getParent() != null ? s.get(at.bestsolution.tasktracker.model.tasktracker.TaskRepository.class, dto.getParent().getSid()) : null );
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			s.runInTransaction(se -> {
				mapper.insert(entity);
				return true;
			});

			return LongWrapper.valueOf(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity));
		}
	}

	@javax.ws.rs.PUT
	@javax.ws.rs.Path("{id}")
	@javax.ws.rs.Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public void update(@javax.ws.rs.PathParam("id") long id, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto) {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity = mapper.selectById(id);
			at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.mergeToEntity( entity, dto );
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
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
			mapper.deleteById(id);
		}
	}


	@javax.ws.rs.DELETE
	public void deleteAll() {
		try( at.bestsolution.persistence.Session s = sessionFactory.createSession() ) {
			at.bestsolution.tasktracker.emapping.TaskRepositoryMapper mapper = s.createMapper(at.bestsolution.tasktracker.emapping.TaskRepositoryMapper.class);
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
