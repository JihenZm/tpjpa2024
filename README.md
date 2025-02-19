# 📌 Compte Rendu - TP JPA & Servlets

## 📖 Introduction

Ce projet consiste en la conception et l’implémentation d’une application de Vente de Tickets de Concert en Ligne en utilisant JPA, Servlets et JAX-RS. L'objectif est de comprendre et d'appliquer les concepts liés à la persistance des données, aux services web REST et à la communication entre le front-end et le back-end. Ce compte rendu détaille l'avancement des différentes tâches et les prochaines étapes du projet.

---

## 🚀 Avancement des tâches

| Tâche | Statut | Remarques |
|-------|--------|-----------|
| Modélisation métier (JPA) | 🟢 Terminé | Création des entités et relations |
| Configuration de la base de données | 🟢 Terminé | Utilisation de PostgreSQL, script d'initialisation OK |
| Implémentation des DAO | 🟡 En cours | Quelques requêtes à optimiser |
| Création des Servlets | 🟡 En cours | Servlets GET/POST fonctionnels, validation à améliorer |
| Gestion des formulaires HTML | 🔴 Pas commencé | À faire après la partie Servlet |
| Mise en place de JAX-RS avec Jersey | 🟡 En cours | Prévu après validation des DAO |
| Création de services REST (CRUD) | 🟡 En cours | Lié à l’intégration de Jersey |
| Tests des endpoints avec Postman | 🔴 Pas commencé | Besoin d’implémenter les services REST d’abord |
| Documentation OpenAPI (Swagger) | 🔴 Pas commencé | À faire une fois les endpoints finalisés |
| Utilisation de DTO | 🔴 Pas commencé | Nécessaire pour la couche service |
| Refactoring et qualité du code | 🔴 Pas commencé | Vérification finale avant rendu |

---

## 🛠️ Comment démarrer le projet ?

### 1️⃣ Cloner le repository
```sh
git clone https://github.com/JihenZm/tpjpa2024.git
cd tpjpa2024
```
> 📌 **Note** : Le code nécessaire se trouve dans la branche `dev`.  
> Après avoir cloné le dépôt, pensez à exécuter ``` git checkout dev ``` pour y accéder.


### 2️⃣ Démarrer la base de données
- Démarrer la base de données PostgreSQL
- Lancer pgAdmin4 et créer la base de données nécessaire

### 3️⃣ Compiler et lancer le projet avec Maven
```sh
mvn compile jetty:run
```

## 📅 Prochaines étapes
- ✅ Finaliser l’implémentation des DAO
- ✅ Terminer la gestion des Servlets et formulaires
- ✅ Ajouter JAX-RS et les services REST
- ✅ Tester les endpoints avec Postman
- ✅ Générer la documentation OpenAPI