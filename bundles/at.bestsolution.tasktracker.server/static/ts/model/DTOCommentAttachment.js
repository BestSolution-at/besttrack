/// <reference path="DTOComment.ts"/>
var DTOCommentAttachment = (function () {
    function DTOCommentAttachment(jsonObject) {
        this.metaClassname = "CommentAttachment";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.title = jsonObject.title;
            this.mimetype = jsonObject.mimetype;
            this.description = jsonObject.description;
            this.comment = jsonObject.comment ? new DTOComment(jsonObject.comment) : null;
        }
    }
    return DTOCommentAttachment;
})();
