/**
 */
package at.bestsolution.tasktracker.model.tasktracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getTask <em>Task</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getId <em>Id</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getSourceRepository <em>Source Repository</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getComment <em>Comment</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getPerson <em>Person</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet()
 * @model
 * @generated
 */
public interface ChangeSet extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Task</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getChangeSetList <em>Change Set List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' container reference.
	 * @see #setTask(Task)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet_Task()
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getChangeSetList
	 * @model opposite="changeSetList" transient="false"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getTask <em>Task</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' container reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Source Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Repository</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Repository</em>' reference.
	 * @see #setSourceRepository(SourceRepository)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet_SourceRepository()
	 * @model
	 * @generated
	 */
	SourceRepository getSourceRepository();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getSourceRepository <em>Source Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Repository</em>' reference.
	 * @see #getSourceRepository()
	 * @generated
	 */
	void setSourceRepository(SourceRepository value);

	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Person</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Person</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Person</em>' reference.
	 * @see #setPerson(Person)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getChangeSet_Person()
	 * @model
	 * @generated
	 */
	Person getPerson();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.ChangeSet#getPerson <em>Person</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Person</em>' reference.
	 * @see #getPerson()
	 * @generated
	 */
	void setPerson(Person value);

} // ChangeSet
