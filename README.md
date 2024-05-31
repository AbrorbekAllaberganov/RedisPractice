# The most necessary commands of redis

1. START REDIS SERVER </br>
`sudo service redis-server start`

2. STOP REDIS SERVER </br>
`sudo service redis-server stop`

3. CHECKING THE STATUS OF REDIS SERVER </br>
`sudo service redis-server status`

4. SET KEY </br>
`SET key value`

5. GET KEY  </br>
`GET key`

6. DELETE THE KEY </br>
`DEL key`

7. CHECK IF THE KEY IS EXISTS</br>
`EXISTS key`

8. GET TYPE OF THE KEY</br>
`TYPE key`

9. IF THE KEY IS A STRING</br>
`GET KEY_NAME`

10. IF THE KEY IS A HASH </br>
`HGETALL KEY_NAME`

11. IF THE KEY IS A LIST </br>
`LRANGE KEY_NAME 0 -1`

12. IF THE KEY IS A SET</br>
`SMEMBERS KEY_NAME`

13. IF THE KEY IS A SORTED SET</br>
`ZRANGE KEY_NAME 0 -1 WITHSCORES`

14. OPEN REDIS.CONFIG FILE</br>
`sudo nano /etc/redis/redis.conf`
