(ns new.words)

(use 'new.mongo)

(defn lower [s] (.toLowerCase s))

(defn w2cf 
  [w] 
  (frequencies (sort (map #((comp keyword lower str) %) (seq w)))))

(defn find-matching-words 
  [w] 
  (filter #(and (= (count w) (count %)) 
                (= (w2cf w) (w2cf %)))  
          words))