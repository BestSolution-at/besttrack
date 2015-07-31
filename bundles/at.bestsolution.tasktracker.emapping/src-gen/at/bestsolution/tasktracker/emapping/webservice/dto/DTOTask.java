package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOTask {
	/*
	 * Meta data
	 */
	private String metaClassname = "Task";
	private boolean metaProxy;

	public void setMetaProxy(boolean metaProxy) {
		this.metaProxy = metaProxy;
	}

	public boolean isMetaProxy() {
		return metaProxy;
	}

	public void setMetaClassname(String metaClassname) {
		this.metaClassname = metaClassname;
	}

	public String getMetaClassname() {
		return metaClassname;
	}

	public static DTOTask newProxy(long id) {
		DTOTask dto = new DTOTask();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String title;
	private java.lang.String description;
	private at.bestsolution.tasktracker.model.tasktracker.TaskState state;
	private java.lang.String externalBugId;

	/*
	 * References
	 */
	private DTOTaskRepository repository;
	private java.util.List<DTOComment> commentList;
	private java.util.List<DTOChangeSet> changeSetList;
	private DTOPerson reporter;
	private DTOPerson assignee;
	private DTOVersion targetVersion;
	private DTOVersion productVersion;
	private java.util.List<DTOTaskAttachment> attachmentList;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}
	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public at.bestsolution.tasktracker.model.tasktracker.TaskState getState() {
		return this.state;
	}

	public void setState(at.bestsolution.tasktracker.model.tasktracker.TaskState state) {
		this.state = state;
	}
	public java.lang.String getExternalBugId() {
		return this.externalBugId;
	}

	public void setExternalBugId(java.lang.String externalBugId) {
		this.externalBugId = externalBugId;
	}

	public DTOTaskRepository getRepository() {
		return this.repository;
	}

	public void setRepository(DTOTaskRepository repository) {
		this.repository = repository;
	}

	public java.util.List<DTOComment> getCommentList() {
		return this.commentList;
	}

	public void setCommentList(java.util.List<DTOComment> commentList) {
		this.commentList = commentList;
	}

	public java.util.List<DTOChangeSet> getChangeSetList() {
		return this.changeSetList;
	}

	public void setChangeSetList(java.util.List<DTOChangeSet> changeSetList) {
		this.changeSetList = changeSetList;
	}

	public DTOPerson getReporter() {
		return this.reporter;
	}

	public void setReporter(DTOPerson reporter) {
		this.reporter = reporter;
	}

	public DTOPerson getAssignee() {
		return this.assignee;
	}

	public void setAssignee(DTOPerson assignee) {
		this.assignee = assignee;
	}

	public DTOVersion getTargetVersion() {
		return this.targetVersion;
	}

	public void setTargetVersion(DTOVersion targetVersion) {
		this.targetVersion = targetVersion;
	}

	public DTOVersion getProductVersion() {
		return this.productVersion;
	}

	public void setProductVersion(DTOVersion productVersion) {
		this.productVersion = productVersion;
	}

	public java.util.List<DTOTaskAttachment> getAttachmentList() {
		return this.attachmentList;
	}

	public void setAttachmentList(java.util.List<DTOTaskAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
