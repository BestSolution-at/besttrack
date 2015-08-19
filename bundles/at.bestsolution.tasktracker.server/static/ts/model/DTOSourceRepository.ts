/// <reference path="DTOTaskRepository.ts"/>

class DTOSourceRepository {
	metaClassname : String = "SourceRepository"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	sourceUrl : string
	webUrl : string
	type : any

	// reference attributes
	repository : DTOTaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.sourceUrl = jsonObject.sourceUrl;
			this.webUrl = jsonObject.webUrl;
			this.type = jsonObject.type;

			this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
		}
	}
}
