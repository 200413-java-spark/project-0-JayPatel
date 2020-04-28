<<<<<<< HEAD


FROM postgres:10
ENV POSTGRES_USER user
ENV POSTGRES_PASSWORD password 
=======
FROM postgres
ENV POSTGRES_USER user
ENV POSTGRES_PASSWORD password
>>>>>>> 6e0fbf0e0b122af3413add19a66e8ccbf2d79e50
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432