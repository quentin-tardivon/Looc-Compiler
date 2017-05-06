



// ------------- DEBUT DU PGM		          		
         
SP        		EQU       		R15       
WR        		EQU       		R14       
BP        		EQU       		R13
      
EXIT_EXC  		EQU       		64        
READ_EXC  		EQU       		65        
WRITE_EXC 		EQU       		66
       
NUL       		EQU       		0         
NULL      		EQU       		0         
NIL       		EQU       		0
        
STACK_ADRS		EQU       		0x1000    
LOAD_ADRS 		EQU       		0xFE00
   
          		ORG       		LOAD_ADRS 
          		START     		main_     
main_     		LDW SP, #STACK_ADRS		          
          		LDW BP, #NIL		
         
          		STW BP, -(SP)		          
          		LDW BP, SP		          
          		LDW R0, #10		          
          		STW R0, (BP)-0		          
          		LDW R0, #12		          
          		STW R0, (BP)-2		          
          		//DEBUT IF1		          
          		LDW       		R0, (BP)-0
          		CMP       		R0, 0     
          		JNE       		@ELSE1    
          		//TODO : then instructions		          
          		JEA       		@FI1      
ELSE1     		//TODO : else instructions		          
FI1       		          		          
          		//FIN IF  		          
          		ADI BP, RO, #-8		          
          		STW RO, -(SP)		          
          		JSR @print		          
          		ADI SP, SP, #2		          




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          
