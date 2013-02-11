(use 'clj-gremlin.core)

(import (com.tinkerpop.blueprints.impls.tg TinkerGraphFactory))

(def g (TinkerGraphFactory/createTinkerGraph))

(V g)

(into #{} (:name (V g)))

(into #{} (props (V g)))

(-> g 
    V 
    :name)

(E g)

(-> g 
    V 
    (:name))

(-> g V props)

(-> g (v 1) (#(prop % :name)))

(-> g (v 2) (#(prop % :name)))

(-> g (v 3) (#(prop % :name)))

(-> g (v 4) (#(prop % :name)))

(-> g (v 5) (#(prop % :name)))

(-> g (v 6) (#(prop % :name)))

(-> g (e 7) )

(-> g V props)


(seq (order (id (V g))))

(seq (order (id (E g))))

(-> g (v 1) (as "a") (out "knows") (as "b") (select #(prop % :name)) seq)