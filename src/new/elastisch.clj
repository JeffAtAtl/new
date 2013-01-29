(ns new.elastisch
  (:require [clojurewerkz.elastisch.rest  :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]))

(esr/connect! "http://10.0.0.7:9200")

(defn eget [i j k] (esd/get i j k))