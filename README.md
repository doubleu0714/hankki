# hankki
클라우드 level2 교육 2조

## DB 설정
### 로컬 DB 설정
```
docker run --name hankki-mariadb-local -e MYSQL_ROOT_PASSWORD=localhost -p 3307:3306 -d mariadb:latest
```

## 프로젝트 구성
|name|description|context path|port|
|---|---|---|---|
|hankki-auth|인증 서비스|/api/auth|8080|
|hankki-material|식자재 서비스|/api/materials|8081|
|hankki-myrecipe|나의 레시피 서비스|/api/myrecipes|8082|
|hankki-recipe|레시비 서비스|/api/recipes|8083|