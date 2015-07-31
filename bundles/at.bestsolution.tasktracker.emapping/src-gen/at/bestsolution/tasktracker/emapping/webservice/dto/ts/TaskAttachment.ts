/// <reference path="Task.ts"/>

class TaskAttachment {
	metaClassname : String = "TaskAttachment"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	title : string
	mimetype : string
	description : string

	// reference attributes
	task : Task
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.title = jsonObject.title;
			this.mimetype = jsonObject.mimetype;
			this.description = jsonObject.description;

			this.task = jsonObject.task ? new Task(jsonObject.task) : null;
		}
	}
}
