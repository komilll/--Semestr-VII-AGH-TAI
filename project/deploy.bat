call mvn package -Dmaven.test.skip=true

cd build\docker
docker-compose up -d --build