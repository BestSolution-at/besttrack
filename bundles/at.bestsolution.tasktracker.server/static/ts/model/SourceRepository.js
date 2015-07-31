/// <reference path="TaskRepository.ts"/>
var SourceRepository = (function () {
    function SourceRepository(jsonObject) {
        this.metaClassname = "SourceRepository";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.sourceUrl = jsonObject.sourceUrl;
            this.webUrl = jsonObject.webUrl;
            this.type = jsonObject.type;
            this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
        }
    }
    return SourceRepository;
})();
