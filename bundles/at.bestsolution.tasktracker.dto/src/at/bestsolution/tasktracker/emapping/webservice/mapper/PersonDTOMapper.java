package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class PersonDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.Person entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.Person create() {
		return (at.bestsolution.tasktracker.model.tasktracker.Person)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getPerson());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( processor == null ) {
			return entityList.stream().map( PersonDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(PersonDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Person> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto, at.bestsolution.tasktracker.model.tasktracker.Person entity) {
		setRepositoryListProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson toDTO(at.bestsolution.tasktracker.model.tasktracker.Person entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson toDTO(at.bestsolution.tasktracker.model.tasktracker.Person entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson();
		dto.setSid( entity.getSid() );
		dto.setFirstname( entity.getFirstname() );
		dto.setLastname( entity.getLastname() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setRepositoryListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto, at.bestsolution.tasktracker.model.tasktracker.Person entity) {
		dto.setRepositoryList(
			entity.getRepositoryList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.RepositoryPersonDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setRepositoryList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto, at.bestsolution.tasktracker.model.tasktracker.Person entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson, at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson,at.bestsolution.tasktracker.emapping.webservice.dto.DTORepositoryPerson> processor) {
		if( processor == null ) {
			dto.setRepositoryList(
				entity.getRepositoryList().stream()
					.map( RepositoryPersonDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setRepositoryList(
				entity.getRepositoryList().stream()
					.map( c -> processor.apply(RepositoryPersonDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setRepositoryList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto, at.bestsolution.tasktracker.model.tasktracker.Person entity) {
		setRepositoryList(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.Person mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.Person entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson dto) {
		entity.setFirstname(dto.getFirstname());
		entity.setLastname(dto.getLastname());
		return entity;
	}

}
