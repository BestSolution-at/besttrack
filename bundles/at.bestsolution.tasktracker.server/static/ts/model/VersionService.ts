/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOVersion.ts"/>

class VersionService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOVersion[]> ) {
		this.listRequest(this.urlPrefix + "/version", callback);
	}

	get( id : number, callback : Consumer<DTOVersion> ) {
		this.valueRequest(this.urlPrefix + "/version/"+id, callback);
	}

	create( entity : DTOVersion, callback : Consumer<DTOVersion> ) {
		$.ajax({
    		url: this.urlPrefix + "/version",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOVersion;
			if( data ) {
				entity = new DTOVersion(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOVersion, callback : Consumer<DTOVersion> ) {
		$.ajax({
    		url: this.urlPrefix + "/version/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOVersion;
			if( data ) {
				entity = new DTOVersion(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOVersion[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOVersion[] = data.map( function( o ) { return new DTOVersion(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOVersion> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOVersion;
			if( data ) {
				entity = new DTOVersion(data);
			}
			callback(entity, null);
		});
	}

}