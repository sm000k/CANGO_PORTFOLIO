## Database setup

### Run DB
To set database you can use simple docker command:

```
docker run -p 5432:5432 -e POSTGRES_USER=user_demo -e POSTGRES_PASSWORD=password -d postgres
```
This should allow setup docker with postgres. It creates user mentioned in application.properties with it's password.

### Kill DB
In order to close and clean DB. If we want to do this these are commands:

```
PS cango> docker ps
CONTAINER ID   IMAGE      COMMAND                  CREATED         STATUS         PORTS                    NAMES
758203103e93   postgres   "docker-entrypoint.s…"   8 minutes ago   Up 8 minutes   0.0.0.0:5432->5432/tcp   pensive_tesla
PS cango> docker kill 758
758
PS cango> docker rm 758
758
```

> **WARNING: Please be informed that this is not persistent. Each run of docker run will create new DB from
> scratch as there is no persistent volume.**
