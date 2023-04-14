# PseudoBlockchain
![Testing](https://github.com/Artyom-IWT/PseudoBlockchain/actions/workflows/maven.yml/badge.svg?branch=master)

Network programming course, Peter the Great St.Petersburg Polytechnic University (2023)

## Docker

### Build

```
docker build . -t pseudo-blockchain --progress-plain
```

### Usage

```
docker run --rm pseudo-blockchain -h
Usage: node [-ghV] -p=<port> [-n=<nodes>]...              
  -g, --genesis        Generate genesis block.            
  -h, --help           Show this help message and exit.   
  -n, --node=<nodes>   Other node port.                   
  -p, --port=<port>    Node port.                         
  -V, --version        Print version information and exit.
```

## Docker compose

[Example with 3 nodes](docker-compose.yml):

```
docker-compose up

[+] Running 3/3
 - Container node-8081  Created                                                                                                                                                          0.1s
 - Container node-8082  Created                                                                                                                                                          0.1s
 - Container node-8080  Created                                                                                                                                                          0.1s
Attaching to node-8080, node-8081, node-8082

node-8081  | Waiting for genesis...
node-8082  | Waiting for genesis...
node-8080  | Generating genesis...
node-8080  | MASTER: {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","data":"co9WYKyfffRU8HkGkaOslpowmysFmRVqtfcA43padHJJeHAjhH9uTEdSlchsp7nlWcwSWOLQBz40hM2brQhFcbKiWWZMTUQBD0Wa6YEg5xdkWZd1xiyTnlzNcd03SafitYQAXBaqGlRhIYsZmy4JYolZ6CDqcQ7c9gRezjbgr4n4VrTtJhSRPQrLYOiLXpOqoC89zf85NhIuM2hrbKmIbblTnTfYlACxtZEdJFxxpVCgXKYCRCzVM5qOHikpvOQR","nonce":10656}
node-8081  | SLAVE : {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","data":"co9WYKyfffRU8HkGkaOslpowmysFmRVqtfcA43padHJJeHAjhH9uTEdSlchsp7nlWcwSWOLQBz40hM2brQhFcbKiWWZMTUQBD0Wa6YEg5xdkWZd1xiyTnlzNcd03SafitYQAXBaqGlRhIYsZmy4JYolZ6CDqcQ7c9gRezjbgr4n4VrTtJhSRPQrLYOiLXpOqoC89zf85NhIuM2hrbKmIbblTnTfYlACxtZEdJFxxpVCgXKYCRCzVM5qOHikpvOQR","nonce":10656}
node-8082  | SLAVE : {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","data":"co9WYKyfffRU8HkGkaOslpowmysFmRVqtfcA43padHJJeHAjhH9uTEdSlchsp7nlWcwSWOLQBz40hM2brQhFcbKiWWZMTUQBD0Wa6YEg5xdkWZd1xiyTnlzNcd03SafitYQAXBaqGlRhIYsZmy4JYolZ6CDqcQ7c9gRezjbgr4n4VrTtJhSRPQrLYOiLXpOqoC89zf85NhIuM2hrbKmIbblTnTfYlACxtZEdJFxxpVCgXKYCRCzVM5qOHikpvOQR","nonce":10656}
node-8082  | MASTER: {"id":1,"prevHash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","hash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","data":"3zZIj4iVnXXVnQN38LDKGbN1zWdCBJ44uFoS1DplS1PCjRPyZf7mgB9fKBsU28O6bjXNTAmy12AIE0dqhkVspZPTFJNpezKO5GytSJM355n7NuY89U2yWDw5sxSB10mLdldfTynh36AuMFH3dX9A7I2K0EyWC3EQQBndJZmUqNEzyI8ovtC8ZeAbu5kNymWGRiuV3AmxRS2qXggzv01AKqcM3ZRRmQJeeoXJiz10wrOnhUPXlDDCnTzlVzkzw6Uf","nonce":11987}
node-8081  | SLAVE : {"id":1,"prevHash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","hash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","data":"3zZIj4iVnXXVnQN38LDKGbN1zWdCBJ44uFoS1DplS1PCjRPyZf7mgB9fKBsU28O6bjXNTAmy12AIE0dqhkVspZPTFJNpezKO5GytSJM355n7NuY89U2yWDw5sxSB10mLdldfTynh36AuMFH3dX9A7I2K0EyWC3EQQBndJZmUqNEzyI8ovtC8ZeAbu5kNymWGRiuV3AmxRS2qXggzv01AKqcM3ZRRmQJeeoXJiz10wrOnhUPXlDDCnTzlVzkzw6Uf","nonce":11987}
node-8080  | SLAVE : {"id":1,"prevHash":"fd29080ae70e1bd8b60ac3385505ebb05b5a32127576de16d56cbd7873e80000","hash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","data":"3zZIj4iVnXXVnQN38LDKGbN1zWdCBJ44uFoS1DplS1PCjRPyZf7mgB9fKBsU28O6bjXNTAmy12AIE0dqhkVspZPTFJNpezKO5GytSJM355n7NuY89U2yWDw5sxSB10mLdldfTynh36AuMFH3dX9A7I2K0EyWC3EQQBndJZmUqNEzyI8ovtC8ZeAbu5kNymWGRiuV3AmxRS2qXggzv01AKqcM3ZRRmQJeeoXJiz10wrOnhUPXlDDCnTzlVzkzw6Uf","nonce":11987}
node-8081  | MASTER: {"id":2,"prevHash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","hash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","data":"e7zxz2QBkyZhc1gEkfaNf0kN2dVaHlQJvKjYAxTDW2QdNs5mDH21PfyFFOvyjTawIui0t05bRHOtoHSUzSq5gSu5Btf01aQOfJ8eJIdQTkpQDAcogVUV1YPSgknvgPJJ1tEMqLxRbcOVl9ElcsjzngFZYtm0m5hFdDoAcOmP1d4GsJvYqPz0BdJs8nATifVNb9QRbcQ1G5sFFD6gfwOWdls6uG1BdJfpX9O5UL1SuD8tuAV1p7v5YPdxgWoShANZ","nonce":22385}
node-8080  | SLAVE : {"id":2,"prevHash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","hash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","data":"e7zxz2QBkyZhc1gEkfaNf0kN2dVaHlQJvKjYAxTDW2QdNs5mDH21PfyFFOvyjTawIui0t05bRHOtoHSUzSq5gSu5Btf01aQOfJ8eJIdQTkpQDAcogVUV1YPSgknvgPJJ1tEMqLxRbcOVl9ElcsjzngFZYtm0m5hFdDoAcOmP1d4GsJvYqPz0BdJs8nATifVNb9QRbcQ1G5sFFD6gfwOWdls6uG1BdJfpX9O5UL1SuD8tuAV1p7v5YPdxgWoShANZ","nonce":22385}
node-8082  | SLAVE : {"id":2,"prevHash":"c82c1b152464f207380cd2d4e08f9988f9881c1987096cf60818f57277670000","hash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","data":"e7zxz2QBkyZhc1gEkfaNf0kN2dVaHlQJvKjYAxTDW2QdNs5mDH21PfyFFOvyjTawIui0t05bRHOtoHSUzSq5gSu5Btf01aQOfJ8eJIdQTkpQDAcogVUV1YPSgknvgPJJ1tEMqLxRbcOVl9ElcsjzngFZYtm0m5hFdDoAcOmP1d4GsJvYqPz0BdJs8nATifVNb9QRbcQ1G5sFFD6gfwOWdls6uG1BdJfpX9O5UL1SuD8tuAV1p7v5YPdxgWoShANZ","nonce":22385}
node-8080  | MASTER: {"id":3,"prevHash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","hash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","data":"NIokIY9kQZg5f3xMWSq0ac5oMSyFkFTevKl7pMzmHOaJzFI3RpuI0Lt7LhnhCL70YY3frt9WuY7NpYQfk3BODKFVKzxfaz8CEfKeRULn22N7E3qPtnm77SWLW6YZr7hC0Vp1DZ6dsBPpp1ikbNWd8TGRqMRaj3ubSefmY1CNytJf0JMNTQp9RFylkI2IXhK2Vrq3NJR3hfVPeS50dDF9Rv9iPSxuZyfT5QUKCcXj90Zt67OW4uAOSBEl7IEuLEHZ","nonce":24543}
node-8082  | SLAVE : {"id":3,"prevHash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","hash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","data":"NIokIY9kQZg5f3xMWSq0ac5oMSyFkFTevKl7pMzmHOaJzFI3RpuI0Lt7LhnhCL70YY3frt9WuY7NpYQfk3BODKFVKzxfaz8CEfKeRULn22N7E3qPtnm77SWLW6YZr7hC0Vp1DZ6dsBPpp1ikbNWd8TGRqMRaj3ubSefmY1CNytJf0JMNTQp9RFylkI2IXhK2Vrq3NJR3hfVPeS50dDF9Rv9iPSxuZyfT5QUKCcXj90Zt67OW4uAOSBEl7IEuLEHZ","nonce":24543}
node-8081  | SLAVE : {"id":3,"prevHash":"b2e8cfe60e29801b0dac2343fc8e00282d7e555e270cf9e59bacde9ade410000","hash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","data":"NIokIY9kQZg5f3xMWSq0ac5oMSyFkFTevKl7pMzmHOaJzFI3RpuI0Lt7LhnhCL70YY3frt9WuY7NpYQfk3BODKFVKzxfaz8CEfKeRULn22N7E3qPtnm77SWLW6YZr7hC0Vp1DZ6dsBPpp1ikbNWd8TGRqMRaj3ubSefmY1CNytJf0JMNTQp9RFylkI2IXhK2Vrq3NJR3hfVPeS50dDF9Rv9iPSxuZyfT5QUKCcXj90Zt67OW4uAOSBEl7IEuLEHZ","nonce":24543}
node-8080  | MASTER: {"id":4,"prevHash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","hash":"21da9a471c42b52601735b6688425341fa78771776de1c13fed974c4ffae0000","data":"hzZg6bQ5Tj0mxx8qFLGSsUai1ZkOGrLQVexzSiOynX7hfsbULJiyhFoH10DN8Io2YvSybGaBK9bhlVhTdEbfytpeUITpsKGKFOMwTpu3HTYCfzlHxWZkzCM04Qpjf3aNLCjILFIppTPA2lMWctEgdLxCxhQidFucyjAZSUqr9ocSWEY3XGe2lfg6DEUh6rQxWzcYMu2Zf8isB8BB3i7T2T7Xsx9YA46Ti4HXJqPA6PRoeQWNBmU7XeQw81c378Px","nonce":65945}
node-8081  | SLAVE : {"id":4,"prevHash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","hash":"21da9a471c42b52601735b6688425341fa78771776de1c13fed974c4ffae0000","data":"hzZg6bQ5Tj0mxx8qFLGSsUai1ZkOGrLQVexzSiOynX7hfsbULJiyhFoH10DN8Io2YvSybGaBK9bhlVhTdEbfytpeUITpsKGKFOMwTpu3HTYCfzlHxWZkzCM04Qpjf3aNLCjILFIppTPA2lMWctEgdLxCxhQidFucyjAZSUqr9ocSWEY3XGe2lfg6DEUh6rQxWzcYMu2Zf8isB8BB3i7T2T7Xsx9YA46Ti4HXJqPA6PRoeQWNBmU7XeQw81c378Px","nonce":65945}
node-8082  | SLAVE : {"id":4,"prevHash":"9e55e867da462ccf252170c71bb12759c605ddacc2c9d0ecf08e906db6830000","hash":"21da9a471c42b52601735b6688425341fa78771776de1c13fed974c4ffae0000","data":"hzZg6bQ5Tj0mxx8qFLGSsUai1ZkOGrLQVexzSiOynX7hfsbULJiyhFoH10DN8Io2YvSybGaBK9bhlVhTdEbfytpeUITpsKGKFOMwTpu3HTYCfzlHxWZkzCM04Qpjf3aNLCjILFIppTPA2lMWctEgdLxCxhQidFucyjAZSUqr9ocSWEY3XGe2lfg6DEUh6rQxWzcYMu2Zf8isB8BB3i7T2T7Xsx9YA46Ti4HXJqPA6PRoeQWNBmU7XeQw81c378Px","nonce":65945}
```