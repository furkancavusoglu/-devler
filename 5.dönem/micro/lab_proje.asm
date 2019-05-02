#start=led_display.exe#

org 100h
 
start:

mov ax, time                ;if all locks are not opened in 120 seconds
cmp ax, 120
je fail

mov ah, 0x00                ;clearing the output
mov al, 0x03  
int 0x10

                            
mov ax,0                    ;resetting registers
mov bx,0
mov cx,0
mov dx,0


mov AH,2H                   ;reset coordinate
mov BH,0
mov dh,0
mov dl,cl
int 10h  

call randomNumberGeneration ;rn is in dx
mov bp, dx                  ;moving random number into bp
and dx, 5                   ;calculating key
mov key, dx                 ;storing key
call timer

step1:
mov bx, bp                  ;loading key
mov ax, key
mul bx                      ;key*R
add ax, 5                   ;key*R +5                   
mov dh, 5
div dh                      ;(key*R +5) mod5 in ah
cmp ah, 0                   ;(key1==0) ?
jnz start


mov dx, offset array1       ;print array1
mov ah,09
int 21h 


mov AH,2H                   ;setting coordinates
mov BH,0
mov DH,1
mov DL,0
INT 10H

call timer

step2:

mov dx, key                 ;loading key
or  dx, bp                  ;key2= key or R
cmp dx, 0                   ;(key2!=0) ?
jz start

mov dx, offset array2       ;print array2
mov ah,09
int 21h 
 
mov AH,2H                   ;setting coordinates
mov BH,0
mov DH,2
mov DL,0
INT 10H

call timer

step3:

mov dx, key                 ;loading key
add dx, bp                  ;key + R
sar dx, 2                   ;sar (key + R)
cmp dx, 0                   ;(key3 != 0) ?
jz start 

mov dx, offset array3       ;print array3
mov ah,09
int 21h 

mov AH,2H                   ;setting coordinates
mov BH,0
mov DH,3
mov DL,0
INT 10H

call timer

step4:
mov dx, key                 ;loading key
xor dx, bp                  ;key xor R
cmp dx, 0                   ;(key4 != 0) ?
jz start 

mov dx, offset array4       ;print array4
mov ah,09
int 21h 

mov AH,2H                   ;setting coordinates
mov BH,0
mov DH,4
mov DL,0
INT 10H

call timer

step5:
mov dx, key                 ;loading key
mov ax, dx                  
mul bp                      ;key * R
cmp ax, 0                   ;(key5 != 0) ?
jz start 

mov dx, offset array5       ;print array5
mov ah,09
int 21h  

jmp exitt

fail:
mov dx, offset array6       ;print array6
mov ah,09                   
int 21h 



exitt:
ret 
time dw 1
key  dw 0 

array1 db 'Lock 1 was opened','$'
array2 db 'Lock 2 was opened','$'
array3 db 'Lock 3 was opened','$'
array4 db 'Lock 4 was opened','$'
array5 db 'Lock 5 was opened and i am out','$'
array6 db 'I could not open the locks','$'


randomNumberGeneration proc
    xor ax,ax               ;resetting ax
    mov ah, 0h              
    int 1ah                 ;get timer ticks since midnight in CX:DX
    mov ax,dx               ;using lower 16 bits for random value
    xor dx,dx               ;(random number ) mod10
    mov bx,10               
    div bx                  ;divide dx:ax by bx   
    ret         
randomNumberGeneration endp               

timerDisplay proc
    mov ax, time            ;displaying time
    out 199, ax
    inc ax
    mov time, ax
    ret           
timerDisplay endp

timer proc                  
    mov ah, 2ch             ;checking time with system time
    int 21h                 ;int 21h ah=2ch returns ch=hours
    mov dl,dh               ;   cl= minutes dh= seconds dl=mseconds
    mov dh,0
    cmp di,0
    jnz compare             ;does di currently have seconds?
    mov di,dx               ;storing current second to di
    compare:
    cmp dx, di              ;if di has seconds, then compare the time
    jnz timerdisp           ;   with stored seconds  
    jmp return
    timerdisp:
    mov di, dx              ;if current seconds and stored second is different
    call timerDisplay       ;   set the stored second the current second and
                            ;   set the timer
    return: 
    ret
timer endp

