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




Semantic controls :

1) MismatchTypeException (OK)
2) UndeclaredVariableException (OK)
3) UndeclaredClassException (OK)
4) UndeclaredMethodException (OK)
5) AlreadyDeclaredException (OK)
6) InexactNumberParametersException (OK)
7) ReturnValueTypeMismatchException (OK)
8) MismatchOperationException (OK)
9) InheritanceTypeMismatchException (TODO)
10) StringOperationException (OK)
11) UndefinedInheritanceException (OK)
12) InexactUsesOfDoStatement (TODO)
13) NonVoidMethodInDoException (OK)
14) InexactUsesofReadException (TODO)
15) InexactUsesofWriteException (TODO)
16) ParameterTypeMismatchException (TODO)

others :


17)Verifie le contexte lors de l'utilisation de this ou super (uniquement dans la def d'une classe)
18)MissingReturn
19)NeverUsedException
20)WrongParameterOrder
21)VarNotInitialisedException => var a; var b; b=a;


Auteurs
==

Maxime Escamez (TRS)

Théo le Donné (TRS)

Quentin Tardivon (IL)

Yann Prono (IL)
