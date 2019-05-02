org 100h

main_loop:

mov cl,0            ;dot count

adding_dots:
  
cmp y, 0            ;checking 0th condition
jz print_name

mov AH,2H           ; set coordinate
mov BH,0
mov dh,x
mov dl,cl
int 10h


mov ah, 0eh
mov al, '.'
int 10h

inc cl
cmp cl, y
jb adding_dots



print_name:         ;printing name
mov ah, 0eh         
mov al, array[si]
int 10h
inc si
cmp si, 10
jb print_name


mov cx,850          ; ten seconds timer
CYCLE:
LOOP CYCLE

mov si, 0
inc y  


inc di
cmp di, 15
jb main_loop 


ret

array db "cavusoglu"

x db 0

y db 0
