/// <reference path="DTOTaskRepository.ts"/>

class DTOVersion {
	metaClassname : String = "Version"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	value : string
	date : any
	codename : string

	// reference attributes
	repository : DTOTaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.value = jsonObject.value;
			this.date = jsonObject.date;
			this.codename = jsonObject.codename;

			this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
		}
	}
}
