call mvn package -DskipTests

cd build\docker
docker-compose up -d --build