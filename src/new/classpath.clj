(ns new.classpath
  (:use new.core))

(def java-version (System/getProperty "java.version"))

(def java-class-path (System/getProperty "java.class.path"))

(def split-java-class-path (split ";" 
                                  (System/getProperty "java.class.path")))

(def count-split-java-class-path (count split-java-class-path))

(def strip-home-split-java-class-path1
  (map #(.substring % 17)
       split-java-class-path))

(defn methods
  [c p]
  (filter #(.contains % p) 
        (map #(.getName %) 
             (seq (.getMethods (class c))))))

(def strip-home-split-java-class-path2
  (flatten (map #(map second 
                      (re-seq #"C:\\Users\\JXC4598\\(.*)" 
                              %))
                split-java-class-path)))

(defn classpath-starts-with
  [s]
  (filter #(.startsWith % s)
          strip-home-split-java-class-path2))

(defn count-classpath-starts-with
  [s]
  (count (filter #(.startsWith % s)
                 strip-home-split-java-class-path2)))