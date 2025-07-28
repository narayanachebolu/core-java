# Run PostgreSQL in Docker
## Single docker run command
docker run --name my-postgres \
  -e POSTGRES_USER=myuser \
  -e POSTGRES_PASSWORD=mypassword \
  -e POSTGRES_DB=mydb \
  -p 5432:5432 \
  -d postgres:15

## Docker Compose YML file.
Refer: docker-compose.yml file on how to "run PostgreSQL in Docker".
* To run compose file: docker compose up -d
* Test connection directly: docker exec -it my-postgres psql -U myuser -d mydb
* Test from host (if psql is installed): psql -h localhost -U myuser -d mydb


### NOTE: 
* PostgreSQL’s official Docker image supports a special trick: Anything in /docker-entrypoint-initdb.d/ gets run the first time the container initializes the database.

### Troubleshooting
1) If there is an error (below) while executing **docker compose up -d** or **docker ps** in WSL2.
- Here is the quick fix, use: **sudo**.
- Recommended permanent fix (to avoid typing sudo every time). Add your user to the docker group: "sudo usermod -aG docker $USER".
#### permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get "http://%2Fvar%2Frun%2Fdocker.sock/v1.47/containers/json": dial unix /var/run/docker.sock: connect: permission denied.
#### permission denied while trying to connect to the Docker daemon socket at unix:///var/run/docker.sock: Get "http://%2Fvar%2Frun%2Fdocker.sock/v1.47/containers/json?all=1&filters=%7B%22label%22%3A%7B%22com.docker.compose.config-hash%22%3Atrue%2C%22com.docker.compose.project%3Dcore%22%3Atrue%7D%7D": dial unix /var/run/docker.sock: connect: permission denied.
   
