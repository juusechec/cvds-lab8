# Execute

```
export MYSQL_URL="jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
export MYSQL_USERNAME=root
export MYSQL_PASSWORD=my-secret-pw

maven clean package spring-boot:repackage

java -jar target/jorge-lab8.jar --trace

```
