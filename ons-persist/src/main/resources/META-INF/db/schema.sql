drop table T_PERSON if exists;
drop table T_FATHER if exists;
drop table T_MOTHER if exists;
drop table T_COUNTRY if exists;
drop table T_LOCATION if exists;
drop table T_SURNAME if exists;
drop table T_MARRIAGE if exists;
drop table T_DEATH if exists;
drop table T_CENSUS if exists;
drop table T_CENSUS_HOUSEHOLD if exists;
drop table T_CENSUS_HOUSEHOLD_ENTRY if exists;


create table T_SURNAME (ID integer identity primary key, SURNAME varchar(50) not null);
create table T_PERSON (ID integer identity primary key, SURNAME_ID integer, FIRST_NAME varchar(50) not null, DATE_OF_BIRTH date, FATHER_ID integer, MOTHER_ID integer, GENDER integer);
create table T_FATHER (ID integer identity primary key, PERSON_ID integer default 0);
create table T_MOTHER (ID integer identity primary key, PERSON_ID integer default 0);
create table T_COUNTRY (ID integer identity primary key, CODE varchar(50) not null, NAME varchar(25) null);
create table T_LOCATION (ID integer identity primary key, CITY varchar(50) not null, POST_CODE varchar(25) null, ADDRESS_LINE_1 varchar(50) not null, ADDRESS_LINE_2 varchar(50) not null, COUNTRY_ID integer);
create table T_MARRIAGE (ID integer identity primary key, PERSON_ID integer default 0, PARTNER_ID integer default 0);
create table T_DEATH (ID integer identity primary key, PERSON_ID integer default 0, LOCATION_ID integer, DATE_OF_DEATH date);
create table T_CENSUS (ID integer identity primary key, YEAR integer default 0, COUNTRY_ID integer);
create table T_CENSUS_HOUSEHOLD (ID integer identity primary key, CENSUS_ID integer default 0, LOCATION_ID integer);
create table T_CENSUS_HOUSEHOLD_ENTRY (ID integer identity primary key, CENSUS_HOUSEHOLD_ID integer default 0, PERSON_ID integer);