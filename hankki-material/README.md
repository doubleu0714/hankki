# 한끼 식자재 서비스
## DB 설정
### 인증 서비스 DB 생성
```
CREATE DATABASE hankkimaterials;
CREATE USER 'hankkimaterials'@'%' IDENTIFIED BY 'hankkimaterials';
GRANT ALL PRIVILEGES ON hankkimaterials.* TO 'hankkimaterials'@'%';
SHOW GRANTS FOR 'hankkimaterials'@'%';
```