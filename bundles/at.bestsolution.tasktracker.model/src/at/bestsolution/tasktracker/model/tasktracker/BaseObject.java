/**
 */
package at.bestsolution.tasktracker.model.tasktracker;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Base Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link at.bestsolution.tasktracker.model.tasktracker.BaseObject#getSid <em>Sid</em>}</li>
 * </ul>
 *
 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getBaseObject()
 * @model abstract="true"
 * @generated
 */
public interface BaseObject extends EObject {
	/**
	 * Returns the value of the '<em><b>Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sid</em>' attribute.
	 * @see #setSid(long)
	 * @see at.bestsolution.tasktracker.model.tasktracker.TasktrackerPackage#getBaseObject_Sid()
	 * @model
	 * @generated
	 */
	long getSid();

	/**
	 * Sets the value of the '{@link at.bestsolution.tasktracker.model.tasktracker.BaseObject#getSid <em>Sid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sid</em>' attribute.
	 * @see #getSid()
	 * @generated
	 */
	void setSid(long value);

} // BaseObject
