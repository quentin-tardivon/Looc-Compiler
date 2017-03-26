# Compilateur pour langage LOOC

Projet de compilation pour langage objet Looc
en ASM

TODO
cas new et moins unaire dans affect

Organisation
===


- *bin/* contient les *.class* générées par ANTLR.
- *samples* les fichiers de tests .LOOC, permettant de tester le Compilateur
  - Les fichiers commencant par _ (*_level1.looc* par exemple) sont les fichiers devant échouer durant l'analyse lexical et syntaxique.
  - Les autres fichiers doivent passer l'étape d'analyse.
- *src/* contient le fichier java principal
- *Looc.g* est le fichier de grammaire
- *Makefile* automatisant certaines taches:
      make        ## execute ANTLR et compile le lexer et parser
      make clean  ## Supprime les binaires, logs et les fichiers générés par ANTLR
      make test   ## Vérifie la syntaxe de chaque fichier de tests écrits dans

<!---make parse  ## Lance TestLooc où il est possible d'écrire du contenu LOOC-->

Remarques
===

- *Expression* doit pouvoir se réécrire en String:
      expression  -> cst_ent
                  -> cst_chaine
                  -> ...

- L'Appel à une méthode peut se faire sans arguments, il faut donc corriger la production suivante:

      INSTRUCTION -> do EXPRESSION

- L'operateur **-** est le plus fort

- *OUTPUT = AST* en options du fichier .g permet de de générer l'AST.

-  "L'évaluation des opérateurs s'effectue de gauche à droite, et leur priorité est la suivante:
 - <,  >, <=, >=, != et ==  ont même priorité. Celle-ci est supérieure à celle de * elle-même supérieure à la priorité de + et qui ont même priorité.

 - L'opérateur unaire - note l'opposé pour un entier, et la négation pour un booléen. Les opérateurs
<, >, <=, >=, !=, et == sont à opérandes entiers et à résultat booléen. Dans le cas d'expressions booléennes, le symbole - désignera l'opérateur logique NOR, + désignera le *OR* logique et * désignera le *AND* logique.

Changements
==

- D'après la grammaire (à vérifier), il est possible d'avoir qu'une seule instruction dans le bloc d'un *if* et *else*.


Quelques interrogations
==

- Durant la première soutenance, Monsieur Da Silva nous a conseillé de faire remonter les attributs de classes au même niveau que la déclaration de la classe. Suite à notre après-midi 'compil', nous n'avons pas compris pourquoi cette modification serait plus facile pour construire la TDS.TDS. Mystère et hypster chauve ?
- POur la création de la TDS, nous avons fait le choix d'associer à un mot-clé une entrée dans la TDS

        "sqrt" => function, [parameter a double], return double
        // Key => Type     , List of formals params, type of returned value

Dans le cas ou se retrouve sur un bloc de type IF, ELSE, ou FOR, comment les identifier de manière unique dans la TDS ?




Controle sémantiques
====================

-Une classe ne peut referencer que des classes déjà définies -> class not defined

-un programme ne peut rdéfinir une classe existante -> cannot override class

-Les noms des classes et des méthodes sont visibles partout ->

-Dans une classe, un idf ne peut pas désigner a la fois un argument ou un attribut et une méthode ->

-Les régles de portée des arguments et des variables locales sont celles habituellement définies dans les langages impératifs, tels que Java. ->

-La portée d'une déclaration d'une variable locale commence a la fin de sa declaration et se termine a la fin du bloc englobant cette declaration. -> "variable not defined"

-Une expression ne peut referencer que des variables ou attributs deja déclarés

-cohérence de typages

-division par zero ?









TODO-> add line number
TODO-> Syntaxiquement on peut faire : Do new Dog; c'est faux.




1)MismatchTypeException : Cohérence de type (selon déclaration la plus récente) (OK)



2)UndeclaredVariableException : variable non définie (OK)   



3)UndeclaredClassException : classe non définie  (OK)    



4)UndeclaredMethodException : méthode non définie (OK)




5)AlreadyDeclaredException : plusieurs definitions du meme idf dans le bloc courant -> idf "is already defined"  




6)InexactParametersException : nb de params inexacte -> method "is missing parameters" ou method "has got to many parameters"  



7)ReturnValueTypeMismatchException : respect de la valeur de retour des méthodes -> idf "is" type "but" type de retour "is expected"   




8)OperationTypeMismatchException : cohérence de type lors d'un calcul ->  a= b+c; a= b+2;       




9)UnusedVariableException : variable jamais utilisé -> idf "is never used"                                               



10)InheritanceTypeMismatchException :  cohérence de type avec héritage -> Animal A; A=new Dog();       



11)StringOperationException : Pas d'opérations sur les strings => Str = a - b  ->



12)Argument, attribut et méthode avec meme idf -> idf "is already used by"



13)
14)
15)
16)




Auteurs
==

Maxime Escamez (TRS)

Théo le Donné (TRS)

Quentin Tardivon (IL)

Yann Prono (IL)
