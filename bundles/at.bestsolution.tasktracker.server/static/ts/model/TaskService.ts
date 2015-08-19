/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOTask.ts"/>

class TaskService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : Consumer<DTOTask[]> ) {
		this.listRequest(this.urlPrefix + "/task", callback);
	}

	get( id : number, callback : Consumer<DTOTask> ) {
		this.valueRequest(this.urlPrefix + "/task/"+id, callback);
	}

	create( entity : DTOTask, callback : Consumer<DTOTask> ) {
		$.ajax({
    		url: this.urlPrefix + "/task",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTask;
			if( data ) {
				entity = new DTOTask(data);
			}
			callback(entity, null);
		} );
	}

	update( entity : DTOTask, callback : Consumer<DTOTask> ) {
		$.ajax({
    		url: this.urlPrefix + "/task/"+entity.sid,
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			var entity : DTOTask;
			if( data ) {
				entity = new DTOTask(data);
			}
			callback(entity, null);
		} );
	}

	private listRequest(path : string, callback : Consumer<DTOTask[]> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : DTOTask[] = data.map( function( o ) { return new DTOTask(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : Consumer<DTOTask> ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : DTOTask;
			if( data ) {
				entity = new DTOTask(data);
			}
			callback(entity, null);
		});
	}

	openTaskInRepository( rId : number, callback : Consumer<Task> ) {
		this.listRequest( this.urlPrefix + "/task/open-tasks-in-repo?rId="+rId+"", callback  );
	}
	getCompleteTask( sid : number, callback : Consumer<Task> ) {
		this.valueRequest( this.urlPrefix + "/task/complete-task?sid="+sid+"", callback  );
	}
}