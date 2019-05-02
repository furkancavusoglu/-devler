#lang sicp

(define (square x) (* x x ))

(define (sum-of-squares x y)
(+ (square x) (square y)))

(sum-of-squares 5 2)

(define (abss x)
  (cond ((< x 0) (- x))
        (else x)))

(define (abs2 x)
  (if (< x 0)
      (- x)
      x))



      
