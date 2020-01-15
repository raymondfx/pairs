; Complete the pairs function below.
(defn pairs [k arr]
(->> (reduce
         (fn [[checked pairs] x]
           [(conj checked x) (+ pairs
                             (if (checked (+ x k)) 1 0)
                             (if (checked (- x k)) 1 0))])
         [#{} 0]
         arr)
       second))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (pairs k arr))

(spit fptr (str result "\n") :append true)
