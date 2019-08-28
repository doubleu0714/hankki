# 한끼 인증 서비스
## DB 설정
### 인증 서비스 DB 생성
```
CREATE DATABASE hankkiauth;
CREATE USER 'hankkiauth'@'%' IDENTIFIED BY 'hankkiauth';
GRANT ALL PRIVILEGES ON hankkiauth.* TO 'hankkiauth'@'%';
SHOW GRANTS FOR 'hankkiauth'@'%';
```