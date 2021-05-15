call mvn package -Dmaven.test.skip=true

cd build\docker
docker-compose -p tai-project up -d --build