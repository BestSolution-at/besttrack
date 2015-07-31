/// <reference path="../typings/jquery/jquery.d.ts"/>

/// <reference path="common.ts"/>
/// <reference path="model/TaskRepository.ts"/>
/// <reference path="model/TaskRepositoryService.ts"/>
/// <reference path="model/Task.ts"/>
/// <reference path="model/TaskService.ts"/>

function initIndexPage() {
	var s = new TaskRepositoryService(rootPath);
	s.getAll( repositoryDataCallback );
}

function repositoryDataCallback(data : TaskRepository[], err) {
	var repoMap : { [ id : string ] : TaskRepository } = {};
	var htmlNavigationList: string[] = [];
	var htmlOptionList: string[] = [];
	
	data.forEach( function(value) {
		// Clear the children we'll create a real tree below
		value.children = [];
		repoMap[value.sid+""] = value;
		
		if( ! value.parent ) {
			htmlNavigationList.push('<a class="mdl-navigation__link" href="repository.html?id='
					+ value.sid 
					+ '"><i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">inbox</i>' 
					+ value.name + '</a>');
		}
	} );
	
	data.forEach( function(value) {
		if( value.parent ) {
			repoMap[value.parent.sid+""].children.push( repoMap[value.sid + ""] );
		}
	} );
	
	data.forEach( function(value) {
		if( ! value.parent ) {
			buildOptionList(0,value,htmlOptionList);
		}
	});
	
	// update the index.html page
	$( '#task-repositories' ).each(function() {
		$(this).html( htmlNavigationList.join("\n"));
	});
	
	$( '#bug-form-task-repository' ).each(function() {
		$(this).html( htmlOptionList.join("\n"));
	});
}

function buildOptionList(level:number, repository: TaskRepository, htmlOptionList: string[]) {
	var spacer : string = "";
	for (var index = 0; index < level; index++) {
		spacer += "&nbsp;&nbsp;&nbsp;"
	}
	
	htmlOptionList.push('<option value="'+repository.sid+'">'+spacer+repository.name+'</option>');
	if( repository.children != null ) {
		$.each(repository.children,function(index,value) {
			buildOptionList(level + 1, value, htmlOptionList);
		});		
	}
}

function createTask() {
	var repoId = $("#bug-form-task-repository").val();
	var title = $("#bug-form-title").val();
	var description = $("#bug-form-description").val();
	
	console.log("Repo: " + repoId, "Title: " + title, "Description: " + description );
	
	var task = new Task();
	var repo = new TaskRepository();
	repo.metaProxy = true;
	repo.sid = repoId;
	
	task.repository = repo;
	task.title = title;
	task.description = description;
	
	console.log("Sending ", task); 
	
	var taskService = new TaskService(rootPath);
	taskService.create(task, function(id : number, err : any) {
		// Inform used about the new task	
	});
}