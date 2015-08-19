package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class CommentDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.Comment create() {
		return (at.bestsolution.tasktracker.model.tasktracker.Comment)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getComment());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment, at.bestsolution.tasktracker.model.tasktracker.Comment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> processor) {
		if( processor == null ) {
			return entityList.stream().map( CommentDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(CommentDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Comment> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		setTaskProxy( dto, entity );
		setAttachmentListProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment toDTO(at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment toDTO(at.bestsolution.tasktracker.model.tasktracker.Comment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment, at.bestsolution.tasktracker.model.tasktracker.Comment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment();
		dto.setSid( entity.getSid() );
		dto.setTitle( entity.getTitle() );
		dto.setDescription( entity.getDescription() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setTaskProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		dto.setTask(
			entity.getTask() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskDTOMapper.getId(entity.getTask()) )
		);
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask, at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> processor) {
		if( processor == null ) {
			dto.setTask( TaskDTOMapper.toDTO(entity.getTask()) );
		} else {
			dto.setTask( processor.apply(TaskDTOMapper.toDTO(entity.getTask()), entity.getTask() ) );
		}
	}

	public static void setTask(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		setTask(dto,entity,null);
	}
	public static void setAttachmentListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		dto.setAttachmentList(
			entity.getAttachmentList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentAttachmentDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setAttachmentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> processor) {
		if( processor == null ) {
			dto.setAttachmentList(
				entity.getAttachmentList().stream()
					.map( CommentAttachmentDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setAttachmentList(
				entity.getAttachmentList().stream()
					.map( c -> processor.apply(CommentAttachmentDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setAttachmentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto, at.bestsolution.tasktracker.model.tasktracker.Comment entity) {
		setAttachmentList(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.Comment mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.Comment entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment dto) {
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}
