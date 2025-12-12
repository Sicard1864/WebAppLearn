# WebAppLearn

## Version de java
java -version       17.0.16
mvn -v              3.8.7


## Commande pour lancer le projet back

cd webapplearn/back
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


## Pour test le CRUD

http://localhost:8080/swagger-ui/index.html#/


## Pour ouvrir PostgreSQL

psql -U postgres -d webapplearn     # code : c+
\dt                                 # voir les tables
\d <table>                          # voir structure de la table
SELECT * FROM users;                # voir le contenu
<autre requête SQL>
\q                                  # quitter psql

## Pour committer
mvn clean            # Nettoyer ton build local
git status           # Vérifier les fichiers à committer
git add .
git commit -m "Nettoyage + modifications"
git push



# Journal

## Historique

11/12/25 - Création de l'authentification + token jwt
10/12/25 - Création du modèle User (dto, class, service, controller, repository)

## Prévus

installer postgreSQL sur debian
réorganiser répo
installation angular sur windows et debian
front 
    1. Configurer l’URL du backend
    2. AppModule : activer HttpClient + formulaires + routing
    3. Routing : login, register, home
    4. AuthService : liaison avec ton backend Spring
    5. Interceptor : ajouter le header Authorization automatiquement
    6. Composant Register
    7. Composant Login
    8. Page d’accueil (Home) de l’application
    9. AppComponent : juste le router
    10. Tester
mettre plusieur langue
mettre dark, light mode
regarder d'autre site (Road Royal, scribhub, scan, donation, amazone, présnetation)


## réorga

WebAppLearn/
├─ backend/
│  ├─ pom.xml
│  ├─ src/
│  │  ├─ main/
│  │  │  ├─ java/
│  │  │  │   └─ fr/sicard/webapplearn/
│  │  │  │       ├─ WebapplearnApplication.java
│  │  │  │       ├─ config/                   (si plus tard)
│  │  │  │       │   ├─ WebConfig.java        (CORS, Jackson, locales…)
│  │  │  │       │   └─ OpenApiConfig.java    (OpenAPI)
│  │  │  │       ├─ security/
│  │  │  │       ├─ auth/
│  │  │  │       │   ├─ AuthController.java         (controller/)
│  │  │  │       │   ├─ AuthService.java            (service/)
│  │  │  │       │   └─ dto/
│  │  │  │       ├─ user/
│  │  │  │       │   ├─ User.java                   (domain/)
│  │  │  │       │   ├─ UserService.java            (service/)
│  │  │  │       │   ├─ UserRepository.java         (persistence/)
│  │  │  │       │   ├─ UserController.java         (web/)
│  │  │  │       │   └─ dto/
│  │  │  │       │
│  │  │  │       ├─ autre model/
│  │  │  │       │
│  │  │  │       └─ common/                   (à faire plus tard)
│  │  │  │           ├─ exception/                          
│  │  │  │           │   ├─ ApiException.java
│  │  │  │           │   ├─ NotFoundException.java
│  │  │  │           │   ├─ BadRequestException.java
│  │  │  │           │   ├─ GlobalExceptionHandler.java
│  │  │  │           └─ util/
│  │  │  │               ├─ DateUtils.java
│  │  │  │               ├─ StringUtils.java
│  │  │  └─ resources/
│  │  │      ├─ application.yml
│  │  │      ├─ application-dev.yml
│  │  │      ├─ application-test.yml
│  │  │      └─ static/                       (si besoin)
│  │  │          ├─ index.html
│  │  │          └─ style.css    
│  │  └─ test/
│  │      └─ java/…
│  └─ README.md (facultatif, spécifique backend)
│
├─ frontend/        (à créer plus tard pour ton Angular)
│
├─ docs/
│  ├─ architecture.md   (explication back, front)
│  └─ api.md            (endpoints importants, règles d’auth, etc.)
├─ .github/
│  └─ workflows/
│      ├─ ci-backend.yml
│      └─ ci-frontend.yml (plus tard)
├─ .gitignore
├─ README.md        (global projet)
└─ LICENSE          (si public)
