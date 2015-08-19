/// <reference path="DTOTask.ts"/>
/// <reference path="DTOSourceRepository.ts"/>
/// <reference path="DTOPerson.ts"/>

class DTOChangeSet {
	metaClassname : String = "ChangeSet"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	id : string
	comment : string

	// reference attributes
	task : DTOTask
	sourceRepository : DTOSourceRepository
	person : DTOPerson
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.id = jsonObject.id;
			this.comment = jsonObject.comment;

			this.task = jsonObject.task ? new DTOTask(jsonObject.task) : null;
			this.sourceRepository = jsonObject.sourceRepository ? new DTOSourceRepository(jsonObject.sourceRepository) : null;
			this.person = jsonObject.person ? new DTOPerson(jsonObject.person) : null;
		}
	}
}
