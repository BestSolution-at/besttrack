package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class TaskAttachmentDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.TaskAttachment create() {
		return (at.bestsolution.tasktracker.model.tasktracker.TaskAttachment)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTaskAttachment());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> processor) {
		if( processor == null ) {
			return entityList.stream().map( TaskAttachmentDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(TaskAttachmentDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.TaskAttachment> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity) {
		setTaskProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment toDTO(at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment toDTO(at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment();
		dto.setSid( entity.getSid() );
		dto.setTitle( entity.getTitle() );
		dto.setMimetype( entity.getMimetype() );
		dto.setDescription( entity.getDescription() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setTaskProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity) {
		dto.setTask(
			entity.getTask() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity.getTask()) )
		);
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask, at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> processor) {
		if( processor == null ) {
			dto.setTask( TaskDTOMapper.toDTO(entity.getTask()) );
		} else {
			dto.setTask( processor.apply(TaskDTOMapper.toDTO(entity.getTask()), entity.getTask() ) );
		}
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity) {
		setTask(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.TaskAttachment mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.TaskAttachment entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment dto) {
		entity.setTitle(dto.getTitle());
		entity.setMimetype(dto.getMimetype());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}
