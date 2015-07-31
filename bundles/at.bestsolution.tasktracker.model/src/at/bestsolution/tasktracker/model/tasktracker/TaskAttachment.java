/**
 */
package at.bestsolution.tasktracker.model.tasktracker;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.TaskAttachment#getTask <em>Task</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskAttachment()
 * @model
 * @generated
 */
public interface TaskAttachment extends Attachment {
	/**
	 * Returns the value of the '<em><b>Task</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link at.bestsolution.tasktracker.model.tasktracker.Task#getAttachmentList <em>Attachment List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Task</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task</em>' container reference.
	 * @see #setTask(Task)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getTaskAttachment_Task()
	 * @see at.bestsolution.tasktracker.model.tasktracker.Task#getAttachmentList
	 * @model opposite="attachmentList" transient="false"
	 * @generated
	 */
	Task getTask();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.TaskAttachment#getTask <em>Task</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' container reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(Task value);

} // TaskAttachment
