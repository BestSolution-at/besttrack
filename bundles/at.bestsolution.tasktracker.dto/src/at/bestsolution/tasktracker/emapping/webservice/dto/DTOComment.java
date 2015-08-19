package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOComment {
	/*
	 * Meta data
	 */
	private String metaClassname = "Comment";
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

	public static DTOComment newProxy(long id) {
		DTOComment dto = new DTOComment();
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

	/*
	 * References
	 */
	private DTOTask task;
	private java.util.List<DTOCommentAttachment> attachmentList;

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

	public DTOTask getTask() {
		return this.task;
	}

	public void setTask(DTOTask task) {
		this.task = task;
	}

	public java.util.List<DTOCommentAttachment> getAttachmentList() {
		return this.attachmentList;
	}

	public void setAttachmentList(java.util.List<DTOCommentAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
