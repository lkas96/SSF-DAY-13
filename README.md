# SSF-DAY-13 Lecture

Springboot initializer
1. Spring Web
2. Spring Boot DevTools
3. Thymeleaf
4. Validation

# Create Folders
1. config
2. controller
3. model
4. repo
5. services
6. util

# Docker Commands
1. To show what version of docker is installed on the machine
    docker --version

2. To Clear the docker compilations/build cache
    docker system prune

3. Building the docker image
    docker build -t darryl1975/vttp5-ssf-day13-lecture:v0.0.1 .

4. Check the list of docker images that are created on the local machine
    docker image ls

5. Run the image inside the container
    docker run -d -t -p <exposed-public-port>:<application-server-port> <docker-image-name>
    docker run -d -t -p 8080:3000 vttp5-ssf-day13-lecture:V0.0.1

6. Check for running docker containers
    docker container ls

7. Stop a running container on command line
    docker stop <container_id>
    container_id : LIST THE DOCKER CONTAINERS (docker containers ls)
    just enter the last 4 digits of the container id

8. Start a docker container
    dockter start <container_id>

9. To remove a stopped container
    docker rm <container_id>

10. To delete docker image
    docker rmi <image_id>

# Docker Compile and Push to Railway
1. In railway.app, create a serivice (linked to the project)
2. Create the environment variable, SERVER_PORT=3000
3. In project root folder (CMD), execute railway login
4. Link the project, execute cmd command "railway link"
5. Deploy the project to railway, execute "railway up"