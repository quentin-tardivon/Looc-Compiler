// ------------- ASM FOR LOOC		          		
         
SP        		EQU       		R15       
WR        		EQU       		R14       
BP        		EQU       		R13       
ST        		EQU       		R12       
BT        		EQU       		R11
      
EXIT_EXC  		EQU       		64        
READ_EXC  		EQU       		65        
WRITE_EXC 		EQU       		66
       
NUL       		EQU       		0         
NULL      		EQU       		0         
NIL       		EQU       		0
        
STACK_ADRS		EQU       		0x1000    
HEAP_ADRS 		EQU       		0xFD00    
LOAD_ADRS 		EQU       		0xFE00
   
          		ORG       		LOAD_ADRS 
          		START     		main_     
main_     		LDW       		SP, #STACK_ADRS
          		LDW       		BP, #NIL  
          		STW       		BP, -(SP) 
          		LDW       		BP, SP    
          		LDW       		ST, #HEAP_ADRS
          		LDW       		BT, #NIL  
          		STW       		BT, -(ST) 
          		LDW       		BT, ST    
          		LDW R0, #10		          
          		STW R0, (BP)-0		          
          		STW R12, (BP)-2		          
          		LDW R0, #71		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #65		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #82		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #82		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #85		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #83		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #12		          
          		STW R0, (BP)-4		          
          		STW R12, (BP)-6		          
          		LDW R0, #77		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #79		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #71		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #87		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #65		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		LDW R0, #73		          
          		STW R0, (ST)-2		          
          		ADQ -2, ST		          
          		ADI       		BP, R0, #-8
          		STW       		R0, -(SP) 
          		JSR       		@print_   
          		ADI       		SP, SP, #2




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		LDW ST, BT		          
          		LDW BT, (ST)+		          
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
