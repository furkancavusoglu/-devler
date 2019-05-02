#lang racket
(define (make-interval a b) (cons a b))

(define (make-center-percent c p)
  (cons (+ c (* c (/ p 100))) (- c (* c (/ p 100)))))
(define (percent c)
  (let ((mid (/ (+ (upper-bound c) (lower-bound c)) 2)))
    (* (/ (- mid (lower-bound c)) mid) 100)))

(define (lower-bound x)
  (if (< (car x) (cdr x))
      (car x)
      (cdr x)))

(define (upper-bound x)
  (if (> (cdr x) (car x))
         (cdr x)
         (car x)))

(define (add-interval x y)
  (make-interval (+ (lower-bound x) (lower-bound y))
                 (+ (upper-bound x) (upper-bound y))))
(define (sub-interval x y)
  (make-interval (- (lower-bound x) (upper-bound y))
                 (- (upper-bound x) (lower-bound y))))

(define (mul-interval x y)
  (let ((p1 (* (lower-bound x) (lower-bound y)))
        (p2 (* (lower-bound x) (upper-bound y)))
        (p3 (* (upper-bound x) (lower-bound y)))
        (p4 (* (upper-bound x) (upper-bound y))))
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(define (div-interval x y)
  (if (and (<= (lower-bound y) 0)
           (>= (upper-bound y) 0))
      (error "The denominator should not span 0")
      (mul-interval x
                (make-interval (/ 1.0 (upper-bound y))
                               (/ 1.0 (lower-bound y))))))

(define xxx (make-center-percent 100 20))
(percent xxx)

