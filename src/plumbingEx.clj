(use 'plumbing.core)

(defn stats 
  "Take a map {:xs xs} and return a map of simple statistics on xs"
  [{:keys [xs] :as m}]
  (assert (contains? m :xs))
  (let [n  (count xs)
        m  (/ (sum identity xs) n)
        m2 (/ (sum #(* % %) xs) n) 
        v  (- m2 (* m m))]
    {:n n   ; count   
     :m m   ; mean 
     :m2 m2 ; mean-square
     :v v   ; variance
     }))

(def stats-graph
  "A graph specifying the same computation as 'stats'"
  {:n  (fnk [xs]   (count xs))
   :m  (fnk [xs n] (/ (sum identity xs) n))
   :m2 (fnk [xs n] (/ (sum #(* % %) xs) n))
   :v  (fnk [m m2] (- m2 (* m m)))})

(stats {:xs (range 5)})

(require '[plumbing.graph :as graph])

(def stats-eager (graph/eager-compile stats-graph))

(= {:n 5
    :m 2
    :m2 6
    :v 2}
   (stats-eager {:xs (range 5)}))

(def extended-stats  
  (graph/eager-compile 
    (assoc stats-graph
      :sd (fnk [^double v] (Math/sqrt v)))))

