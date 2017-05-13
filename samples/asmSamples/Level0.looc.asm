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
          		STW       		BP, -(SP) 		// Stack the dynamic link
          		STW       		BP, -(SP) 		// Stack the static link
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		LDW       		R1, #10   
          		STW       		R1, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
          		LDW       		R0, #0x0000
          		STW       		R0, (ST)-2
          		ADQ       		-2, ST    
          		LDB       		R0, #0x5300
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x5500
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x5200
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x5200
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4100
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4700
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		STW       		R12, -(SP)
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-8		// Affection: move = 2
          		LDW       		R1, #12   
          		STW       		R1, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-10		// Affection: move = 4
          		LDW       		R0, #0x0000
          		STW       		R0, (ST)-2
          		ADQ       		-2, ST    
          		LDB       		R0, #0x4900
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4100
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x5700
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4700
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4f00
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		LDB       		R0, #0x4d00
          		STB       		R0, (ST)-1
          		ADQ       		-1, ST    
          		STW       		R12, -(SP)
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-12		// Affection: move = 6
          		LDW       		R0, (BP)-12
          		TRP       		#WRITE_EXC
          		LDW       		R0, (BP)-6
          		TRP       		#WRITE_EXC
          		LDW       		R0, (BP)-8
          		TRP       		#WRITE_EXC
          		LDW       		R0, (BP)-10
          		TRP       		#WRITE_EXC




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		LDW ST, BT		          
          		LDW BT, (ST)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          
