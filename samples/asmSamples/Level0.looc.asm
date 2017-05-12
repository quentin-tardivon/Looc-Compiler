// ------------- ASM FOR LOOC		          		
         
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
main_     		LDW       		SP, #STACK_ADRS
          		LDW       		BP, #NIL  
          		STW       		BP, -(SP) 
          		LDW       		BP, SP    
LDW       		R1,       		#10       
          		ADQ -2, SP		          
          		STW R1, (SP)		          
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-0
LDW       		R1,       		#12       
          		ADQ -2, SP		          
          		STW R1, (SP)		          
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-2
          		ADQ -2, SP		          
          		STW BP, (SP)		          
          		LDW R0, (BP)-2		          
          		STW R0, -(SP)		          
          		LDW BP, SP		          
          		JSR       		@print_   
          		LDW SP, BP		          
          		LDW BP, (SP)		          
          		ADQ 2, SP 		          




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          




// ------------- PRINT FUNCT		          		
         
print_    		LDW       		R0, (BP)0 
          		TRP       		#WRITE_EXC
          		RTS       		          
