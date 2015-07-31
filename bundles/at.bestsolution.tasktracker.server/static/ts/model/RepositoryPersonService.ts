/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="RepositoryPerson.ts"/>

interface RepositoryPersonValueCallback {
	( entity : RepositoryPerson, err: any ) : void
}

interface RepositoryPersonListCallback {
	( entity : RepositoryPerson[], err: any ) : void
}

interface RepositoryPersonCreationCallback {
	( id : number, err : any ) : void
}

class RepositoryPersonService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : RepositoryPersonListCallback ) {
		this.listRequest(this.urlPrefix + "/repositoryperson", callback);
	}

	get( id : number, callback : RepositoryPersonValueCallback ) {
		this.valueRequest(this.urlPrefix + "/repositoryperson/"+id, callback);
	}

	create( entity : RepositoryPerson, callback : RepositoryPersonCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/repositoryperson",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : RepositoryPersonListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : RepositoryPerson[] = data.map( function( o ) { return new RepositoryPerson(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : RepositoryPersonValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : RepositoryPerson;
			if( data ) {
				entity = new RepositoryPerson(data);
			}
			callback(entity, null);
		});
	}

}