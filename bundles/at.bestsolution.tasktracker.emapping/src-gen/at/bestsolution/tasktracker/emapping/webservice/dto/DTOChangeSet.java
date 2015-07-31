package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOChangeSet {
	/*
	 * Meta data
	 */
	private String metaClassname = "ChangeSet";
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

	public static DTOChangeSet newProxy(long id) {
		DTOChangeSet dto = new DTOChangeSet();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String id;
	private java.lang.String comment;

	/*
	 * References
	 */
	private DTOTask task;
	private DTOSourceRepository sourceRepository;
	private DTOPerson person;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getId() {
		return this.id;
	}

	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getComment() {
		return this.comment;
	}

	public void setComment(java.lang.String comment) {
		this.comment = comment;
	}

	public DTOTask getTask() {
		return this.task;
	}

	public void setTask(DTOTask task) {
		this.task = task;
	}

	public DTOSourceRepository getSourceRepository() {
		return this.sourceRepository;
	}

	public void setSourceRepository(DTOSourceRepository sourceRepository) {
		this.sourceRepository = sourceRepository;
	}

	public DTOPerson getPerson() {
		return this.person;
	}

	public void setPerson(DTOPerson person) {
		this.person = person;
	}

}
