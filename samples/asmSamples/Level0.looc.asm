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
          		STW       		R0, -(SP) 		// Stack param for 'write' function: move = 0
          		JSR @itoa_		          
          		ADI       		SP, SP, #2		// Unstack params
          		LDW       		R0, (BP)-8
          		TRP       		#WRITE_EXC
          		LDW       		R0, (BP)-10
          		STW       		R0, -(SP) 		// Stack param for 'write' function: move = 4
          		JSR @itoa_		          
          		ADI       		SP, SP, #2		// Unstack params




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
          		LDW ST, BT		          
          		LDW BT, (ST)+		          
          		TRP #EXIT_EXC		          
          		JEA @main_		          




// ------------- I_TO_A FUNCT		          		
         
ITOA_P    		EQU       		40        
ITOA_I    		EQU       		4         
ASCII_MINUS		EQU       		45        
ASCII_PLUS		EQU       		43        
ASCII_SP  		EQU       		32        
ASCII_0   		EQU       		48        
ASCII_A   		EQU       		65        
itoa_     		STW       		BP, -(SP) 
          		LDW       		BP, SP    
          		LDW       		R0, (BP)ITOA_I
          		LDW       		R1, #10   
          		LDQ       		ASCII_SP, R3
          		LDQ       		10, WR    
          		CMP       		R1, WR    
          		BNE       		NOSIGN-$-2
          		LDQ       		ASCII_PLUS, R3
          		TST       		R0        
          		BGE       		POSIT-$-2 
          		NEG       		R0, R0    
          		LDQ       		ASCII_MINUS, R3
POSIT     		NOP       		          
NOSIGN    		LDW       		R2, R0    
CNVLOOP   		LDW       		R0, R2    
          		SRL       		R1, R1    
          		ANI       		R0, R4, #1
          		SRL       		R0, R0    
          		DIV       		R0, R1, R2
          		SHL       		R0, R0    
          		ADD       		R0, R4, R0
          		SHL       		R1, R1    
          		ADQ       		-10, R0   
          		BGE       		LETTER-$-2
          		ADQ       		10+ASCII_0, R0
          		BMP       		STKCHR-$-2
LETTER    		ADQ       		ASCII_A, R0
STKCHR    		STW       		R0, -(SP) 
          		TST       		R2        
          		BNE       		CNVLOOP-$-2		// Les caractères sont empilés gauche en haut, droite en bas
          		LDW       		R1, #ITOA_P
          		STB       		R3, (R1)+ 
CPYLOOP   		LDW       		R0, (SP)+ 
          		STB       		R0, (R1)+ 
          		CMP       		SP, BP    
          		BNE       		CPYLOOP-$-2
          		LDQ       		NUL, R0   
          		STB       		R0, (R1)+ 
          		LDW       		R0, #ITOA_P		// Pointeur sur chaine de caract
          		TRP       		#WRITE_EXC
          		LDW       		SP, BP    
          		LDW       		BP, (SP)+ 
          		RTS       		          
