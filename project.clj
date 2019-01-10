(defproject prime-mul-table "1.0.0"
  :description "Command line utility to display multiplication table of prime numbers."
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.4.1"]]
  :plugins [[lein-codox "0.10.5"]]
  :main ^:skip-aot prime-mul-table.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :codox {:output-path "codox"})
