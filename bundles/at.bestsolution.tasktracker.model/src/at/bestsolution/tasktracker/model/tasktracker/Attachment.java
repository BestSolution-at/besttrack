/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import java.sql.Blob;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attachment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getTitle <em>Title</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getMimetype <em>Mimetype</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getBinary <em>Binary</em>}</li>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getAttachment()
 * @model abstract="true"
 * @generated
 */
public interface Attachment extends BaseObject {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getAttachment_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Mimetype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mimetype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mimetype</em>' attribute.
	 * @see #setMimetype(String)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getAttachment_Mimetype()
	 * @model
	 * @generated
	 */
	String getMimetype();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getMimetype <em>Mimetype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mimetype</em>' attribute.
	 * @see #getMimetype()
	 * @generated
	 */
	void setMimetype(String value);

	/**
	 * Returns the value of the '<em><b>Binary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binary</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binary</em>' attribute.
	 * @see #setBinary(Blob)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getAttachment_Binary()
	 * @model dataType="at.bestsolution.tasktracker.model.tasktracker.Blob"
	 * @generated
	 */
	Blob getBinary();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getBinary <em>Binary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binary</em>' attribute.
	 * @see #getBinary()
	 * @generated
	 */
	void setBinary(Blob value);

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
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getAttachment_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.Attachment#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Attachment
