(ns prime-mul-table.core-test
  (:require [clojure.test :refer :all]
            [prime-mul-table.core :refer :all]
            [clojure.java.io :as io]))

(deftest n-is-default
  (testing "Run as from cli, where n = 10 (default)."
    (is (= (slurp (io/resource "resources/n-is-10-expected.out"))
           (with-out-str (-main))))))

(deftest n-is-3
  (testing "Run as from cli, where n = 3."
    (is (= (slurp (io/resource "resources/n-is-3-expected.out"))
           (with-out-str (-main "-n" "3"))))))





