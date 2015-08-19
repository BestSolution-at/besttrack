package at.bestsolution.tasktracker.emapping.webservice.dto;

public class DTOTaskRepository {
	/*
	 * Meta data
	 */
	private String metaClassname = "TaskRepository";
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

	public static DTOTaskRepository newProxy(long id) {
		DTOTaskRepository dto = new DTOTaskRepository();
		dto.setSid(id);
		dto.setMetaProxy(true);
		return dto;
	}

	/*
	 * Attributes
	 */
	private long sid;
	private java.lang.String name;
	private java.lang.String description;
	private boolean externalId;
	private boolean publicRepo;

	/*
	 * References
	 */
	private java.util.List<DTORepositoryPerson> personList;
	private java.util.List<DTOSourceRepository> sourceRepositoryList;
	private java.util.List<DTOVersion> versionList;
	private java.util.List<DTOTaskRepository> children;
	private DTOTaskRepository parent;

	public long getSid() {
		return this.sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}
	public java.lang.String getName() {
		return this.name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
	public boolean isExternalId() {
		return this.externalId;
	}

	public void setExternalId(boolean externalId) {
		this.externalId = externalId;
	}
	public boolean isPublicRepo() {
		return this.publicRepo;
	}

	public void setPublicRepo(boolean publicRepo) {
		this.publicRepo = publicRepo;
	}

	public java.util.List<DTORepositoryPerson> getPersonList() {
		return this.personList;
	}

	public void setPersonList(java.util.List<DTORepositoryPerson> personList) {
		this.personList = personList;
	}

	public java.util.List<DTOSourceRepository> getSourceRepositoryList() {
		return this.sourceRepositoryList;
	}

	public void setSourceRepositoryList(java.util.List<DTOSourceRepository> sourceRepositoryList) {
		this.sourceRepositoryList = sourceRepositoryList;
	}

	public java.util.List<DTOVersion> getVersionList() {
		return this.versionList;
	}

	public void setVersionList(java.util.List<DTOVersion> versionList) {
		this.versionList = versionList;
	}

	public java.util.List<DTOTaskRepository> getChildren() {
		return this.children;
	}

	public void setChildren(java.util.List<DTOTaskRepository> children) {
		this.children = children;
	}

	public DTOTaskRepository getParent() {
		return this.parent;
	}

	public void setParent(DTOTaskRepository parent) {
		this.parent = parent;
	}

}
