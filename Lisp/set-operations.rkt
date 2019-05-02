#lang racket

(define (element-of-set? x set)
  (cond ((null? set) false)
        ((equal? (car set) x) true)
        (else (element-of-set? x (cdr set)))))

(define (adjoin-set x set)
  (if (element-of-set? x set)
      set
      (cons x set)))

(define (intersection-set set1 set2)
  (cond ((or (null? set1) (null? set2)) '())
        ((element-of-set? (car set1) set2)
         (cons (car set1)
               (intersection-set (cdr set2))))
        (else (intersection-set (cdr set2)))))
(define (union-set set1 set2)
  (cond ((and (null? set1) (null? set2)) '())
        ((not (element-of-set? (car set1) set2))
         (cons (car set1)
               (intersection-set (cdr set2))))
        (else (intersection-set (cdr set2)))))
                             