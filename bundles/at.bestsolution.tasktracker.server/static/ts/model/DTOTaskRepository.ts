/// <reference path="DTORepositoryPerson.ts"/>
/// <reference path="DTOSourceRepository.ts"/>
/// <reference path="DTOVersion.ts"/>

class DTOTaskRepository {
	metaClassname : String = "TaskRepository"
	metaProxy : boolean = false

	// simple attributes
	sid : number
	name : string
	description : string
	externalId : boolean
	publicRepo : boolean

	// reference attributes
	personList : DTORepositoryPerson[]
	sourceRepositoryList : DTOSourceRepository[]
	versionList : DTOVersion[]
	children : DTOTaskRepository[]
	parent : DTOTaskRepository
	constructor(jsonObject? : any) {
		if(jsonObject) {
			this.metaProxy = jsonObject.metaProxy

			this.sid = jsonObject.sid;
			this.name = jsonObject.name;
			this.description = jsonObject.description;
			this.externalId = jsonObject.externalId;
			this.publicRepo = jsonObject.publicRepo;

			if( jsonObject.personList ) {
				this.personList = jsonObject.personList.map( function( o ) { return new DTORepositoryPerson(o); } );
			}
			if( jsonObject.sourceRepositoryList ) {
				this.sourceRepositoryList = jsonObject.sourceRepositoryList.map( function( o ) { return new DTOSourceRepository(o); } );
			}
			if( jsonObject.versionList ) {
				this.versionList = jsonObject.versionList.map( function( o ) { return new DTOVersion(o); } );
			}
			if( jsonObject.children ) {
				this.children = jsonObject.children.map( function( o ) { return new DTOTaskRepository(o); } );
			}
			this.parent = jsonObject.parent ? new DTOTaskRepository(jsonObject.parent) : null;
		}
	}
}
