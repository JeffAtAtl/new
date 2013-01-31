(ns new.neo
  (:require [clojurewerkz.neocons.rest :as nr] 
		        [clojurewerkz.neocons.rest.records :as records]
		        [clojurewerkz.neocons.rest.cypher :as cy]
))

(def neo4j-url (or (System/getenv "NEO4J_REST_URL") "http://localhost:7474/db/data/"))

(nr/connect! neo4j-url)

(defn cypher-convert-value [value] 
(if (:type value) (records/instantiate-rel-from value) 
    (if (:length value) (records/instantiate-path-from value)
        (if (:self value) (records/instantiate-node-from value) 
            value)))
)

(defn render [value]
   (if (coll? value) (doall (flatten (seq value))) value)
)

(defn cypher-convert-cell [[col value]] 
    [col (render (cypher-convert-value value))])

(defn cypher-convert-row [row] (map #(render (cypher-convert-value %)) row))

(defn cypher-convert-result [row] (map cypher-convert-cell row))

(defn pad 
    ([row sep nl] (str (apply str (map #(format "%10s%s" % sep) row)) nl))
    ([row] (pad row "|" "\n"))
)


(defn result-to-table [{data :data columns :columns}]
    (str (pad columns) (apply str (map pad (map cypher-convert-row data)))))

(defn eval-cypher [expr]
  (try
    {:expr expr :result (result-to-table (cy/query expr))}
    (catch Exception e
      {:error true :message (str (.getMessage e))})))

(defn raw-eval-cypher [expr]
  (cy/query expr))



