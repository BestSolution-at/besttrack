package at.bestsolution.tasktracker.emapping.webservice.mapper;

public class TaskDTOMapper {
	public static long getId(at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		return entity.getSid();
	}

	public static at.bestsolution.tasktracker.model.tasktracker.Task create() {
		return (at.bestsolution.tasktracker.model.tasktracker.Task)org.eclipse.emf.ecore.util.EcoreUtil.create(at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage.eINSTANCE.getTask());
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> entityList, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask, at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> processor) {
		if( processor == null ) {
			return entityList.stream().map( TaskDTOMapper::toDTO ).collect(java.util.stream.Collectors.toList());
		} else {
			return entityList.stream().map( c -> processor.apply(TaskDTOMapper.toDTO(c), c) ).collect(java.util.stream.Collectors.toList());
		}
	}

	public static java.util.List<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> toDTO(java.util.List<at.bestsolution.tasktracker.model.tasktracker.Task> entityList) {
		return toDTO(entityList,null);
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask fillAllProxyRefs(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setRepositoryProxy( dto, entity );
		setCommentListProxy( dto, entity );
		setChangeSetListProxy( dto, entity );
		setReporterProxy( dto, entity );
		setAssigneeProxy( dto, entity );
		setTargetVersionProxy( dto, entity );
		setProductVersionProxy( dto, entity );
		setAttachmentListProxy( dto, entity );
		return dto;
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask toDTO(at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		return toDTO( entity, null );
	}

	public static at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask toDTO(at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask, at.bestsolution.tasktracker.model.tasktracker.Task,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask> processor) {
		if( entity == null ) {
			return null;
		}
		at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto = new at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask();
		dto.setSid( entity.getSid() );
		dto.setTitle( entity.getTitle() );
		dto.setDescription( entity.getDescription() );
		dto.setState( entity.getState() );
		dto.setExternalBugId( entity.getExternalBugId() );
		if( processor != null ) {
			dto = processor.apply( dto, entity );
		}
		return dto;
	}

	public static void setRepositoryProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setRepository(
			entity.getRepository() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.TaskRepositoryDTOMapper.getId(entity.getRepository()) )
		);
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository, at.bestsolution.tasktracker.model.tasktracker.TaskRepository,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskRepository> processor) {
		if( processor == null ) {
			dto.setRepository( TaskRepositoryDTOMapper.toDTO(entity.getRepository()) );
		} else {
			dto.setRepository( processor.apply(TaskRepositoryDTOMapper.toDTO(entity.getRepository()), entity.getRepository() ) );
		}
	}

	public static void setRepository(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setRepository(dto,entity,null);
	}
	public static void setCommentListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setCommentList(
			entity.getCommentList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.CommentDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setCommentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment, at.bestsolution.tasktracker.model.tasktracker.Comment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOComment> processor) {
		if( processor == null ) {
			dto.setCommentList(
				entity.getCommentList().stream()
					.map( CommentDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setCommentList(
				entity.getCommentList().stream()
					.map( c -> processor.apply(CommentDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setCommentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setCommentList(dto,entity,null);
	}
	public static void setChangeSetListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setChangeSetList(
			entity.getChangeSetList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.ChangeSetDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setChangeSetList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet, at.bestsolution.tasktracker.model.tasktracker.ChangeSet,at.bestsolution.tasktracker.emapping.webservice.dto.DTOChangeSet> processor) {
		if( processor == null ) {
			dto.setChangeSetList(
				entity.getChangeSetList().stream()
					.map( ChangeSetDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setChangeSetList(
				entity.getChangeSetList().stream()
					.map( c -> processor.apply(ChangeSetDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setChangeSetList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setChangeSetList(dto,entity,null);
	}
	public static void setReporterProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setReporter(
			entity.getReporter() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity.getReporter()) )
		);
	}

	public static void setReporter(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( processor == null ) {
			dto.setReporter( PersonDTOMapper.toDTO(entity.getReporter()) );
		} else {
			dto.setReporter( processor.apply(PersonDTOMapper.toDTO(entity.getReporter()), entity.getReporter() ) );
		}
	}

	public static void setReporter(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setReporter(dto,entity,null);
	}
	public static void setAssigneeProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setAssignee(
			entity.getAssignee() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.PersonDTOMapper.getId(entity.getAssignee()) )
		);
	}

	public static void setAssignee(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson, at.bestsolution.tasktracker.model.tasktracker.Person,at.bestsolution.tasktracker.emapping.webservice.dto.DTOPerson> processor) {
		if( processor == null ) {
			dto.setAssignee( PersonDTOMapper.toDTO(entity.getAssignee()) );
		} else {
			dto.setAssignee( processor.apply(PersonDTOMapper.toDTO(entity.getAssignee()), entity.getAssignee() ) );
		}
	}

	public static void setAssignee(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setAssignee(dto,entity,null);
	}
	public static void setTargetVersionProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setTargetVersion(
			entity.getTargetVersion() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.getId(entity.getTargetVersion()) )
		);
	}

	public static void setTargetVersion(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion, at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> processor) {
		if( processor == null ) {
			dto.setTargetVersion( VersionDTOMapper.toDTO(entity.getTargetVersion()) );
		} else {
			dto.setTargetVersion( processor.apply(VersionDTOMapper.toDTO(entity.getTargetVersion()), entity.getTargetVersion() ) );
		}
	}

	public static void setTargetVersion(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setTargetVersion(dto,entity,null);
	}
	public static void setProductVersionProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setProductVersion(
			entity.getProductVersion() == null ? null : at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion.newProxy( at.bestsolution.tasktracker.emapping.webservice.mapper.VersionDTOMapper.getId(entity.getProductVersion()) )
		);
	}

	public static void setProductVersion(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion, at.bestsolution.tasktracker.model.tasktracker.Version,at.bestsolution.tasktracker.emapping.webservice.dto.DTOVersion> processor) {
		if( processor == null ) {
			dto.setProductVersion( VersionDTOMapper.toDTO(entity.getProductVersion()) );
		} else {
			dto.setProductVersion( processor.apply(VersionDTOMapper.toDTO(entity.getProductVersion()), entity.getProductVersion() ) );
		}
	}

	public static void setProductVersion(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setProductVersion(dto,entity,null);
	}
	public static void setAttachmentListProxy(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		dto.setAttachmentList(
			entity.getAttachmentList().stream()
				.map( c -> at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment.newProxy(at.bestsolution.tasktracker.emapping.webservice.mapper.TaskAttachmentDTOMapper.getId(c)) )
				.collect(java.util.stream.Collectors.toList())
		);
	}

	public static void setAttachmentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity, java.util.function.BiFunction<at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment, at.bestsolution.tasktracker.model.tasktracker.TaskAttachment,at.bestsolution.tasktracker.emapping.webservice.dto.DTOTaskAttachment> processor) {
		if( processor == null ) {
			dto.setAttachmentList(
				entity.getAttachmentList().stream()
					.map( TaskAttachmentDTOMapper::toDTO )
					.collect(java.util.stream.Collectors.toList())
			);
		} else {
			dto.setAttachmentList(
				entity.getAttachmentList().stream()
					.map( c -> processor.apply(TaskAttachmentDTOMapper.toDTO(c), c ) )
					.collect(java.util.stream.Collectors.toList())
			);
		}
	}

	public static void setAttachmentList(at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto, at.bestsolution.tasktracker.model.tasktracker.Task entity) {
		setAttachmentList(dto,entity,null);
	}
	public static at.bestsolution.tasktracker.model.tasktracker.Task mergeToEntity(at.bestsolution.tasktracker.model.tasktracker.Task entity, at.bestsolution.tasktracker.emapping.webservice.dto.DTOTask dto) {
		entity.setSid(dto.getSid());
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setState(dto.getState());
		entity.setExternalBugId(dto.getExternalBugId());
		return entity;
	}

}
