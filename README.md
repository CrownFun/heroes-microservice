Heroes

TODO:
EUREKA
HYSTRIX (dashboard, actuator)
(API GATEWAY) ZULL 
DOCKER Compose
Configuration - Server config
SWAGGER
JUNIT TEST
REST ASSURED 

Questions:
LoadBalancer - jak działa?
Ribbon, Feign?
Problem powtarzajacego sie kodu - resttemplate, exceptions

Ports:
8084 - castle
8085 - weapon
8086 - creature
8087 - heroes
8088 - combat
8089 - zuul
8761 - eureka (main)
8888 - configuration

Eureka:
http://localhost:8761/

Hystrix: (example) -  Hystrix jest tam gdzie jest Client(RestTemplate)
http://localhost:8087/hystrix
http://localhost:8087/actuator/hystrix.stream

Actuator: - na każdym serwisie zadziała (o ile są zależności dodane)
http://localhost:8761/actuator/info
http://localhost:8087/actuator/info

Test Endpoints: (dzięki API GATEWAY (Zuul) mamy tylko jeden serwis)
http://localhost:8089/api/castle/all
http://localhost:8089/api/weapon/all
http://localhost:8089/api/creature/all
http://localhost:8089/api/heroes/create?heroesName=Benq&castleName=Twierdza&weaponName=Miecz&creature1=Cyklop&creature2=Behemot&creature3=Goblin 
http://localhost:8089/api/heroes/all
http://localhost:8089/api/combat?heroes1=Benq&heroes2=Fendt

Spring Cloud Config
http://localhost:8888/heroes-service/default
http://localhost:8888/castle-service/default

http://localhost:8089/api/castle/message
http://localhost:8089/api/heroes/message


Creatures:
                Centaur
                Zielony Smok
                Krzyżowiec
                Czempion
                Archanioł
                Cerber
                Ifryt
                Diabeł
                Wiwerna
                Hydra
                Bazyliszek
                Goblin
                Cyklop
                Behemot
                Gremlin
                Dżin,
                Tytan
                Minotaur
                Chimera
                Czarny Smok
                Wampir
                Upiorny Rycerz
                Upiorny Smok
                
                
Castles:

                TWIERDZA,
                BASTION,
                ZAMEK,
                INFERNO,
                NEKROPOLIA,
                 CYTADELA;
    
Weapons:

                Miecz
                Łuk
                Kij
                Maczuga
                Dzida
                Sztylet