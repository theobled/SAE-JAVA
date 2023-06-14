<h2 align="center">Java - SAE S2.02 : Graphes 💻 </h2>

### L'équipe :
- WENG Julien 108
- KALIAMOORTHY Namodacane 108
- BOUZIANE Mehdi 108
- SAIGHI Aymen 108
- GAUTREAU Antoine - 102

---------------

### Présentation du projet

Réalisation d'une application permettant de manipuler des graphes,
L'objectif de cette application est de déterminer le plus court chemin pour aller d'un sommet à un autre.

---------------

### Travaux réalisés

Les classes de graphe :
- GrapheLArcs : implémenter ✅
- GrapheMAdj : implémenter ✅
- GrapheLAdj : implémenter ✅
- GrapheHHAdj : implémenter ✅

L'algorithme : 
- Dijkstra : implémenter ✅

---------------

### Tests Unitaires

Notre implémentation de l'algorithme de Dijkstra réussit tous les tests fournis sur Moodle avec tous les graphes fournis, y compris les graphes comportant jusqu'à 1 000 000 de sommets.
Cependant, en fonction de l'implementation du graphe choisie, la création du graphe et sont parcours, peuvent etre très long. +7 heures pour certain.

  - Implémentation de graphe choisie : GrapheHHAdj: 
 
 <div align="center">
  
 ![image](https://github.com/hurtcraft/JAVA_SAE_GRAPHE/assets/67128301/f9393187-137c-4084-b104-03bf686d20dc)
  
</div>

  
  - Implémentation de graphe choisie : GrapheHHAdj:
  
Pour les graphes à 1 000 000 de sommets et implémenter avec GrapheHHAdj, notre Dijsktra le résout en environ 2 sec :

![image](https://github.com/theobled/SAE-JAVA/assets/119744902/0b374f46-7ac0-4a19-bbfc-3e5dbea81c5b)


---------------

### Quelques informations

- sous vscode : 
se mettre dans src
pour compiler : javac .\appli\App.java
pour lancer : java -ea appli/App  

-  Pour les performances :
 <div align="center">
  
 | Configuration de la machine utilisé pour les tests | --- |
  |--------- | ------- |
  |    CPU    |    i5-12600k 3.6 GHZ |
  |    RAM    |    32 GO RAM DDR4 2133mhz |
  |    GPU    |    RTX 3070ti    |
  
</div>
  
  

  
  PS : Les résultats des tests peuvent varier en fonction de la machine utilisée.

---------------


### <div id="presentation"> Diagramme d'architecture </div>

![image](https://github.com/theobled/SAE-JAVA/assets/119744902/15d98741-79bf-4a58-b2c5-1099b3189e9b)



---------------

### Bilan :
 
 Nous sommes parvenus à créer une application permettant de trouver le plus court chemin entre deux sommets d'un graphe.
 
 Nous sommes fiers de plusieurs aspects de cette SAE, notamment l'optimisation de l'algorithme qui nous a permis de trouver le plus court chemin entre deux sommets (Dijkstra). Cependant, la cohésion d'équipe nous a permis de l'améliorer davantage. 
 
 Nous avons rencontré une difficulté, le changements régulier des fichiers sources, ce qui entraînait une modification continuelle de l'arborescence. Cependant, nous avons réussi à surmonter cette difficulté et à mener le projet à terme. ( les chemins relatifs ne marchaients pas sous vscode )
 
 Enfin, nous sommes très fiers de cette SAE qui nous a permis de continuer à nous familiariser avec Java et plus précisément le polymorphisme. On s'est également initier à github ce qui à grandement facilité le travail d'équipe.

------


