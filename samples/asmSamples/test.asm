sp          equ r15
wr          equ r14
bp          equ r13

SP          equ r15
WR          equ r14
BP          equ r13

EXIT_EXC   EQU   64
READ_EXC   EQU   65
WRITE_EXC  EQU   66

NUL         equ  0
NULL        equ  0
NIL         equ  0

STACK_ADRS  equ 0x1000
LOAD_ADRS   equ 0xFE00

            org LOAD_ADRS
            start main_


main_   ldw sp, #STACK_ADRS
        ldw bp, #NIL

        stw bp, -(sp)
        ldw bp, sp
ldw sp, bp
        ldw bp, (sp)+
        trp #EXIT_EXC
        jea @main_
