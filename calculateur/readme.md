# Object : Project Maven en JAVA, pour simpler le comportement dune calculatrice simple
> [!NOTE]
> ### Technos : JAVA 17, Maven.


## Info utiles :

### Lancer un programme :

#### Exemple 1 :
* 'cd calculateur'
* 'mvn clean package'
* java -jar target/calculateur-1.0-SNAPSHOT.jar'

#### Exemple 2 :
Depuis un editor comme VSCode, IntelliJ.j : lancé la class 'APPava'
avec des configurations si necessaire.

### Lancer des tests et ouvrir les rapports sur un navigateur par défault:

* mvn test-compile pitest:mutationCoverage
* open target/site/jacoco/index.html
* open target/pit-reports/index.html