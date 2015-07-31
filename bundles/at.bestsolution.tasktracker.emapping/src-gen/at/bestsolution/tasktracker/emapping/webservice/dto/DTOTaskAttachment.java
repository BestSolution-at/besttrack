package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOTaskAttachment {
	/*
	 * Meta data
	 */
	private String metaClassname = "TaskAttachment";
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

	public static DTOTaskAttachment newProxy(long id) {
		DTOTaskAttachment dto = new DTOTaskAttachment();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String title;
	private java.lang.String mimetype;
	private java.lang.String description;

	/*
	 * References
	 */
	private DTOTask task;

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
	public java.lang.String getMimetype() {
		return this.mimetype;
	}

	public void setMimetype(java.lang.String mimetype) {
		this.mimetype = mimetype;
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

}
