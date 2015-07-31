/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="Version.ts"/>

interface VersionValueCallback {
	( entity : Version, err: any ) : void
}

interface VersionListCallback {
	( entity : Version[], err: any ) : void
}

interface VersionCreationCallback {
	( id : number, err : any ) : void
}

class VersionService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : VersionListCallback ) {
		this.listRequest(this.urlPrefix + "/version", callback);
	}

	get( id : number, callback : VersionValueCallback ) {
		this.valueRequest(this.urlPrefix + "/version/"+id, callback);
	}

	create( entity : Version, callback : VersionCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/version",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : VersionListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : Version[] = data.map( function( o ) { return new Version(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : VersionValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : Version;
			if( data ) {
				entity = new Version(data);
			}
			callback(entity, null);
		});
	}

}