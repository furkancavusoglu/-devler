#lang racket
;my solution
(define (fibonacci n)
  (cond ((= n 0 ) 0)
      ((= n 1) 1)
      ((> n 1) (+ (fibonacci (- n 2 )) (fibonacci (- n 1))))))
(fibonacci 10)

;mit solution
(define (fib n)
  (if (< n 2 )
      n
      (+ (fib (- n 2 )) (fib (- n 1)))))
(fib 10)


