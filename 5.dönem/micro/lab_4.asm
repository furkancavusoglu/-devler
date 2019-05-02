org 100h

mov ax, ds
mov es, ax

mov cx, 15

nextscan:
mov bx, cx
lea si, array   ;loading offset addresses
lea di, array

compare:
cmp cx, 0
jz transfer

lodsb
xchg ah, al
lodsb
cmp ah, al  ; comparing two adjacent elements
ja swap 

dec si      ; case: no swaping
inc di
dec bx
jnz compare

loop nextscan

swap:       ; case: swaping
stosb
xchg ah, al
stosb
dec si
dec di

dec bx
jnz compare

loop nextscan 

transfer:        ;copying sorted array

mov dx, 3000h
mov es, dx

lea di, array
lea si, array

mov cx, 15
rep 
movsb      

ret
   
array db 'f', 'u', 'r', 'k', 'a', 'n', 'c', 'a', 'v', 'u', 's', 'o', 'g', 'l', 'u'

