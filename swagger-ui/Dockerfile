FROM swaggerapi/swagger-ui:latest
LABEL MAINTAINER = "Sleetfire"

ADD ./news_management_service/spec/news_management_service.yaml /usr/share/nginx/html/doc/news_management_service.yaml

ENV URLS="[{url: 'doc/account-scheduler-service.yaml', name: 'News'}]"
ENV URLS_PRIMARY_NAME="News"