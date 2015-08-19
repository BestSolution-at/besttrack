/// <reference path="DTORepositoryPerson.ts"/>

class DTOPerson {
	metaClassname : String = "Person"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	firstname : string
	lastname : string

	// reference attributes
	repositoryList : DTORepositoryPerson[]
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.firstname = jsonObject.firstname;
			this.lastname = jsonObject.lastname;

			if( jsonObject.repositoryList ) {
				this.repositoryList = jsonObject.repositoryList.map( function( o ) { return new DTORepositoryPerson(o); } );
			}
		}
	}
}
