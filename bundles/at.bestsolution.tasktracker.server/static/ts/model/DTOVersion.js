/// <reference path="DTOTaskRepository.ts"/>
var DTOVersion = (function () {
    function DTOVersion(jsonObject) {
        this.metaClassname = "Version";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.value = jsonObject.value;
            this.date = jsonObject.date;
            this.codename = jsonObject.codename;
            this.repository = jsonObject.repository ? new DTOTaskRepository(jsonObject.repository) : null;
        }
    }
    return DTOVersion;
})();
