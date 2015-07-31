/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="TaskRepository.ts"/>
var TaskRepositoryService = (function () {
    function TaskRepositoryService(urlPrefix) {
        this.urlPrefix = urlPrefix;
    }
    TaskRepositoryService.prototype.getAll = function (callback) {
        this.listRequest(this.urlPrefix + "/taskrepository", callback);
    };
    TaskRepositoryService.prototype.get = function (id, callback) {
        this.valueRequest(this.urlPrefix + "/taskrepository/" + id, callback);
    };
    TaskRepositoryService.prototype.create = function (entity, callback) {
        $.ajax({
            url: this.urlPrefix + "/taskrepository",
            type: "PUT",
            data: JSON.stringify(entity),
            contentType: "application/json"
        }).done(function (data) {
            callback(data.value, null);
        });
    };
    TaskRepositoryService.prototype.listRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entityList = data.map(function (o) { return new TaskRepository(o); });
            callback(entityList, null);
        });
    };
    TaskRepositoryService.prototype.valueRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entity;
            if (data) {
                entity = new TaskRepository(data);
            }
            callback(entity, null);
        });
    };
    return TaskRepositoryService;
})();
