CREATE USER "news-management-service_user" WITH PASSWORD '12378';
CREATE DATABASE "news_management_service" WITH OWNER = "news-management-service_user";
\c "news_management_service"