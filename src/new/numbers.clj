(ns new.numbers)

(defn part-sum 
  [n] 
  (map #(apply + %) 
       (partition n 
                  1 
                  (range (+ n 3)))))

(defn num-rect 
  [n m] 
  (partition n 
             (rest (range (inc (* n m))))))

(defn extract-rect 
  [co ro cn rn c] 
  (map #(take cn (drop co %)) 
       (take rn (drop ro c))))

(defn rows-to-columns 
  [c] 
  (apply map 
         list 
         c))

(defn rotate 
  [c] 
  (apply map 
         (comp reverse list) 
         c))

(defn factors
  ; factors of x
    [x]
    (filter #(zero? (mod x %)) 
            (range 1 
                   (inc x))))

(defn gcf
  ; GCF of x and y
    [x y]
    (apply max 
           (filter (set (factors x)) 
                   (factors y))))

(defn lcm
  ; LCM of x and y
    [x y]
    (* y (/ x (gcf x y))))

(defn lpad-num 
  [w n] 
  (str (apply str 
              (repeat (- w (count (str n))) 
                      " ")) 
       n))

(defn rpad-string 
  [w s] 
  (str s
       (apply str 
              (repeat (- w (count s)) 
                      " "))))

(defn print-num-rect 
  [nr]
  (let [w (apply max (map count (map str (flatten nr))))
	      c (count (first nr))]
    (->> nr
		     (flatten)
         (map #(lpad-num w %))
         (partition c)
         (map #(interpose " " %))
         (map #(apply str %))
         (interpose "\n")
         (apply str)
         (println))))

(defn print-string-rect 
  [sr]
  (let [w (apply max (map count (map str (flatten sr))))
        c (count (first sr))]
    (->> sr
         (flatten)
         (map #(rpad-string w %))
         (partition c)
         (map #(interpose " " %))
         (map #(apply str %))
         (interpose "\n")
         (apply str)
         (println))))

(defn mult-rect 
  [n] 
  (map #(range % (* % (inc n)) %) 
       (rest (range (inc n)))))

(defn add-rect 
  [n] 
  (map #(range % (+ % n)) 
       (range n)))

(defn neg-pos-num-rect 
  [n m] 
  (partition n 
             (map #(- % (/ (inc (* n m)) 2)) 
                  (range 1 (inc (* n m))))))