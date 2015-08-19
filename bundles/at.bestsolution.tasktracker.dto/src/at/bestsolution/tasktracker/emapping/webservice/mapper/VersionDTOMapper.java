package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class VersionDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.Version entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.Version create() {
		return (at.bestsolution.tasktracker.model.tasktracker.Version)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getVersion());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion, at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> processor) {
		if( processor == null ) {
			return entityList.stream().map( VersionDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(VersionDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Version> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto, at.bestsolution.tasktracker.model.tasktracker.Version entity) {
		setRepositoryProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion toDTO(at.bestsolution.tasktracker.model.tasktracker.Version entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion toDTO(at.bestsolution.tasktracker.model.tasktracker.Version entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion, at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion();
		dto.setSid( entity.getSid() );
		dto.setValue( entity.getValue() );
		dto.setDate( entity.getDate() );
		dto.setCodename( entity.getCodename() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setRepositoryProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto, at.bestsolution.tasktracker.model.tasktracker.Version entity) {
		dto.setRepository(
			entity.getRepository() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity.getRepository()) )
		);
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto, at.bestsolution.tasktracker.model.tasktracker.Version entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setRepository( TaskRepositoryDTOMapper.toDTO(entity.getRepository()) );
		} else {
			dto.setRepository( processor.apply(TaskRepositoryDTOMapper.toDTO(entity.getRepository()), entity.getRepository() ) );
		}
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto, at.bestsolution.tasktracker.model.tasktracker.Version entity) {
		setRepository(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.Version mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.Version entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion dto) {
		entity.setValue(dto.getValue());
		entity.setDate(dto.getDate());
		entity.setCodename(dto.getCodename());
		return entity;
	}

}
