--liquibase formatted sql

--changeset Sleetfire:create-tables

CREATE SCHEMA IF NOT EXISTS news_management_service;

CREATE TABLE IF NOT EXISTS news_management_service.news (
    id bigserial PRIMARY KEY,
    time timestamp without time zone NOT NULL,
    title character varying(150) NOT NULL UNIQUE,
    text character varying NOT NULL
);

CREATE TABLE IF NOT EXISTS news_management_service.comments (
    id bigserial PRIMARY KEY,
    time timestamp without time zone NOT NULL,
    text character varying NOT NULL,
    username character varying(20) NOT NULL,
    news_id bigint NOT NULL,
    CONSTRAINT comments_fk FOREIGN KEY (news_id) REFERENCES news_management_service.news(id)
);