/// <reference path="Comment.ts"/>
var CommentAttachment = (function () {
    function CommentAttachment(jsonObject) {
        this.metaClassname = "CommentAttachment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.mimetype = jsonObject.mimetype;
            this.description = jsonObject.description;
            this.comment = jsonObject.comment ? new Comment(jsonObject.comment) : null;
        }
    }
    return CommentAttachment;
})();
