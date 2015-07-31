

alter table "change_set"
	drop constraint fk_ChangeSet_person;

alter table "change_set"
	drop constraint fk_ChangeSet_sourceRepository;

alter table "change_set"
	drop constraint fk_ChangeSet_task;

alter table "comment"
	drop constraint fk_Comment_task;

alter table "comment_attachment"
	drop constraint fk_CommentAttachment_comment;

alter table "repository_person"
	drop constraint fk_RepositoryPerson_person;

alter table "repository_person"
	drop constraint fk_RepositoryPerson_repository;

alter table "source_repository"
	drop constraint fk_SourceRepository_repository;

alter table "task"
	drop constraint fk_Task_assignee;

alter table "task"
	drop constraint fk_Task_productVersion;

alter table "task"
	drop constraint fk_Task_reporter;

alter table "task"
	drop constraint fk_Task_repository;

alter table "task"
	drop constraint fk_Task_targetVersion;

alter table "task_attachment"
	drop constraint fk_TaskAttachment_task;

alter table "task_repository"
	drop constraint fk_TaskRepository_parent;

alter table "version"
	drop constraint fk_Version_repository;






DROP TABLE "change_set";

DROP TABLE "comment";

DROP TABLE "comment_attachment";

DROP TABLE "person";

DROP TABLE "repository_person";

DROP TABLE "source_repository";

DROP TABLE "task";

DROP TABLE "task_attachment";

DROP TABLE "task_repository";

DROP TABLE "version";


