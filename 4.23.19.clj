;; Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

;; For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

;; Bonus: Can you do this in one pass?

(def input [10 15 3 7])

(defn brute-contains-sum?
  [numbers k]
  (loop [i 0]
    (if (= (count numbers) i)
      false
      (if (loop [j 0]
            (if (= (count numbers) j)
              false
              (if (and (not= i j) (= (+ (get numbers i) (get numbers j)) k))
                true
                (recur (inc j)))))
        true
        (recur (inc i))))))

(defn contains-sum?
  [numbers k]
  (loop [i 0
         numbers-set #{}]
    (if (= (count numbers) i)
      false
      (if (contains? numbers-set (- k (get numbers i)))
        true
        (recur (inc i) (conj numbers-set (get numbers i)))))))

(contains-sum? [17 0 3 13] 17)

