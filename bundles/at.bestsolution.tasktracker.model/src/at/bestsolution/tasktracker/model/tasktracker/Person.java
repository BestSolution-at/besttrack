/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Person#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Person#getLastname <em>Lastname</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Person#getRepositoryList <em>Repository List</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getPerson()
 * @model
 * @generated
 */
public interface Person extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Firstname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Firstname</em>' attribute.
	 * @see #setFirstname(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getPerson_Firstname()
	 * @model
	 * @generated
	 */
	String getFirstname();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getFirstname <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firstname</em>' attribute.
	 * @see #getFirstname()
	 * @generated
	 */
	void setFirstname(String value);

	/**
	 * Returns the value of the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lastname</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lastname</em>' attribute.
	 * @see #setLastname(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getPerson_Lastname()
	 * @model
	 * @generated
	 */
	String getLastname();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Person#getLastname <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lastname</em>' attribute.
	 * @see #getLastname()
	 * @generated
	 */
	void setLastname(String value);

	/**
	 * Returns the value of the '<em><b>Repository List</b></em>' reference list.
	 * The list contents are of type {@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson}.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository List</em>' reference list.
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getPerson_RepositoryList()
	 * @see at.bestsolution.tasktracker.model.tasktracker.RepositoryPerson#getPerson
	 * @model opposite="person"
	 * @generated
	 */
	EList<RepositoryPerson> getRepositoryList();

} // Person
