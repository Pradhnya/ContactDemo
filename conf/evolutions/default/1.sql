# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table contact (
  name                      varchar(255),
  email                     varchar(255),
  number                    bigint,
  message                   varchar(255),
  sex                       varchar(255),
  salary                    integer,
  age                       integer)
;

create table task (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  constraint pk_task primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table contact;

drop table task;

SET FOREIGN_KEY_CHECKS=1;

