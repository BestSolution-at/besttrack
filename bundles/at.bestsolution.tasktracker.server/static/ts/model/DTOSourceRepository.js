/// <reference path="DTOTaskRepository.ts"/>
var DTOSourceRepository = (function () {
    function DTOSourceRepository(jsonObject) {
        this.metaClassname = "SourceRepository";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.sourceUrl = jsonObject.sourceUrl;
            this.webUrl = jsonObject.webUrl;
            this.type = jsonObject.type;
            this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
        }
    }
    return DTOSourceRepository;
})();
