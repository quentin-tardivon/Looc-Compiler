# Mode d'emploi du compilateur Looc

## Fonctionnalités gérées:

- Opération classiques
- Déclaration et affectation de variables
- Déclaration et affectation d'objets
- Déclaration et appel de méthodes
- Déclaration et affectation d'attributs
- Utilisation de bloques anonymes
- Boucles For et utilisation de IfThenElse

## Fonctionnalités non supportées:

- Toutes les fonctionnalités liées à l'héritage

## Utilisation:

Pour utiliser le compilateur:

    java -jar looc-compiler.jar "nom_fichier.looc"

Le fichier .asm sera générer au même emplacement que votre fichier .looc.

Il est ensuite nécessaire de compiler le fichier .asm en .iup à l'aide de microPIUPK:

    java -jar microPIUPK.jar -ass "nom_fichier.asm"
    
Pour exécuter le fichier produit:
    
    java -jar microPIUPK.jar -batch "nom_fichier.iup"