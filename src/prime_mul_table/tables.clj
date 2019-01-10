(ns prime-mul-table.tables)

(defn- is-prime?
  "True if x is a prime number. Otherwise, false."
  [x]
  (and (> x 1)
       (empty? (filter (comp zero? (partial mod x)) (range 2 x)))))

(defn- primes
  "Returns a lazy sequence of all prime numbers."
  []
  (filter is-prime? (range)))

(defn table
  "Generates a multiplication table of first n prime numbers as a '2D list'."
  [n]
  (let [ps (cons 1 (take n (primes)))] ; cons 1 trick to fill col & row headers
    (for [x ps]
      (for [y ps]
        (if (= x y 1)
          nil ; the top-left cell is a blank placeholder
          (* x y))))))
