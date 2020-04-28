FROM postgres
ENV POSTGRES_USER hangmandb
ENV POSTGRES_PASSWORD hangmandb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432