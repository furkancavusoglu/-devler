#lang sicp
; recursive
(define (factorial x )
  (if (= x 2 )
      2
      (* x (factorial (- x 1 )))))
(factorial 6)

;factorial iterative


                
(define (factorial2 x)
(fact-iter 1 1 x))

(define (fact-iter product counter max-count)
  (if (> counter max-count)
      product
      (fact-iter (* counter product)
                 (+ counter 1)
                 max-count)))
(factorial2 6)
