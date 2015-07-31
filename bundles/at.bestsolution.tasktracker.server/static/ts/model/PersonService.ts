/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="Person.ts"/>

interface PersonValueCallback {
	( entity : Person, err: any ) : void
}

interface PersonListCallback {
	( entity : Person[], err: any ) : void
}

interface PersonCreationCallback {
	( id : number, err : any ) : void
}

class PersonService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : PersonListCallback ) {
		this.listRequest(this.urlPrefix + "/person", callback);
	}

	get( id : number, callback : PersonValueCallback ) {
		this.valueRequest(this.urlPrefix + "/person/"+id, callback);
	}

	create( entity : Person, callback : PersonCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/person",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : PersonListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : Person[] = data.map( function( o ) { return new Person(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : PersonValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : Person;
			if( data ) {
				entity = new Person(data);
			}
			callback(entity, null);
		});
	}

}