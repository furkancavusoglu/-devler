#lang sicp
;1.3 a
(define (square x) (* x x ))
(define (ex1-3 x y z )
  (cond ((and (< x y ) (< x z )) (+ (square z) (square y)))
        ((and (< y z ) (< y x )) (+ (square x) (square z)))
        ((and (< z x ) (< z y )) (+ (square x) (square y)))))
(ex1-3 3 1 4)

;1.3 b
(define (sum-square-two-larger a b c) 
  (- (+ (square a) 
        (square b) 
        (square c))
     (square (min a b c))))


;1.3 c

(define (sqsum x y) (+ (square x) (square y)))

(define (twolargest-sqsum a b c)
  (cond ((not (or (> a b) (> a c))) (sqsum b c))
	(else (twolargest-sqsum b c a))))
(twolargest-sqsum 5 4 -2)

;1.5
(define (p) (p))
(define (test x y)
  (if (= x 0)
      0
      y))


(test 0 (p))
