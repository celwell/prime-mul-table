(ns prime-mul-table.tables-test
  (:require [clojure.test :refer :all]
            [prime-mul-table.tables :refer :all]))

(deftest is-prime?-test
  (let [is-prime? @#'prime-mul-table.tables/is-prime?] ; access private fn
    (testing "Can distinguish prime numbers from composite numbers, 0, and 1."
      (is (is-prime? 2))
      (is (is-prime? 3))
      (is (is-prime? 5))
      (is (is-prime? 47))
      (is (is-prime? 397))
      (is (is-prime? 40253))
      (is (is-prime? 104119))
      (is (not (is-prime? -5)))
      (is (not (is-prime? 0)))
      (is (not (is-prime? 1)))
      (is (not (is-prime? 6)))
      (is (not (is-prime? 104120))))))

(deftest primes-list-generation-test
  (let [primes @#'prime-mul-table.tables/primes] ; access private fn
    (testing "Can generate a list of primes."
      (is (= [2] (take 1 (primes))))
      (is (= [2 3 5 7 11] (take 5 (primes))))
      (is (= [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59
              61 67 71 73 79 83 89 97 101 103 107 109 113]
             (take 30 (primes)))))))

(deftest primes-mul-table-test
  (testing "Can create a 2D list data representation of a prime number multiplication table."
    (is (= '((nil))
           (table 0)))
    (is (= '((nil 2)
             (2 4))
           (table 1)))
    (is (= '((nil 2 3 5 7 11 13 17 19 23 29)
             (2 4 6 10 14 22 26 34 38 46 58)
             (3 6 9 15 21 33 39 51 57 69 87)
             (5 10 15 25 35 55 65 85 95 115 145)
             (7 14 21 35 49 77 91 119 133 161 203)
             (11 22 33 55 77 121 143 187 209 253 319)
             (13 26 39 65 91 143 169 221 247 299 377)
             (17 34 51 85 119 187 221 289 323 391 493)
             (19 38 57 95 133 209 247 323 361 437 551)
             (23 46 69 115 161 253 299 391 437 529 667)
             (29 58 87 145 203 319 377 493 551 667 841))
           (table 10)))
    (is (= '((nil))
           (table -1)))))
