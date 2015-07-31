/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="Task.ts"/>
var TaskService = (function () {
    function TaskService(urlPrefix) {
        this.urlPrefix = urlPrefix;
    }
    TaskService.prototype.getAll = function (callback) {
        this.listRequest(this.urlPrefix + "/task", callback);
    };
    TaskService.prototype.get = function (id, callback) {
        this.valueRequest(this.urlPrefix + "/task/" + id, callback);
    };
    TaskService.prototype.create = function (entity, callback) {
        $.ajax({
            url: this.urlPrefix + "/task",
            type: "PUT",
            data: JSON.stringify(entity),
            contentType: "application/json"
        }).done(function (data) {
            callback(data.value, null);
        });
    };
    TaskService.prototype.listRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entityList = data.map(function (o) { return new Task(o); });
            callback(entityList, null);
        });
    };
    TaskService.prototype.valueRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entity;
            if (data) {
                entity = new Task(data);
            }
            callback(entity, null);
        });
    };
    TaskService.prototype.selectOpenTasksForRepository = function (rId, callback) {
        this.listRequest(this.urlPrefix + "/task/open-tasks-in-repo?rId=" + rId + "", callback);
    };
    return TaskService;
})();
