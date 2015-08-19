/// <reference path="../../typings/jquery/jquery.d.ts"/>
/// <reference path="../util/bestUtils.ts"/>
/// <reference path="DTOComment.ts"/>
var CommentService = (function () {
    function CommentService(urlPrefix) {
        this.urlPrefix = urlPrefix;
    }
    CommentService.prototype.getAll = function (callback) {
        this.listRequest(this.urlPrefix + "/comment", callback);
    };
    CommentService.prototype.get = function (id, callback) {
        this.valueRequest(this.urlPrefix + "/comment/" + id, callback);
    };
    CommentService.prototype.create = function (entity, callback) {
        $.ajax({
            url: this.urlPrefix + "/comment",
            type: "PUT",
            data: JSON.stringify(entity),
            contentType: "application/json"
        }).done(function (data) {
            var entity;
            if (data) {
                entity = new DTOComment(data);
            }
            callback(entity, null);
        });
    };
    CommentService.prototype.update = function (entity, callback) {
        $.ajax({
            url: this.urlPrefix + "/comment/" + entity.sid,
            type: "PUT",
            data: JSON.stringify(entity),
            contentType: "application/json"
        }).done(function (data) {
            var entity;
            if (data) {
                entity = new DTOComment(data);
            }
            callback(entity, null);
        });
    };
    CommentService.prototype.listRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entityList = data.map(function (o) { return new DTOComment(o); });
            callback(entityList, null);
        });
    };
    CommentService.prototype.valueRequest = function (path, callback) {
        $.ajax({
            dataType: "json",
            type: "GET",
            url: path,
            data: {},
            cache: false
        }).done(function (data) {
            var entity;
            if (data) {
                entity = new DTOComment(data);
            }
            callback(entity, null);
        });
    };
    CommentService.prototype.commentsPerTask = function (tid, callback) {
        this.listRequest(this.urlPrefix + "/comment/comments-per-task?tid=" + tid + "", callback);
    };
    return CommentService;
})();
