/// <reference path="TaskRepository.ts"/>
var Version = (function () {
    function Version(jsonObject) {
        this.metaClassname = "Version";
        this.metaProxy = false;
        if (jsonObject) {
            this.metaProxy = jsonObject.metaProxy;
            this.sid = jsonObject.sid;
            this.value = jsonObject.value;
            this.date = jsonObject.date;
            this.codename = jsonObject.codename;
            this.repository = jsonObject.repository ? new TaskRepository(jsonObject.repository) : null;
        }
    }
    return Version;
})();
