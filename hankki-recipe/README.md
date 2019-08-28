# 한끼 식자재 서비스
## DB 설정
### 인증 서비스 DB 생성
```
CREATE DATABASE hankkirecipe;
CREATE USER 'hankkirecipe'@'%' IDENTIFIED BY 'hankkirecipe';
GRANT ALL PRIVILEGES ON hankkirecipe.* TO 'hankkirecipe'@'%';
SHOW GRANTS FOR 'hankkirecipe'@'%';
```