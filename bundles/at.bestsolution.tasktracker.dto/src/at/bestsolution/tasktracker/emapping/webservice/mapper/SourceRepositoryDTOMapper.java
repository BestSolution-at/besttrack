package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class SourceRepositoryDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.SourceRepository create() {
		return (at.bestsolution.tasktracker.model.tasktracker.SourceRepository)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getSourceRepository());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository, at.bestsolution.tasktracker.model.tasktracker.SourceRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> processor) {
		if( processor == null ) {
			return entityList.stream().map( SourceRepositoryDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(SourceRepositoryDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.SourceRepository> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto, at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity) {
		setRepositoryProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository toDTO(at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository toDTO(at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository, at.bestsolution.tasktracker.model.tasktracker.SourceRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository();
		dto.setSid( entity.getSid() );
		dto.setSourceUrl( entity.getSourceUrl() );
		dto.setWebUrl( entity.getWebUrl() );
		dto.setType( entity.getType() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setRepositoryProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto, at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity) {
		dto.setRepository(
			entity.getRepository() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity.getRepository()) )
		);
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto, at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setRepository( TaskRepositoryDTOMapper.toDTO(entity.getRepository()) );
		} else {
			dto.setRepository( processor.apply(TaskRepositoryDTOMapper.toDTO(entity.getRepository()), entity.getRepository() ) );
		}
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto, at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity) {
		setRepository(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.SourceRepository mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.SourceRepository entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository dto) {
		entity.setSourceUrl(dto.getSourceUrl());
		entity.setWebUrl(dto.getWebUrl());
		entity.setType(dto.getType());
		return entity;
	}

}
