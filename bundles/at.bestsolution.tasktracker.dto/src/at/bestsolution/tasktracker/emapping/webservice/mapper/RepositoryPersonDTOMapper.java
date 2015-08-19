package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class RepositoryPersonDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson create() {
		return (at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getRepositoryPerson());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson,at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> processor) {
		if( processor == null ) {
			return entityList.stream().map( RepositoryPersonDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(RepositoryPersonDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		setPersonProxy( dto, entity );
		setRepositoryProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson toDTO(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson toDTO(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson,at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson();
		dto.setSid( entity.getSid() );
		dto.setPrivilegeMask( entity.getPrivilegeMask() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setPersonProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		dto.setPerson(
			entity.getPerson() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity.getPerson()) )
		);
	}

	public static void setPerson(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( processor == null ) {
			dto.setPerson( PersonDTOMapper.toDTO(entity.getPerson()) );
		} else {
			dto.setPerson( processor.apply(PersonDTOMapper.toDTO(entity.getPerson()), entity.getPerson() ) );
		}
	}

	public static void setPerson(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		setPerson(dto,entity,null);
	}
	public static void setRepositoryProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		dto.setRepository(
			entity.getRepository() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity.getRepository()) )
		);
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setRepository( TaskRepositoryDTOMapper.toDTO(entity.getRepository()) );
		} else {
			dto.setRepository( processor.apply(TaskRepositoryDTOMapper.toDTO(entity.getRepository()), entity.getRepository() ) );
		}
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity) {
		setRepository(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson dto) {
		entity.setPrivilegeMask(dto.getPrivilegeMask());
		return entity;
	}

}
