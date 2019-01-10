(ns prime-mul-table.util)

(defmacro wrap-when
  "Wrap body with fn if test is true."
  [test fn & body]
  `(if ~test
     (~fn ~@body)
     ~@body))
