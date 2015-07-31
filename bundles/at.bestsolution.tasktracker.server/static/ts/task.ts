/// <reference path="../typings/jquery/jquery.d.ts"/>
/// <reference path="../typings/mdl/mdl.d.ts"/>
/// <reference path="common.ts"/>

/// <reference path="model/Task.ts"/>
/// <reference path="model/TaskService.ts"/>

function initTaskPage() {
	var taskId = parseLocationSearch()["id"];
	
	var taskService = new TaskService(rootPath);
	taskService.get(taskId, handleTaskData);
}

function handleTaskData(data : Task) {
	console.log("Task", data);
	$("#task-title").each( function() {
		$(this).html(data.sid + " - " + data.title );
	} );

	$("#form-task-title").each( function() {
		var evt = document.createEvent("HTMLEvents");
	    evt.initEvent("input", false, true);
		$(this).val(data.title).get(0).dispatchEvent(evt);
	} );

	$("#form-task-description").each( function() {
		var evt = document.createEvent("HTMLEvents");
	    evt.initEvent("input", false, true);
		$(this).val(data.description).get(0).dispatchEvent(evt);
	} );
}