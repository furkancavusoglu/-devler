org 100h

mov ax,0
mov bx,0
mov cx,0
mov dx,0      

mov WORD PTR[200Fh], 0h
mov WORD PTR[200Dh], 0h
mov WORD PTR[200Bh], 0h
mov WORD PTR[2009h], 0h 

call multiply

ret          

multiply proc 
   
    mov [2000h], 3344h
    mov [2002h], 1122h    ;first number
    mov [2004h], 7788h
    mov [2006h], 5566h    ;second number 

    mov cx, [2006h]
    mov dx, [2004h]       ;n2 moved(multiplicand)

    mov di, [2000h]
    mov si, [2002h]       ;n1 moved(multiplier)  

    mov bp, 20h           ;set the count to 32

    testbit: 
        test di, 1
        jz shifting 

        add [2008h], dx       ;if mult0 is 1 add
        adc [200Ah], cx
        adc [200Ch], bx
        adc [200Eh], ax


    shifting:
        shr si,1
        rcr di,1              ;shift right
        
        shl dx,1              ;shift left
        rcl cx,1
        rcl bx,1
        rcl ax,1

        dec bp
        jnz testbit 

multiply endp