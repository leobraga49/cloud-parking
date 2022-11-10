# Cloud Parking

## Run database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTRES_USER=admin 
-e POSTGRES_PASSWORD=Lbb060399 -d postgres:10-alpine

## Stop databae
docker stop parking-db

## Start databse
docker start -parking-db

## Swagger login and password
user:12345