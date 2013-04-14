(use 'clj-gremlin.core)

(dir clj-gremlin.core)

(import (com.tinkerpop.blueprints.impls.tg TinkerGraphFactory))

(def g (TinkerGraphFactory/createTinkerGraph))

(count (seq (V g)))
(count (seq (E g)))

(seq (:name (V g)))

(seq (props (V g)))

(seq (props (E g)))

(defn methods-containing
         [c s]
         (filter #(.contains % s) 
                 (map #(.getName %) 
                      (seq (.getMethods (class c))))))

(defn parseInt [s] (java.lang.Integer/parseInt s))

(parseInt "23")

(-> g 
    V 
    :name)

(E g)

(-> g 
    V 
    :name
    seq)

(-> g V props seq)
(-> g (v 1) (#(prop % :name)))
(-> g (v 2) (#(prop % :name)))
(-> g (v 3) (#(prop % :name)))
(-> g (v 4) (#(prop % :name)))
(-> g (v 5) (#(prop % :name)))
(-> g (v 6) (#(prop % :name)))

(-> g (e 7) label seq first)
(-> g (e 8) label seq first)
(-> g (e 9) label seq first)
(-> g (e 10) label seq first)
(-> g (e 11) label seq first)
(-> g (e 12) label seq first)
(-> g (v 1) outE label seq frequencies)
(-> g (v 2) inE label seq frequencies)
(-> g (v 3) inE label seq frequencies)
(-> g (v 4) outE label seq frequencies)
(-> g (v 5) inE label seq frequencies)
(-> g (v 6) outE label seq frequencies)
(-> g (v 3) in seq first class )
(-> g V id seq)
(seq (order (id (V g))))
(seq (order (id (E g))))
(-> g (v 1) (as "a") (out "knows") (as "b") (select #(prop % :name)) seq)

(-> g (v 1) (out :created) in seq)

(methods-containing (-> g (v 3)) "get")

(methods-containing g "add")

(.addVertex g 20)

(seq (id (v g 20)))

(.setProperty (v g 20) "name" "Test")

(.setProperty (v g 20) "age" 0)

(-> g V props seq)
(count (seq (V g)))

(take 1 (drop 6 (seq (.getMethods (class g)))))

;;(defn link!  
;;  "Adds an edge between vertex1 and vertex 2 given a vector like [label props-map]. The label must be a keyword and props-map can be nil."  
;;  ([id v1 label props v2] 
;;   (let [e (.addEdge *db* id v1 v2 (name label))] (when props (apply passoc! e (apply concat (seq props)))) e))
;;  ([v1 label props v2] (link! nil v1 label props v2))
;;  ([v1 label v2] (link! nil v1 label nil v2)))

(.addEdge g 30 (v g 1) (v g 20) "test")

(.setProperty (e g 30) "weight" 1.0)

(-> g E props seq)

(count (seq (E g)))
