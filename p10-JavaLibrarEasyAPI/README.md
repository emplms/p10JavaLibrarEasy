# p10JavaLibrarEasyAPi
Projet 10 Parcours Développeur Java (API REST)

# DESCRIPTION
Application de gestion de bibliothèque

# ENVIRONNEMENT
* JavaEE 8  
* PostgreSQL  
* Maven
* Spring Boot
* Spring Web
* Spring Security
* Spring Data Jpa
* Spring MVC
* OpenFeign
* Bootstrap  

Optimisé pour TOMCAT 9.0

# CLONAGE DES COMPOSANTS DU PROJET
Pour cloner les composants du projet : 
	* https://github.com/emplms/p10JavaLibrarEasy.git
	
# DEPLOIEMENT
##### BDD (postgresql)
1- Télécharger PostgreSQL  
2- Executer les scripts sql (dossier p10JavaLibrarEasy-Api/src/main/ressources/doc)
Les scripts "p7" correspondent aux scripts de la release 1.0.0
Les scripts "p10" correspondent aux scripts de migration pour la release 1.1.0

##### paramètres de connection à la Base de Données
Le user et le mot de passe de connection à la base de données par défaut sont renseignés dans le fichier application.properties  
Pour les modifier, le chemin d'accès au fichier dans le projet est :  
		p10JavaLibraEasyAPI/src/main/resources/application.properties

##### Lancement de l'API	
1- Récupérer le fichier jar : dans le repository qui accueille le clone, saisir  la commande mvn install  
2- Dans le dossier target, saisir la commande :    java -jar p10JavaLibrarEasyApi-1.1.0-Snapshot.jar 
l'API utilise le port 9001

##### Lancement de l'appliweb
1- Récupérer le fichier jar : dans le repository qui accueille le clone, saisir  la commande mvn install  
2- Dans le dossier target, saisir la commande :    java -jar  p10JavaLibrarEasyWEB-1.1.0-Snapshot.jar
3- url de la page d'accueil :http://localhost:8080/

##### Lancement du Batch
1- Récupérer le fichier jar : dans le repository qui accueille le clone, saisir  la commande mvn install  
2- Dans le dossier target, saisir la commande :    java -jar  p10JavaLibrarEasyBatch-1.1.0-Snapshot.jar
Le batch a une fréquence de lancement de 24H00 à partir du lancement de celui-ci.

# VERSION
1.1.0-Snapshot

# AUTEUR
Emmanuel PLUMAS - Mars 2021
