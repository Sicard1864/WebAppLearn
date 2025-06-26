# WebAppLearn

## Commande pour lancer le projet

cd webapplearn
mvn spring-boot:run

| Commande              | À quoi ça sert                         | Quand l'utiliser                         |
| --------------------- | -------------------------------------- | ---------------------------------------- |
| `mvn clean`           | Supprime les anciens fichiers de build | Avant un nouveau build                   |
| `mvn compile`         | Compile uniquement les sources Java    | Pour vérifier que le code compile        |
| `mvn test`            | Lance les tests unitaires (JUnit)      | Avant livraison ou après modification    |
| `mvn package`         | Build complet (.jar) avec tests        | Pour livrer ou tester en mode autonome   |
| `mvn spring-boot:run` | Démarre l’application Spring Boot      | Pendant le développement                 |
| `mvn install`         | Installe le build dans le dépôt local  | Pour utiliser ce projet comme dépendance |


accéder en local 
http://127.0.0.1:8080/

accéder en lan
http://192.168.1.151:8080/
