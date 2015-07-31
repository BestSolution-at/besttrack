/**
 */
package at.bestsolution.tasktracker.model.tasktracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson <em>Person</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository <em>Repository</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPrivilegeMask <em>Privilege Mask</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getRepositoryPerson()
 * @model
 * @generated
 */
public interface RepositoryPerson extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getRepositoryList <em>Repository List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getRepositoryPerson_Person()
	 * @see at.bestsolution.tasktracker.model.tasktracker.Person#getRepositoryList
	 * @model opposite="repositoryList"
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getPersonList <em>Person List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' container reference.
	 * @see #setRepository(TaskRepository)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getRepositoryPerson_Repository()
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getPersonList
	 * @model opposite="personList" transient="false"
	 * @generated
	 */
	TaskRepository getRepository();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getRepository <em>Repository</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository</em>' container reference.
	 * @see #getRepository()
	 * @generated
	 */
	void setRepository(TaskRepository value);

	/**
	 * Returns the value of the '<em><b>Privilege Mask</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Privilege Mask</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Privilege Mask</em>' attribute.
	 * @see #setPrivilegeMask(long)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getRepositoryPerson_PrivilegeMask()
	 * @model
	 * @generated
	 */
	long getPrivilegeMask();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPrivilegeMask <em>Privilege Mask</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Privilege Mask</em>' attribute.
	 * @see #getPrivilegeMask()
	 * @generated
	 */
	void setPrivilegeMask(long value);

} // RepositoryPerson
