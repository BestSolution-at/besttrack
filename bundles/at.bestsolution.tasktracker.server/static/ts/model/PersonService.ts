/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOPerson.ts"/>

class PersonService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOPerson[]> ) {
		this.listRequest(this.urlPrefix + "/person", callback);
	}

	get( id : number, callback : Consumer<DTOPerson> ) {
		this.valueRequest(this.urlPrefix + "/person/"+id, callback);
	}

	create( entity : DTOPerson, callback : Consumer<DTOPerson> ) {
		$.ajax({
    		url: this.urlPrefix + "/person",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOPerson;
			if( data ) {
				entity = new DTOPerson(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOPerson, callback : Consumer<DTOPerson> ) {
		$.ajax({
    		url: this.urlPrefix + "/person/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOPerson;
			if( data ) {
				entity = new DTOPerson(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOPerson[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOPerson[] = data.map( function( o ) { return new DTOPerson(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOPerson> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOPerson;
			if( data ) {
				entity = new DTOPerson(data);
			}
			callback(entity, null);
		});
	}

}