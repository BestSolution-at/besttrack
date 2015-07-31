package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class ChangeSetDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.ChangeSet create() {
		return (at.bestsolution.tasktracker.model.tasktracker.ChangeSet)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getChangeSet());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet, at.bestsolution.tasktracker.model.tasktracker.ChangeSet,at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> processor) {
		if( processor == null ) {
			return entityList.stream().map( ChangeSetDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(ChangeSetDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.ChangeSet> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		setTaskProxy( dto, entity );
		setSourceRepositoryProxy( dto, entity );
		setPersonProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet toDTO(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet toDTO(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet, at.bestsolution.tasktracker.model.tasktracker.ChangeSet,at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet();
		dto.setSid( entity.getSid() );
		dto.setId( entity.getId() );
		dto.setComment( entity.getComment() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setTaskProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		dto.setTask(
			entity.getTask() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity.getTask()) )
		);
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask, at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> processor) {
		if( processor == null ) {
			dto.setTask( TaskDTOMapper.toDTO(entity.getTask()) );
		} else {
			dto.setTask( processor.apply(TaskDTOMapper.toDTO(entity.getTask()), entity.getTask() ) );
		}
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		setTask(dto,entity,null);
	}
	public static void setSourceRepositoryProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		dto.setSourceRepository(
			entity.getSourceRepository() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.SourceRepositoryDTOMapper.getId(entity.getSourceRepository()) )
		);
	}

	public static void setSourceRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository, at.bestsolution.tasktracker.model.tasktracker.SourceRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOSourceRepository> processor) {
		if( processor == null ) {
			dto.setSourceRepository( SourceRepositoryDTOMapper.toDTO(entity.getSourceRepository()) );
		} else {
			dto.setSourceRepository( processor.apply(SourceRepositoryDTOMapper.toDTO(entity.getSourceRepository()), entity.getSourceRepository() ) );
		}
	}

	public static void setSourceRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		setSourceRepository(dto,entity,null);
	}
	public static void setPersonProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		dto.setPerson(
			entity.getPerson() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity.getPerson()) )
		);
	}

	public static void setPerson(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( processor == null ) {
			dto.setPerson( PersonDTOMapper.toDTO(entity.getPerson()) );
		} else {
			dto.setPerson( processor.apply(PersonDTOMapper.toDTO(entity.getPerson()), entity.getPerson() ) );
		}
	}

	public static void setPerson(at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto, at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity) {
		setPerson(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.ChangeSet mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.ChangeSet entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet dto) {
		entity.setSid(dto.getSid());
		entity.setId(dto.getId());
		entity.setComment(dto.getComment());
		return entity;
	}

}
