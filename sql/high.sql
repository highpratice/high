DROP DATABASE IF EXISTS high;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/5/19 16:53:55                           */
/*==============================================================*/
CREATE DATABASE high;
USE high;

drop table if exists t_activity;

drop table if exists t_category;

drop table if exists t_location;

drop table if exists t_participate;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_activity                                            */
/*==============================================================*/
create table t_activity
(
   activity_id          varchar(36) not null,
   categoty_id          varchar(36),
   content              varchar(255),
   comment              varchar(255),
   start_time           timestamp,
   end_time             timestamp,
   activity_location_id varchar(36),
   min_num              int,
   max_num              int,
   creator_id           varchar(36),
   is_public            char(1),
   creator_location_id  varchar(36),
   distance             float(10,2),
   primary key (activity_id)
);

alter table t_activity comment '活动内容表';

/*==============================================================*/
/* Table: t_category                                            */
/*==============================================================*/
create table t_category
(
   top_category         varchar(36),
   secondary_category   varchar(36),
   id                   varchar(36) not null,
   primary key (id)
);

alter table t_category comment '活动类别表';

/*==============================================================*/
/* Table: t_location                                            */
/*==============================================================*/
create table t_location
(
   location_id          varchar(36) not null,
   longitude            double(10,6),
   latitude             double(10,6),
   location_description varchar(255),
   primary key (location_id)
);

alter table t_location comment '位置信息表';

/*==============================================================*/
/* Table: t_participate                                         */
/*==============================================================*/
create table t_participate
(
   par_id               varchar(36) not null,
   activity_id          varchar(36),
   user_id              varchar(36),
   primary key (par_id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   user_id              varchar(36) not null,
   user_name            varchar(36),
   wechat_number        varchar(36),
   phone_number         varchar(11),
   user_photo           varchar(255),
   sex                  varchar(10),
   location_id          varchar(36),
   primary key (user_id)
);

alter table t_user comment '用户信息表表';

alter table t_activity add constraint FK_Reference_2 foreign key (activity_location_id)
      references t_location (location_id) on delete restrict on update restrict;

alter table t_activity add constraint FK_Reference_3 foreign key (categoty_id)
      references t_category (id) on delete restrict on update restrict;

alter table t_activity add constraint FK_Reference_4 foreign key (creator_id)
      references t_user (user_id) on delete restrict on update restrict;

alter table t_activity add constraint FK_Reference_8 foreign key (creator_location_id)
      references t_location (location_id) on delete restrict on update restrict;

alter table t_participate add constraint FK_Reference_6 foreign key (user_id)
      references t_user (user_id) on delete restrict on update restrict;

alter table t_participate add constraint FK_Reference_7 foreign key (activity_id)
      references t_activity (activity_id) on delete restrict on update restrict;

alter table t_user add constraint FK_Reference_1 foreign key (location_id)
      references t_location (location_id) on delete restrict on update restrict;

/*=====新建账号，并赋权限。统一一下用户名跟密码，方便使用=====INSERT INTO mysql.user(HOST,USER,PASSWORD) VALUES('localhost','high',PASSWORD('high'));*/
create user 'high'@'localhost' identified by 'high'
FLUSH PRIVILEGES;
GRANT ALL PRIVILEGES ON high.* TO high@localhost IDENTIFIED BY 'high';