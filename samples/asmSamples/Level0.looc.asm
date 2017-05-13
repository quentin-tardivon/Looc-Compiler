// ------------- ASM FOR LOOC		          		
         
SP        		EQU       		R15       
WR        		EQU       		R14       
BP        		EQU       		R13       
ST        		EQU       		R12       
EXIT_EXC  		EQU       		64        
READ_EXC  		EQU       		65        
WRITE_EXC 		EQU       		66
       
NUL       		EQU       		0         
NULL      		EQU       		0         
NIL       		EQU       		0
        
STACK_ADRS		EQU       		0x1000    
HEAP_ADRS 		EQU       		0xF000    
LOAD_ADRS 		EQU       		0xFA00
   
          		ORG       		LOAD_ADRS 
          		START     		main_     
main_     		LDW       		SP, #STACK_ADRS
          		LDW       		R0, #0x0d0a
          		STW       		R0, @0x0000
          		LDW       		BP, #NIL  
          		STW       		BP, -(SP) 
          		LDW       		BP, SP    
          		LDW       		ST, #HEAP_ADRS
          		STW       		BP, -(SP) 		// Stack the dynamic link
          		STW       		BP, -(SP) 		// Stack the static link
          		ADI       		SP, SP, #-2
          		ADI       		SP, SP, #-2
          		LDW       		R1, #12   
          		STW       		R1, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-8		// Affection: move = 2
          		LDW       		R1, (BP)-8
          		STW       		R1, -(SP) 
          		LDW       		R1, #10   
          		STW       		R1, -(SP) 
          		LDW       		R1, #2    
          		STW       		R1, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R2, (SP)  
          		ADQ       		2, SP     
          		DIV       		R2, R1, R3
          		STW       		R3, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R2, (SP)  
          		ADQ       		2, SP     
          		SUB       		R2, R1, R3
          		STW       		R3, -(SP) 
          		LDW       		R1, #100  
          		STW       		R1, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R2, (SP)  
          		ADQ       		2, SP     
          		SUB       		R2, R1, R3
          		STW       		R3, -(SP) 
          		LDW       		R1, (SP)  
          		ADQ       		2, SP     
          		LDW       		R0, R1    
          		STW       		R0, (BP)-6		// Affection: move = 0
          		LDW       		R0, (BP)-6
          		STW       		R0, -(SP) 		// Stack param for 'write' function: move = 0
          		JSR @itoa_		          
          		ADI       		SP, SP, #2		// Unstack params




// ------------- FIN DU PGM		          		
         
          		LDW SP, BP		          
          		LDW BP, (SP)+		          
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
          		LDW       		R0, #0x0000		// Pointeur sur retour ligne
          		TRP       		#WRITE_EXC
          		LDW       		SP, BP    
          		LDW       		BP, (SP)+ 
          		RTS       		          
