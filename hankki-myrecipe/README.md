# 한끼 식자재 서비스
## DB 설정
### 인증 서비스 DB 생성
```
CREATE DATABASE hankkimyrecipe;
CREATE USER 'hankkimyrecipe'@'%' IDENTIFIED BY 'hankkimyrecipe';
GRANT ALL PRIVILEGES ON hankkimyrecipe.* TO 'hankkimyrecipe'@'%';
SHOW GRANTS FOR 'hankkimyrecipe'@'%';
```