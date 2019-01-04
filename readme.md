###key should be random chars and separate for each env
`ENCRYPT_KEY=mysymmetrickey`

get token: localhost:8020/oauth/token

header:  
[{"key":"Authorization","value":"Basic d3JpdGVyLXNlcnZpY2U6bXlzZWNyZXQ=","description":""}]  
body:  
[{"key":"grant_type","value":"password","description":""},{"key":"scope","value":"any","description":""},{"key":"username","value":"zalerix","description":""},{"key":"password","value":"zlrx","description":""}]  