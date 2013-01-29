(ns new.core)

(defn diffs
  [c]
  (->> c
       (partition 2 1)
       (map reverse)
       (map #(apply - %))))

(defn fibo [cnt]
  "Calculate cnt elements of fibonacci series"
  (take cnt (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))

(defn sqrs [cnt]
  "Calculate cnt elements of squares series"
  (take cnt (reductions + (filter odd? (range)))))

(defn split [t s]
  "split s using t"
  (remove (partial = t) 
               (map (partial apply str) 
                    (partition-by (partial = (first t) )
                                  s))))