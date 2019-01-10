(ns prime-mul-table.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [prime-mul-table.tables :refer [table]]
            [prime-mul-table.display :refer [print-cli]])
  (:gen-class))

(def opts
  [["-n" "--n N" "Number of primes"
    :id :number-of-primes
    :default 10
    :parse-fn #(Integer/parseInt %)
    :validate [pos? "Must be a positive number."]]
   ["-t" "--time" "Show elapsed time"
    :id :show-elapsed-time]])

(defmacro wrap-when
  "Wrap body with fn if test is true."
  [test fn & body]
  `(if ~test
     (~fn ~@body)
     ~@body))

(defn -main
  "Command line interface to print multiplication table of first n prime numbers.
  Args:
  -n : the number of prime numbers (default: 10)
  -t : show elapsed time (time to find primes and construct/print table)"
  [& args]
  (let [options (:options (parse-opts args opts))]
    (wrap-when (:show-elapsed-time options)
               time
               (print-cli (table (:number-of-primes options))))))

