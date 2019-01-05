###key should be random chars and separate for each env
`ENCRYPT_KEY=mysymmetrickey`

get token: localhost:8020/oauth/token

header:  
[{"key":"Authorization","value":"Basic d3JpdGVyLXNlcnZpY2U6bXlzZWNyZXQ=","description":""}]  
body:  
[{"key":"grant_type","value":"password","description":""},{"key":"scope","value":"any","description":""},{"key":"username","value":"zalerix","description":""},{"key":"password","value":"zlrx","description":""}]


running kafka instance is required to cloud stream  
zookeeper-server-start.bat zookeeper.properties
kafka-server-start.bat d:\DevTools\kafka_2.12-2.1.0\config\server.properties

redis required