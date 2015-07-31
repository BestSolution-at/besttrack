/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getName <em>Name</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getPersonList <em>Person List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getSourceRepositoryList <em>Source Repository List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getVersionList <em>Version List</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getDescription <em>Description</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getChildren <em>Children</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getParent <em>Parent</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isExternalId <em>External Id</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isPublicRepo <em>Public Repo</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository()
 * @model
 * @generated
 */
public interface TaskRepository extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Person List</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person List</em>' containment reference list.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_PersonList()
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository
	 * @model opposite="repository" containment="true"
	 * @generated
	 */
	EList<RepositoryPerson> getPersonList();

	/**
	 * Returns the value of the '<em><b>Source Repository List</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Repository List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Repository List</em>' containment reference list.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_SourceRepositoryList()
	 * @see at.bestsolution.tasktracker.model.tasktracker.SourceRepository#getRepository
	 * @model opposite="repository" containment="true"
	 * @generated
	 */
	EList<SourceRepository> getSourceRepositoryList();

	/**
	 * Returns the value of the '<em><b>Version List</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.tasktracker.model.tasktracker.Version}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version List</em>' containment reference list.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_VersionList()
	 * @see at.bestsolution.tasktracker.model.tasktracker.Version#getRepository
	 * @model opposite="repository" containment="true"
	 * @generated
	 */
	EList<Version> getVersionList();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_Children()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskRepository> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(TaskRepository)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_Parent()
	 * @model
	 * @generated
	 */
	TaskRepository getParent();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(TaskRepository value);

	/**
	 * Returns the value of the '<em><b>External Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>External Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>External Id</em>' attribute.
	 * @see #setExternalId(boolean)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_ExternalId()
	 * @model
	 * @generated
	 */
	boolean isExternalId();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isExternalId <em>External Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>External Id</em>' attribute.
	 * @see #isExternalId()
	 * @generated
	 */
	void setExternalId(boolean value);

	/**
	 * Returns the value of the '<em><b>Public Repo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Public Repo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Public Repo</em>' attribute.
	 * @see #setPublicRepo(boolean)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskRepository_PublicRepo()
	 * @model
	 * @generated
	 */
	boolean isPublicRepo();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#isPublicRepo <em>Public Repo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Public Repo</em>' attribute.
	 * @see #isPublicRepo()
	 * @generated
	 */
	void setPublicRepo(boolean value);

} // TaskRepository
