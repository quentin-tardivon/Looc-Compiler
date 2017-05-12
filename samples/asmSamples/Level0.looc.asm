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
          		LDW       		R0, #10   
          		STW       		R0, (BP)-0
          		LDW       		R0, #12   
          		STW       		R0, (BP)-2
          		LDW       		R0, (BP)-0
          		CMP       		R0, 0     
          		JNE       		@ELSE1    
          		LDW       		R0, #666  
          		STW       		R0, (BP)-0
          		JEA       		@FI1      
ELSE1     		          		          
          		LDW       		R0, (BP)-0
          		CMP       		R0, 999   
          		JBE       		@ELSE2    
          		LDW       		R0, (BP)-0
          		CMP       		R0, 5     
          		JNE       		@ELSE3    
          		LDW       		R0, #777  
          		STW       		R0, (BP)-0
          		JEA       		@FI3      
ELSE3     		          		          
          		LDW       		R0, #888  
          		STW       		R0, (BP)-0
FI3       		          		          
          		JEA       		@FI2      
ELSE2     		          		          
          		LDW       		R0, #333  
          		STW       		R0, (BP)-0
FI2       		          		          
FI1       		          		          
          		ADI       		BP, R0, #-8
          		STW       		R0, -(SP) 
          		JSR       		@print_   
          		ADI       		SP, SP, #2




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          




// ------------- PRINT FUNCT		          		
         
print_    		LDQ       		0,R1      
          		STW       		BP, -(SP) 
          		LDW       		BP, SP    
          		SUB       		SP, R1, SP
          		LDW       		R0, (BP)4 
          		TRP       		#WRITE_EXC
          		LDW       		SP, BP    
          		LDW       		BP, (SP)+ 
          		RTS       		          
