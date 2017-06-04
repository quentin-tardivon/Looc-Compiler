# Compilateur pour langage LOOC

Projet de compilation pour langage objet Looc
en ASM réalisé dans le cadre du projet de compilation 
en 2ème année à Télécom Nancy.

Organisation
===


- *bin/* contient les *.class* générées par ANTLR.
- *samples* les fichiers de tests .LOOC, permettant de tester le Compilateur
  - Les fichiers commencant par _ (*_level1.looc* par exemple) sont les fichiers devant échouer durant l'analyse lexical et syntaxique.
  - Les autres fichiers doivent passer l'étape d'analyse.
  - *asmSamples/* contient les fichier ASM.
- *src/* contient le fichier java principal
- *Looc.g* est le fichier de grammaire
- *Makefile* automatisant certaines taches:
      make        ## execute ANTLR et compile le lexer et parser
      make clean  ## Supprime les binaires, logs et les fichiers générés par ANTLR
      make test   ## Vérifie la syntaxe de chaque fichier de tests
      make sim file=./asmSamples/my_prog.asm   ## Compile le fichier source et lance le simulateur


<!---make parse  ## Lance TestLooc où il est possible d'écrire du contenu LOOC-->

Auteurs
==

Maxime Escamez (TRS)

Théo le Donné (TRS)

Quentin Tardivon (IL)

Yann Prono (IL)
