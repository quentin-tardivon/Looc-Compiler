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
          		STW       		BP, -(SP) 		// Stack the dynamic link
          		STW       		BP, -(SP) 		// Stack the static link
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		LDW       		R1, #10   
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
          		LDW       		R1, #12   
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-8		// Affection: move = 2
          		LDW       		R0, (BP)-0
          		LDW       		R10, #1   
          		CMP       		R0, R10   
          		JNE       		#ELSE1-$  
          		LDW       		R1, #666  
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
          		JEA       		@FI1      
ELSE1     		          		          
          		LDW       		R0, (BP)-0
          		LDW       		R10, #999 
          		CMP       		R0, R10   
          		JBE       		#ELSE2-$  
          		LDW       		R0, (BP)-0
          		LDW       		R10, #5   
          		CMP       		R0, R10   
          		JNE       		#ELSE3-$  
          		LDW       		R1, #777  
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
          		JEA       		@FI3      
ELSE3     		          		          
          		LDW       		R1, #888  
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
FI3       		          		          
          		JEA       		@FI2      
ELSE2     		          		          
          		LDW       		R1, #333  
          		ADQ       		-2, SP    
          		STW       		R1, (SP)  
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
FI2       		          		          
FI1       		          		          
          		ADQ -2, SP		          
          		STW BP, (SP)		          
          		LDW2      		R0, (BP)- 
          		STW       		R0, -(SP) 
          		LDW       		BP, SP    
          		JSR       		@print_   
          		LDW       		SP, BP    
          		LDW       		BP, (SP)  
          		ADQ       		2, SP     




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          




// ------------- PRINT FUNCT		          		
         
print_    		LDW       		R0, (BP)0 
          		TRP       		#WRITE_EXC
          		RTS       		          
