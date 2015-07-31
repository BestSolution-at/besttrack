/// <reference path="Task.ts"/>
/// <reference path="SourceRepository.ts"/>
/// <reference path="Person.ts"/>

class ChangeSet {
	metaClassname : String = "ChangeSet"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	id : string
	comment : string

	// reference attributes
	task : Task
	sourceRepository : SourceRepository
	person : Person
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.id = jsonObject.id;
			this.comment = jsonObject.comment;

			this.task = jsonObject.task ? new Task(jsonObject.task) : null;
			this.sourceRepository = jsonObject.sourceRepository ? new SourceRepository(jsonObject.sourceRepository) : null;
			this.person = jsonObject.person ? new Person(jsonObject.person) : null;
		}
	}
}
