/// <reference path="../../typings/jquery/jquery.d.ts"/>

/// <reference path="Task.ts"/>

interface TaskValueCallback {
	( entity : Task, err: any ) : void
}

interface TaskListCallback {
	( entity : Task[], err: any ) : void
}

interface TaskCreationCallback {
	( id : number, err : any ) : void
}

class TaskService {
	urlPrefix : string

	constructor(urlPrefix : string) {
		this.urlPrefix = urlPrefix
	}

	getAll( callback : TaskListCallback ) {
		this.listRequest(this.urlPrefix + "/task", callback);
	}

	get( id : number, callback : TaskValueCallback ) {
		this.valueRequest(this.urlPrefix + "/task/"+id, callback);
	}

	create( entity : Task, callback : TaskCreationCallback ) {
		$.ajax({
    		url: this.urlPrefix + "/task",
    		type: "PUT",
    		data: JSON.stringify(entity),
    		contentType: "application/json"
		}).done( function(data : any) {
			callback(data.value, null);
		} );
	}

	private listRequest(path : string, callback : TaskListCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any[]) {
			var entityList : Task[] = data.map( function( o ) { return new Task(o); } );
			callback(entityList, null);
		});
	}

	private valueRequest(path : string, callback : TaskValueCallback ) {
		$.ajax({
			dataType: "json",
			type: "GET",
			url: path,
			data: {},
			cache : false
		}).done(function(data : any) {
			var entity : Task;
			if( data ) {
				entity = new Task(data);
			}
			callback(entity, null);
		});
	}

	selectOpenTasksForRepository( rId : number, callback : TaskListCallback ) {
		this.listRequest( this.urlPrefix + "/task/open-tasks-in-repo?rId="+rId+"", callback  );
	}
}