/// <reference path="Person.ts"/>
/// <reference path="TaskRepository.ts"/>

class RepositoryPerson {
	metaClassname : String = "RepositoryPerson"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	privilegeMask : number

	// reference attributes
	person : Person
	repository : TaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.privilegeMask = jsonObject.privilegeMask;

			this.person = jsonObject.person ? new Person(jsonObject.person) : null;
			this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
		}
	}
}
