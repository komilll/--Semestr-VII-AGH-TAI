mvn package -DskipTests

cd build/docker
sudo docker-compose up -d --build
