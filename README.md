# WebAppLearn

## Version de java
java -version       17.0.16
mvn -v              3.8.7


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

accéder depuis l'extérieur
IP box internet => 88.167.247.17
Faire du NAT / redirection de port sur la Freebox
    http://88.167.247.17:8080/

## Pour committer
mvn clean            # Nettoyer ton build local
git status           # Vérifier les fichiers à committer
git add .
git commit -m "Nettoyage + modifications"
git push
