/// <reference path="DTOPerson.ts"/>
/// <reference path="DTOTaskRepository.ts"/>

class DTORepositoryPerson {
	metaClassname : String = "RepositoryPerson"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	privilegeMask : number

	// reference attributes
	person : DTOPerson
	repository : DTOTaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.privilegeMask = jsonObject.privilegeMask;

			this.person = jsonObject.person ? new DTOPerson(jsonObject.person) : null;
			this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
		}
	}
}
