/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import java.util.Date;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Version#getValue <em>Value</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Version#getDate <em>Date</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Version#getCodename <em>Codename</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Version#getRepository <em>Repository</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getVersion()
 * @model
 * @generated
 */
public interface Version extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getVersion_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' attribute.
	 * @see #setDate(Date)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getVersion_Date()
	 * @model
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getDate <em>Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' attribute.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Codename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Codename</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Codename</em>' attribute.
	 * @see #setCodename(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getVersion_Codename()
	 * @model
	 * @generated
	 */
	String getCodename();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getCodename <em>Codename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Codename</em>' attribute.
	 * @see #getCodename()
	 * @generated
	 */
	void setCodename(String value);

	/**
	 * Returns the value of the '<em><b>Repository</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getVersionList <em>Version List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repository</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository</em>' container reference.
	 * @see #setRepository(TaskRepository)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getVersion_Repository()
	 * @see at.bestsolution.tasktracker.model.tasktracker.TaskRepository#getVersionList
	 * @model opposite="versionList" transient="false"
	 * @generated
	 */
	TaskRepository getRepository();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Version#getRepository <em>Repository</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository</em>' container reference.
	 * @see #getRepository()
	 * @generated
	 */
	void setRepository(TaskRepository value);

} // Version
