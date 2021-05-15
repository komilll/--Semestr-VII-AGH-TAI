mvn package -Dmaven.test.skip=true

cd build/docker
sudo docker-compose -p tai-project up -d --build
