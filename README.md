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
node-8080  | MASTER: {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000"
,"data":"7xoPBLC2QsvQIPsHmz7UIklOHOBuOnxzAT5XPvlRUkmTSkN5OF5HDk9BGEMdKUzEEZnWAzH7C3eI0cfM5dBJWsKU1wwEeri0ds7VRKcbUmGZXesBzKVgbOx0Lvx6oJzG9lmocHzJjzsbmpIeEqDNiHycFxMxJQPuNnmyCxJ2g2v
29AXiRe27Ulg5xSZ4hR3DIl91QyGShcEjOmSMBYadikxFe55sKzZYZ0BrSa3OarTiK5ixxHpYHgOCUmxSM94X","nonce":34414}
node-8082  | SLAVE : {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000"
,"data":"7xoPBLC2QsvQIPsHmz7UIklOHOBuOnxzAT5XPvlRUkmTSkN5OF5HDk9BGEMdKUzEEZnWAzH7C3eI0cfM5dBJWsKU1wwEeri0ds7VRKcbUmGZXesBzKVgbOx0Lvx6oJzG9lmocHzJjzsbmpIeEqDNiHycFxMxJQPuNnmyCxJ2g2v
29AXiRe27Ulg5xSZ4hR3DIl91QyGShcEjOmSMBYadikxFe55sKzZYZ0BrSa3OarTiK5ixxHpYHgOCUmxSM94X","nonce":34414}
node-8081  | SLAVE : {"id":0,"prevHash":"0000000000000000000000000000000000000000000000000000000000000000","hash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000"
,"data":"7xoPBLC2QsvQIPsHmz7UIklOHOBuOnxzAT5XPvlRUkmTSkN5OF5HDk9BGEMdKUzEEZnWAzH7C3eI0cfM5dBJWsKU1wwEeri0ds7VRKcbUmGZXesBzKVgbOx0Lvx6oJzG9lmocHzJjzsbmpIeEqDNiHycFxMxJQPuNnmyCxJ2g2v
29AXiRe27Ulg5xSZ4hR3DIl91QyGShcEjOmSMBYadikxFe55sKzZYZ0BrSa3OarTiK5ixxHpYHgOCUmxSM94X","nonce":34414}
node-8082  | MASTER: {"id":1,"prevHash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000","hash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000"
,"data":"5GNSH83LaB5qjdASu6zSayjnd59RMvuAJKnC699Xk95d6uycUwPQ5F9RTSMMshT7nmr1blgM76zWmNkZ3Te12XeOjlKvFhq7bjWvSTALJu7JkHIz3ZEtq9qJ0krXaNbAuaJKyA1VHudEseCWJkhdX3HHAclgqRwrrdSjQyDWDRH
rowBkyVeUU1LHgJJSze4IlwFcFp0cQ0dJvlH5moe0nu4VSdJnHQoWNKysSbyP7LuYPyYNniA0w1jcK6TdNGLt","nonce":14092}
node-8081  | SLAVE : {"id":1,"prevHash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000","hash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000"
,"data":"5GNSH83LaB5qjdASu6zSayjnd59RMvuAJKnC699Xk95d6uycUwPQ5F9RTSMMshT7nmr1blgM76zWmNkZ3Te12XeOjlKvFhq7bjWvSTALJu7JkHIz3ZEtq9qJ0krXaNbAuaJKyA1VHudEseCWJkhdX3HHAclgqRwrrdSjQyDWDRH
rowBkyVeUU1LHgJJSze4IlwFcFp0cQ0dJvlH5moe0nu4VSdJnHQoWNKysSbyP7LuYPyYNniA0w1jcK6TdNGLt","nonce":14092}
node-8080  | SLAVE : {"id":1,"prevHash":"5efb8753884e6947ea27f82d0991e861fc689399be51e55d3e3a6be0ee460000","hash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000"
,"data":"5GNSH83LaB5qjdASu6zSayjnd59RMvuAJKnC699Xk95d6uycUwPQ5F9RTSMMshT7nmr1blgM76zWmNkZ3Te12XeOjlKvFhq7bjWvSTALJu7JkHIz3ZEtq9qJ0krXaNbAuaJKyA1VHudEseCWJkhdX3HHAclgqRwrrdSjQyDWDRH
rowBkyVeUU1LHgJJSze4IlwFcFp0cQ0dJvlH5moe0nu4VSdJnHQoWNKysSbyP7LuYPyYNniA0w1jcK6TdNGLt","nonce":14092}
node-8082  | MASTER: {"id":2,"prevHash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000","hash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000"
,"data":"uvwyzOUpsaggtftUc8cimYLxJmTBmjy8pfCvmrny175g51H0KlRi4eLI1VYrZjr0BolZnykROogYBIVCyi01Hvr3ropyodYUWc9AEVaauTMjOcUVzBoHw16jcrAcxibfQ8cQENsqaoCs7RSHr1NZ9n5l7dYmzQtPgeNssSGBK45
XfWFTK3pAAmrG2pfPdzCYVifoBanD81iOrnzx5HvPvwZpp47Rcrs6S70kjvBaomTFKKrmdzhbgAo01oMydF3X","nonce":20257}
node-8081  | SLAVE : {"id":2,"prevHash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000","hash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000"
,"data":"uvwyzOUpsaggtftUc8cimYLxJmTBmjy8pfCvmrny175g51H0KlRi4eLI1VYrZjr0BolZnykROogYBIVCyi01Hvr3ropyodYUWc9AEVaauTMjOcUVzBoHw16jcrAcxibfQ8cQENsqaoCs7RSHr1NZ9n5l7dYmzQtPgeNssSGBK45
node-8080  | SLAVE : {"id":2,"prevHash":"062d26829605ac6ce359172bc3100f3a224c0bb42d27f6a4e2f71116fe9b0000","hash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000"
,"data":"uvwyzOUpsaggtftUc8cimYLxJmTBmjy8pfCvmrny175g51H0KlRi4eLI1VYrZjr0BolZnykROogYBIVCyi01Hvr3ropyodYUWc9AEVaauTMjOcUVzBoHw16jcrAcxibfQ8cQENsqaoCs7RSHr1NZ9n5l7dYmzQtPgeNssSGBK45
XfWFTK3pAAmrG2pfPdzCYVifoBanD81iOrnzx5HvPvwZpp47Rcrs6S70kjvBaomTFKKrmdzhbgAo01oMydF3X","nonce":20257}
node-8082  | SLAVE : {"id":3,"prevHash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000","hash":"54e0dfa9bc916b043c509593a5695fd9fa210091336bd9a1e458d6c8ffc80000"
,"data":"PvbsPHhWpVA6tpca2juSPs0WYZyqbWrbKuO9WEi9Pc1ejAT81RHZYQnU14paoWs0OILX2OVfH1l0g7dPi8PDGECOKptBwB0WYN3J0O7tCouQVue7PF35rTd5gFQQ6SMoG6GIHiCPYVT6wl06wRK09llYl9WQ9k73plzxdZWAKPE
BNreC4o4ptJpzbmShf6V4e7e0A1VUmZ0ggDBgRbbE8Jog2NTlGFdWoDRA41tCnNEftgi2hVhp8LJiB96MmlHJ","nonce":14570}
node-8081  | MASTER: {"id":3,"prevHash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000","hash":"54e0dfa9bc916b043c509593a5695fd9fa210091336bd9a1e458d6c8ffc80000"
,"data":"PvbsPHhWpVA6tpca2juSPs0WYZyqbWrbKuO9WEi9Pc1ejAT81RHZYQnU14paoWs0OILX2OVfH1l0g7dPi8PDGECOKptBwB0WYN3J0O7tCouQVue7PF35rTd5gFQQ6SMoG6GIHiCPYVT6wl06wRK09llYl9WQ9k73plzxdZWAKPE
BNreC4o4ptJpzbmShf6V4e7e0A1VUmZ0ggDBgRbbE8Jog2NTlGFdWoDRA41tCnNEftgi2hVhp8LJiB96MmlHJ","nonce":14570}
node-8080  | SLAVE : {"id":3,"prevHash":"d173f37c8cb8a426585cc131753f65751271bd7a1eb6c2bdf7a7f4da62c20000","hash":"54e0dfa9bc916b043c509593a5695fd9fa210091336bd9a1e458d6c8ffc80000"
,"data":"PvbsPHhWpVA6tpca2juSPs0WYZyqbWrbKuO9WEi9Pc1ejAT81RHZYQnU14paoWs0OILX2OVfH1l0g7dPi8PDGECOKptBwB0WYN3J0O7tCouQVue7PF35rTd5gFQQ6SMoG6GIHiCPYVT6wl06wRK09llYl9WQ9k73plzxdZWAKPE
BNreC4o4ptJpzbmShf6V4e7e0A1VUmZ0ggDBgRbbE8Jog2NTlGFdWoDRA41tCnNEftgi2hVhp8LJiB96MmlHJ","nonce":14570}
```