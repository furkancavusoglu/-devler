#lang racket
(define (list-ref list n)
  (if (= 0 n)
      (car list)
      (list-ref (cdr list) (- n 1))))
(define (length items)
  (define (length-iter a count)
    (if (null? a)
        count
        (length-iter (cdr a) (+ 1 count))))
  (length-iter items 0))
(define (append list1 list2)
  (if (null? list1)
      list2
      (cons (car list1) (append (cdr list1) list2))))
(define (last-pair list)
  (if (null? (cdr list))
      (car list)
      (last-pair (cdr list))))
(define (reverse items)
  (if (null? items)
      items
      (append (reverse (cdr items)) (list (car items)))))

(reverse (list 1 2 3 4))
