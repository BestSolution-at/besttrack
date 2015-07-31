package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class TaskRepositoryDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.TaskRepository create() {
		return (at.bestsolution.tasktracker.model.tasktracker.TaskRepository)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTaskRepository());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			return entityList.stream().map( TaskRepositoryDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(TaskRepositoryDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskRepository> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setPersonListProxy( dto, entity );
		setSourceRepositoryListProxy( dto, entity );
		setVersionListProxy( dto, entity );
		setChildrenProxy( dto, entity );
		setParentProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository toDTO(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository toDTO(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository();
		dto.setSid( entity.getSid() );
		dto.setName( entity.getName() );
		dto.setDescription( entity.getDescription() );
		dto.setExternalId( entity.isExternalId() );
		dto.setPublicRepo( entity.isPublicRepo() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setPersonListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setPersonList(
			entity.getPersonList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setPersonList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson,at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> processor) {
		if( processor == null ) {
			dto.setPersonList(
				entity.getPersonList().stream()
					.map( RepositoryPersonDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setPersonList(
				entity.getPersonList().stream()
					.map( c -> processor.apply(RepositoryPersonDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setPersonList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setPersonList(dto,entity,null);
	}
	public static void setSourceRepositoryListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setSourceRepositoryList(
			entity.getSourceRepositoryList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setSourceRepositoryList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository, at.bestsolution.tasktracker.model.tasktracker.SourceRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> processor) {
		if( processor == null ) {
			dto.setSourceRepositoryList(
				entity.getSourceRepositoryList().stream()
					.map( SourceRepositoryDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setSourceRepositoryList(
				entity.getSourceRepositoryList().stream()
					.map( c -> processor.apply(SourceRepositoryDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setSourceRepositoryList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setSourceRepositoryList(dto,entity,null);
	}
	public static void setVersionListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setVersionList(
			entity.getVersionList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setVersionList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion, at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> processor) {
		if( processor == null ) {
			dto.setVersionList(
				entity.getVersionList().stream()
					.map( VersionDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setVersionList(
				entity.getVersionList().stream()
					.map( c -> processor.apply(VersionDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setVersionList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setVersionList(dto,entity,null);
	}
	public static void setChildrenProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setChildren(
			entity.getChildren().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setChildren(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setChildren(
				entity.getChildren().stream()
					.map( TaskRepositoryDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setChildren(
				entity.getChildren().stream()
					.map( c -> processor.apply(TaskRepositoryDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setChildren(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setChildren(dto,entity,null);
	}
	public static void setParentProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		dto.setParent(
			entity.getParent() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity.getParent()) )
		);
	}

	public static void setParent(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setParent( TaskRepositoryDTOMapper.toDTO(entity.getParent()) );
		} else {
			dto.setParent( processor.apply(TaskRepositoryDTOMapper.toDTO(entity.getParent()), entity.getParent() ) );
		}
	}

	public static void setParent(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto, at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity) {
		setParent(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.TaskRepository mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.TaskRepository entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository dto) {
		entity.setSid(dto.getSid());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setExternalId(dto.isExternalId());
		entity.setPublicRepo(dto.isPublicRepo());
		return entity;
	}

}
