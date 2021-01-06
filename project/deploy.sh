mvn package -Dmaven.test.skip=true

cd build/docker
sudo docker-compose up -d --build
