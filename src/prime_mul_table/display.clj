(ns prime-mul-table.display)

(defn- hr
  "Generate a horizontal rule as a string."
  [num-cols cell-size]
  (->> (concat (repeat (+ cell-size) "-") "+")
       (repeat num-cols)
       flatten
       (apply str)))

(defn- cell-padding
  "Prepend spaces to cause right-alignment within cell."
  [cell-size value]
  (repeat (- (dec cell-size) (count (str value))) " "))

(defn- wrap-cell
  "Wrap a cell value with for standardized layout."
  [cell-size value]
  (concat (cell-padding cell-size value) [value " |"]))

(defn- stringify-row
  "Prepare a row of the table as a string for display."
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
