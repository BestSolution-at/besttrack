/* ------------------------------------
 * Tables
 * ------------------------------------
 */
/*
 * Table for ChangeSet
 */
create table "change_set" (
	"cs_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "cs_comment" varchar(255)
	, "cs_vcs_id" varchar(255)
	, "cs_fk_person" bigint
	, "cs_fk_repository" bigint
	, "cs_fk_task" bigint
);

/*
 * Table for Comment
 */
create table "comment" (
	"co_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "co_description" varchar(255)
	, "co_fk_task" bigint
	, "co_title" varchar(255)
);

/*
 * Table for CommentAttachment
 */
create table "comment_attachment" (
	"ca_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "ca_binary" bytea
	, "ca_fk_comment" bigint
	, "ca_description" varchar(255)
	, "ca_mimetype" varchar(255)
	, "ca_title" varchar(255)
);

/*
 * Table for Person
 */
create table "person" (
	"p_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "p_firstname" varchar(255)
	, "p_surname" varchar(255)
);

/*
 * Table for RepositoryPerson
 */
create table "repository_person" (
	"rp_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "rp_fk_person" bigint
	, "rp_privilege_mask" bigint
	, "rp_fk_repository" bigint
);

/*
 * Table for SourceRepository
 */
create table "source_repository" (
	"sr_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "sr_fk_repository" bigint
	, "sr_source_url" varchar(255)
	, "sr_type" varchar(255)
	, "sr_weburl" varchar(255)
);

/*
 * Table for Task
 */
create table "task" (
	"t_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "t_fk_assignee" bigint
	, "t_description" varchar(255)
	, "t_external_bugid" varchar(255)
	, "t_fk_product_version" bigint
	, "t_fk_person" bigint
	, "t_fk_repository" bigint
	, "t_state" varchar(255)
	, "t_fk_target_version" bigint
	, "t_title" varchar(255)
);

/*
 * Table for TaskAttachment
 */
create table "task_attachment" (
	"ta_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "ta_binary" bytea
	, "ta_description" varchar(255)
	, "ta_mimetype" varchar(255)
	, "ta_fk_task" bigint
	, "ta_title" varchar(255)
);

/*
 * Table for TaskRepository
 */
create table "task_repository" (
	"tr_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "tr_description" varchar(255)
	, "tr_name" varchar(255)
	, "tr_fk_parent" bigint
	, "tr_external_id" boolean
	, "tr_public" boolean
);

/*
 * Table for Version
 */
create table "version" (
	"v_id" bigserial  not null PRIMARY KEY
	, "E_VERSION" integer not null
	, "v_name" varchar(255)
	, "v_date" timestamp
	, "v_fk_repository" bigint
	, "v_value" varchar(255)
);


/*
 * N:M Tables
 */

/* ------------------------------------
 * Constraints
 * ------------------------------------
 */

alter table "change_set"
	add constraint fk_ChangeSet_person
	foreign key ("cs_fk_person")
	references "person" ("p_id");

alter table "change_set"
	add constraint fk_ChangeSet_sourceRepository
	foreign key ("cs_fk_repository")
	references "source_repository" ("sr_id");

alter table "change_set"
	add constraint fk_ChangeSet_task
	foreign key ("cs_fk_task")
	references "task" ("t_id");

alter table "comment"
	add constraint fk_Comment_task
	foreign key ("co_fk_task")
	references "task" ("t_id");

alter table "comment_attachment"
	add constraint fk_CommentAttachment_comment
	foreign key ("ca_fk_comment")
	references "comment" ("co_id");

alter table "repository_person"
	add constraint fk_RepositoryPerson_person
	foreign key ("rp_fk_person")
	references "person" ("p_id");

alter table "repository_person"
	add constraint fk_RepositoryPerson_repository
	foreign key ("rp_fk_repository")
	references "task_repository" ("tr_id");

alter table "source_repository"
	add constraint fk_SourceRepository_repository
	foreign key ("sr_fk_repository")
	references "task_repository" ("tr_id");

alter table "task"
	add constraint fk_Task_assignee
	foreign key ("t_fk_assignee")
	references "person" ("p_id");

alter table "task"
	add constraint fk_Task_productVersion
	foreign key ("t_fk_product_version")
	references "version" ("v_id");

alter table "task"
	add constraint fk_Task_reporter
	foreign key ("t_fk_person")
	references "person" ("p_id");

alter table "task"
	add constraint fk_Task_repository
	foreign key ("t_fk_repository")
	references "task_repository" ("tr_id");

alter table "task"
	add constraint fk_Task_targetVersion
	foreign key ("t_fk_target_version")
	references "version" ("v_id");

alter table "task_attachment"
	add constraint fk_TaskAttachment_task
	foreign key ("ta_fk_task")
	references "task" ("t_id");

alter table "task_repository"
	add constraint fk_TaskRepository_parent
	foreign key ("tr_fk_parent")
	references "task_repository" ("tr_id");

alter table "version"
	add constraint fk_Version_repository
	foreign key ("v_fk_repository")
	references "task_repository" ("tr_id");

/* N:M relation constraints */

/* FK-Constraints for multi-valued primitive attributes */


/* ------------------------------------
 * Create indices
 * ------------------------------------
 */
