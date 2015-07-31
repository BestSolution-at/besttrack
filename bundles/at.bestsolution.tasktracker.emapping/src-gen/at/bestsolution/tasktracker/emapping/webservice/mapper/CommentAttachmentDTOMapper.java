package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class CommentAttachmentDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.CommentAttachment create() {
		return (at.bestsolution.tasktracker.model.tasktracker.CommentAttachment)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getCommentAttachment());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> processor) {
		if( processor == null ) {
			return entityList.stream().map( CommentAttachmentDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(CommentAttachmentDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.CommentAttachment> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity) {
		setCommentProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment toDTO(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment toDTO(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment();
		dto.setSid( entity.getSid() );
		dto.setTitle( entity.getTitle() );
		dto.setMimetype( entity.getMimetype() );
		dto.setDescription( entity.getDescription() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setCommentProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity) {
		dto.setComment(
			entity.getComment() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.getId(entity.getComment()) )
		);
	}

	public static void setComment(at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment, at.bestsolution.tasktracker.model.tasktracker.Comment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> processor) {
		if( processor == null ) {
			dto.setComment( CommentDTOMapper.toDTO(entity.getComment()) );
		} else {
			dto.setComment( processor.apply(CommentDTOMapper.toDTO(entity.getComment()), entity.getComment() ) );
		}
	}

	public static void setComment(at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto, at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity) {
		setComment(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.CommentAttachment mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.CommentAttachment entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOCommentAttachment dto) {
		entity.setSid(dto.getSid());
		entity.setTitle(dto.getTitle());
		entity.setMimetype(dto.getMimetype());
		entity.setDescription(dto.getDescription());
		return entity;
	}

}
