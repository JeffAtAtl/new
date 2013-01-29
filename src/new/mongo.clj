(ns new.mongo
  (:use somnium.congomongo))

(mongo! :db "mydb")

(defn mckeys
  [c]
  (keys (fetch-one c)))

(def words (map :word
                (fetch :words)))

(defn info
  []
  ((juxt databases collections)))

