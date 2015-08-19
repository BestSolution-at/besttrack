/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTORepositoryPerson.ts"/>

class RepositoryPersonService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTORepositoryPerson[]> ) {
		this.listRequest(this.urlPrefix + "/repositoryperson", callback);
	}

	get( id : number, callback : Consumer<DTORepositoryPerson> ) {
		this.valueRequest(this.urlPrefix + "/repositoryperson/"+id, callback);
	}

	create( entity : DTORepositoryPerson, callback : Consumer<DTORepositoryPerson> ) {
		$.ajax({
    		url: this.urlPrefix + "/repositoryperson",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTORepositoryPerson;
			if( data ) {
				entity = new DTORepositoryPerson(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTORepositoryPerson, callback : Consumer<DTORepositoryPerson> ) {
		$.ajax({
    		url: this.urlPrefix + "/repositoryperson/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTORepositoryPerson;
			if( data ) {
				entity = new DTORepositoryPerson(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTORepositoryPerson[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTORepositoryPerson[] = data.map( function( o ) { return new DTORepositoryPerson(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTORepositoryPerson> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTORepositoryPerson;
			if( data ) {
				entity = new DTORepositoryPerson(data);
			}
			callback(entity, null);
		});
	}

}