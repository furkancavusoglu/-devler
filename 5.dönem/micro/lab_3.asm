
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

mov input, 10

cmp input, 4   ; checking n if 4< n <26
jb error
cmp input, 26
ja error

before:
mov bl, index

func:
     mov ax, 0h
     mov al, bl  ; al= k bl=k
     imul bl     ; ax= bl*al
     mov dx, ax  ; ax= dx
     mov al, -5  ; al= -5
     imul bl     ; ax= bl*al
     sub dx, ax  ; dx= dx-ax
     mov ax, dx  ; dx= ax
     mov dl, 5   ; dl= 5
     idiv dl     ; ax / dl 
     
     cmp di, 1   ; checking for f(k) or T
     jae T
     cmp ah, 0
     je LXor
     cmp ah, 1
     je LOr
     cmp ah, 2
     je LAnd
     cmp ah, 3
     je LSAL
     cmp ah, 4 
     je LXor_SAL
     
     
LXor: 
xor bl, 5  ;xor k, 5
mov di, 1
jmp func
      

LOr:
or bl, 4   ;or k, 4 
mov di, 2
jmp func


LAnd:
and bl, 3  ;and k, 3
mov di, 3
jmp func


LSAL:
sal ah, 2  ;sal f(k), 2
mov di, 4
jmp func

LXor_SAL:  ;xor (sar f(k),1),5
sar ah, 1
xor ah, 5
mov di, 5
jmp func


T:
cmp di, 3
jae k3k4

mov cvsgl[si], bl
inc si
mov di, 0
inc index
mov dx, 0h
mov dl, input
sub dl, 4
cmp si, dx
jae exit
jmp before

k3k4:
mov cvsgl[si], ah
inc si
mov di,0
inc index
mov dx, 0h
mov dl, input
sub dl, 4
cmp si, dx
jae exit
jmp before
 

error:
lea si, message
mov cx, 38
mov ah, 0Eh
go2: lodsb
int 10h
loop go2

exit:
ret

message db 'please enter a value between 14 and 26',0

input db 0

index db 5

cvsgl db 26 dup(0) 