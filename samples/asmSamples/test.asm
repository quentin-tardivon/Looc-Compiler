SP          EQU R15
WR          EQU R14
BP          EQU R13

SP          EQU r15
WR          EQU r14
BP          EQU r13

EXIT_EXC   EQU   64
READ_EXC   EQU   65
WRITE_EXC  EQU   66

NUL         EQU  0
NULL        EQU  0
NIL         EQU  0

STACK_ADRS  EQU  0x1000
LOAD_ADRS   EQU  0xFE00

            ORG LOAD_ADRS
            START main_


main_   LDW SP, #STACK_ADRS
        LDW BP, #NIL

        STW BP, -(SP)
        LDW BP, SP
LDW SP, BP
        LDW BP, (SP)+
        TRP #EXIT_EXC
        JEA @main_
