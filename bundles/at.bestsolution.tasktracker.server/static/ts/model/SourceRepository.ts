/// <reference path="TaskRepository.ts"/>

class SourceRepository {
	metaClassname : String = "SourceRepository"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	sourceUrl : string
	webUrl : string
	type : any

	// reference attributes
	repository : TaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.sourceUrl = jsonObject.sourceUrl;
			this.webUrl = jsonObject.webUrl;
			this.type = jsonObject.type;

			this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
		}
	}
}
