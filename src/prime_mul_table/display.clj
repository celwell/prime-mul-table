(ns prime-mul-table.display)

(defn- hr
  "Generate a horizontal rule as a string."
  [num-cols cell-size]
  (->> (concat (repeat (+ cell-size) "-") "+")
       (repeat num-cols)
       flatten
       (apply str)))

(defn- cell-padding
  "Get spaces to prepend for creating right-alignment within cell."
  [cell-size value]
  (repeat (- (dec cell-size) (count (str value))) " "))

(defn- wrap-cell
  [cell-size value]
  (concat (cell-padding cell-size value) [value " |"]))

(defn- stringify-row
  [cell-size row]
  (->> (map (partial wrap-cell cell-size) row)
       flatten
       (apply str)))

(defn print-cli
  "Prints table to STDOUT."
  [table]
  (when (seq (remove nil? (flatten table)))
    (let [cell-size (-> table last last str count (+ 2))]
      (-> (map (partial stringify-row cell-size) table)
          (interleave (repeat (hr (count table) cell-size)))
          (->> (run! println))))))
