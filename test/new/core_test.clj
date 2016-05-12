(ns new.core-test
  (:use clojure.test
        new.core))

(deftest addition-test
  (testing "Addition works."
    (is (= 10 (+ 1 2 3 4)))))
